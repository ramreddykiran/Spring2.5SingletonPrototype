package com.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.customer.services.demo1.PrototypeService;
import com.customer.services.demo1.SingletonService;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-Customer.xml"});
    	App app = new App();
    	
    	//This will demonstrate single class level scope
    	app.demo1(context);
    	
    	//super class is singleton and subclass is prototype
    	app.demo2(context);
    }

	private void demo2(ApplicationContext context) {
		
	}

	private void demo1(ApplicationContext context) {
		System.out.println("demo1 started");
		PrototypeService prototypeService1 = (PrototypeService)context.getBean("prototypeService");
    	prototypeService1.setPrototypeMessage("prototype service message");
    	System.out.println("Prototype Message : " + prototypeService1.getPrototypeMessage());
    	
    	//retrieve it again
    	PrototypeService prototypeService2 = (PrototypeService)context.getBean("prototypeService");
    	
    	System.out.println("Prototyppe Message : " + prototypeService2.getPrototypeMessage()); 
    	// it displays null as the scope is prototype
    	
    	SingletonService singletonService1 = (SingletonService) context.getBean("singletonService");
    	singletonService1.setSingletonMessage("singleton service message");
    	System.out.println("singleton message "+singletonService1.getSingletonMessage());
    	
    	SingletonService singletonService2 = (SingletonService) context.getBean("singletonService");
    	System.out.println("singleton message "+singletonService2.getSingletonMessage());
    	//it displays singletonService1 message as the scope is singleton
    	
    	System.out.println("demo1 completed");
	}
}
