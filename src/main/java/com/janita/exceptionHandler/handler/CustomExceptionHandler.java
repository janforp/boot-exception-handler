package com.janita.exceptionHandler.handler;

import com.janita.exceptionHandler.common.ErrorInfo;
import com.janita.exceptionHandler.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常处理类
 * 针对不同的异常自定义不同的方法
 * 环绕通知
 * 切面:针对所有的controller中抛出的异常
 * 若使用@ControllerAdvice,则不会自动转换为JSON格式
 */
@RestControllerAdvice
public class CustomExceptionHandler {

	/**
	 * 只要抛出该类型异常,则由此方法处理
	 * 并由此方法响应出异常状态码及消息
	 * 如:RoleController.getRoleById(String id)方法
	 * //TODO 为什么要手动在此方法处抛出异常呢?
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorInfo> handleNotFound(HttpServletRequest request, NotFoundException e) throws Exception {
		
		ErrorInfo body = new ErrorInfo();
		body.setCode(HttpStatus.NOT_FOUND.toString());
		body.setMessage(e.getMessage());

		//可以根据公司情况不同，类似的异常可能需要不同的状态码
		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<ErrorInfo>(body, HttpStatus.NOT_FOUND); 
		return responseEntity;
	}
}
