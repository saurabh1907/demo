package com.flp.ems.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class DateParser {
public static Date dateParser(String dateToParse) throws java.text.ParseException{
	 DateFormat dateformatter = new SimpleDateFormat("dd/mm/yyyy"); 
	 Date date= new Date((dateformatter.parse(dateToParse)).getTime());
	 return date;//hello
}
}
