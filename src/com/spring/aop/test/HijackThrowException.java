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
 * $Log: HijackThrowException.java,v $
 */

package com.spring.aop.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.aop.ThrowsAdvice;

public class HijackThrowException implements ThrowsAdvice
   {
   protected static Logger logg = null;

   public void afterThrowing(IllegalArgumentException e) throws Throwable
      {
      logg = Logger.getLogger(e.getClass());
      PropertyConfigurator.configure("C:\\javaroot\\projects\\PeopelManagment\\src\\log4j.properties");

      System.out.println("HijackThrowException : Throw exception hijacked!");
      
      logg.info(" : " + e.getLocalizedMessage());
      logg.debug(e);
      }
   }