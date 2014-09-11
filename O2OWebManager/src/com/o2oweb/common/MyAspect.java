package com.o2oweb.common;

/**
 * @author �������� zj
 * @version ����ʱ�䣺May 20, 2013 10:10:36 AM
 * ��˵��    aop�����
 */
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect
{
	private static Logger logger = Logger.getLogger(MyAspect.class.getName());

	public MyAspect()
	{
	}

	@Before("Pointcuts.pointcut()")
	public void beforeAdvice()
	{
		logger.info("ִ��ǰ��֪ͨ");
	}

	@After("Pointcuts.pointcut()")
	public void afterAdvice()
	{
		logger.info("ִ��β��֪ͨ");
	}

	@AfterReturning(pointcut = "Pointcuts.pointcut()", returning = "returnValue")
	public void afterReturningAdvice(Object returnValue)
	{
		logger.info("ִ�з���ֵβ֪ͨ��" + returnValue);
	}

	@AfterThrowing(pointcut = "Pointcuts.pointcut()", throwing = "ex")
	public void afterThrowException(Exception ex)
	{
		logger.error("�����쳣��Ϣ��" + ex.getMessage());
	}

	@Around("Pointcuts.pointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object returnValue = null;
		logger.info("���뻷��֪ͨ��");
		logger.info("�����ࣺ" + pjp.getTarget().getClass().getName());
		logger.info("�����ࣺ" + pjp.getThis().getClass().getName());
		logger.info("���뷽����" + pjp.getSignature().getName());
		Object[] args = pjp.getArgs();
		for (Object o : args) {
			logger.info(o + " ");
		}
		try {
			returnValue = pjp.proceed();
			logger.info("����ִ����ɣ�");
		} catch (Exception e) {
			logger.info("�����쳣��Ϣ:", e);
			throw e;
		} finally {
			logger.info("��ɻ���֪ͨ!");
		}
		return returnValue;
	}
}
