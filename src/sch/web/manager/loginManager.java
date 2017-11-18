package sch.web.manager;

import java.util.Map;

public interface loginManager {
	/**
	 * 學生登入
	 * @param param
	 * @return
	 */
	Map<String, Object> stuLogin(Map<String, Object> param);
	/**
	 * 老師登入
	 * @param param
	 * @return
	 */
	Map<String, Object> tchLogin(Map<String, Object> param);
}
