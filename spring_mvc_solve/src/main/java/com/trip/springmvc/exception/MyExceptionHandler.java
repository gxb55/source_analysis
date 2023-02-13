package com.trip.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xbguo
 * @createTime 2023年02月11日 16:55:00
 * {@link <a href="https://docs.spring.io/spring-framework/docs/5.3.25/reference/html/web.html#mvc-ann-exceptionhandler">...</a>}
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public String handlerZeroException(Exception e) {

        return "error.jsp";
    }
}
