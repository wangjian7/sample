package rpc.javacodegeeks;

import javax.jws.WebService;

@WebService(endpointInterface = "rpc.javacodegeeks.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String getHelloWorldAsString(String str) {
		return "Hello World of JAX-WS " + str;
	}

}
