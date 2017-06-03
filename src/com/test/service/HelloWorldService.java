package com.test.service;

import com.test.helloworld.HelloWorld;
import com.test.helloworld.StrutsHelloWorld;

public class HelloWorldService {
	
	private HelloWorld helloWorld;
	
//	public HelloWorldService(){
//        this.helloWorld = new StrutsHelloWorld();
//  }
	
	public HelloWorldService(){}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public void execute(){
		this.helloWorld.sayHello();
	}
}
