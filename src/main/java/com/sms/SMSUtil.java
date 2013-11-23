package com.sms;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSUtil {
	public static String SMS_ACCOUNT_NAME = "caru";
	public static String SMS_ACCOUNT_PASSWORD = "168168";
	public static void sendSM(String message, String[] mobiles){
		final String msg = message;
		String mobile_s = "";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		final String time = sdf.format(now);
		for(int i = 0; i < mobiles.length; i++){
			if(i != 0){
				mobile_s = mobile_s + ",";
			}
			mobile_s = mobile_s + mobiles[i];
		}
		final String mobile_s1 = mobile_s;
		Thread st = new Thread(new Runnable(){
			public void run(){
				SMSServer sms = new SMSServer();
				sms.sendSms(SMS_ACCOUNT_NAME, SMS_ACCOUNT_PASSWORD, mobile_s1, msg, time);
			}
		});
		st.start();
	}
	
	public static void sendSM(String message, String mobile){
		String[] mobiles = new String[]{mobile};
		sendSM(message, mobiles);
	}

	public static void main(String[] args){
		sendSM( "ÄãºÃ,ÖÐ¹ú", "13814838918,13773277186");
	}
}
