package com.fanchen.clearmind;

public class People {
	
	private String name;
	
	private int age;
	
	private String nationality;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Get functions
	 * @return
	 */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getNationality() {
		return nationality;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Set functions
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public People() {
		this.name = "fan";
		this.age = 26;
		this.nationality = "Chinese";
	}
	
	public People(String namePassIn, int agePassIn, String nationalityPassIn) {
		this.name = namePassIn;
		this.age = agePassIn;
		this.nationality = nationalityPassIn;
	}
	
	public String toString() {
		return this.name +" "+ this.age + " "+ this.nationality;
	}
	

	public String toBigString() {
		return this.name +" "+ this.age + " "+ this.nationality+this.name +" "+ this.age + " "+ this.nationality;
	}
	
	
	
	public static void main(String[] args) {
		
		People JinBao = new People();
		
		System.out.println(JinBao.age);
		System.out.println(JinBao.name);
		System.out.println(JinBao.nationality);
		
	}
	
	
	

}
