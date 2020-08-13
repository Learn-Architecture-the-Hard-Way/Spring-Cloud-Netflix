package com.ttmo.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Aspect
@Component
public class LoggerAspect {

    @Value("${cluster-id}")
    private String clusterId;

    @Around("execution(* com.ttmo.springboot.controller.*.*(..))")
    Object around(ProceedingJoinPoint pjp) throws Throwable {
        String signature = pjp.getSignature().toString();
        Object[] args = pjp.getArgs();

        System.out.println("=".repeat(50));
        System.out.println("cluster-id: " + clusterId);
        System.out.println(signature);
        System.out.println("args: " + Arrays.toString(args));
        Object result = pjp.proceed(args);
        System.out.println("result: " + result);

        return result;
    }

}
