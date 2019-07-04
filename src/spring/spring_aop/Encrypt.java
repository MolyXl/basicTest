package spring.spring_aop;

import java.lang.annotation.*;

/**
 * @author MaZhuli
 * @description 注解
 * @date 2019/7/4
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) //注解会被保留到那个阶段(source,源码,不编译,class,编译,不运行,runtime,jvm运行时),
@Documented // 注解表明这个注解应该被 javadoc工具记录.
public @interface Encrypt {

}
