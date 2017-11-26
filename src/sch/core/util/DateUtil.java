package sch.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
	/**
	 * 取得西元系統時間 yyyyMMDD
	 * @return yyyyMMDD 八碼的西元日期
	 */
	public static String getSysDate() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = dateFormat.format(gc.getTime());
		
		return dateStr;
	}	
	/**
	 * 取得民國系統時間 yyyMMDD
	 * @return yyyMMDD 七碼的民國日期
	 */
	public static String getSysMDate() {
		return MDtoCD(getSysDate());
	}
	/**
	 * 將西元時間轉為民國時間 yyyMMDD 轉為 yyyyMMDD
	 * @param dateStr 八碼的西元日期
	 * @return yyyMMDD 七碼的民國日期
	 */
	public static String CDtoMD(String dateStr) {
		if(!isCDate(dateStr)) {
			if(dateStr.length() == 10) {
				
			} else {
				return dateStr;
			}			
		}
			
		String yyy = String.valueOf(Integer.parseInt(dateStr.substring(0,4)) - 1911).trim();
		
		if(yyy.length() == 2)
			yyy = "0" + yyy;
		return yyy + dateStr.substring(4,dateStr.length());
	}
	/**
	 * 將民國時間轉為西元 yyyMMDD 轉為yyyyMMDD
	 * @param dateStr 七碼的民國日期
	 * @return yyyyMMDD 八碼的西元日期
	 */
	public static String MDtoCD(String dateStr) {
		if(!isMDate(dateStr)) {
			if(dateStr.length() == 9) {
				
			} else {
				return dateStr;
			}
		}
					
		String yyy = String.valueOf(Integer.parseInt(dateStr.substring(0,3)) + 1911).trim();
		
		return yyy + dateStr.substring(3,dateStr.length());
	}
	/**
	 * 取得格式化的系統時間　yyy/MM/dd(民國)
	 * @return yyy/MM/dd(民國)
	 */
	public static String doM2WDate() {
		return String.valueOf((Integer.parseInt(doC2WDate().substring(0,4)) - 1911)) + doC2WDate().substring(4);
	}
	/**
	 * 取得格式化的系統時間　yyy/MM/dd(民國)
	 * @return
	 */
	public static String doM2WDate(String type) {
		return String.valueOf((Integer.parseInt(doC2WDate(type).substring(0,4)) - 1911)) + doC2WDate(type).substring(4);
	}
	/**
	 * 取得格式化的系統時間　yyyy/MM/dd(西元)
	 * @return yyyy/MM/dd(西元)
	 */
	public static String doC2WDate() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.TAIWAN);		
		return df.format(new Date());
	}
	/**
	 * 取得格式化的系統時間(需傳入型態)
	 * @param type 傳入型態 ex:/,-
	 * @return
	 */
	public static String doC2WDate(String type) {
		GregorianCalendar gc = new GregorianCalendar();		
		gc.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy"+ type +"MM"+ type +"dd");
		String dateStr = dateFormat.format(gc.getTime());
		
		return dateStr;
	}
	/**
	 * 取得完整的西元系統時間 yyyy/MM/dd hh:mm:ss
	 * @return yyyy/MM/dd hh:mm:ss
	 */
	public static String convertToCDate() {
		return doC2WDate() + " " + getSysTime();
	}
	/**
	 * 取得完整的民國系統時間 yyy/MM/dd hh:mm:ss
	 * @return yyy/MM/dd hh:mm:ss
	 */
	public static String convertToMDate() {
		return doM2WDate() + " " + getSysTime();
	}
	/**
	 * 取得完整的西元系統時間 yyyy-MM-DD(可直接寫入資料庫的date)
	 * @return
	 */
	public static String converToDateforDB() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINESE);
		return df.format(new Date());
	}
	/**
	 * 取得完整的西元系統時間 yyyy-MM-DD hh:mm:ss(可直接寫入資料庫的datetime)
	 * @return
	 */
	public static String converToDateTimeforDB() {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINESE);
		return df.format(new Date());
	}
	/**
	 * 取得系統完整日期 xxxx年xx月xx日 (西元)
	 * @return
	 */
	public static String getFullCDate() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.TAIWAN);
		
		return df.format(new Date());
	}
	/**
	 * 取得系統完整日期 xxx年xx月xx日 (民國)
	 * @return
	 */
	public static String getFullMDate() {		
		String dateStr = String.valueOf(Integer.parseInt(getFullCDate().substring(0,4)) - 1911);	
		return dateStr + getFullCDate().substring(4);
	}
	/**
	 * 將西元或民國日期轉為完整日期
	 * @param dateStr 西元或民國日期
	 * @return
	 */
	public static String getFullDate(String dateStr) {
		//先判斷傳進來的是西元還是民國的年度
		if(isMDate(dateStr)) 
			return dateStr.substring(0,3) + "年" + dateStr.substring(3,5) + "月" + dateStr.substring(5,7) + "日";
		else if(isCDate(dateStr))
			return dateStr.substring(0,4) + "年" + dateStr.substring(4,6) + "月" + dateStr.substring(6,8) + "日";
		else 
			return dateStr;			
	}
	/**
	 * 判斷是否為民國日期
	 * @param dateStr 民國日期
	 * @return
	 */
	public static boolean isMDate(String dateStr) {
		try {
			if(dateStr.length() != 7) 
				return false;
			String year = String.valueOf(Integer.parseInt(dateStr.substring(0,3))  + 1911);
			String month = dateStr.substring(3,5);
			String day = dateStr.substring(5,7);			
			String input_date = year + month + day;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = dateFormat.parse(input_date);
			String _dateStr = dateFormat.format(date);
			
			if(_dateStr.equals(input_date))
				return true;
		} catch (ParseException e) {
			return false;
		}
		return false;
	}
	/**
	 * 檢查是否為西元日期
	 * @param dateStr 西元日期
	 * @return
	 */
	public static boolean isCDate(String dateStr)  {		
		try {
			if(dateStr.length() != 8) 
				return false;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = dateFormat.parse(dateStr);
			String _dateStr = dateFormat.format(date);
			
			if(_dateStr.equals(dateStr))
				return true;
		} catch (ParseException e) {
			return false;
		}		
		return false;		
	}
	/**
	 * 取得系統時間  kk:mm:ss
	 * @return
	 */
	public static String getSysTime() {
		DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.CHINESE);
		return df.format(new Date());
	}
	/**
	 * 取得系統時間  kkmmss
	 * @return
	 */
	public static String getSySTime() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
		
		return dateFormat.format(gc.getTime());
	}
	/**
	 * 取得完整系統時間 上午 kk:mm:ss
	 * @return
	 */
	public static String getFullSysTime() {
		DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.TAIWAN);
		return df.format(new Date());
	}
	/**
	 * 取得15碼系統時間yyymmddhhmmssSS(民國)
	 * @return
	 */
	public static String getSysTimeStamp() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmssSSS");
		String dateStr = dateFormat.format(gc.getTime());
		
		return getSysMDate() + dateStr.substring(0,8);
	}

	public static void main(String[] args) {
		/*System.out.println(DateUtil.doC2WDate());
		System.out.println(DateUtil.convertToCDate());
		System.out.println(DateUtil.convertToMDate());
		System.out.println(DateUtil.getFullCDate());
		System.out.println(DateUtil.getFullMDate());
		System.out.println(DateUtil.getSysTime());
		System.out.println(DateUtil.getFullSysTime());
		System.out.println(getSysTimeStamp());
		System.out.println(MDtoCD("1061111"));
		System.out.println(CDtoMD("20171231"));
		System.out.println(getFullDate("20170228"));
		System.out.println(converToDateTimeforDB());
		System.out.println(converToDateforDB());*/
		System.out.println(CDtoMD("2017-12-31"));
		System.out.println(MDtoCD("1061231"));
	}
}
