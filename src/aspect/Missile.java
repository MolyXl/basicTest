package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author MaZhuli
 * @description 导弹
 * @date 2019/7/5
 */
@Aspect
public class Missile {
    @Pointcut("@annotation(aspect.Radar)")
    public void ouAspect() {
    }

    @Before("ouAspect()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("方法前.......");
        System.out.println(joinPoint.getArgs()[0]);
    }

    @Around("strike()")
    public void strike(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截");
        joinPoint.proceed();
    }
}
