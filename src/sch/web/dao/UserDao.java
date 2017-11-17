package sch.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserDao {
	public List<Map<String,Object>> select();
}
