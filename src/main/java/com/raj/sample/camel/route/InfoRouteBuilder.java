package com.raj.sample.camel.route;

import org.springframework.stereotype.Component;

@Component
public class InfoRouteBuilder extends BaseRestRouteBuilder {

	@Override
	public void configure() throws Exception {
		super.configure();
		rest("/info").description("InFo API")

				.get("/").description("InFo API")
				.to("direct:info");

		infoRoute();
	}

	private void infoRoute() {
		from("direct:info")
			.log("I am here:: ${body}")
			.setBody().simple("This is sample Spring Boot, Camel integration project")
		;

	}

}