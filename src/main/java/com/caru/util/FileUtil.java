package com.caru.util;

public class FileUtil {
	public static String getFileName(String browserFile){
		String result = browserFile;
		if(browserFile.lastIndexOf("\\")>0){
			result = browserFile.substring(browserFile.lastIndexOf("\\") + 1);
		}
		return result;
	} 
}
