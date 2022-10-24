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

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class PerformanceMonitorConfiguration {
	/* Please view lesson 02_04 for a detailed explanation of the below code */

	@Bean
    public PerformanceMonitorInterceptor invocationInterceptor() {
		log.info("*** invocationInterceptor init");
        return new PerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public * com.nle.spring.performance.monitor.client.controller.DemoController.*(..))")
    public void monitor() { 
    	log.info("*** PerformanceMonitorConfiguration monitor");
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.nle.spring.performance.monitor.client.aop.PerformanceMonitorConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, invocationInterceptor());
    }

    @Bean
    public CustomPerformanceMonitorInterceptor customInterceptor() {
    	log.info("*** CustomPerformanceMonitorInterceptor init");
    	
        return new CustomPerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public * com.nle.spring.performance.monitor.client.domain.CpuLoader.expensiveCalculation(..))")
    public void customMonitor() {
    	log.info("*** bind to expensiveCalculation");
    }

    @Bean
    public Advisor customPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.nle.spring.performance.monitor.client.aop.PerformanceMonitorConfiguration.customMonitor()");
        return new DefaultPointcutAdvisor(pointcut, customInterceptor());
    }

}
