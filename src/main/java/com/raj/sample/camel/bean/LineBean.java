package com.raj.sample.camel.bean;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.raj.sample.camel.domain.LineCountResponse;

@Component
public class LineBean {

	public void createResponse(Exchange exchange) {
		LineCountResponse response = new LineCountResponse();
		response.setCleuCount(8);
		response.setEleuCont(2);
		response.setTotalCount(10);
		exchange.getIn().setBody(response);
	}
}
