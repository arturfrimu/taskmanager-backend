package com.stefanini.taskmanager.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private Logger logger = Logger.getLogger(this.getClass());

    @Before("execution(* com.stefanini.taskmanager.dao.impl.*.*(..)) || execution(* com.stefanini.taskmanager.controllers.*.*(..))"
            + " || execution(* com.stefanini.taskmanager.service.*.*(..))")
    public void logBeforeDAOMethods(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("Now running: " + method + " method from class: " + signature.getDeclaringTypeName());
    }

    @AfterThrowing(pointcut = "execution(* com.stefanini.taskmanager.dao.impl.*.*(..)) || execution(* com.stefanini.taskmanager.service.impl.*.*(..))"
            + " || execution(* com.stefanini.taskmanager.controllers.*.*(..))", throwing = "ex")
    public void logDAOAndJWTTokenMethodsException(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        logger.error("Exception in method: " + method + " from class: " + signature.getDeclaringTypeName() + " with arguments:" + arguments + "\nException: " + ex.getCause());
    }
}