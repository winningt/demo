package com.example.demo.com.example.demo.config;

/**
 * Created by lizehua035 on 18-6-12.
 */

import com.example.demo.GavaDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class GuavaAspect {
    private Logger logger= LoggerFactory.getLogger(GuavaAspect.class);
    @Autowired
    private GavaDao gavaDao;

    @Pointcut("@annotation(com.example.demo.com.example.demo.config.GuavaCache)")
    public void around(){

    }

    @Around("around()")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint ) {
        logger.info("缓存调用开始:");

        String applId = null;
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0) {
            applId = String.valueOf(args[0]);
        }
        logger.info("缓存调用开始:"+applId);
        int i=Integer.parseInt(applId);
        List<String> list = gavaDao.getPOIList(i);
        if(list==null||list.size()<=0){
        try {
            logger.info("方法调用开始:");
            Object object = proceedingJoinPoint.proceed();
            return object;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        }
        logger.info("缓存调用结束:");
        return list;
    }}
