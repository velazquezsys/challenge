package com.gbm.challenge.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 22:43
 * @email <velazquez.sys at gmail.com>
 */

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.gbm.challenge..*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        logger.debug(">>> method invocation: \"{}\" args: \"{}\"", joinPoint.getSignature(), joinPoint.getArgs());
    }


    @AfterReturning(pointcut = "execution(* com.gbm.challenge..*(..))", returning = "object")
    public void logAfterReturning(JoinPoint joinPoint, Object object) {
        logger.debug(">>> end method invocation \"{}\", return value \"{}\"", joinPoint.getSignature(), object == null ? null : object.toString());
    }
}
