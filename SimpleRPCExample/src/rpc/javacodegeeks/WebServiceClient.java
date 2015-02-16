package rpc.javacodegeeks;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WebServiceClient{

	public static void main(String[] args) throws Exception {

	    URL wsdlUrl = new URL("http://localhost:8888/webservice/helloworld?wsdl");

	    //qualifier name ...
        QName qname = new QName("http://javacodegeeks.rpc/", "WebServiceImplService");

        Service service = Service.create(wsdlUrl, qname);

        WebServiceInterface helloWorldInterface = service.getPort(WebServiceInterface.class);

        System.out.println(helloWorldInterface.getHelloWorldAsString("- This is Java Code Geeks")); 
   } 
}
