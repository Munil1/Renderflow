package com.byabie.rdf.util;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Util {
	public static String loadResourceText(String pathExtension) {
		StringBuilder returns = new StringBuilder();
		try {
			URL jarLocation = Util.class.getProtectionDomain().getCodeSource().getLocation();
			File jarFile = new File(jarLocation.toURI());
			File file = new File(jarFile.getParentFile(), pathExtension);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				returns.append(reader.nextLine()).append(System.lineSeparator());
			}
		} catch(Exception exc) {exc.printStackTrace();}
		return returns.toString();
	}
	public static File loadResource(String pathExtension) {
		try {
			URL jarLocation = Util.class.getProtectionDomain().getCodeSource().getLocation();
			File jarFile = new File(jarLocation.toURI());
			return new File(jarFile.getParentFile(), pathExtension);
		} catch(Exception exc) {exc.printStackTrace();}
		return null;
	}
	public static String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
	public static boolean begins(String toCheck, String beginsWith) {
		if(toCheck.length() < beginsWith.length()) {
			return false;
		}
		if(toCheck == null || beginsWith == null) {
			return false;
		}
		for(int i = 0; i != beginsWith.length(); i++) {
			if(toCheck.charAt(i) != beginsWith.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean ends(String toCheck, String endsWith) {
        if (toCheck == null || endsWith == null) {
            return false;
        }
        if (endsWith.length() > toCheck.length()) {
            return false;
        }

        int startIndex = toCheck.length() - endsWith.length();
        for (int i = 0; i < endsWith.length(); i++) {
            if (toCheck.charAt(startIndex + i) != endsWith.charAt(i)) {
                return false;
            }
        }
        return true;
    }
	public interface Convertible {
		 String toString();
		 Integer toInt();
		 Boolean toBoolean();
		 Object toObject();
		 Class<?> toClass();
		
		 Object fromString(String convertFrom);
		 Object fromInt(Integer convertFrom);
		 Object fromBoolean(Boolean convertFrom);
		 Object fromObject(Object convertFrom);
		 Object fromClass(Class<?> convertFrom);
	}
}