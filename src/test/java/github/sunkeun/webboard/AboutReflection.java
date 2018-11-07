package github.sunkeun.webboard;

import java.lang.reflect.Method;
import java.util.ArrayList;





public class AboutReflection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Class.forName("github.sunkeun.webboard.web.HomeController");
		/*
		HomeController obj = HomeController.class.newInstance();
		Method m = HomeController.class.getMethod("getArray");
		*/
		
	/*	Student s = new Student();
		s.getName();*/
		/*
		Student s2 = Student.class.newInstance();
		
		Method m = Student.class.getMethod("getName", null);
		m.invoke(s2, args)
		*/
		
		ArrayList<String> names = new ArrayList<>();
		names.add("dkdkd");
	}
}
