package rpc.javacodegeeks;

import javax.xml.ws.Endpoint;
import rpc.javacodegeeks.WebServiceImpl;

public class WebServicePublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8888/webservice/helloworld", new WebServiceImpl());
    }

}
