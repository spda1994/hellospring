package com.withvaadin.vaadinExample;

import java.util.Date;

public class Todos {

	private int id;
	private String title;
	private String priority;
	private Date date;

	public Todos(int id, String title, String priority, Date date) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.title=title;
		this.priority=priority;
		this.date=new Date();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	

}
