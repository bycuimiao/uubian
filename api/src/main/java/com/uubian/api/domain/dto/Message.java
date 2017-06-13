package com.uubian.api.domain.dto;

public class Message {
	private int code;
	private String text;
	
	public Message(){
		code=0;
		text="";
	}
	

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public static Message init(int code,String text){
		Message message = new Message();
		message.setText(text);
		message.setCode(code);
		return message;
	}
	public static Message init(int code){
		Message msg = new Message();
		msg.setCode(code);
		return msg;
	}
	public static Message init(String text){
		Message message = new Message();
		message.setText(text);
		return message;
	}
}
