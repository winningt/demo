package com.example.demo.com.example.demo.aop.test;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.lang.reflect.Method;

/**
 * Created by lizehua035 on 18-6-19.
 */
public class Client {

    public static void main(String[] args) {
        //pointcut 定义， 匹配方式可以按上面的说明修改，  这里是注解类的所有方法都匹配
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);

        // advice 定义， 根据前面的介绍知道 这个是 横切逻辑的定义， 这里是 方法执行前插入横切逻辑
        BeforeAdvice advice = new MethodBeforeAdvice() {
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println(target.getClass().getSimpleName() + ":" + method.getName() + " - before logic ");
            }
        };

        // Spring 中的 Aspect ， pointcut 和 advice 的封装类
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);

        // Spring 基本织入器 weaving 和 weaver
        ProxyFactory weaver = new ProxyFactory();
        weaver.setTarget(new TargetObject());   //指定代理目标对象
        weaver.addAdvisor(advisor);             //指定 Aspect

        Object proxyObject = weaver.getProxy(); //生成代理对象 （这里没接口， Spring 使用 CGLIB 创建子类）

        ((TargetObject) proxyObject).method1();
        ((TargetObject) proxyObject).method2();
    }
}