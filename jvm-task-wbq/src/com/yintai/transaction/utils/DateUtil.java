package com.yintai.transaction.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 
	 * ��ȡ����ʱ��
	 * @return�����ַ�����ʽyyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(currentTime);

		return dateString;

	}
}
