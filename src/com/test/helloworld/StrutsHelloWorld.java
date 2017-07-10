package com.test.helloworld;

public class StrutsHelloWorld implements HelloWorld{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Struts say Hello!");
	}

	@Override
	public Integer foo() {//方法重写，返回类型可以是其子类(Object->Integer)
		// TODO Auto-generated method stub
		return null;
	}

}
