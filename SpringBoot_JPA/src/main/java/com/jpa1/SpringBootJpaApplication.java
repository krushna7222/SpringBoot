package com.jpa1;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/* JPA is the specification
hibernate is the implementation of JPA(Java Persistence API)


JpaRepository and CrudRepository

*/

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootJpaApplication.class, args);
		
		StudentRepository stud = (StudentRepository) context.getBean("studentRepository");
		
		/*
		
		//1. Saving Single object
		
		Student st = new Student();
			st.setName("Sachin");
			st.setMarks(537.30);
			
			Student s = stud.save(st);
			
			System.out.println("You inserted Data "+s);
			
			*/
		
		
		/*
		
		//2.saving multiple objects
		 Student s= new Student();
		    s.setName("yash");
		    s.setMarks(822.2);
		    
		    Student s2= new Student();
		    s2.setName("uday");
		    s2.setMarks(922.2);  
		    
		    
		    Student s3= new Student();
		    s3.setName("priya");
		    s3.setMarks(322.2); 
		    
		    List<Student> studList= List.of(s,s2,s3);
		     
		    
		   List result= stud.saveAll(studList);  //Iterable => List,Set,Map,array  int a=90;
		System.out.println("\n\nmultiple objects saved by you "+result+"\n\n");
		
		*/
		
		/*
		//3 select Opration for getting all data
		
		List<Student> stlist = stud.findAll();
		
		stlist.forEach((s)->System.out.println(s));
		*/
		
		
		/*
		 
		//4 find single record
		
		Optional<Student> op = stud.findById(2);
				Student st = op.get();
		
		System.out.println(st);
		
		*/
		
		/*
		
		//5 update single record
		
		Optional<Student> op = stud.findById(53);
		Student st = op.get();
		
		st.setName("Hemraj");
		st.setMarks(366.25);
		
		Student sob = stud.save(st);
		
		System.out.println(sob);
		
		*/
		
		
		/*
		//6 delete single record
	
		stud.deleteById(54);
		
		List<Student> stlist = stud.findAll();	
		stlist.forEach((s)->System.out.println(s));
		*/
		
		
		/*
		//7 delete Multiple record
		
		Optional<Student> op = stud.findById(2);
		Student st = op.get();
		
		Optional<Student> op1 = stud.findById(3);
		Student st1 = op1.get();
		
		Optional<Student> op2 = stud.findById(4);
		Student st2 = op2.get();
		
		List<Student> slist = List.of(st,st1,st2);
		
		
			stud.deleteAll(slist);
			
			List<Student> stlist = stud.findAll();	
			stlist.forEach((s)->System.out.println(s));
			
			*/
			
			
		/*
		//8 delete all record
		
			stud.deleteAll();
			
			List<Student> stlist = stud.findAll();	
			stlist.forEach((s)->System.out.println(s));
			
			
			*/
		
			//9.
//	          List<Student> nameList=  stud.findByName("jayesh");    
//	              nameList.forEach((s)-> System.out.println(s));
	     
	    
	       //10.
//	      List<Student> nameList=  stud.findByMarks( 385.25 );    
//	      nameList.forEach((s)-> System.out.println(s));

	     
	       // List<Student> nameList=  stud.getByName("jayesh");    
	       //nameList.forEach((s)-> System.out.println(s));

//	     List<Student> nameList=  stud.findByNameStartingWith("j");    
//	     nameList.forEach((s)-> System.out.println(s));
	     
	     
//	     List<Student> nameList=  stud.findByNameContaining("ay");    
//	     nameList.forEach((s)-> System.out.println(s));
		
//		List<Student> nameList=  stud.findByMarksLessThan(885.25);
//		nameList.forEach((s)-> System.out.println(s));
		
//		List<Student> nameList=  stud.findByMarksGreaterThanEqual(885.25);
//		nameList.forEach((s)-> System.out.println(s));
		
		
		
//		List<Double> mlist=List.of(885.25,355.25,358.25,458.25); 
//		List<Student> nameList=  stud.findByMarksIn(mlist);
//		nameList.forEach((s)-> System.out.println(s));

		
//		List<Student> studlist=  stud.getAllData();    
//		studlist.forEach((s)-> System.out.println(s));
		
		
//		List<Student> studlist=  stud.getAllStudentByUsingOrderClause();    
//		studlist.forEach((s)-> System.out.println(s));
		
		
//		List<Student> studlist=  stud.getStudentWithNameAndMarks("Jayesh", 358.25);    
//		studlist.forEach((s)-> System.out.println(s));
		
		
		List<Student> studlist=  stud.getAllStuds();    
		studlist.forEach((s)-> System.out.println(s));
		
				
	}

}
