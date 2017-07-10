package com.test.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Soldier {
	private String category;
	//字段装配
	//如果找不到匹配的bean，不抛错，不设置weapon属性
	@Autowired
	//没起作用...
	@Qualifier("weaponBean1")
	private Weapon weapon;
	
	//构造方法装配
//	@Autowired
//	public Soldier(Weapon wpn){
//		this.weapon = wpn;
//	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	//用setter方法装配
	//@Autowired
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
