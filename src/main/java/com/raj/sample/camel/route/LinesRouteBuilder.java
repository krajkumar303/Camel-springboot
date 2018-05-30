package com.raj.sample.camel.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raj.sample.camel.bean.LineBean;
import com.raj.sample.camel.domain.LineCountRequest;
import com.raj.sample.camel.domain.LineCountResponse;

@Component
public class LinesRouteBuilder extends BaseRestRouteBuilder {

  @Autowired
  LineBean lineBean;

  @Override
  public void configure() throws Exception {
    super.configure();
    rest("/lines").description("Line API").consumes("application/json").produces("application/json")

        .post("/count").description("Line Count API which will give you the CLEU and ELEU count")
        .type(LineCountRequest.class).outType(LineCountResponse.class).to("direct:lineCount");

    countRoute();
  }

  private void countRoute() {
    from("direct:lineCount").log("I am here:: ${body}").bean(lineBean, "createResponse");

    from("direct:postPersons").log("I am here:: ${body}").bean(lineBean, "createResponse");
   /* from("file://A")
      .split().tokenize("\n", 999)
      .streaming()
      .log("Spliting::::::::::")
        .unmarshal("csv").bean("transferDate", "enrich").marshal("csv")
      .to("file://B?fileExist=Append");
    
    from("file://B?delete=true").to("file://A"); */
  }

}
