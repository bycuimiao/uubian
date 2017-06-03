package com.uubian.api.domain;

public class Message {
	private int status;
	private String msgText;
	
	public Message(){
		status=0;
		msgText="";
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsgText() {
		return msgText;
	}
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	public static Message init(int status,String msgText){
		Message msg = new Message();
		msg.setMsgText(msgText);
		msg.setStatus(status);
		return msg;
	}
	public static Message init(int status){
		Message msg = new Message();
		msg.setStatus(status);
		return msg;
	}
	public static Message init(String msgText){
		Message msg = new Message();
		msg.setMsgText(msgText);
		return msg;
	}
}
