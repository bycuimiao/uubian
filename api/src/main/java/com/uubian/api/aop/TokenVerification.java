package com.uubian.api.aop;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.uubian.api.repository.redis.TockenRepository;
@Aspect
@Component
public class TokenVerification {
	
		
	//@Pointcut("execution(* com.uubian.api.controller..*(..)) && !execution(* com.uubian.api.controller.LoginController.*(..))")
	@Pointcut("execution(* com.uubian.api.controller..*(..)) && !@annotation(com.uubian.api.annotation.Privilege)")  
    public void controllerMethodPointcut(){}  
      
    @Autowired
	public TockenRepository tockenRepository;
	
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp){  
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
    	Cookie cookies[]=request.getCookies();
    	String token="";
    	if(cookies!=null){
        	for(int i=0;i<cookies.length;i++){
        		Cookie cookie=cookies[i];
        		if(cookie.getName().equals("token")){
        			token=cookie.getValue();
        			break;
        		}
        	}
    	}
    	if(token.length()>0){
    		String tokenValue=tockenRepository.getTocken(token);
    		if(tokenValue!=null&&tokenValue.length()>0){
    			try {
    				tockenRepository.setTocken(token, tokenValue);
    				return pjp.proceed();
    			} catch (Throwable e) {
    				return null;
    			} 
    		}else{
    			return null;
    		}
    	}else{
    		return null;
    	}
    	
    }  
}
