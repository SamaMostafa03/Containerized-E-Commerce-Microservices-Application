package com.sama.E_Commerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sama.E_Commerce.controller.ProductController.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }


    @After("execution(* com.sama.E_Commerce.controller.ProductController.*(..))")
    public void logMethodExecution(JoinPoint jp){
        LOGGER.info("Method Executed: " + jp.getSignature().getName());
    }


    @AfterThrowing("execution(* com.sama.E_Commerce.controller.ProductController.deleteProduct*(..)) || execution(* com.sama..E_Commerce.controller.updateProduct*(..))")
    public void logMethodError(JoinPoint jp){
        LOGGER.info("Method has error: " + jp.getSignature().getName());
    }


    @AfterReturning("execution(* com.sama.E_Commerce.controller.ProductController.*(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method succeeded: " + jp.getSignature().getName());
    }


}
