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
 * $Log: HijackAfterMethod.java,v $
 */

package com.spring.aop.test;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.aop.AfterReturningAdvice;

public class HijackAfterMethod implements AfterReturningAdvice
   {
   protected static Logger logg = null;

  // @Override
   public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
      {
      logg = Logger.getLogger(target.getClass());
      PropertyConfigurator.configure("C:\\javaroot\\projects\\PeopelManagment\\src\\log4j.properties");

      System.out.println("HijackAfterMethod : After method hijacked!");

      logg.info(" : " + method.getName());
      logg.debug(target);
      }
   }
