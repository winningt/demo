package com.example.demo.com.example.demo.aop.test;

/**
 * Created by lizehua035 on 18-6-19.
 */
@ClassLevelAnnotation
public class TargetObject {

    @MethodLevelAnnotation
    public void method1() {
        System.out.println("target : method1");
    }

    public void method2() {
        System.out.println("target : method2");
    }
}
