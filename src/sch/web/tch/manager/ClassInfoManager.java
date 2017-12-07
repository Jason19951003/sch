package sch.web.tch.manager;

import java.util.List;
import java.util.Map;

public interface ClassInfoManager {
	/**
	 * 班級資訊主要方法
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> processMain(Map<String, Object> param);
}
