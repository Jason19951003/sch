package sch.web.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class RequestBean {
	
	private HttpServletRequest request;
	private Map resultMap;
	private List<MultipartFile> mulitFile;
	
	public RequestBean(Map resultMap) {
		this.resultMap = resultMap;		
	}
	
	public RequestBean(Map resultMap, List<MultipartFile> mulitFile) {
		this.resultMap = resultMap;
		this.mulitFile = mulitFile;
	}
	
	public static RequestBean buildRequestBean(HttpServletRequest request) throws Exception {		
		if (request instanceof MultipartHttpServletRequest) {
			return buildRequestBeanWithMultiPart(request);
		} else {
			return buildRequestBeanWithRequest(request);
		}		
	}
	
	private static RequestBean buildRequestBeanWithMultiPart(HttpServletRequest request) throws Exception {
		RequestBean requestBean = null;
		Map<String, String[]> map = request.getParameterMap();		
		List<MultipartFile> mulitFile = new ArrayList<MultipartFile>();		
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multi.getFileNames();
		
		while (iterator.hasNext()) {
			String fileName = iterator.next();
			for (int i = 0; i < multi.getFiles(fileName).size(); i++) {
				MultipartFile file = multi.getFiles(fileName).get(i);
				
				if (file.getSize() == 0)
					continue;
				
				mulitFile.add(file);
			}
		}
		
		requestBean = new RequestBean(formatMap(map), mulitFile);
		requestBean.setRequest(request);
		return requestBean;
	}

	private static RequestBean buildRequestBeanWithRequest(HttpServletRequest request) throws Exception {
		RequestBean requestBean = null;
		Map<String, String[]> map = request.getParameterMap();	
		
		requestBean = new RequestBean(formatMap(map));
		requestBean.setRequest(request);
		
		return requestBean;
	}
	
	/**
	 * 將Map轉為<String,Object>
	 * @param map
	 * @return
	 */
	private static Map<String, Object> formatMap(Map<String, String[]> map) {
		Map<String, Object> tranMap = new Hashtable<String, Object>();
		for (String key : map.keySet()) {
			if (map.get(key) != null && ((String[])map.get(key)).length == 1) {
				String val = map.get(key)[0];
				tranMap.put(key, val);
			} else if (map.get(key) != null && ((String[])map.get(key)).length > 1) {
				tranMap.put(key, map.get(key));
			} else {
				tranMap.put(key, "");
			}
		}
		
		return tranMap;
	}
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * @return the resultMap
	 */
	public Map getResultMap() {
		return resultMap;
	}
	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
	/**
	 * @return the mulitFile
	 */
	public List<MultipartFile> getMulitFile() {
		return mulitFile;
	}
	/**
	 * @param mulitFile the mulitFile to set
	 */
	public void setMulitFile(List<MultipartFile> mulitFile) {
		this.mulitFile = mulitFile;
	}
	/**
	 * 取得Session
	 * @return
	 */
	public HttpSession getSession() {
		return this.request.getSession();
	}
	/**
	 * 設置Attribute
	 * @param s
	 * @param obj
	 */
	public void setAttribute(String s, Object obj) {
		this.request.setAttribute(s, obj);
	}
	/**
	 * 取得Attribute
	 * @param s
	 * @return
	 */
	public Object getAttribute(String s) {
		return this.request.getAttribute(s);
	}
}
