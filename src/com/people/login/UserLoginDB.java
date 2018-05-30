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
 * $Log: UserLoginDB.java,v $
 */

package com.people.login;

public class UserLoginDB
   {
   public static final String GET_USER_DETAILS = "SELECT * FROM PEOPLE_USER_LOGIN WHERE USER_ID = ? AND NEW_PSWD = ?";
   
   public static final String INSERT_USER_LOGIN = "INSERT INTO PEOPLE_USER_LOGIN VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
   
   public static final String FORGET_PASSWORD = "SELECT * FROM PEOPLE_USER_LOGIN WHERE USER_ID = ? AND USER_NAME = ? ";
   
   public static final String UPDATE_PASSWORD = "UPDATE PEOPLE_USER_LOGIN SET OLD_PSWD = ?, NEW_PSWD = ?, UPDATEDON = ? WHERE USER_ID = ? AND USER_NAME = ? AND NEW_PSWD = ? ";
   }
