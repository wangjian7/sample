package rpc.javacodegeeks.client;


public class WSClient {
	public static void main(String[] args) {

	WebServiceImplService webService = new WebServiceImplService();
	WebServiceInterface serviceInterface = webService.getWebServiceImplPort();

	System.out.println(serviceInterface.getHelloWorldAsString("- This is Java Code Geeks"));
 }
}