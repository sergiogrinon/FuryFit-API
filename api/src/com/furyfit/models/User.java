package com.furyfit.models;

public class User {
	
	//User data
	int id, age;
	float height, weight;
	String name, surname, username, email, sex, objective, specialCar;
	
	//Constructor
	public User(int id, int age, float height, float weight, String name, String surname, String username, String email,
			String sex, String objective, String specialCar) {
		this.id = id;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.sex = sex;
		this.objective = objective;
		this.specialCar = specialCar;
	}
	
	//Constructor without id for the queries
	public User(int age, float height, float weight, String name, String surname, String username, String email,
			String sex, String objective, String specialCar) {
		super();
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.sex = sex;
		this.objective = objective;
		this.specialCar = specialCar;
	}



	//Getter and Setter Methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getSpecialCar() {
		return specialCar;
	}

	public void setSpecialCar(String specialCar) {
		this.specialCar = specialCar;
	}
	
}
