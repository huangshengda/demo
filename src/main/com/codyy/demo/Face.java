package main.com.codyy.demo;

public class Face implements Cloneable {
	
	private int age;
	private String name;
	
	public Face(){
		
	}
	
	public Face(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Face face = (Face) super.clone();
		return face;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
