package sch.web.dao.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import sch.core.dao.BaseDao;
import sch.core.dao.impl.DaoFactory;
import sch.core.dao.support.SchTransactionManager;
import sch.core.util.LogUtil;
import sch.web.dao.SchDao;

@Aspect
public class SchDaoAdvice {
	
	@Around(value = "execution(* sch.**.**.*manager..*(..))")
	public Object ManagerAround(ProceedingJoinPoint point) throws Throwable {
		if (point.getThis() instanceof SchDaoAdviceTarget) {
			SchDao dao = DaoFactory.getDaoFactory().createDao("ds_SchDao");
			LogUtil.info(point.getClass(), "### create ds_SchDao success ...");
			((SchDaoAdviceTarget)point.getThis()).setDao(dao);
			//預設啟動交易
			SchTransactionManager tx = dao.beginTransaction(BaseDao.PROPAGATION_REQUIRED, BaseDao.DEFAULT_TRANSACTION_TIMEOUT);
			((SchDaoAdviceTarget)point.getThis()).setSchTransactionManager(tx);
		}
		Object result = point.proceed();
		System.out.println("Around：result=" + result);
		return result;
	}
}
