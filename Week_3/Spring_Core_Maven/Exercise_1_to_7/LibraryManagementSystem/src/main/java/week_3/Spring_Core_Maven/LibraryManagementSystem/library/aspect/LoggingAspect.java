package week_3.Spring_Core_Maven.LibraryManagementSystem.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Executed " + joinPoint.getSignature() + " in " + duration + " ms");
        return result;
    }
}
