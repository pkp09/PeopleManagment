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

package com.people.registration;

public class UserRegistrationDB
   {
   public static final String GET_USER_DETAILS = "SELECT * FROM PEOPLE_USER_REGISTRATION ";// Where USER_ID = ? OR USER_NAME = ? OR EMAIL = ? OR PHONE = ? OR MOBILE = ? OR DOB = ?";
   
   public static final String INSERT_USER_DETAILS = "INSERT INTO PEOPLE_USER_REGISTRATION VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
   
   public static final String UPDATE_PASSWORD = "UPDATE PEOPLE_USER_REGISTRATION SET PSWD = ? WHERE USER_ID = ? AND USER_NAME = ?";
   
   public static final String UPDATE_USER_DETAILS = "UPDATE PEOPLE_USER_REGISTRATION SET ADDRESS_1  = ?, ADDRESS_2 = ?, EMAIL = ?, PHONE = ?, MOBILE = ?, DOB = ?, GENDER = ?, NATIONALITY = ?, UPDATEDON = ? WHERE USER_ID = ?";// AND USER_NAME = ?
   }
