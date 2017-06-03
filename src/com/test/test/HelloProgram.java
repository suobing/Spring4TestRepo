package com.test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.helloworld.HelloWorld;
import com.test.pojo.Animal;
import com.test.service.HelloWorldService;

public class HelloProgram {
	public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        //getBean方法-----总有一个入口
        HelloWorldService service =  (HelloWorldService) context.getBean("helloWorldService");
        
//        HelloWorld helloWorld = service.getHelloWorld();
//        helloWorld.sayHello();
        
        service.execute();
        
        HelloWorld entry = (HelloWorld) context.getBean("strutsHelloWorld");
        entry.sayHello();
        
        Animal animal = (Animal) context.getBean("animal");
        animal.speak();
	}
}
