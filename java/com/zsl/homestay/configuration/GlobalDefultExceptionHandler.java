package com.zsl.homestay.configuration;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zsl.homestay.commen.Result;
import com.zsl.homestay.commen.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalDefultExceptionHandler {

	@ExceptionHandler(MyException.class)
	public Result handlerSellerException(MyException e) {
		return ResultUtil.fail(e.getCode(), e.getMessage());
	}

	/**
	 * 主动throw的异常
	 *
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result handleUnProccessableServiceException(Exception e, HttpServletResponse response) {
		response.setStatus(Response.SC_INTERNAL_SERVER_ERROR);
		log.error("exception :{}", e);
		return ResultUtil.fail(Response.SC_INTERNAL_SERVER_ERROR, "操作失败");
	}

}
