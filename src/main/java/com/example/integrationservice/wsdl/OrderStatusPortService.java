
package com.example.integrationservice.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "OrderStatusPortService", targetNamespace = "http://soapservice.com/soapentity", wsdlLocation = "http://localhost:8080/ws/status.wsdl")
public class OrderStatusPortService
    extends Service
{

    private final static URL ORDERSTATUSPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException ORDERSTATUSPORTSERVICE_EXCEPTION;
    private final static QName ORDERSTATUSPORTSERVICE_QNAME = new QName("http://soapservice.com/soapentity", "OrderStatusPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ws/status.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORDERSTATUSPORTSERVICE_WSDL_LOCATION = url;
        ORDERSTATUSPORTSERVICE_EXCEPTION = e;
    }

    public OrderStatusPortService() {
        super(__getWsdlLocation(), ORDERSTATUSPORTSERVICE_QNAME);
    }

    public OrderStatusPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDERSTATUSPORTSERVICE_QNAME, features);
    }

    public OrderStatusPortService(URL wsdlLocation) {
        super(wsdlLocation, ORDERSTATUSPORTSERVICE_QNAME);
    }

    public OrderStatusPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDERSTATUSPORTSERVICE_QNAME, features);
    }

    public OrderStatusPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderStatusPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrderStatusPort
     */
    @WebEndpoint(name = "OrderStatusPortSoap11")
    public OrderStatusPort getOrderStatusPortSoap11() {
        return super.getPort(new QName("http://soapservice.com/soapentity", "OrderStatusPortSoap11"), OrderStatusPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderStatusPort
     */
    @WebEndpoint(name = "OrderStatusPortSoap11")
    public OrderStatusPort getOrderStatusPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://soapservice.com/soapentity", "OrderStatusPortSoap11"), OrderStatusPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDERSTATUSPORTSERVICE_EXCEPTION!= null) {
            throw ORDERSTATUSPORTSERVICE_EXCEPTION;
        }
        return ORDERSTATUSPORTSERVICE_WSDL_LOCATION;
    }

}
