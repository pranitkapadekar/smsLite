package com.lale.smslite;

/**
 * @author pranit.kapadekar
 *This class represents a message sent from Lale
 *It has utility to make sure the message is screened before its sent to the end user
 */
public class LaleMessage {
	
	/**
	 * The actual message
	 */
	private String message;
	
	/**
	 * The allowed length of message;
	 */
	private Integer maxLength;
	
	public LaleMessage(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	
	public String getScreenedMessage(){
		// do something with this 
		return message;
		
	}
	
	
	
	
	
	

}
