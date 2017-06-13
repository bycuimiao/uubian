package com.uubian.api.domain.postgres;

public class UserDetail {
	private long user_id;
	private String realname;//真实姓名
	private String domicile_country;
	private String domicile_province;
	private String domicile_city;
	private String domicile_county;
	private String headurl;
	private int sex;
	private String occupation;//职业
	private String industry;//行业
	private String summary_base;//一句话简介
	private String summary_detail;//详细简介
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getDomicile_country() {
		return domicile_country;
	}
	public void setDomicile_country(String domicile_country) {
		this.domicile_country = domicile_country;
	}
	public String getDomicile_province() {
		return domicile_province;
	}
	public void setDomicile_province(String domicile_province) {
		this.domicile_province = domicile_province;
	}
	public String getDomicile_city() {
		return domicile_city;
	}
	public void setDomicile_city(String domicile_city) {
		this.domicile_city = domicile_city;
	}
	public String getDomicile_county() {
		return domicile_county;
	}
	public void setDomicile_county(String domicile_county) {
		this.domicile_county = domicile_county;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSummary_base() {
		return summary_base;
	}
	public void setSummary_base(String summary_base) {
		this.summary_base = summary_base;
	}
	public String getSummary_detail() {
		return summary_detail;
	}
	public void setSummary_detail(String summary_detail) {
		this.summary_detail = summary_detail;
	}

	
	
}
