package reflect;

import pojo.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author MaZhuli
 * @description 反射
 * @date 2019/6/18
 */
public class Reflection {
    public static void main(String[] args) {
        People p = new People("aa", 4, 5);
        Class people = People.class;
        Constructor[] constructors = people.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            String name = constructor.getName();
            Class[] parameterTypes = constructor.getParameterTypes();
            Parameter[] parameters = constructor.getParameters();
            System.out.println(i);
        }
        Method[] methods = people.getMethods();
        for (int i = 0; i < constructors.length; i++) {
            Method method = methods[i];
            int parameterCount = method.getParameterCount();
            Parameter[] parameters = method.getParameters();
            for (int k = 0; k < parameters.length; k++) {
                Parameter parameter = parameters[k];
                String name = parameter.getName();
                Class<?> type = parameter.getType();
                String simpleName = type.getSimpleName();
                String typeName = type.getTypeName();
                System.out.println(k);
            }
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            System.out.println(i);
        }
        //暴力
        Field[] fields = people.getDeclaredFields();
        for (int i = 0; i < constructors.length; i++) {
            Field field = fields[i];
            try {
                //暴力
                field.setAccessible(true);
                Object o = field.get(p);
                System.out.println(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String name = field.getName();
            AnnotatedType annotatedType = field.getAnnotatedType();
            Class<?> declaringClass = field.getDeclaringClass();
            System.out.println(i);
        }
    }
}
