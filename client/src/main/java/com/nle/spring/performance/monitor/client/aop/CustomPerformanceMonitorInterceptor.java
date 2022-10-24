package com.nle.spring.performance.monitor.client.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {
	private static long warnCount = 0;
    private static long warnThreshold = 10;

    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
    	log.info("*** CustomPerformanceMonitorInterceptor init");
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logg) throws Throwable {
    	log.info("*** CustomPerformanceMonitorInterceptor invokeUnderTrace");
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        log.info("     Method " + name);
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            if (time > warnThreshold){
                log.warn("     Method execution longer than 10 ms!");
                log.info("     Custom warnings count: " + ++warnCount);
            }
        }
    }
}
