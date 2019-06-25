package client;

import com.google.gson.*;
import message.*;
import java.net.*;

import java.io.*;

public class ClientTCP {
	
	private Socket socket;
	private Gson gson;
	private DataInputStream input;
	private DataOutputStream output;
	private static int requestID = 0;
	
	public ClientTCP(){
		try {
			this.gson = new Gson();
			this.socket = new Socket( "10.0.124.63", 9999 );
			this.input = new DataInputStream( socket.getInputStream() );
			this.output = new DataOutputStream( socket.getOutputStream() );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public String doOperation( String remoteObjectRef, int methodID, String arguments ) {
		try {
			requestID+=1;
			Message messageRequest = new Message( 0, requestID, remoteObjectRef, methodID, arguments );
			String request = gson.toJson(messageRequest);
			
			//:tamanhoJson:{...Json...}
			sendRequest( ":"+request.length()+":"+request );
			
			Message messageResponse = getResponse(remoteObjectRef, methodID);
		
			if( messageResponse == null ) {
				
				return "erro";
				
			}
			
			return messageResponse.getArguments();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	private void sendRequest( String request ){
		try {
			
			output.writeUTF( request );
			
			System.out.println("Request: " + request);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	private Message getResponse( String remoteObjectRef, int methodID ){
		try {
			
			BufferedReader i = new BufferedReader(new InputStreamReader(input));
			String response = i.readLine();
			
			System.out.println("Response: " + response.substring(2));
			
			Message messageResponse = gson.fromJson( response, Message.class );
			
			System.out.println("Aqui");
			
			if( requestID == messageResponse.getRequestID() ) {
				
				return messageResponse;
			
			}
			
		
		} catch (Exception e) {
			
			System.out.println("Response Inválido");
			
		}
		
		return null;
		
	}
	
	
	public void close(){
		try {
			this.socket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}