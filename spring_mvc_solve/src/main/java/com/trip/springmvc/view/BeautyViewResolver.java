package com.trip.springmvc.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author xbguo
 * @createTime 2023年02月11日 15:51:00
 * 如果他打开会覆盖默认的视图解析器，没法加载默认的，导致功能缺失
 */
//@Component
public class BeautyViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("beauty:")) {
            return new BeautyView();
        }
        return null;
    }
}
