package testspringbean;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
	static Logger log = Logger.getLogger(MainClass.class.getName());
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("WebModuleApplicationContext.xml");
				
		log.info("Going to create HelloWord Obj");
		Person person = (Person)context.getBean("person");
		String message = person.getMessage();
		System.out.println(message);
		
		log.info("Exiting the program");
	}

}
