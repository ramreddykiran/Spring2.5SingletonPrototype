package com.scope.services.demo3;

public class PrototypeSuperClass {
	
	/*public PrototypeSuperClass(){
		System.out.println("Demo3 PrototypeSuperClass DC");
	}*/
	
	private SingletonSubClass singletonSubClass;

	public SingletonSubClass getSingletonSubClass() {
		return singletonSubClass;
	}

	public void setSingletonSubClass(SingletonSubClass singletonSubClass) {
		this.singletonSubClass = singletonSubClass;
	}
	

}
