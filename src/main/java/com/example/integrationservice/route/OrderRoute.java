package com.example.integrationservice.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;

@Component
public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() {
    	
    	JaxbDataFormat jaxb = new JaxbDataFormat(); 
    	  jaxb.setContextPath("com.test.integrationservice.wsdl"); 


        // Define the route to interact with the SOAP service
        from("direct:getOrderStatus")
        	.log("SOAP request: ${body}")
            .to("spring-ws://http://localhost:8080/ws/status.wsdl")
            .log("SOAP Response: ${body}")
            .unmarshal(jaxb)
            .log("After unmarshall: ${body}");
    }
}