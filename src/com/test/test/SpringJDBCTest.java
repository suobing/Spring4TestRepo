package com.test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.CustomerDao;
import com.test.pojo.Customer;
import com.test.pojo.Person;

public class SpringJDBCTest {
	public static void main(String[] args){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("com/test/test/applicationContext.xml");
		
		CustomerDao customerDao = (CustomerDao) cfx.getBean("customerDAO");
		
//		Customer customer1 = new Customer(12310,"maomao",26);
//		customerDao.insert(customer1);
		

		Customer customer2 = customerDao.findByCustomerId(12309);
		
		System.out.println(customer2.getCusId()+" "+customer2.getName()+" "+customer2.getAge());
		try{	
			System.out.println(customer2.getAddr().getFulladdr());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//自动装配,对象已赋属性值
		//byName
		Customer customer3 = (Customer) cfx.getBean("customer");
		System.out.println(customer3.getAddr().getFulladdr());

		//byType
		Person person = (Person) cfx.getBean("person");
		System.out.println(person.getAbility().getSkill());
//		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.class.path"));
	}
}
