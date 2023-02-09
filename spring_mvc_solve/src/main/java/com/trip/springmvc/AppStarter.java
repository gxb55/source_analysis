package com.trip.springmvc;

import com.trip.springmvc.config.SpringConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author xbguo
 * @createTime 2023年02月07日 21:46:00
 */
public class AppStarter  {
    //implements WebApplicationInitializer

    public void onStartup(ServletContext servletContext) throws ServletException {
        // spring的上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        // servlet servlet会初始化，初始化的时候会init，在init里面会初始化spring的容器，加载spring对应的bean
        DispatcherServlet servlet = new DispatcherServlet(context);
        // 这里初始化
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
