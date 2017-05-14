package com.uubian.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import com.uubian.annotation.SystemControllerLog;

@Aspect
@Order(1)
@Component
public class SystemLog {
	
	//@Pointcut("execution(* com.arcgis.action.*Action.*(..))")
	@Pointcut("@annotation(com.uubian.annotation.SystemControllerLog)")
    public void declearJoinPointExpression(){}
	
	@After("declearJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
		String logText = ""; 
		try {
			String targetName = joinPoint.getTarget().getClass().getName();    
	        String methodName = joinPoint.getSignature().getName();    
	        Object[] arguments = joinPoint.getArgs();    
	        Class targetClass = Class.forName(targetName);    
	        Method[] methods = targetClass.getMethods();    
	        for (Method method : methods) {    
	             if (method.getName().equals(methodName)) {    
	                Class[] clazzs = method.getParameterTypes();    
	                 if (clazzs.length == arguments.length) {    
	                	 logText = method.getAnnotation(SystemControllerLog.class).logText();    
	                     break;    
	                }    
	            }    
	        } 
		} catch (Exception e) {
			logText = "方法异常"; 
		}
		  
        
    }
}
