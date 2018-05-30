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

package com.people.login;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserLoginDbObj implements Serializable
   {
   private String user_Id;
   private String user_Name;
   private String old_Pswd;
   private String new_Pswd;
   private String pswd_Eff_Date;
   private String pswd_Exp_Date;
   private String createdon;
   private String updatedon;

   /**
    * @return the user_Id
    */
   public String getUser_Id()
      {
      return user_Id;
      }

   /**
    * @param user_Id the user_Id to set
    */
   public void setUser_Id(String user_Id)
      {
      this.user_Id = user_Id;
      }

   /**
    * @return the user_Name
    */
   public String getUser_Name()
      {
      return user_Name;
      }

   /**
    * @param user_Name the user_Name to set
    */
   public void setUser_Name(String user_Name)
      {
      this.user_Name = user_Name;
      }

   /**
    * @return the old_Pwd
    */
   public String getOld_Pwd()
      {
      return old_Pswd;
      }

   /**
    * @param old_Pwd the old_Pwd to set
    */
   public void setOld_Pwd(String old_Pwd)
      {
      this.old_Pswd = old_Pwd;
      }

   /**
    * @return the new_Pwd
    */
   public String getNew_Pwd()
      {
      return new_Pswd;
      }

   /**
    * @param new_Pwd the new_Pwd to set
    */
   public void setNew_Pwd(String new_Pwd)
      {
      this.new_Pswd = new_Pwd;
      }

   /**
    * @return the pswd_Eff_Date
    */
   public String getPswd_Eff_Date()
      {
      return pswd_Eff_Date;
      }

   /**
    * @param pswd_Eff_Date the pswd_Eff_Date to set
    */
   public void setPswd_Eff_Date(String pswd_Eff_Date)
      {
      this.pswd_Eff_Date = pswd_Eff_Date;
      }

   /**
    * @return the pswd_Exp_Date
    */
   public String getPswd_Exp_Date()
      {
      return pswd_Exp_Date;
      }

   /**
    * @param pswd_Exp_Date the pswd_Exp_Date to set
    */
   public void setPswd_Exp_Date(String pswd_Exp_Date)
      {
      this.pswd_Exp_Date = pswd_Exp_Date;
      }

   /**
    * @return the createdon
    */
   public String getCreatedon()
      {
      return createdon;
      }

   /**
    * @param createdon the createdon to set
    */
   public void setCreatedon(String createdon)
      {
      this.createdon = createdon;
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