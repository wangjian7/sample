package rmi.helloworld.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

    private HelloClient() {}

    public static void main(String[] args) {

	String host = "localhost";
	try {
	    Registry registry = LocateRegistry.getRegistry(host);
	    Hello stub = (Hello) registry.lookup("Hello");
	    String response = stub.sayHello();
	    System.out.println("response: " + response);
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}