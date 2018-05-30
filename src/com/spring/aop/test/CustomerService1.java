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
 * $Log: CustomerService.java,v $
 */

package com.spring.aop.test;

public class CustomerService1
   {
   private String name;
   private String url;

   public void setName(String name)
      {
      this.name = name;
      }

   public void setUrl(String url)
      {
      this.url = url;
      }

   public void printName()
      {
      System.out.println("Customer name : " + this.name);
      }

   public void printURL()
      {
      System.out.println("Customer website : " + this.url);
      }

   public void printThrowException()
      {
      throw new IllegalArgumentException();
      }

   }