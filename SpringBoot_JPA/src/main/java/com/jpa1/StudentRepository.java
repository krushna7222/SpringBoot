package com.jpa1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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

    
    //JPQL / HQL Query
    
    @Query("select s from Student s")
    public List<Student> getAllData();   //select * from studen
    
    // @Query("select s from Student s order by marks desc")
    @Query("select s from Student s order by marks")
    public List<Student> getAllStudentByUsingOrderClause();   //select * from studen
        
    
     @Query("select s from Student s where name=:n AND marks=:m") //HQL/JPQL
     public List<Student> getStudentWithNameAndMarks(@Param("n") String name,@Param("m") double marks);
     
     
     
     //2.native query
      @Query(value = "select * from Student", nativeQuery = true) //SQL
      public List<Student> getAllStuds();
    
}
