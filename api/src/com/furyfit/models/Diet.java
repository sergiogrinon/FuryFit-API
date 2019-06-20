package com.furyfit.models;

public class Diet {
	
	//Diet data
	int id;
	String name, type, description;
	
	//Constructor
	public Diet(int id, String name, String type, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
	}

	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
