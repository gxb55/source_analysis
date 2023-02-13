package com.trip.springmvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 美女
 * @author xbguo
 * @createTime 2023年02月11日 15:43:00
 * 自定义 视图渲染器 渲染视图
 */
public class BeautyView implements View {
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<h1>"+request.getParameter("name")+"</h1>");
        stringBuffer.append("<h2>"+model.get("姓名")+"</h2>");
        String str="<img log-rightclick=\"p=5.102\" style=\"width: 448.851px; left: 256px; top: 0px; height: 586px; cursor: pointer;\" title=\"点击查看图片来源\" src=\"https://img2.baidu.com/it/u=3811908258,705588351&amp;fm=253&amp;fmt=auto&amp;app=138&amp;f=JPEG?w=500&amp;h=653\">";
        stringBuffer.append(str);
        response.getWriter().write(stringBuffer.toString());
    }
}
