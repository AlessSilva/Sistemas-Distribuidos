package message;

public class Message {
	
	private int messageType;
	
	
	private int requestID;
	private String objectReference;
	private int methodID;
	private String arguments;
	
	public Message() {}
	
	public Message(int messageType, int requestID, String objectReference, int methodID, String arguments) {
		
		this.messageType = messageType;
		this.requestID = requestID;
		this.objectReference = objectReference;
		this.methodID = methodID;
		this.arguments = arguments;
	
	}
	
	//get's and set's methods
	
	public int getMessageType() {
	
		return messageType;
	
	}
	public void setMessageType(int messageType) {
	
		this.messageType = messageType;
	
	}
	public int getRequestID() {
	
		return requestID;
	
	}
	public void setRequestID(int requestID) {
	
		this.requestID = requestID;
	
	}
	public String getObjectReference() {
	
		return objectReference;
	
	}
	public void setObjectReference(String objectReference) {
	
		this.objectReference = objectReference;
	
	}
	public int getMethodID() {
	
		return methodID;
	
	}
	public void setMethodID(int methodID) {
	
		this.methodID = methodID;
	
	}
	public String getArguments() {
	
		return arguments;
	
	}
	public void setArguments(String arguments) {
	
		this.arguments = arguments;
	}
}
