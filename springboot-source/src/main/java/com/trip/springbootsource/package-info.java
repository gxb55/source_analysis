/**
 * @author xbguo
 * @createTime 2023年02月12日 12:35:00
 * @SpringBootApplication
 *  @SpringBootConfiguration
 *  @EnableAutoConfiguration
 *
 *  @Import(AutoConfigurationPackages.Registrar.class)
 *  容器中导入BasePackagesBeanDefinition 这个类的package里面保存了根路径
 *
 *  @Import(AutoConfigurationImportSelector.class)
 *      AutoConfigurationGroup
 *
 *
 * DispatcherServletAutoConfiguration
 *
 *
 * ServletWebServerApplicationContext
 * web类型的上下文，在onRefresh() 方法中创建web容器
 * ConditionalOnClass 类的注解如何生效
 *
 * 问题
 * 1.@Import 注解解析
 * 2.
 */
package com.trip.springbootsource;