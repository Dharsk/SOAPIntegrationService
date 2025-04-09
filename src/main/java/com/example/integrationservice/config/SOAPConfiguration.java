
package com.example.integrationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.integrationservice.soapclient.OrderstatusClient;

@Configuration
public class SOAPConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.test.integrationservice.wsdl");
		return marshaller;
	}


	@Bean
	public OrderstatusClient orderStatusClient(Jaxb2Marshaller marshaller) {
		OrderstatusClient client = new OrderstatusClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
