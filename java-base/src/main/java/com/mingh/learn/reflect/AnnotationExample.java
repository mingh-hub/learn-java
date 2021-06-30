package com.mingh.learn.reflect;

import com.mingh.learn.reflect.annotation.LogString;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @ClassName AnnotationExample
 * @Author Hai.Ming
 * @Date 2021/6/15 00:42
 * @Description java.lang.annotation.Annotation JDK 1.5
 *                      1. 如何声明一个注解?
 *                          1.1 访问修饰符为 public, 不写也默认为 public
 *                          1.2 示例: com.mingh.learn.reflect.annotation.LogString
 *                      2. 元注解
 *                          2.1 @Target  表明该注解可以应用的 java 元素类型, 可声明多个
 *                              a ElementType.TYPE: 应用于类、接口（包括注解类型）、枚举
 *                              b ElementType.FIELD: 应用于属性（包括枚举中的常量）
 *                              c ElementType.METHOD: 应用于方法
 *                              d ElementType.PARAMETER: 应用于方法的形参
 *                              e ElementType.CONSTRUCTOR: 应用于构造函数
 *                          2.2 @Retention  表明该注解的生命周期
 *                              a RetentionPolicy.SOURCE: 不包含在类文件中, 编译时被丢弃
 *                              b RetentionPolicy.CLASS: 默认值, 包含在类文件中, JVM 加载时被丢弃
 *                              c RetentionPolicy.RUNTIME: 包含在类文件中, 由 JVM 加载, 在运行时可以被获取到
 *                          2.3 @Document  表明该注解标记的元素可以被 Javadoc 或类似的工具文档化
 *                          2.4 @Inherited  表明使用了@Inherited 的注解, 所标记的类的子类也会拥有这个注解
 */
@Slf4j
public class AnnotationExample {

    public static void main(String[] args) {
        try {
            // 加载类
            Class<?> clazz = Class.forName("com.mingh.learn.reflect.bean.Person");
            // 处理类上注解
            disposeClassAnnotation(clazz);
            // 处理方法上的注解
            disposeMethodAnnotation(clazz);
        } catch (Exception e) {
            log.error("执行异常: ", e);
        }
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 18:13
     * @Description 处理方法上的注解
     **/
    private static void disposeMethodAnnotation(Class<?> clazz) {
        log.info("处理方法上的注解");
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).filter(m -> m.isAnnotationPresent(LogString.class)).forEach(AnnotationExample::disposeMethod);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 17:36
     * @Description 处理类上的注解
     **/
    private static void disposeClassAnnotation(Class<?> clazz) {
        // 判断类上有没有加对应注解注解
        if (!clazz.isAnnotationPresent(LogString.class)) {
            log.info("当前类上没有加注解");
            return;
        }
        // 如果类上有注解, 需要给类中的每个方法加注解
        // Spring AOP 可以配置切入点表达式, 可以配置哪个访问修饰符类型的方法会被切到
        System.out.println("处理 public 类型且非静态的方法加注解");
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length == 0) {
            log.info("当前类中没有方法, 无需处理");
            return;
        }
        Arrays.stream(methods).filter(AnnotationExample::isPublicAndNonstatic).forEach(AnnotationExample::disposeMethod);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 18:00
     * @Description 处理方法的出入参
     **/
    private static void disposeMethod(Method method) {
        log.info("方法: {}() do something", method.getName());
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/15 17:46
     * @Description 判断是否为公共且非静态方法, 且方法上没有注解
     **/
    private static boolean isPublicAndNonstatic(Method method) {
        return Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.isAnnotationPresent(LogString.class);
    }
}
