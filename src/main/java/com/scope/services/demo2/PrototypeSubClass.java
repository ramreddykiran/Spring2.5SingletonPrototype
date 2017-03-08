package com.scope.services.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Service
//@Scope(value="prototype")
public class PrototypeSubClass {
	
	public PrototypeSubClass(){
		System.out.println("PrototypeClass DC");
	}

	public void validate(String requestId) {
		
	}

}
