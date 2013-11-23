package com.common.web;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

import com.caru.exception.ExceptionKeys;
import com.common.util.BitsUtil;
import com.common.util.EncryptionUtil;

public class TokenUtil {
	public static final int ACCOUNTID_LENGTH = 4;
	public static final int CORPORATIONID_LENGTH = 4;
	public static final int CONTACTID_LENGTH = 4;
	public static final int CARCOUNT_LENGTH = 1;
	public static final int CARID_LENGTH = 4;
	public static final int HASH_LENGTH = 32;

	public static String getTicket(Token token) throws Exception {
		String ticket = null;
		int[] carIDs = token.getCarids();
		byte[] majorContent = new byte[ACCOUNTID_LENGTH + CORPORATIONID_LENGTH
				+ CONTACTID_LENGTH + CARCOUNT_LENGTH + CARID_LENGTH
				* carIDs.length + HASH_LENGTH];
		int accountid = token.getAccountid();
		BitsUtil.putInt(majorContent, 0, accountid);
		int corporationID = token.getCorporationid();
		BitsUtil.putInt(majorContent, ACCOUNTID_LENGTH, corporationID);
		int contactID = token.getContactid();
		BitsUtil.putInt(majorContent, ACCOUNTID_LENGTH + CORPORATIONID_LENGTH,
				contactID);
		majorContent[ACCOUNTID_LENGTH + CORPORATIONID_LENGTH + CONTACTID_LENGTH] = (byte) carIDs.length;
		int carIDStartPos = ACCOUNTID_LENGTH + CORPORATIONID_LENGTH
				+ CONTACTID_LENGTH + CARCOUNT_LENGTH;
		for (int i = 0; i < carIDs.length; i++) {
			BitsUtil.putInt(majorContent, carIDStartPos + (CARID_LENGTH * i),
					carIDs[i]);
		}
		long now = System.currentTimeMillis();
		BitsUtil.putLong(majorContent, carIDStartPos + CARID_LENGTH
				* carIDs.length, now);

		byte[] mHash = EncryptionUtil.sha2sum(majorContent);
		byte[] encrypt = EncryptionUtil.encrypt(majorContent);

		byte[] ticketB = new byte[mHash.length + encrypt.length];
		System.arraycopy(mHash, 0, ticketB, 0, mHash.length);
		System.arraycopy(encrypt, 0, ticketB, mHash.length, encrypt.length);
		ticket = new String(Base64.encodeBase64(ticketB));
		return ticket;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 400; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					main1(null);
				}
			});
			t.start();
		}
	}

	public static void main1(String[] args) {
		EncryptionUtil.sha2sum(new byte[] { 10, 20, 30 });
		Token token = new Token();
		token.setAccountid(100);
		token.setContactid(200);
		token.setCorporationid(300);
		int[] carIds = { 55, 65, 75 };
		token.setCarids(carIds);
		String ticket = null;
		for (int i = 0; i < 50; i++) {
			try {
				System.out.println("Thread " + Thread.currentThread()+ " Token1 = " + token.toString());
				long now = System.currentTimeMillis();
				ticket = getTicket(token);

				long now1 = System.currentTimeMillis();
				System.out.println("Thread " + Thread.currentThread()+ " getTicket took : " + (now1 - now));
				token = getToken(ticket);
				long now2 = System.currentTimeMillis();
				System.out.println("Thread " + Thread.currentThread()+ " getToken took : " + (now2 - now1));
				System.out.println("Thread " + Thread.currentThread()+ " Token2 = " + token.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public static Token getToken(String ticket) throws Exception {
		Token token = new Token();
		byte[] decodeBytes = Base64.decodeBase64(ticket.getBytes());
		byte[] hash = new byte[HASH_LENGTH];
		byte[] encrypt = new byte[decodeBytes.length - HASH_LENGTH];
		System.arraycopy(decodeBytes, 0, hash, 0, HASH_LENGTH);
		System.arraycopy(decodeBytes, HASH_LENGTH, encrypt, 0,
				decodeBytes.length - HASH_LENGTH);

		byte[] majorContent = EncryptionUtil.decrypt(encrypt);
		byte[] mHash = EncryptionUtil.sha2sum(majorContent);
		if (!Arrays.equals(hash, mHash)) {
			throw new Exception(ExceptionKeys.INVALID_CREDENTIAL);
		}
		int accountid = BitsUtil.getInt(majorContent, 0);
		token.setAccountid(accountid);
		int corporationID = BitsUtil.getInt(majorContent, ACCOUNTID_LENGTH);
		token.setCorporationid(corporationID);
		int contactID = BitsUtil.getInt(majorContent, ACCOUNTID_LENGTH
				+ CORPORATIONID_LENGTH);
		token.setContactid(contactID);

		byte carCount = majorContent[ACCOUNTID_LENGTH + CORPORATIONID_LENGTH
				+ CONTACTID_LENGTH];
		int[] carIDs = new int[carCount];

		int carIDStartPos = ACCOUNTID_LENGTH + CORPORATIONID_LENGTH
				+ CONTACTID_LENGTH + CARCOUNT_LENGTH;
		for (int i = 0; i < carIDs.length; i++) {
			carIDs[i] = BitsUtil.getInt(majorContent, carIDStartPos
					+ (CARID_LENGTH * i));
		}
		token.setCarids(carIDs);
		long timeStamp = BitsUtil.getLong(majorContent, carIDStartPos
				+ CARID_LENGTH * carIDs.length);
		long now = System.currentTimeMillis();
		if (now - timeStamp > 30 * 60 * 1000) {
			throw new Exception(ExceptionKeys.INVALID_CREDENTIAL);
		}
		token.setActiveTime(now);
		return token;
	}
}
