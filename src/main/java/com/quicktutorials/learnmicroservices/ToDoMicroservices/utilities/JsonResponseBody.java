package com.quicktutorials.learnmicroservices.ToDoMicroservices.utilities;

public class JsonResponseBody {

	private int server;//http response code
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public JsonResponseBody(int server, Object response) {
		
		this.server = server;
		this.response = response;
	}
	public JsonResponseBody() {
		
	}
	private Object response;
	
}

