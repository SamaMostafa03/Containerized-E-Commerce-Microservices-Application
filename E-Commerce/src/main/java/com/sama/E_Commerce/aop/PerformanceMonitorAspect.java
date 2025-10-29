package com.sama.E_Commerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
@Aspect
public class PerformanceMonitorAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.sama.E_Commerce.controller.ProductController.*(..))")
    public Object monitorMethodTime(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info("Method called: " + jp.getSignature().getName());
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken by method execution: " + (end-start) + "ms");
        return obj;
    }
}
