package com.scope.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scope.services.demo1.PrototypeService;
import com.scope.services.demo1.SingletonService;
import com.scope.services.demo2.PrototypeSubClass;
import com.scope.services.demo2.SingletonSuperClass;
import com.scope.services.demo3.PrototypeSuperClass;
import com.scope.services.demo3.SingletonSubClass;

public class ScopeDemo {
    public static void main( String[] args ) {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
    	ScopeDemo scopeDemo = new ScopeDemo();
    	
    	//This will demonstrate single class level scope
    	//scopeDemo.demo1(context);
    	
    	//super class is singleton and subclass is prototype
    	//scopeDemo.demo2(context);
    	
    	//super class is prototype and subclass is singleton
    	scopeDemo.demo3(context);
    	
    	//super class prototype and subclass prototype
    }

	private void demo3(ApplicationContext context) {
		System.out.println("demo3 started");
		PrototypeSuperClass prototypeSuperClass1 = (PrototypeSuperClass) context.getBean("prototypeSuperClass");
		SingletonSubClass scSub1 = prototypeSuperClass1.getSingletonSubClass();
		
		PrototypeSuperClass prototypeSuperClass2 = (PrototypeSuperClass) context.getBean("prototypeSuperClass");
		SingletonSubClass scSub2 = prototypeSuperClass2.getSingletonSubClass();
		if(prototypeSuperClass1==prototypeSuperClass2){
			System.out.println("prototype super classes are same");
		} else {
			System.out.println("prototype super classes are different ");
			System.out.println("prototypeSuperClass1 = "+prototypeSuperClass1+ "   prototypeSuperClass2 = " +prototypeSuperClass2);
		}
		
		
		if(scSub1==scSub2){
			System.out.println("singleton sub classes are same");
			
		}else {
			System.out.println("singleton sub classes are different ");
			System.out.println("singletonSubClass1 = "+scSub1+ "   singletonSubClass2 = " +scSub2);
		}
		System.out.println("demo3 completed");
	}

	private void demo2(ApplicationContext context) {
		System.out.println("demo2 started");
		SingletonSuperClass singletonSuperClass1 = (SingletonSuperClass) context.getBean("singletonSuperClass");
		PrototypeSubClass pcSub1 =singletonSuperClass1.getPrototypeSubClass();
		
		SingletonSuperClass singletonSuperClass2 = (SingletonSuperClass) context.getBean("singletonSuperClass");
		PrototypeSubClass pcSub2 = singletonSuperClass2.getPrototypeSubClass();
		
		if(singletonSuperClass1==singletonSuperClass2){
			System.out.println("singleton classes are same");
		} else {
			System.out.println("singleton classes are different ");
			System.out.println("singletonSuperClass1 = "+singletonSuperClass1+ "   singletonSuperClass2 = " +singletonSuperClass2);
		}
		
		
		if(pcSub1==pcSub2){
			System.out.println("prototype sub classes are same");
			
		}else {
			System.out.println("prototype sub classes are different ");
			System.out.println("prototypeSubClass1 = "+pcSub1+ "   prototypeSubClass2 = " +pcSub2);
		}
		System.out.println("demo2 completed");
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
