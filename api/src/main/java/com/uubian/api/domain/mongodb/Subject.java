package com.uubian.api.domain.mongodb;

import org.springframework.data.annotation.Id;

public class Subject {
	@Id
	private String id;
	private String title;
	private String detail;
	private String obverse;
	private String reverse;
	private int votenum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getObverse() {
		return obverse;
	}
	public void setObverse(String obverse) {
		this.obverse = obverse;
	}
	public String getReverse() {
		return reverse;
	}
	public void setReverse(String reverse) {
		this.reverse = reverse;
	}
	public int getVotenum() {
		return votenum;
	}
	public void setVotenum(int votenum) {
		this.votenum = votenum;
	}
}
