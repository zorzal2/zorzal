package com.fontar.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class Validation extends TestCase {
	
	public void testDateValidation() throws ParseException{
		Pattern datePattern = Pattern.compile("\\d{1}(\\d{1})*/\\d{1}(\\d{1})*/(\\d{4})");
		
		Matcher dateMatcher = datePattern.matcher("1/1/2000");
		assertTrue(dateMatcher.matches());
		
		dateMatcher = datePattern.matcher("01/12/2000");
		assertTrue(dateMatcher.matches());
		
		dateMatcher = datePattern.matcher("23/1/2012");
		assertTrue(dateMatcher.matches());
		
		dateMatcher = datePattern.matcher("1/1/2**");
		assertFalse(dateMatcher.matches());
		
		dateMatcher = datePattern.matcher("a/**/2**/");
		assertFalse(dateMatcher.matches());
		
		dateMatcher = datePattern.matcher("1/1/200/");
		assertFalse(dateMatcher.matches());
		
	}

}
