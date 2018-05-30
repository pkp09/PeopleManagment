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
 * $Log: LoginDbObj.java,v $
 */

package com.people.registration;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserRegistrationDbObj implements Serializable
   {
   private String userId;
   private String userName;
   private String pswd;
   private String address1;
   private String address2;
   private String email;
   private String phone;
   private String mobile;
   private String dob;
   private String gender;
   private String nationality;
   private String cratedon;
   private String updatedon;
   
   /**
    * @return the userId
    */
   public String getUserId()
      {
      return userId;
      }
   /**
    * @param userId the userId to set
    */
   public void setUserId(String userId)
      {
      this.userId = userId;
      }
   /**
    * @return the userName
    */
   public String getUserName()
      {
      return userName;
      }
   /**
    * @param userName the userName to set
    */
   public void setUserName(String userName)
      {
      this.userName = userName;
      }
   /**
    * @return the pswd
    */
   public String getPswd()
      {
      return pswd;
      }
   /**
    * @param pswd the pswd to set
    */
   public void setPswd(String pswd)
      {
      this.pswd = pswd;
      }
   /**
    * @return the address1
    */
   public String getAddress1()
      {
      return address1;
      }
   /**
    * @param address1 the address1 to set
    */
   public void setAddress1(String address1)
      {
      this.address1 = address1;
      }
   /**
    * @return the address2
    */
   public String getAddress2()
      {
      return address2;
      }
   /**
    * @param address2 the address2 to set
    */
   public void setAddress2(String address2)
      {
      this.address2 = address2;
      }
   /**
    * @return the email
    */
   public String getEmail()
      {
      return email;
      }
   /**
    * @param email the email to set
    */
   public void setEmail(String email)
      {
      this.email = email;
      }
   /**
    * @return the phone
    */
   public String getPhone()
      {
      return phone;
      }
   /**
    * @param phone the phone to set
    */
   public void setPhone(String phone)
      {
      this.phone = phone;
      }
   /**
    * @return the mobile
    */
   public String getMobile()
      {
      return mobile;
      }
   /**
    * @param mobile the mobile to set
    */
   public void setMobile(String mobile)
      {
      this.mobile = mobile;
      }
   /**
    * @return the dob
    */
   public String getDob()
      {
      return dob;
      }
   /**
    * @param dob the dob to set
    */
   public void setDob(String dob)
      {
      this.dob = dob;
      }
   /**
    * @return the gender
    */
   public String getGender()
      {
      return gender;
      }
   /**
    * @param gender the gender to set
    */
   public void setGender(String gender)
      {
      this.gender = gender;
      }
   /**
    * @return the nationality
    */
   public String getNationality()
      {
      return nationality;
      }
   /**
    * @param nationality the nationality to set
    */
   public void setNationality(String nationality)
      {
      this.nationality = nationality;
      }
   /**
    * @return the cratedon
    */
   public String getCratedon()
      {
      return cratedon;
      }
   /**
    * @param cratedon the cratedon to set
    */
   public void setCratedon(String cratedon)
      {
      this.cratedon = cratedon;
      }
   /**
    * @return the updatedon
    */
   public String getUpdatedon()
      {
      return updatedon;
      }
   /**
    * @param updatedon the updatedon to set
    */
   public void setUpdatedon(String updatedon)
      {
      this.updatedon = updatedon;
      }
   }