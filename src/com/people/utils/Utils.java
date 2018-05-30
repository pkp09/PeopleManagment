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
 * $Log: Utils.java,v $
 */

package com.people.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utils
   {
   /**
    * @return
    */
   public static String getCurrentDate()
      {
      String formattedDate = null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      formattedDate = sdf.format(Calendar.getInstance().getTime());
      return formattedDate;
      }
   /**
    * @return
    */
   public static String getCurrentDateTime()
      {
      String formattedDateTime = null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      formattedDateTime = sdf.format(Calendar.getInstance().getTime());
      //System.out.println(formattedDateTime);
      return formattedDateTime;
      }

   /**
    * @return
    */
   public static String createDropDown()
      {
      ArrayList<String> al = new ArrayList<String>();
      al.add("Afghanistan");
      al.add("Albania");
      al.add("Algeria");
      al.add("Andorra");
      al.add("Angola");
      al.add("Antarctica");
      al.add("Antigua and Barbuda");
      al.add("Argentina");
      al.add("Armenia");
      al.add("Australia");
      al.add("Austria");
      al.add("Azerbaijan");
      al.add("Bahamas");
      al.add("Bahrain");
      al.add("Bangladesh");
      al.add("Barbados");
      al.add("Belarus");
      al.add("Belgium");
      al.add("Belize");
      al.add("Benin");
      al.add("Bermuda");
      al.add("Bhutan");
      al.add("Bolivia");
      al.add("Bosnia and Herzegovina");
      al.add("Botswana");
      al.add("Brazil");
      al.add("Brunei");
      al.add("Bulgaria");
      al.add("Burkina Faso");
      al.add("Burma");
      al.add("Burundi");
      al.add("Cambodia");
      al.add("Cameroon");
      al.add("Canada");
      al.add("Cape Verde");
      al.add("Central African Republic");
      al.add("Chad");
      al.add("Chile");
      al.add("China");
      al.add("Colombia");
      al.add("Comoros");
      al.add("Congo, Democratic Republic");
      al.add("Congo, Republic of the");
      al.add("Costa Rica");
      al.add("Cote d'Ivoire");
      al.add("Croatia");
      al.add("Cuba");
      al.add("Cyprus");
      al.add("Czech Republic");
      al.add("Denmark");
      al.add("Djibouti");
      al.add("Dominica");
      al.add("Dominican Republic");
      al.add("East Timor");
      al.add("Ecuador");
      al.add("Egypt");
      al.add("El Salvador");
      al.add("Equatorial Guinea");
      al.add("Eritrea");
      al.add("Estonia");
      al.add("Ethiopia");
      al.add("Fiji");
      al.add("Finland");
      al.add("France");
      al.add("Gabon");
      al.add("Gambia");
      al.add("Georgia");
      al.add("Germany");
      al.add("Ghana");
      al.add("Greece");
      al.add("Greenland");
      al.add("Grenada");
      al.add("Guatemala");
      al.add("Guinea");
      al.add("Guinea-Bissau");
      al.add("Guyana");
      al.add("Haiti");
      al.add("Honduras");
      al.add("Hong Kong");
      al.add("Hungary");
      al.add("Iceland");
      al.add("India");
      al.add("Indonesia");
      al.add("Iran");
      al.add("Iraq");
      al.add("Ireland");
      al.add("Israel");
      al.add("Italy");
      al.add("Jamaica");
      al.add("Japan");
      al.add("Jordan");
      al.add("Kazakhstan");
      al.add("Kenya");
      al.add("Kiribati");
      al.add("Korea North");
      al.add("Korea, South");
      al.add("Kuwait");
      al.add("Kyrgyzstan");
      al.add("Laos");
      al.add("Latvia");
      al.add("Lebanon");
      al.add("Lesotho");
      al.add("Liberia");
      al.add("Libya");
      al.add("Liechtenstein");
      al.add("Lithuania");
      al.add("Luxembourg");
      al.add("Macedonia");
      al.add("Madagascar");
      al.add("Malawi");
      al.add("Malaysia");
      al.add("Maldives");
      al.add("Mali");
      al.add("Malta");
      al.add("Marshall Islands");
      al.add("Mauritania");
      al.add("Mauritius");
      al.add("Mexico");
      al.add("Micronesia");
      al.add("Moldova");
      al.add("Mongolia");
      al.add("Morocco");
      al.add("Monaco");
      al.add("Mozambique");
      al.add("Namibia");
      al.add("Nauru");
      al.add("Nepal");
      al.add("Netherlands");
      al.add("New Zealand");
      al.add("Nicaragua");
      al.add("Niger");
      al.add("Nigeria");
      al.add("Norway");
      al.add("Oman");
      al.add("Pakistan");
      al.add("Panama");
      al.add("Papua New Guinea");
      al.add("Paraguay");
      al.add("Peru");
      al.add("Philippines");
      al.add("Poland");
      al.add("Portugal");
      al.add("Qatar");
      al.add("Romania");
      al.add("Russia");
      al.add("Rwanda");
      al.add("Samoa");
      al.add("San Marino");
      al.add(" Sao Tome");
      al.add("Saudi Arabia");
      al.add("Senegal");
      al.add("Serbia and Montenegro");
      al.add("Seychelles");
      al.add("Sierra Leone");
      al.add("Singapore");
      al.add("Slovakia");
      al.add("Slovenia");
      al.add("Solomon Islands");
      al.add("Somalia");
      al.add("South Africa");
      al.add("Spain");
      al.add("Sri Lanka");
      al.add("Sudan");
      al.add("Suriname");
      al.add("Swaziland");
      al.add("Sweden");
      al.add("Switzerland");
      al.add("Syria");
      al.add("Taiwan");
      al.add("Tajikistan");
      al.add("Tanzania");
      al.add("Thailand");
      al.add("Togo");
      al.add("Tonga");
      al.add("Trinidad and Tobago");
      al.add("Tunisia");
      al.add("Turkey");
      al.add("Turkmenistan");
      al.add("Uganda");
      al.add("Ukraine");
      al.add("United Arab Emirates");
      al.add("United Kingdom");
      al.add("United States");
      al.add("Uruguay");
      al.add("Uzbekistan");
      al.add("Vanuatu");
      al.add("Venezuela");
      al.add("Vietnam");
      al.add("Yemen");
      al.add("Zambia");
      al.add("Zimbabwe");

      String soption = "";
      for (int i = 0; i < al.size(); i++)
         {
         soption = soption + "<option value=" + al.get(i) + ">" + al.get(i) + "</option>";
         }
      return soption;
      }

   public static String createDropDown(String sXmlPath) throws SAXException, IOException, ParserConfigurationException
      {
      Map<String, String> national = readXml(sXmlPath);
      String sOption = "";
      Set<Entry<String, String>> set = national.entrySet();

      for (Entry<String, String> forSet : set)
         {
         //System.out.println(forSet.getKey());
        // System.out.println(forSet.getValue());

         sOption = sOption + "<option value='" + forSet.getKey() + "'>" + forSet.getValue() + "</option>";
         }

      return sOption;
      }

   /**
    * @param sXmlFilePath
    * @return
    * @throws SAXException
    * @throws IOException
    * @throws ParserConfigurationException
    */
   public static Map<String, String> readXml(String sXmlFilePath) throws SAXException, IOException,
         ParserConfigurationException
      {
      Map<String, String> nationality = new TreeMap<String, String>();
      File fXmlFile = new File(sXmlFilePath);
      // Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML
      // documents.
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);

      doc.getDocumentElement().normalize();

      //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

      NodeList nList = doc.getElementsByTagName("option");
      for (int temp = 0; temp < nList.getLength(); temp++)
         {
         Node nNode = nList.item(temp);
         Element eElement = (Element) nNode;
         Node n = nList.item(temp);
         Node actualNode = n.getFirstChild();
         if (actualNode != null)
            {
            nationality.put(eElement.getAttribute("value"), actualNode.getNodeValue());
            }
         }
      return nationality;
      }

   /**
    * @param args
    * @throws ParserConfigurationException 
    * @throws IOException 
    * @throws SAXException 
    */
   public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
      {
      // getCurrentDate();
      // System.out.println(createDropDown());
         //createDropDown("C:\\javaroot\\projects\\PeopelManagment\\WebContent\\WEB-INF\\natyionality.xml");
      getCurrentDateTime();
      }

   }
