package com.raj.sample.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class BaseRestRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/*restConfiguration().component("{{component}}").port("{{port}}")
		  .bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true");	*/

		restConfiguration()
			.component("{{component}}").port("{{port}}")
        		//.contextPath("/camel-sample")
        		.apiContextPath("/api-doc")
            .apiProperty("api.title", "Camel REST API")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true")
            .apiContextRouteId("doc-api")
            .scheme("https").port("4431")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            ;
	}

}
