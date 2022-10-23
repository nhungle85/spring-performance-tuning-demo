package com.nle.spring.performance.monitor.client.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class PerformanceMonitorConfiguration {
	/* Please view lesson 02_04 for a detailed explanation of the below code */

    public PerformanceMonitorInterceptor invocationInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public String com.nle.spring.performance.monitor.client.controller.DemoController.*(..))")
    public void monitor() { }

    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.nle.spring.performance.monitor.client.aop.PerformanceMonitorConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, invocationInterceptor());
    }

    public CustomPerformanceMonitorInterceptor customInterceptor() {
        return new CustomPerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public String com.nle.spring.performance.monitor.client.domain.CpuLoader.expensiveCalculation(..))")
    public void customMonitor() { }

    public Advisor customPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.nle.spring.performance.monitor.client.aop.PerformanceMonitorConfiguration.customMonitor()");
        return new DefaultPointcutAdvisor(pointcut, customInterceptor());
    }

}
