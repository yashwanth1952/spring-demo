package com.springboot.project.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspects {

    private Logger logger= LoggerFactory.getLogger(ServiceAspects.class);

    @Before("execution(* com.springboot.project.service.*.*(..))")
    public void serviceAspects(JoinPoint joinPoint){
        logger.info("******Executing @Before on method : "+joinPoint.getSignature().toShortString());
    }
}
