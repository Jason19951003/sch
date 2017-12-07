package sch.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("classDao")
public interface ClassDao {
	/**
	 * 查詢班級資料
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> query(Map<String, Object> param);	
}
