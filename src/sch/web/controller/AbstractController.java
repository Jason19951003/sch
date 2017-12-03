package sch.web.controller;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import sch.core.common.BaseConstant;

@SuppressWarnings("all")
public abstract class AbstractController implements BaseController {
	
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	private RequestBean requestBean;
	private ResponseBean responseBean;
	private String method;
	
	
	@RequestMapping("/")
	public ModelAndView testController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding(BaseConstant.SYSTEM_ENCODE_UTF8);
		response.setContentType(BaseConstant.HTTP_CONTENT_TYPE);
		try {
			this._request = request;
			this._response = response;
			this.responseBean = new ResponseBean();
			
			this.requestBean = RequestBean.buildRequestBean(request);
			this.method = request.getParameter("action");
			
			Object obj = getCurrent();
			Method m = obj.getClass().getMethod(this.method, RequestBean.class, ResponseBean.class, HttpServletResponse.class);
			m.invoke(obj, requestBean, responseBean, _response);
			
			switch (responseBean.getReturnType()) {
			case JSON:
				if (responseBean.getData() == null ) {
					responseBean.setData(new HashMap(0));
				}
				response.getWriter().print(toJsonString(this.responseBean));
				response.getWriter().close();
				return null;
			case DOWNLOAD:
				
				return null;
			case NO_RETURN:
				
				return null;
			case SERVER_PAGE_FORWARD:
				ModelAndView mav = new ModelAndView();				
				mav.setViewName(responseBean.getReturnPage());
				return mav;
				
			default:
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();			
			throw new Exception(e);			
		}
	}
	
	public AbstractController getCurrent() {
		return this;
	}
	
	public String toJsonString(Object obj) {
		Gson gson = new Gson();
		String str = gson.toJson(obj);
		return str;
	}
	
	/**
	 * @return the _request
	 */
	public HttpServletRequest get_request() {
		return _request;
	}

	/**
	 * @param _request the _request to set
	 */
	public void set_request(HttpServletRequest _request) {
		this._request = _request;
	}

	/**
	 * @return the _response
	 */
	public HttpServletResponse get_response() {
		return _response;
	}

	/**
	 * @param _response the _response to set
	 */
	public void set_response(HttpServletResponse _response) {
		this._response = _response;
	}

	/**
	 * @return the requestBean
	 */
	public RequestBean getRequestBean() {
		return requestBean;
	}

	/**
	 * @param requestBean the requestBean to set
	 */
	public void setRequestBean(RequestBean requestBean) {
		this.requestBean = requestBean;
	}

	/**
	 * @return the responseBean
	 */
	public ResponseBean getResponseBean() {
		return responseBean;
	}

	/**
	 * @param responseBean the responseBean to set
	 */
	public void setResponseBean(ResponseBean responseBean) {
		this.responseBean = responseBean;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
}
