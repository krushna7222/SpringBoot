package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringAopApplication.class, args);
		
		PaymentService1 p = (PaymentService1)context.getBean("paymentServiceImpl1");
		
//		p.makePayment(700);
		p.makePayment(7000);
	}

}
