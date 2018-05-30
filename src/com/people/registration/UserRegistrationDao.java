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

package com.people.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.people.utils.ConnectionUtil;
import com.people.utils.Utils;

public class UserRegistrationDao {
private static Logger logger = Logger.getLogger(UserRegistrationDao.class);

public UserRegistrationDbObj getUserDetails(UserRegistrationDbObj objUserRegistrationDbObj) throws SQLException{
	Connection con = ConnectionUtil.getDBConnection();
	String sql = UserRegistrationDB.GET_USER_DETAILS;
	
	if (objUserRegistrationDbObj.getUserId() != null
			&& !"".equals(objUserRegistrationDbObj.getUserId()))
		sql = sql + "Where USER_ID = ?";
	
	PreparedStatement ps = con.prepareStatement(sql);
	if (objUserRegistrationDbObj.getUserId() != null
			&& !"".equals(objUserRegistrationDbObj.getUserId()))
		ps.setString(1, objUserRegistrationDbObj.getUserId());
	
	ResultSet rs = ps.executeQuery();
	logger.info(ps);
	while (rs.next()) {
		objUserRegistrationDbObj.setUserId(rs.getString("user_Id"));
		objUserRegistrationDbObj.setUserName(rs.getString("user_Name"));
		objUserRegistrationDbObj.setDob(rs.getString("dob"));
		objUserRegistrationDbObj.setEmail(rs.getString("email"));
		objUserRegistrationDbObj.setMobile(rs.getString("mobile"));
		objUserRegistrationDbObj.setPhone(rs.getString("phone"));
		objUserRegistrationDbObj.setAddress1(rs.getString("address_1"));
		objUserRegistrationDbObj.setAddress2(rs.getString("address_2"));
		objUserRegistrationDbObj.setGender(rs.getString("Gender"));
		objUserRegistrationDbObj.setNationality(rs.getString("Nationality"));
	}
	return objUserRegistrationDbObj;
}
	/**
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserRegistrationDbObj> getUserRegistration(
			UserRegistrationDbObj objUserRegistrationDbObj) throws SQLException {
		Connection con = ConnectionUtil.getDBConnection();
		String sql = UserRegistrationDB.GET_USER_DETAILS;

		if (objUserRegistrationDbObj.getUserId() != null
				&& !"".equals(objUserRegistrationDbObj.getUserId()))
			sql = sql + "Where USER_ID = ?";
		//sql = sql + "Where USER_ID LIKE % ? % ";
		if (objUserRegistrationDbObj.getUserName() != null
				&& !"".equals(objUserRegistrationDbObj.getUserName())) {
			if (sql.contains("USER_ID"))
				sql = sql + " OR USER_NAME = ?";
			else
				sql = sql + " Where USER_NAME = ?";
		}
		if (objUserRegistrationDbObj.getEmail() != null
				&& !"".equals(objUserRegistrationDbObj.getEmail())) {
			if (sql.contains("USER_ID") || sql.contains("USER_NAME"))
				sql = sql + " OR EMAIL = ?";
			else
				sql = sql + " Where EMAIL = ?";
		}
		if (objUserRegistrationDbObj.getPhone() != null
				&& !"".equals(objUserRegistrationDbObj.getPhone())) {
			if (sql.contains("USER_ID") || sql.contains("USER_NAME")
					|| sql.contains("EMAIL"))
				sql = sql + " OR PHONE = ?";
			else
				sql = sql + " Where PHONE = ?";
		}

		if (objUserRegistrationDbObj.getMobile() != null
				&& !"".equals(objUserRegistrationDbObj.getMobile())) {
			if (sql.contains("USER_ID") || sql.contains("USER_NAME")
					|| sql.contains("EMAIL") || sql.contains("PHONE"))
				sql = sql + " OR MOBILE = ?";
			else
				sql = sql + " Where MOBILE = ?";
		}
		if (objUserRegistrationDbObj.getDob() != null
				&& !"".equals(objUserRegistrationDbObj.getDob())) {
			if (sql.contains("USER_ID") || sql.contains("USER_NAME")
					|| sql.contains("EMAIL") || sql.contains("PHONE")
					|| sql.contains("MOBILE"))
				sql = sql + " OR DOB = ?";
			else
				sql = sql + " Where DOB = ?";
		}

		PreparedStatement ps = con.prepareStatement(sql);

		int i = 1;
		if (objUserRegistrationDbObj.getUserId() != null
				&& !"".equals(objUserRegistrationDbObj.getUserId()))
			ps.setString(i++, objUserRegistrationDbObj.getUserId());
		if (objUserRegistrationDbObj.getUserName() != null
				&& !"".equals(objUserRegistrationDbObj.getUserName()))
			ps.setString(i++, objUserRegistrationDbObj.getUserName());
		if (objUserRegistrationDbObj.getEmail() != null
				&& !"".equals(objUserRegistrationDbObj.getEmail()))
			ps.setString(i++, objUserRegistrationDbObj.getEmail());
		if (objUserRegistrationDbObj.getPhone() != null
				&& !"".equals(objUserRegistrationDbObj.getPhone()))
			ps.setString(i++, objUserRegistrationDbObj.getPhone());
		if (objUserRegistrationDbObj.getMobile() != null
				&& !"".equals(objUserRegistrationDbObj.getMobile()))
			ps.setString(i++, objUserRegistrationDbObj.getMobile());
		if (objUserRegistrationDbObj.getDob() != null
				&& !"".equals(objUserRegistrationDbObj.getDob()))
			ps.setString(i++, objUserRegistrationDbObj.getDob());
		logger.info(ps);
		ResultSet rs = ps.executeQuery();
		logger.info(ps);
		logger.info(ps.toString());
		ArrayList<UserRegistrationDbObj> al = new ArrayList<UserRegistrationDbObj>();
		UserRegistrationDbObj objUserRegistrDbObj = null;
		while (rs.next()) {
			objUserRegistrDbObj = new UserRegistrationDbObj();
			objUserRegistrDbObj.setUserId(rs.getString("user_Id"));
			objUserRegistrDbObj.setUserName(rs.getString("user_Name"));
			objUserRegistrDbObj.setDob(rs.getString("dob"));
			objUserRegistrDbObj.setEmail(rs.getString("email"));
			objUserRegistrDbObj.setMobile(rs.getString("mobile"));
			objUserRegistrDbObj.setPhone(rs.getString("phone"));
			objUserRegistrDbObj.setAddress1(rs.getString("address_1"));
			objUserRegistrDbObj.setAddress2(rs.getString("address_2"));
			objUserRegistrDbObj.setGender(rs.getString("Gender"));
			objUserRegistrDbObj.setNationality(rs.getString("Nationality"));
			al.add(objUserRegistrDbObj);
		}
		return al;
	}

	/**
	 * @param objUserRegistrationDbObj
	 * @throws SQLException
	 */
	public int insertUserDetails(UserRegistrationDbObj objUserRegistrationDbObj)
			throws SQLException {
		Connection con = ConnectionUtil.getDBConnection();
		String sql = UserRegistrationDB.INSERT_USER_DETAILS;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, objUserRegistrationDbObj.getUserId());
		ps.setString(2, objUserRegistrationDbObj.getUserName());
		ps.setString(3, objUserRegistrationDbObj.getPswd());
		ps.setString(4, objUserRegistrationDbObj.getAddress1());
		ps.setString(5, objUserRegistrationDbObj.getAddress2());
		ps.setString(6, objUserRegistrationDbObj.getEmail());
		ps.setString(7, objUserRegistrationDbObj.getPhone());
		ps.setString(8, objUserRegistrationDbObj.getMobile());
		ps.setString(9, objUserRegistrationDbObj.getDob());
		ps.setString(10, objUserRegistrationDbObj.getGender());
		ps.setString(11, objUserRegistrationDbObj.getNationality());
		ps.setString(12, Utils.getCurrentDateTime());
		ps.setString(13, Utils.getCurrentDateTime());
		logger.info(ps.toString());
		return ps.executeUpdate();
	}

	/**
	 * @param objUserRegistrationDbObj
	 * @throws SQLException
	 */
	public int updatePasswrod(UserRegistrationDbObj objUserRegistrationDbObj, Connection con)
			throws SQLException {
		String sql = UserRegistrationDB.UPDATE_PASSWORD;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, objUserRegistrationDbObj.getPswd());
		ps.setString(2, objUserRegistrationDbObj.getUserId());
		ps.setString(3, objUserRegistrationDbObj.getUserName());
		logger.info(ps.toString());
		return ps.executeUpdate();
	}
	
	/**
	 * @param objUserRegistrationDbObj
	 * @throws SQLException
	 */
	public int updateUserDetails(UserRegistrationDbObj objUserRegistrationDbObj, Connection con)
			throws SQLException {
		String sql = UserRegistrationDB.UPDATE_USER_DETAILS;
		// UPDATE PEOPLE_USER_REGISTRATION SET ADDRESS_1  = ?, ADDRESS_2 = ?, EMAIL = ?, PHONE = ?,
		//MOBILE = ?, DOB = ?, GENDER = ?, NATIONALITY = ?, UPDATEDON = ? WHERE USER_ID = ? AND USER_NAME = ?
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, objUserRegistrationDbObj.getAddress1());
		ps.setString(2, objUserRegistrationDbObj.getAddress2());
		ps.setString(3, objUserRegistrationDbObj.getEmail());
		ps.setString(4, objUserRegistrationDbObj.getPhone());
		ps.setString(5, objUserRegistrationDbObj.getMobile());
		ps.setString(6, objUserRegistrationDbObj.getDob());
		ps.setString(7, objUserRegistrationDbObj.getGender());
		ps.setString(8, objUserRegistrationDbObj.getNationality());
		ps.setString(9, Utils.getCurrentDateTime());
		ps.setString(10, objUserRegistrationDbObj.getUserId());
		logger.info(ps.toString());
		return ps.executeUpdate();
	}
}