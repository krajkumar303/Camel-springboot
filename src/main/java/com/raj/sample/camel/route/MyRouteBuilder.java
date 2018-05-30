package com.raj.sample.camel.route;

import java.util.Date;
import java.util.Objects;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
class MyRouteBuilder extends RouteBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRouteBuilder.class);
        @Override
        public void configure() throws Exception {
            from("timer:simple?period=503")
                .id("simple-route")
                .transform()
                    .exchange(this::dateToTime)
                .process()
                    .message(this::log)
                .process()
                    .body(this::log)
                .choice()
                    .when()
                        .body(Integer.class, b -> (b & 1) == 0)
                        .log("Received even number")
                    .when()
                        .body(Integer.class, (b, h) -> h.containsKey("skip") ? false : (b & 1) == 0)
                        .log("Received odd number")
                    .when()
                        .body(Objects::isNull)
                        .log("Received null body")
                    .when()
                        .body(Integer.class, b -> (b & 1) != 0)
                        .log("Received odd number")
                .endChoice();
        }

        private Long dateToTime(Exchange e) {
            return e.getProperty(Exchange.TIMER_FIRED_TIME, Date.class).getTime();
        }

        private void log(Object b) {
            LOGGER.info("body is: {}", b);
        }

        private void log(Message m) {
            LOGGER.info("message is: {}", m);
        }
    }