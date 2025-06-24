package com.jpa1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	  //custom finder methods/derived query methods
    public List<Student>  getByName(String s );
    public List<Student>  findByMarks(double m );
    public List<Student>  findByName(String s );
    
    
    public List<Student> findByNameStartingWith(String prefix);
    
    public List<Student> findByNameEndingWith(String prefix);
    
    public List<Student> findByNameContaining(String prefix);
    
    public List<Student> findByNameLike(String words);
    
    
    public List<Student> findByMarksLessThan(double marks);
    public List<Student> findByMarksGreaterThanEqual(double marks);
    
    public List<Student> findByMarksIn(List<Double> marks);
//    
    public List<Student> findByMarksOrderByMarks(double m);

}
