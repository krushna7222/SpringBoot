package com.aop;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl1 implements PaymentService1 {

	@Override
	public int makePayment(int amt) {
		// TODO Auto-generated method stub
		
		System.out.println(amt + "Amt Created");
		System.out.println(amt + "Amt Debited");
		
		if(amt < 1000)
        {
            
             throw new ArithmeticException("Something went wrong..");
        }
        else{
               return amt;
        }
		
		
	}

}
