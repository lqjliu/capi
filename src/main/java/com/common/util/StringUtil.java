package com.common.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static long[] getLongs(String ids, String sep) {
		String[] idsArray = splitString(ids, sep);
		long[] result = new long[idsArray.length];
		for (int i = 0; i < idsArray.length; i++) {
			result[i] = Long.parseLong(idsArray[i]);
		}
		return result;
	}

	public static String[] splitString(String ids, String sep) {
		if (ids == null || ids.equals("")) {
			return null;
		}
		String idsTemp = ids;
		List<String> result = new ArrayList<String>();
		while (idsTemp.indexOf(sep) >= 0) {
			int pos = idsTemp.indexOf(sep);
			String pre = idsTemp.substring(0, pos);
			idsTemp = idsTemp.substring(pos + 1);
			if(!pre.equals("")){
				result.add(pre);
			}
		}
		if (idsTemp != null && !idsTemp.equals("")) {
			result.add(idsTemp);
		}
		String[] results = new String[result.size()];
		for(int i = 0 ; i<result.size(); i++){
			results[i] = result.get(i);
		}
		return results;
	}

	public static void main(String[] args){
		String abc = "1#4#10";
		String[] result = splitString(abc,"#");
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
		System.out.println("**************************");
		abc = "1";
		result = splitString(abc,"#");
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
		System.out.println("**************************");
		
		abc = "1#4#";
		result = splitString(abc,"#");
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}		
		System.out.println("**************************");
		abc = "#1#4";
		result = splitString(abc,"#");
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}		
	}
	
}
