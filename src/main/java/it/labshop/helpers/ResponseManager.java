package it.labshop.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseManager {

	private ObjectMapper mapper;
	private int code;          
	private String message;   
	
	public ResponseManager( int code, String message ){ 
		mapper = new ObjectMapper(); 
		this.code = code;         
		this.message = message;      
	}
	
	public ObjectNode getResponse(){ 
		ObjectNode objJson = mapper.createObjectNode();
		objJson.put("code", this.code);             
		objJson.put("status", this.message);
		return objJson;
	}
	
	
	
}
