package com.scope.services.demo2;


public class SingletonSuperClass {
	
	/*public SingletonSuperClass(){
		System.out.println("Demo2 SingletonSuperClass DC");
	}
	*/
	private PrototypeSubClass prototypeSubClass;
	
	public PrototypeSubClass getPrototypeSubClass() {
		return prototypeSubClass;
	}

	public void setPrototypeSubClass(PrototypeSubClass prototypeSubClass) {
		this.prototypeSubClass = prototypeSubClass;
	}

}
