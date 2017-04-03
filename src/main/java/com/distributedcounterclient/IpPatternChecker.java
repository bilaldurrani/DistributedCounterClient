package com.distributedcounterclient;

import java.util.regex.Pattern;

public class IpPatternChecker {

	Pattern ipPattern = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
	
	public boolean checkIp(String toCheck, String port) {
		return checkIsInt(port) && ipPattern.matcher(toCheck).matches();
	}
	
	private boolean checkIsInt(String toCheck) {
		try{
				Integer.parseInt(toCheck);
				return true;
		} catch (NumberFormatException e) {
				return false;
		}
	}
}
