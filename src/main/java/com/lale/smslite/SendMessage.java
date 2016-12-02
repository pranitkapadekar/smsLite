package com.lale.smslite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendMessage {
	public static String ACCOUNT_SID;
	public static String AUTH_TOKEN;
	public static String SENDER_PHONE_NUMBER;

	public SendMessage(){
		@SuppressWarnings("unused")
		Properties prop = new Properties();
		@SuppressWarnings("unused")
		InputStream properties = null;
		try {
			properties = new FileInputStream("/Users/pranit.kapadekar/Documents/workspace/smslite/src/main/java/com/lale/smslite/config.properties");
			try {
				prop.load(properties);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ACCOUNT_SID = prop.getProperty("twilio.account_sid");
			AUTH_TOKEN = prop.getProperty("twilio.auth_token");
			SENDER_PHONE_NUMBER = prop.getProperty("twilio.sender_phone");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void sendMessage(LaleMessage laleMessage, LalePhoneNumber laleNumber){
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			try{
	    		Message message = Message.creator(new PhoneNumber(laleNumber.getPhoneNumber()),
	    		        new PhoneNumber(SENDER_PHONE_NUMBER), 
	    		        laleMessage.getMessage()).create();
	    		System.out.println("Message sent successfully to:"+laleNumber.getPhoneNumber());
	    	} catch (Exception e){
	    		System.out.println("Encountered some issues sending message to"+laleNumber.getPhoneNumber());
	    	}
			
	}
	
	public  void broadCastMessage(LaleMessage laleMessage,List<LalePhoneNumber> lalePhoneNumbers){
		for(LalePhoneNumber lalePhoneNumber: lalePhoneNumbers){
			sendMessage(laleMessage, lalePhoneNumber);
		}
	}
	
	
	public static void main(String[] args) {
		SendMessage message = new SendMessage();
	}
	

}
