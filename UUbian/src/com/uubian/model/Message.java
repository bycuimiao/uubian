package com.uubian.model;

public class Message {
	public int status;
	public String msgText;
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
	public static Message init(int s,String t){
		Message msg = new Message();
		msg.setMsgText(t);
		msg.setStatus(s);
		return msg;
	}
}
