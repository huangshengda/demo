package main.com.codyy.demo;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Face face = new Face(28,"Tom");
		Face face2 = (Face) face.clone();
		
		System.out.println(face.getName() == face2.getName());
		
		System.out.println(face == face2);
	}

}
