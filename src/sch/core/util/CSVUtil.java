package sch.core.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class CSVUtil {
	private BufferedWriter bw = null;
	/**
	 * 傳入產擋路徑(編碼預設BIG5)
	 * @param path	
	 * @throws Exception
	 */
	public void createCSV(String path) throws Exception {
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path , false),"BIG5"));
	}
	/**
	 * 傳入產擋路徑與編碼隔式
	 * @param path
	 * @param format
	 * @throws Exception
	 */
	public void createCSV(String path , String format) throws Exception {
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path , false),format));
	}
	/**
	 * 傳入的參數需以逗後分開(通常用在標題)
	 * @param str
	 * @throws IOException
	 */
	public void writeCSV(String str) throws IOException {
		bw.write(str);
		bw.flush();
	}
	/**
	 * 傳入List
	 * @param datalist
	 * @throws IOException
	 */
	public void writeCSV(List<Map<String, Object>> datalist) throws IOException {
		for(int i = 0; i < datalist.size(); i++) {
			Map<String, Object> map = datalist.get(i);
			String row = "";
			for(String str : map.keySet()) {
				row += map.get(str) + ",";
			}
			
			row = row.substring(0, row.length() - 1) + "\r\n";
			bw.write(row);
			bw.flush();
		}
	}
	/**
	 * 傳入List(可自訂資料的順序)
	 * @param datalist
	 * @throws IOException
	 */
	public void writeCSV(List<Map<String, Object>> datalist, String[] param) throws IOException {
		for(int i = 0; i < datalist.size(); i++) {
			Map<String, Object> map = datalist.get(i);
			String row = "";
			for(String str : param) {
				row += map.get(str) + ",";
			}
			
			row = row.substring(0, row.length() - 1) + "\r\n";
			bw.write(row);
			bw.flush();
		}
	}
	/**
	 * 關閉 BufferedWriter
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (bw != null) {
			bw.close();
		}
	}
}
