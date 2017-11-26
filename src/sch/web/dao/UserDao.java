package sch.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserDao {
	/**
	 * 學生登入
	 * @param param
	 * @return
	 */
	public Map<String,Object> stuLogin(Map<String, Object> param);
	/**
	 * 老師登入
	 * @param param
	 * @return
	 */
	public Map<String,Object> tchLogin(Map<String, Object> param);
	/**
	 * 查詢學生基本資料
	 * @param param
	 * @return
	 */
	public Map<String,Object> select_stu(Map<String, Object> param);
	/**
	 * 查詢老師基本資料
	 * @param param
	 * @return
	 */
	public Map<String,Object> select_tch(Map<String, Object> param);
}
