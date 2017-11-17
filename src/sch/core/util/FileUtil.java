package sch.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private static List<File> fileList = new ArrayList<File>();
	private static final byte[] buffer = new byte[4096];
	/**
	 * 刪除目錄下所有檔案和資料夾
	 * @param file
	 */
	public static void deleteAllFile(File file) {
		if(file.exists() && file.isDirectory()) {
			for(File f : file.listFiles()) {
				if(f.isDirectory())
					deleteAllFile(f);
				if(f.isFile())
					f.delete();
			}
			deleteFolder(file);
		}
	}
	/**
	 * 刪除資料夾
	 * @param file
	 */
	private static void deleteFolder(File file) {
		for(File f : file.listFiles()) {
			if(f.isDirectory())
				deleteFolder(f);
			f.delete();
		}
	}
	/**
	 * 取得目錄下所有的檔案
	 * @param file
	 * @return
	 */
	public static List<File> allFile(String file) {
		return allFile(new File(file));
	}
	/**
	 * 取得目錄下所有的檔案
	 * @param file
	 * @return
	 */
	public static List<File> allFile(File file) {
		for(File f : file.listFiles()) {
			if(f.isDirectory())
				allFile(f);
			if(f.isFile())
				fileList.add(f);
		}
		return fileList.size() == 0 ? null : fileList;
	}
	/**
	 * 複製檔案
	 * @param source 原始檔
	 * @param dest 目的檔
	 * @throws Exception	 
	 */
	public static void copyFile(File source, File dest) throws Exception {
		if (source.exists() && !source.isDirectory()) {
			BufferedInputStream bins = null;
			BufferedOutputStream bout = null;
			try {
				bins = new BufferedInputStream(new FileInputStream(source));
				bout = new BufferedOutputStream(new FileOutputStream(dest));
				int len = 0;
				while ((len = bins.read(buffer)) > 0) {
					bout.write(buffer , 0 , len);
				}
				bout.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("複製檔案時發生錯誤");
			} finally {
				if(bout != null)
					bout.close();
				if(bins != null)
					bins.close();
			}
		}else {
			throw new Exception(source.getPath() + "檔案不存在");
		}
	}
	/**
	 * 複製檔案
	 * @param source 原始檔
	 * @param dest 目的檔
	 * @throws Exception
	 */
	public static void copyFile(String source, String dest) throws Exception {
		copyFile(new File(source), new File(dest));
	}
	/**
	 * 搬動檔案
	 * @param source 原始檔
	 * @param dest 目的檔
	 * @throws Exception
	 */
	public static void moveFile(String source, String dest) throws Exception {
		moveFile(new File(source), new File(dest));
	}
	/**
	 * 搬動檔案
	 * @param source 原始檔
	 * @param dest 目的檔
	 * @throws Exception
	 */
	public static void moveFile(File source, File dest) throws Exception  {
		if(source.exists() && !source.isDirectory()) {
			BufferedInputStream bins = null;
			BufferedOutputStream bout = null;
			try {
				bout = new BufferedOutputStream(new FileOutputStream(dest));
				bins = new BufferedInputStream(new FileInputStream(source));

				int len = 0;
				while ((len = bins.read(buffer)) > 0) {
					bout.write(buffer , 0 , len);
				}
				bout.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("搬動檔案時發生錯誤");
			} finally {
				if(bout != null)
					bout.close();
				if(bins != null)
					bins.close();
				source.delete();
			}
		} else {
			throw new Exception(source.getPath() + "檔案不存在");
		}
	}
	/**
	 * 複製多個檔案
	 * @param source
	 * @param dest
	 * @throws Exception
	 */
	public static void copyMoreFile(String[] source, String[] dest) throws Exception {
		if(source.length != dest.length) {
			throw new Exception("source與dest長度不同");
		} else {
			for(int i = 0; i < source.length; i++) {
				try {
					copyFile(source[i] , dest[i]);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	/**
	 * 複製多個檔案
	 * @param source
	 * @param dest
	 * @throws Exception
	 */
	public static void copyMoreFile(File[] source, File[] dest) throws Exception {
		if(source.length != dest.length) {
			throw new Exception("source與dest長度不同");
		} else {
			for(int i = 0; i < source.length; i++) {
				try {
					copyFile(source[i] , dest[i]);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	/**
	 * 搬動多個檔案
	 * @param source
	 * @param dest
	 * @throws Exception
	 */
	public static void moveMoreFile(File[] source, File[] dest) throws Exception {
		if(source.length != dest.length) {
			throw new Exception("source與dest長度不同");
		} else {
			for(int i = 0; i < source.length; i++) {
				try {
					moveFile(source[i] , dest[i]);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	/**
	 * 搬動多個檔案
	 * @param source
	 * @param dest
	 * @throws Exception
	 */
	public static void moveMoreFile(String[] source, String[] dest) throws Exception {
		if(source.length != dest.length) {
			throw new Exception("source與dest長度不同");
		} else {
			for(int i = 0; i < source.length; i++) {
				try {
					moveFile(source[i] , dest[i]);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	/**
	 * 查看檔案類型
	 * @param file
	 * @return
	 */
	public static String findFileType(File file) {
		String str = file.getName();
		return str.substring(str.lastIndexOf(".") + 1 , str.length());
	}
	/**
	 * 查看檔案類型
	 * @param file
	 * @return
	 */
	public static String findFileType(String file) {
		return findFileType(new File(file));
	}
	/**
	 * 比較兩個檔案類行是否相同
	 * @param file
	 * @param file2
	 * @return
	 */
	public static boolean isFileTypeSame(File file,File file2) {
		if(findFileType(file).equals(findFileType(file2))) {
			return true;
		}
		return false;
	}
	/**
	 * 比較兩個檔案類行是否相同
	 * @param file
	 * @param file2
	 * @return
	 */
	public static boolean isFileTypeSame(String file,String file2) {
		return isFileTypeSame(new File(file), new File(file2));
	}	
	/**
	 * 判斷某目錄下是否有該檔案(單一目錄)
	 * @param url 要判斷的目錄
	 * @param path 要判斷的檔案
	 * @return
	 */
	public static boolean isDirectoryHaveFile(File url, File file) {
		for(File f : url.listFiles()) {
			if(f.isDirectory())
				continue;
			if(f.getName().equals(file.getName())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判斷某目錄下是否有該檔案(單一目錄)
	 * @param url 要判斷的目錄
	 * @param path 要判斷的檔案
	 * @return
	 */
	public static boolean isDirectoryHaveFile(String url, String file) {
		return isDirectoryHaveFile(new File(url), new File(file));
	}
	/**
	 * 查詢該目錄下有多少該檔名(返回完整路徑+檔名)
	 * @param filepath 路徑
	 * @param name 檔名
	 * @return
	 */
	public static String findFileName(File filePath, String name) {
		if(FileUtil.size() > 0)
			FileUtil.clear();
		List<File> file = allFile(filePath);
		String fileName = "";
		for(File f : file) {
			if(f.getName().equals(name)) {
				fileName += f.getPath() + "\r\n";
			}
		}
		return fileName.equals("") ? "查無此檔案" : fileName;
	}
	/**
	 * 查詢該目錄下有多少該檔名(返回總數)
	 * @param filepath 路徑
	 * @param name 檔名
	 * @return
	 */
	public static int findFileTotal(File filePath, String name) {
		List<File> file = allFile(filePath);
		int total = 0;
		for(File f : file) {
			if(f.getName().equals(name)) {
				total++;
			}
		}
		return total;
	}
	
	public static List<File> getFileList() {
		return fileList;
	}
	/**
	 * 返回list大小
	 * @return
	 */
	public static int size() {
		return fileList.size();
	}
	/**
	 * 清空list
	 */
	public static void clear() {
		fileList.clear();
	}
}
