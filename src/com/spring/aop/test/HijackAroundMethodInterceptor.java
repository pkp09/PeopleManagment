/*
 * Copyright (c) 2011 SIX Systems AG. All Rights Reserved.
 * http://www.sys.sisclear.com
 *
 * This software is the confidential and proprietary information of SIX
 * Systems AG ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with SIX.
 *
 * History:
 * --------
 * $Log: HijackAroundMethodInterceptor.java,v $
 */

package com.spring.aop.test;

import java.util.Arrays;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
 
public class HijackAroundMethodInterceptor implements MethodInterceptor {
  // @Override
   public Object invoke(MethodInvocation methodInvocation) throws Throwable {
 
      System.out.println("Method name : "
            + methodInvocation.getMethod().getName());
      System.out.println("Method arguments : "
            + Arrays.toString(methodInvocation.getArguments()));
 
      System.out.println("HijackAroundMethod : Before method hijacked!");
 
      try {
         Object result = methodInvocation.proceed();
         System.out.println("HijackAroundMethod : Before after hijacked!");
 
         return result;
 
      } catch (IllegalArgumentException e) {
 
         System.out.println("HijackAroundMethod : Throw exception hijacked!");
         throw e;
      }
   }
}