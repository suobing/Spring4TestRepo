package com.test.pojo;

public class Person {
	private Ability ability;

	//构造方法装备，或者自动装配时，使用
//	public Person(Ability ably){
//		System.out.println("autowiring by constructor");
//		this.ability = ably;
//	}
	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		System.out.println("autowiring by type");
		this.ability = ability;
	}
	
}
