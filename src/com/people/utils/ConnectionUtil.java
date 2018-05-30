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
 * $Log: Connection.java,v $
 */

package com.people.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil
   {
   private static Logger logger  = Logger.getLogger(ConnectionUtil.class);
   /**
    * @return
    * @throws ClassNotFoundException
    */
   public static Connection getDBConnection()
      {
      Connection connection = null;
      Properties prop = new Properties();
      try
         {
         prop.load(new FileInputStream("D:\\ProjectBackup\\PeopleManagment\\PeopleManagment_Properties.properties"));
         }
      catch (FileNotFoundException e)
         {
         logger.error(prop, e);
         }
      catch (IOException e)
         {
         logger.error(prop, e);
         }
      String dbDriver = prop.getProperty("dbDriver");
      String dbUrl = prop.getProperty("dbUrl");
      String dbUser = prop.getProperty("dbUser");
      String dbPassword = prop.getProperty("dbPassword");

      try
         {
         Class.forName(dbDriver);
         }
      catch (ClassNotFoundException cne)
         {
         logger.error(cne, cne);
         throw new RuntimeException("Cant load db driver class", cne);
         }
      try
         {
         connection = (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         }
      catch (SQLException sqle)
         {
         logger.error(connection, sqle);
         }
      return connection;
      }

   /**
    * Method to close the database connection
    * @param connection
    */
   public static void closeConnection(Connection connection)
      {
      try
         {
         if (connection != null)
            {
            connection.close();
            connection = null;
            }
         }
      catch (SQLException e)
         {
         logger.error(connection, e);
         }
      }

   /**
    * Method to close the result set
    * @param rs
    */
   public static void closeResultset(ResultSet rs)
      {
      try
         {
         if (rs != null)
            {
            rs.close();
            rs = null;
            }
         }
      catch (SQLException e)
         {
         logger.error(rs, e);
         }
      }

   /**
    * Method to close the prepared statement
    * @param ps
    */
   public static void closePrepareStatement(PreparedStatement ps)
      {
      try
         {
         if (ps != null)
            {
            ps.close();
            ps = null;
            }
         }
      catch (SQLException e)
         {
         logger.error(ps, e);
         }
      }

   /**
    * Method to close the statement
    * @param st
    */
   public static void closeStatement(Statement st)
      {
      try
         {
         if (st != null)
            {
            st.close();
            st = null;
            }
         }
      catch (SQLException e)
         {
         logger.error(st, e);
         }
      }

   /**
    * Starts a transaction by setting the commit-mode to manual commit. All subsequent sql operations will form part of
    * one transaction until operation 'endTransaction' is called which will commit or roll-back all enclosed sql
    * operations. Executing sql statements without using this operation will be regarded as single operation
    * transactions and hence will commit automatically after execution.
    * 
    * @param dataSourceName
    * @throws SQLException
    * @throws DbException
    */
   public static void startTransaction(Connection connection) throws SQLException
      {
      try
         {
         if (!connection.getAutoCommit())
            throw new RuntimeException("Invalid start transaction handling, auto commit is already inactive!");

         connection.setAutoCommit(false);
         }
      catch (Throwable ex)
         {
         logger.error(connection, ex);
         if (ex instanceof RuntimeException)
            throw (RuntimeException) ex;
         if (!(ex instanceof SQLException))
            ex = new SQLException("Cannot start transaction: " + ex.toString());
         throw (SQLException) ex;
         }
      }

   /**
    * Ends a transaction by doing either a commit or roll-back of all sql operations since a call to operation
    * 'startTransaction'. After calling this operation, the commit mode will again be auto-commit (as of the default
    * connection status).
    * 
    * @param dataSourceName
    * @param commit if true, indicates to commit the operations, otherwise to roll-back.
    * @throws DbException if a db error occurs.
    */
   public static void endTransaction(Connection connection, boolean commit) throws SQLException
      {
      try
         {
         if (connection.getAutoCommit())
            throw new RuntimeException("Invalid end transaction handling, auto commit is active!");

         if (commit)
            connection.commit();
         else
            connection.rollback();
         connection.setAutoCommit(true);
         }
      catch (Throwable ex)
         {
         logger.error(connection, ex);
         if (ex instanceof RuntimeException)
            throw (RuntimeException) ex;
         if (!(ex instanceof SQLException))
            ex = new SQLException("Cannot end transaction: " + ex.toString());
         throw (SQLException) ex;
         }
      }

   /**
    * @param args
    * @throws IOException
    * @throws FileNotFoundException
    */
   public static void main(String[] args) throws FileNotFoundException, IOException
      {
      Connection connection = ConnectionUtil.getDBConnection();
      Statement st = null;
      ResultSet rs = null;
      try
         {
         st = connection.createStatement();
         String sql = "select * from people_user_login";
         rs = st.executeQuery(sql);
         while (rs.next())
            {
            System.out.println(rs.getString("USER_ID"));
            }
         }
      catch (SQLException e)
         {
         e.printStackTrace();
         }
      finally
         {
         closeResultset(rs);
         closeStatement(st);
         closeConnection(connection);
         }
      }
   }