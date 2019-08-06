package com.nanfeng.annotation;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-23 21:31
 */

/**
 * JDK 提供的常用注解
 *  @Override：限定重写父类方法
 * @Deprecated：用于表示程序元素（类，方法等）已经过时
 * @SuppressWranings:抑制编译器警告
 * 2.如何自定义注解
 * 3元注解
 * @Retention 指定Annotation可以保留多长时间
 * （SOURCE 编辑器直接丢弃这种策略的注解，CLASS 编译时保留，加载时不保留，RUNTIME 运行时也保留）
 * @Target 用于指定可以修饰哪些类型
 * @Documented 被修饰的Annotation被javadoc工具提取成JAVA文档
 * @Inherited 被它修饰的Annotation具有继承性，（其子类也具有该注解）
 */
public class TestAnnotation {

}

 @interface MyAnnotation{
    String value() default "hello";
}