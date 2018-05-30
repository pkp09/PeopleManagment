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
 * $Log: LoginServlet.java,v $
 */

package com.people.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.people.login.UserLoginDao;
import com.people.login.UserLoginDbObj;
import com.people.utils.ConnectionUtil;
import com.people.utils.Utils;

@SuppressWarnings("serial")
public class UserRegistrationServlet extends HttpServlet {
   private static Logger logger = Logger.getLogger(UserRegistrationServlet.class);

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      logger.info("Registration Servlet");
      ArrayList<String> alError = new ArrayList<String>();
      Connection con = ConnectionUtil.getDBConnection();
      UserRegistrationDao objUserRegistrationDao = new UserRegistrationDao();
      UserRegistrationDbObj objUserRegistrationDbObj = new UserRegistrationDbObj();
      String sActionHidden = request.getParameter("actionHidden");

      if (!"".equals(sActionHidden) && sActionHidden != null) {
         if ("registration".equals(sActionHidden)) {
            try {
               objUserRegistrationDbObj.setUserId(request.getParameter("user_id"));
               objUserRegistrationDbObj.setUserName(request.getParameter("user_name"));
               objUserRegistrationDbObj.setPswd(request.getParameter("password"));
               objUserRegistrationDbObj.setAddress1(request.getParameter("address1"));
               objUserRegistrationDbObj.setAddress2(request.getParameter("address2"));
               objUserRegistrationDbObj.setEmail(request.getParameter("email"));
               objUserRegistrationDbObj.setPhone(request.getParameter("phone"));
               objUserRegistrationDbObj.setMobile(request.getParameter("mobile"));
               objUserRegistrationDbObj.setDob(request.getParameter("dob"));
               objUserRegistrationDbObj.setGender(request.getParameter("gender"));
               objUserRegistrationDbObj.setNationality(request.getParameter("nationality"));
               ConnectionUtil.startTransaction(con);
               int iFlag = objUserRegistrationDao.insertUserDetails(objUserRegistrationDbObj);
               if (iFlag > 0) {
                  UserLoginDao objUserLoginDao = new UserLoginDao();
                  UserLoginDbObj objUserLoginDbObj = new UserLoginDbObj();
                  objUserLoginDbObj.setUser_Id(request.getParameter("user_id"));
                  objUserLoginDbObj.setUser_Name(request.getParameter("user_name"));
                  objUserLoginDbObj.setNew_Pwd(request.getParameter("password"));
                  objUserLoginDbObj.setOld_Pwd(request.getParameter("password"));
                  objUserLoginDbObj.setPswd_Eff_Date(Utils.getCurrentDate());
                  objUserLoginDbObj.setPswd_Exp_Date(Utils.getCurrentDate());
                  objUserLoginDao.insertUserDetails(objUserLoginDbObj);
                  ConnectionUtil.endTransaction(con, true);
                  ArrayList<String> al = new ArrayList<String>();
                  al.add("You have registered successfully. Please login with User id and Password");
                  request.setAttribute("success_message", al);
                  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                        "/jsps/people_user_login.jsp");
                  requestDispatcher.forward(request, response);
               } else {
                  ConnectionUtil.endTransaction(con, false);
                  alError.add("Please enter a valid user id");
                  alError.add("Please enter a valid password");
                  request.setAttribute("error_message", alError);
                  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                        "/jsps/people_user_registration.jsp");
                  requestDispatcher.forward(request, response);
               }
            } catch (SQLException e) {
               logger.error(e);
               try {
                  ConnectionUtil.endTransaction(con, false);
               } catch (SQLException e1) {
                  logger.error(e);
               }
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_registration.jsp");
               requestDispatcher.forward(request, response);
            }
        } else if ("search".equals(sActionHidden)) {
            try {
               objUserRegistrationDbObj.setUserId(request.getParameter("user_id"));
               objUserRegistrationDbObj.setUserName(request.getParameter("user_name"));
               objUserRegistrationDbObj.setEmail(request.getParameter("email"));
               objUserRegistrationDbObj.setPhone(request.getParameter("phone"));
               objUserRegistrationDbObj.setMobile(request.getParameter("mobile"));
               objUserRegistrationDbObj.setDob(request.getParameter("dob"));

               ArrayList<UserRegistrationDbObj> alUserDetails = objUserRegistrationDao
                     .getUserRegistration(objUserRegistrationDbObj);

               request.setAttribute("ResultTable", alUserDetails);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_search.jsp");
               requestDispatcher.forward(request, response);
            } catch (SQLException e) {
               logger.error(e);
               e.printStackTrace();
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_search.jsp");
               requestDispatcher.forward(request, response);
            }
         }else if ("searchView".equals(sActionHidden)) {
             try {
                 objUserRegistrationDbObj.setUserId(request.getParameter("user_id"));

                 UserRegistrationDbObj alUserDetails = objUserRegistrationDao
                       .getUserDetails(objUserRegistrationDbObj);

                 request.setAttribute("UserDetail", alUserDetails);
                 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                       "/jsps/people_user_view_details.jsp");
                 requestDispatcher.forward(request, response);
              } catch (SQLException e) {
                 logger.error(e);
                 e.printStackTrace();
                 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                       "/jsps/people_user_search.jsp");
                 requestDispatcher.forward(request, response);
              }
           } 
        
        else if ("resetPassword".equals(sActionHidden)) {
            String sUserId = request.getParameter("user_id");
            String sUserName = request.getParameter("user_name");
            String sPwd = request.getParameter("old_password");
            UserLoginDao objUserLoginDao = new UserLoginDao();
            UserLoginDbObj objUserLoginDbObj = new UserLoginDbObj();
            int iFlag = 0;
            try {
               objUserLoginDbObj = objUserLoginDao.getUserLogin(sUserId, sPwd);
               String sdbNewPswd = objUserLoginDbObj.getNew_Pwd();
               ConnectionUtil.startTransaction(con);
               if (!"".equals(sdbNewPswd) && sdbNewPswd != null && sdbNewPswd.equals(sPwd)) {
                  objUserRegistrationDbObj.setUserId(sUserId);
                  objUserRegistrationDbObj.setUserName(sUserName);
                  objUserRegistrationDbObj.setPswd(request.getParameter("new_password"));
                  iFlag = objUserRegistrationDao.updatePasswrod(objUserRegistrationDbObj, con);
                  if (iFlag > 0) {
                     iFlag = 0;
                     objUserLoginDbObj.setUser_Id(request.getParameter("user_id"));
                     objUserLoginDbObj.setUser_Name(request.getParameter("user_name"));
                     objUserLoginDbObj.setNew_Pwd(request.getParameter("new_password"));
                     objUserLoginDbObj.setOld_Pwd(sdbNewPswd);
                     iFlag = objUserLoginDao.changeUserPwd(objUserLoginDbObj, sPwd);
                     if (iFlag > 0)
                        ConnectionUtil.endTransaction(con, true);
                  }
               }
            } catch (SQLException e) {
               e.printStackTrace();
               try {
                  ConnectionUtil.endTransaction(con, false);
               } catch (SQLException e1) {
                  logger.error(e1);
               }
            }
            if (iFlag > 0) {
               ArrayList<String> al = new ArrayList<String>();
               al.add("You have successfully changed the password. Please login with new password");
               request.setAttribute("success_message", al);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_login.jsp");
               requestDispatcher.forward(request, response);
            } else {
               try {
                  ConnectionUtil.endTransaction(con, false);
               } catch (SQLException e1) {
                  logger.error(e1);
               }
               ArrayList<String> al = new ArrayList<String>();
               al.add("Please enter a valid user details.");
               request.setAttribute("error_message", al);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_reset_password.jsp");
               requestDispatcher.forward(request, response);
            }
         } else if("modifyView".equals(sActionHidden)){
        	 HttpSession session = request.getSession();
        	 String sUserId = (String) session.getAttribute("User_id");
        	 objUserRegistrationDbObj.setUserId(sUserId);
        	 try {
        	 ArrayList<UserRegistrationDbObj> alUserDetails = objUserRegistrationDao
                     .getUserRegistration(objUserRegistrationDbObj);
        	 request.setAttribute("UserDetail", alUserDetails);
        	 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_modify_details.jsp");
               requestDispatcher.forward(request, response);
        	 }catch (SQLException e) {
                 logger.error(e);
                 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                       "/jsps/people_user_search.jsp");
                 requestDispatcher.forward(request, response);
              }
         } else if("modify".equals(sActionHidden)){
        	 HttpSession session = request.getSession();
        	 String sUserId = (String) session.getAttribute("User_id");
             objUserRegistrationDbObj.setAddress1(request.getParameter("address1"));
             objUserRegistrationDbObj.setAddress2(request.getParameter("address2"));
             objUserRegistrationDbObj.setEmail(request.getParameter("email"));
             objUserRegistrationDbObj.setPhone(request.getParameter("phone"));
             objUserRegistrationDbObj.setMobile(request.getParameter("mobile"));
             objUserRegistrationDbObj.setDob(request.getParameter("dob"));
             objUserRegistrationDbObj.setGender(request.getParameter("gender"));
             objUserRegistrationDbObj.setNationality(request.getParameter("nationality"));
             objUserRegistrationDbObj.setUserId(sUserId);
             int iFlag = 0;
             try {
				ConnectionUtil.startTransaction(con);
				iFlag = objUserRegistrationDao.updateUserDetails(objUserRegistrationDbObj, con);
				if(iFlag > 0 ){
					ConnectionUtil.endTransaction(con, true);
					UserRegistrationDbObj objUserDetails = objUserRegistrationDao
		                     .getUserDetails(objUserRegistrationDbObj);
					request.setAttribute("UserDetail", objUserDetails);
	                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
	                        "/jsps/people_user_view_details.jsp");
	                requestDispatcher.forward(request, response);
				}
				else{
					ArrayList<String> al = new ArrayList<String>();
		               al.add("Please enter valid user details.");
		               request.setAttribute("success_message", al);
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
	                        "/jsps/people_user_modify_details.jsp");
	                requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();				
				try {
					ConnectionUtil.endTransaction(con, false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                        "/jsps/people_user_modify_details.jsp");
                requestDispatcher.forward(request, response);
			}
         } else {
            try {
               objUserRegistrationDbObj.setUserId(request.getParameter("user_id"));
               objUserRegistrationDbObj.setUserName(request.getParameter("user_name"));
               objUserRegistrationDbObj.setEmail(request.getParameter("email"));
               objUserRegistrationDbObj.setPhone(request.getParameter("phone"));
               objUserRegistrationDbObj.setMobile(request.getParameter("mobile"));
               objUserRegistrationDbObj.setDob(request.getParameter("dob"));

               ArrayList<UserRegistrationDbObj> alUserDetails = objUserRegistrationDao
                     .getUserRegistration(objUserRegistrationDbObj);
               if ("true".equals(request.getParameter("view"))) {
                  request.setAttribute("UserDetail", alUserDetails);
                  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                        "/jsps/people_user_details.jsp");
                  requestDispatcher.forward(request, response);
               } else {
                  request.setAttribute("ResultTable", alUserDetails);
                  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                        "/jsps/people_user_search.jsp");
                  requestDispatcher.forward(request, response);
               }
            } catch (SQLException e) {
               logger.error(e);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_search.jsp");
               requestDispatcher.forward(request, response);
            }
         }
      } else {
         try {
            String sUserId = request.getParameter("UserId");
            if (!"".equals(sUserId) && sUserId != null) {

               objUserRegistrationDbObj.setUserId(sUserId);
               ArrayList<UserRegistrationDbObj> alUserDetails = objUserRegistrationDao
                     .getUserRegistration(objUserRegistrationDbObj);
               request.setAttribute("UserDetail", alUserDetails);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_details.jsp");
               requestDispatcher.forward(request, response);
            } else {
               ArrayList<UserRegistrationDbObj> alUserDetails = objUserRegistrationDao
                     .getUserRegistration(objUserRegistrationDbObj);
               request.setAttribute("ResultTable", alUserDetails);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_search.jsp");
               requestDispatcher.forward(request, response);
            }
         } catch (SQLException e) {
            logger.error(e);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsps/people_home.jsp");
            requestDispatcher.forward(request, response);
         }
      }
   }
}