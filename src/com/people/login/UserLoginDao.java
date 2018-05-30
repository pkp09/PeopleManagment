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
 * $Log: UserLoginDao.java,v $
 */

package com.people.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.people.utils.ConnectionUtil;
import com.people.utils.Utils;

public class UserLoginDao
   {
   private static Logger logger = Logger.getLogger(UserLoginDao.class);

   /**
    * @return
    * @throws IOException
    * @throws FileNotFoundException
    * @throws SQLException
    */
   public UserLoginDbObj getUserLogin(String sUserId, String sPwd) throws IOException, SQLException
      {
      UserLoginDbObj objUserLoginDbObj = new UserLoginDbObj();
      Connection con = ConnectionUtil.getDBConnection();
      String sql = UserLoginDB.GET_USER_DETAILS;
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, sUserId);
      ps.setString(2, sPwd);
      logger.info(ps.toString());
      logger.info(ps);
      ResultSet rs = ps.executeQuery();
      if (rs.next())
         {
         objUserLoginDbObj.setUser_Id(rs.getString("user_Id"));
         objUserLoginDbObj.setUser_Name(rs.getString("user_Name"));
         objUserLoginDbObj.setNew_Pwd(rs.getString("new_pswd"));
         objUserLoginDbObj.setOld_Pwd(rs.getString("old_pswd"));
         }
      return objUserLoginDbObj;
      }

   
   /**
    * @return
    * @throws IOException
    * @throws FileNotFoundException
    * @throws SQLException
    */
   public UserLoginDbObj getUserDetails(UserLoginDbObj objUserLoginDbObj) throws IOException, SQLException
      {
      Connection con = ConnectionUtil.getDBConnection();
      String sql = UserLoginDB.FORGET_PASSWORD;
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, objUserLoginDbObj.getUser_Id());
      ps.setString(2, objUserLoginDbObj.getUser_Name());
      logger.info(ps.toString());
      logger.info(ps);
      ResultSet rs = ps.executeQuery();
      if (rs.next())
         {
         objUserLoginDbObj.setUser_Id(rs.getString("user_Id"));
         objUserLoginDbObj.setUser_Name(rs.getString("user_Name"));
         objUserLoginDbObj.setNew_Pwd(rs.getString("NEW_PSWD"));
         }
      return objUserLoginDbObj;
      }
   
   /**
    * @param objUserLoginDbObj
    * @return
    * @throws IOException
    * @throws FileNotFoundException
    * @throws SQLException
    */
   public int insertUserDetails(UserLoginDbObj objUserLoginDbObj) throws IOException, SQLException
      {
      Connection con = ConnectionUtil.getDBConnection();
      String sql = UserLoginDB.INSERT_USER_LOGIN;
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, objUserLoginDbObj.getUser_Id());
      ps.setString(2, objUserLoginDbObj.getUser_Name());
      ps.setString(3, objUserLoginDbObj.getNew_Pwd());
      ps.setString(4, objUserLoginDbObj.getOld_Pwd());
      ps.setString(5, objUserLoginDbObj.getPswd_Eff_Date());
      ps.setString(6, objUserLoginDbObj.getPswd_Exp_Date());
      ps.setString(7, Utils.getCurrentDateTime());
      ps.setString(8, Utils.getCurrentDateTime());
      logger.info(ps.toString());
      logger.info(ps);
      return ps.executeUpdate();
      }

   /**
    * @param objUserLoginDbObj
    * @throws SQLException 
    */
   public void updateUserDetails(UserLoginDbObj objUserLoginDbObj)
      {
      
      }

   /**
    * @param objUserLoginDbObj
    */
   public int changeUserPwd(UserLoginDbObj objUserLoginDbObj, String sOldPswd) throws SQLException
      {
      Connection con = ConnectionUtil.getDBConnection();
      String sql = UserLoginDB.UPDATE_PASSWORD;
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, objUserLoginDbObj.getOld_Pwd());
      ps.setString(2, objUserLoginDbObj.getNew_Pwd());
      ps.setString(3, Utils.getCurrentDateTime());
      ps.setString(4, objUserLoginDbObj.getUser_Id());
      ps.setString(5, objUserLoginDbObj.getUser_Name());
      ps.setString(6, sOldPswd);
      logger.info(ps.toString());
      logger.info(ps);
      return ps.executeUpdate();
      }

   /**
    * @param sUserId
    * @return
    */
   public String forgetPwd(String sUserId)
      {
      String sPwd = null;

      return sPwd;
      }
   }