package com.lale.smslite;

import java.util.ArrayList;
import java.util.List;

public class SendMessageService{

   public SendMessageService(){
	   
   }
	
	
	public void broadCastMessage(String message, List<String> phoneNumbers){
		LaleMessage laleMessage = new LaleMessage(message);
		List<LalePhoneNumber> lalePhoneNumbers = getListOfNumbers(phoneNumbers);
		SendMessage sendMessage = new SendMessage();
		sendMessage.broadCastMessage(laleMessage, lalePhoneNumbers);
	}
	
	public List<LalePhoneNumber> getListOfNumbers(List<String> phoneNumbers){
		ArrayList<LalePhoneNumber> numList = new ArrayList<LalePhoneNumber>();
		for(String num : phoneNumbers){
			numList.add(new LalePhoneNumber(num));
		}
		return numList;
	}

	public static void main(String[] args) {
		SendMessageService service = new SendMessageService();
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers.add("+12134472302");
		service.broadCastMessage("Test message", phoneNumbers);
		
	}	
}
