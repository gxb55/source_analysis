package com.trip.springmvc;

import com.trip.springmvc.config.SpringConfig;
import com.trip.springmvc.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xbguo
 * @createTime 2023年02月08日 21:51:00
 */
public class QuickAppStarter extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取spring的配置类 构建上下文
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 获取springMVC的配置类构建context
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
