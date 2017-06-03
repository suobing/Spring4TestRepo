package com.test.pojo;

public class Animal {
	private String category;
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public void speak(){
		System.out.println("I am a "+ this.category);
	}
}
