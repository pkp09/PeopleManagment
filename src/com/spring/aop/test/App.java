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
 * $Log: App.java,v $
 */

package com.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
   {
   public static void main(String[] args)
      {
      ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Customer.xml" });

      CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy3");

      System.out.println("*************************");
      cust.printName();
      System.out.println("*************************");
      cust.printURL();
      System.out.println("*************************");
      try
         {
         cust.printThrowException();
         }
      catch (Exception e)
         {

         }

      }
   }
