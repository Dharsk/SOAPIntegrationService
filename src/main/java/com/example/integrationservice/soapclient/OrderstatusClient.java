
package com.example.integrationservice.soapclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.test.integrationservice.wsdl.OrderStatusRequest;
import com.test.integrationservice.wsdl.OrderStatusResponse;

public class OrderstatusClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(OrderstatusClient.class);

	public OrderStatusResponse getStatus(String country) {

		OrderStatusRequest request = new OrderStatusRequest();
		request.setOrderId("001");

		log.info("Requesting location for " + country);

		OrderStatusResponse response = (OrderStatusResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://soapservice.com/soapentity/OrderStatusRequest"));

		return response;
	}

}
