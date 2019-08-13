package com.spring.springboot.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	private Map<String, Object> exceptionHandler(HttpServletRequest req,Exception e){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		modeMap.put("success", false);
		modeMap.put("errMsg", e.getMessage());
		return modeMap;
	}
}
