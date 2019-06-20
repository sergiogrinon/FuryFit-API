package com.furyfit.models;

public class InterestLink {
	
	int id;
	String picSRC, pageLink;
	
	public InterestLink(int id, String picSRC, String pageLink) {
		super();
		this.id = id;
		this.picSRC = picSRC;
		this.pageLink = pageLink;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicSRC() {
		return picSRC;
	}
	public void setPicSRC(String picSRC) {
		this.picSRC = picSRC;
	}
	public String getPageLink() {
		return pageLink;
	}
	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	
	

}
