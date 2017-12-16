package sch.web.dao.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import sch.core.dao.impl.DaoFactory;

@Aspect
public class SchDaoAdvice {
	
	@Around(value = "execution(* sch.**.**.*manager..*(..))")
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		if (point.getThis() instanceof SchDaoAdviceTarget) {			
			((SchDaoAdviceTarget)point.getThis()).setDao(DaoFactory.getDaoFactory().createDao("ds_SchDao"));
		}		
		Object result = point.proceed();
		System.out.println("Around：result=" + result);
		return result;
	}
}
