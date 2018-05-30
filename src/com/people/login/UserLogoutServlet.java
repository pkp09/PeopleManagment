package com.people.login;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class UserLogoutServlet extends HttpServlet {

   private static Logger logger = Logger.getLogger(UserLogoutServlet.class);

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      doPost(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      logger.info(request);
      response.setHeader("Cache-Control", "no-cache, no-store");
      response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
      HttpSession session = request.getSession(false);

      if (session != null) {
         session.invalidate();
         Cookie[] cookie = request.getCookies();
         for (Cookie cookies : cookie) {
            cookies.setPath("/");
            cookies.setMaxAge(0); // Don't set to -1 or it will become a session
                                  // cookie!
            response.addCookie(cookies);
         }
         response.sendRedirect(request.getContextPath() + "/jsps/people_user_login.jsp");
      }
   }
}
