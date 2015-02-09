package rmi.helloworld;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl implements Hello {

	public HelloImpl() {
	}

	public String sayHello() {
		return "Hello, world!";
	}

	public static void main(String args[]) {

		try {
			  System.out.println(InetAddress.getLocalHost().getHostName());
			HelloImpl obj = new HelloImpl();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Hello", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
