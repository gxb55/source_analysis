package com.trip.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xbguo
 * @createTime 2023年02月11日 16:43:00
 */
@ResponseStatus(value = HttpStatus.CONFLICT,reason = "非法用户")
public class InvalidUserException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766123L;
}
