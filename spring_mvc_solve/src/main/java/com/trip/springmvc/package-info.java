/**
 * 官方文档
 * https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/web.html#mvc
 *
 * springMVC子容器
 * 1.
 * 2.org.springframework.web.servlet.HttpServletBean#init() 刷新子容器即springMVC的容器
 *
 *
 * spring父容器
 * 1.org.springframework.web.context.AbstractContextLoaderInitializer#registerContextLoaderListener(javax.servlet.ServletContext) 获取父容器配置，将父容器保持在listener里面
 * 2.ContextLoaderListener 在spring初始化之后会调用
 *
 *
 * @3661 super里面创建父容器，子类提供配置类；ContextLoaderListener 保存了这个容器
 *
 * @3779 当前类创建，子类提供配置类  ；DispatcherServlet 保存了这个容器
 *
 *
 * org.springframework.web.servlet.handler.AbstractHandlerMethodMapping#afterPropertiesSet()
 * 在这里进行bean的映射
 *
 *
 * org.springframework.web.servlet.FrameworkServlet#configureAndRefreshWebApplicationContext(org.springframework.web.context.ConfigurableWebApplicationContext)
 * 这里新增了监听器
 *
 *
 * org.springframework.web.servlet.HandlerMapping=
 *  org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,\
 * 	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping,\
 * 	org.springframework.web.servlet.function.support.RouterFunctionMapping
 *
 *
 * org.springframework.web.servlet.HandlerAdapter=
 *  org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter,\
 * 	org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter,\
 * 	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter,\
 * 	org.springframework.web.servlet.function.support.HandlerFunctionAdapter
 * 	DispatcherServlet.properties
 */

package com.trip.springmvc;