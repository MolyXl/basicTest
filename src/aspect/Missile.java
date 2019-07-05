package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author MaZhuli
 * @description 导弹
 * @date 2019/7/5
 */
@Aspect
public class Missile {
    @Pointcut("@annotation(aspect.Radar)")
    public void intercept() {
    }

    @Before("intercept()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("方法前.......");
        System.out.println(joinPoint.getArgs()[0]);
    }

    @Around("strike()")
    public Object strike(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截");
        return joinPoint.proceed();
    }


    //-------------------第一种方式：前置后置方法，有局限性，共用类变量会出现线程安全问题，用的不多-----------------
    //指定切入点表达式，拦截那些方法，即为那些类生成代理对象
//    @Pointcut("execution(* com.springboot.aop.aspect.UserService.*(..))")
//    public void pointCut() {
//    }
//    @Before("pointCut()")
//    public void begin() {
//        System.out.println("前置增强：log日志开始记录了------>");
//    }
//    @After("pointCut()")
//    public void close() {
//        System.out.println("后置增强：log日志完成记录了<------");
//    }

//-------------------第二种方式：环绕织入，最常见，开发中用的最多-----------------
    //@within(M)的匹配规则
    //@within(注解类型全限定名)匹配所有持有指定注解的类里面的方法, 即要把注解加在类上.
    // 在接口上声明不起作用,子孙类经测试匹配不到

    //@annotation(M)的匹配规则
    @Around(value = "@annotation(LogRecord) || @within(LogRecord)")
    public Object logRecord(ProceedingJoinPoint pjp) throws Throwable {

        //1.获取类上的注解
        Radar annoOnClass = (Radar) pjp.getSignature().getDeclaringType().getAnnotation(Radar.class);
        //获取注解的信息value数组，即自定义注解中的String[] value() default {};
        String[] megOnClass = null;
        if (annoOnClass != null && annoOnClass.value().length > 0) {
            megOnClass = annoOnClass.value();
        }
        //2.获取方法上定义的注解
        Method mth = ((MethodSignature) pjp.getSignature()).getMethod();
        Radar annoOnMehtod = mth.getAnnotation(Radar.class);
        String[] megOnMethod = null;
        if (annoOnMehtod != null && annoOnMehtod.value().length > 0) {
            megOnMethod = annoOnMehtod.value();
        }

        //得到类上的注解信息
        StringBuilder msg = new StringBuilder();
        if (null != megOnClass) {
            for (String onClass : megOnClass) {
                msg.append(onClass + "===》");
            }
        }
        //得到方法上的注解信息
        if (null != megOnMethod) {
            msg.append("：user的姓名是：" + megOnMethod[0] + ",年龄是" + megOnMethod[1]);
        }
        //相当于增强方法，和业务无关的代码(比如日志记录、权限校验)
        System.out.println("（业务无关代码:）log日志开始记录了====》" +"（获取的注解信息：）"+ msg.toString() + "");
        //执行目标对象的方法，即业务代码
        Object obj = pjp.proceed();
        //相当于增强方法，和业务无关的代码（比如日志记录、权限校验）
        System.out.println("（业务无关代码）log日志完成了记录《====" +"（获取的注解信息：）"+ msg.toString() + "");
        return obj;
    }

}
