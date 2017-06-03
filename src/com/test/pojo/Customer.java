package com.test.pojo;

public class Customer {
	private int cusId;
	private String name;
	private int age;
	
	private Address addr;
	
	public Customer(){}
	
	public Customer(int cusId, String name, int age) {
		this.cusId = cusId;
		this.name  = name;
		this.age   = age;
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
