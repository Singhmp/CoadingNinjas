package com.rahclassvar;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	Bird myBird=new Bird();
//	
//	System.out.println(myBird.getSpeed());
//
//	myBird.fly();
	
System.out.println(Bird.getSpeed());
	
	Bird.setSpeed(25);
	System.out.println(Bird.getSpeed());
	Bird mySecondBird=new Bird();
	
	System.out.println(mySecondBird.getSpeed());
	
	mySecondBird.setSpeed(45);
	System.out.println(Bird.getSpeed());
	
	Bird myThirdBird=new Bird();
	System.out.println(myThirdBird.getSpeed());
	
	Bird.fly();
	method1();
	}

public static void method1() {
	
	System.out.println("Method");
	
}

}
