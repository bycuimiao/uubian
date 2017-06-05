package com.uubian.api.domain;

public class Message {
	private int code;
	private String msgText;
	
	public Message(){
		code=0;
		msgText="";
	}
	

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMsgText() {
		return msgText;
	}
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	public static Message init(int code,String msgText){
		Message msg = new Message();
		msg.setMsgText(msgText);
		msg.setCode(code);
		return msg;
	}
	public static Message init(int code){
		Message msg = new Message();
		msg.setCode(code);
		return msg;
	}
	public static Message init(String msgText){
		Message msg = new Message();
		msg.setMsgText(msgText);
		return msg;
	}
}
