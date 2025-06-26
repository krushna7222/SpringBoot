package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;


@EnableAspectJAutoProxy
@Aspect
@Component
public class MyAspect1 {

	//as//this aspect is a class here in which we can put advice(the code which we want to insert im Aop_Main without modifying the actual code)

    //here printBefore and printAfter() are advises which i want to execute before and after mainservice(i.e make payment here)
      
      
     //here,we have 2 methods which execute  before main service printBefore() and msg()..but printBefore() executes before msg
      @Before("execution(* com.aop.PaymentServiceImpl1.makePayment(..))")
      public void printBefore()    //this is executed before the main service thats why it has a name  
      {
          System.out.println("payment started.."); //payment
          
      }
            
      
      @After("execution(* com.aop.PaymentServiceImpl1.makePayment(..))")
      public void printAfter()    //this is executed before the main service thats why it has a name  
      {
          System.out.println("payment done..");
          
      }
      
      
   // this @AfterThrowing advice will run only if we will have an exception in our main service(makePayment())
      @AfterThrowing("within(com.aop.PaymentServiceImpl1)")
       public void failed(JoinPoint joinPoint)  //here, joinPoint variable stores the joinpoint details like void com.aop.usingAnno.PaymentService1.makePayment1(int))
       {
              System.out.println("Exception thrown in makePayment Method="+joinPoint.toString());
                                                                        //this joinPoint.toString() will return an exception class name which is occurred in our main service 
          }

           
      
      
      //this @AfterReturning advice will run only if we will not have any error or exception in our main service(makePayment())
      //means it will run to indicate that our main service is executed properly
      @AfterReturning(pointcut="execution(* com.aop.PaymentServiceImpl1.makePayment(..))", returning="n")
      public void sucess(int  n)     //here, makePayment() method must returning something..it doesnt have a return type void..
       {                                                 //here,a is of type int only because makePayment() returning int type of value    
          System.out.println("success.. Returned Value ="+n);
      }
	
}
