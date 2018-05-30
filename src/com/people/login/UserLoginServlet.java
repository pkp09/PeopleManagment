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

package com.people.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.people.utils.Base64Encoder;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
   private static Logger logger = Logger.getLogger(UserLoginServlet.class);
   
   /*static{
      
      System.out.println("UserLoginServlet.enclosing_method()" );
      new UserLoginServlet();
   }
   
   UserLoginServlet(){
      System.out.println("Hello Login");
   }*/
   
   /*
    * (non-Javadoc)
    * 
    * @see
    * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
    * , javax.servlet.http.HttpServletResponse)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
    * , javax.servlet.http.HttpServletResponse)
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      logger.info("Login Page");
      ArrayList<String> alMessage = new ArrayList<String>();
      HttpSession session = request.getSession();

      String sActionHidden = (String) (request.getParameter("actionHidden") != null ? request
            .getParameter("actionHidden") : request.getAttribute("actionHidden"));
      String sUserId = (String) (request.getParameter("User_id") != null ? request.getParameter("User_id") : request
            .getAttribute("User_id"));
      String sPwd = (String) (request.getParameter("User_pswd") != null ? request.getParameter("User_pswd") : request
            .getAttribute("User_pswd"));
      String sRememberMe = (String) (request.getParameter("RememberMe") != null ? request.getParameter("RememberMe")
            : request.getAttribute("sRememberMe"));

      UserLoginDao objUserLoginDao = new UserLoginDao();

      if (sActionHidden != null && !"".equals(sActionHidden)) {
         if (sActionHidden.equals("login")) {
            if (!"".equals(sUserId) && sUserId != null && !"".equals(sPwd) && sPwd != null) {
               try {
                  UserLoginDbObj objUserLoginDbObj = objUserLoginDao.getUserLogin(sUserId, sPwd);
                  sUserId = objUserLoginDbObj.getUser_Id();
                  if (objUserLoginDbObj != null
                        && (!"".equals(sUserId) && sUserId != null && objUserLoginDbObj.getUser_Id().length() > 0)) {
                     request.setAttribute("password", Base64Encoder.encode(sPwd));
                     request.setAttribute("username", Base64Encoder.encode(sUserId));

                     request.setAttribute("User_id", sUserId);
                     if (!"".equals(sRememberMe) && sRememberMe != null && sRememberMe.equals("RememberMe")) {
                        saveCookies(response, sUserId, sPwd, sRememberMe);
                     } else {
                        releaseCookie(response);
                     }
                     session.setAttribute("User_id", sUserId);

                     if (sUserId != null) {
                        if (request.getParameter("User_id") != null) {
                           RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                                 "/jsps/people_home.jsp");
                           requestDispatcher.forward(request, response);
                        } else {
                           response.sendRedirect("jsps/people_home.jsp");
                        }
                     }
                  } else {
                     alMessage.add("Please enter a valid user id.\n");
                     alMessage.add("Please enter a valid password.");
                     request.setAttribute("error_message", alMessage);
                     RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                           "/jsps/people_user_login.jsp");
                     requestDispatcher.forward(request, response);
                  }
               } catch (SQLException e) {
                  logger.error(e);
               }
            } else {
               String sErrorMsg = request.getParameter("errorMsg");
               if (!"".equals(sErrorMsg) && sErrorMsg != null)
                  alMessage.add(sErrorMsg);
               else {
                  alMessage.add("Please enter a valid user id. \n");
                  alMessage.add("Please enter a valid password.");
               }
               request.setAttribute("error_message", alMessage);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_login.jsp");
               requestDispatcher.forward(request, response);
            }
         }
         if (sActionHidden.equals("forgetPassword")) {
            sUserId = request.getParameter("user_id");
            String sUserName = request.getParameter("user_name");
            if (!"".equals(sUserId) && sUserId != null && !"".equals(sUserName) && sUserName != null) {
               try {
                  UserLoginDbObj objUserLoginDbObj = new UserLoginDbObj();
                  objUserLoginDbObj.setUser_Id(sUserId);
                  objUserLoginDbObj.setUser_Name(sUserName);
                  objUserLoginDbObj = objUserLoginDao.getUserDetails(objUserLoginDbObj);
                  String sNewPwd = objUserLoginDbObj.getNew_Pwd();

                  if (!"".equals(sNewPwd) && sNewPwd != null) {
                     request.setAttribute("Password", sNewPwd);
                     RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                           "/jsps/people_user_forget_password.jsp");
                     requestDispatcher.forward(request, response);
                  } else {
                     alMessage.add("Please enter a valid details.");
                     request.setAttribute("error_message", alMessage);
                     RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                           "/jsps/people_user_forget_password.jsp");
                     requestDispatcher.forward(request, response);
                  }

               } catch (SQLException e) {
                  logger.error(e);
               }

            } else {
               alMessage.add("Please enter a valid user id.\n");
               alMessage.add("Please enter a valid user name.");
               request.setAttribute("error_message", alMessage);
               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                     "/jsps/people_user_forget_password.jsp");
               requestDispatcher.forward(request, response);
            }
         }
      } else {
         response.sendRedirect("people_managment_welcome.jsp");
      }
   }

   /**
 * @param response
 * @param sUserName
 * @param sPassword
 * @param sRememberMe
 */
private static void saveCookies(HttpServletResponse response, String sUserName, String sPassword, String sRememberMe) {

      // Cookie cookieUsername = new Cookie("username",
      // Base64Encoder.encode(sUserName));
      Cookie cookieUsername = new Cookie("username", sUserName);
      cookieUsername.setMaxAge(24 * 60 * 60);
      cookieUsername.setPath("/");
      // Cookie cookiePassword = new Cookie("password",
      // Base64Encoder.encode(sPassword));
      Cookie cookiePassword = new Cookie("password", sPassword);
      cookiePassword.setMaxAge(24 * 60 * 60);
      cookiePassword.setPath("/");
      Cookie cookieRememberMe = new Cookie("RememberMe", sRememberMe);
      cookieRememberMe.setMaxAge(24 * 60 * 60);
      cookieRememberMe.setPath("/");
      response.addCookie(cookieUsername);
      response.addCookie(cookiePassword);
      response.addCookie(cookieRememberMe);
   }

   /**
 * @param response
 */
private static void releaseCookie(HttpServletResponse response) {
      Cookie cookieUsername = new Cookie("username", "expired");
      cookieUsername.setMaxAge(0);
      response.addCookie(cookieUsername);

      Cookie cookiePassword = new Cookie("password", "expired");
      cookiePassword.setMaxAge(0);
      response.addCookie(cookiePassword);
   }

   /**
 * @param request
 * @param name
 * @return
 */
public static String getCookieValue(HttpServletRequest request, String name) {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
         for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
               return cookie.getValue();
            }
         }
      }
      return null;
   }
}