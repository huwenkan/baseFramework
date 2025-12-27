package org.vectorcontroller.baseframework.handler;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.vectorcontroller.baseframework.exeception.BusinessException;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 处理所有的运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseResultVO handleRuntimeException(RuntimeException e) {
        logger.error("运行时异常：{}", e.getMessage());
        return ResponseResultVO.error(500, "服务器内部错误");
    }

    // 处理自定义的业务异常
    @ExceptionHandler(BusinessException.class)
    public ResponseResultVO handleBusinessException(BusinessException e) {
        logger.error("业务异常：{}", e.getMessage());
        return ResponseResultVO.error(e.getErrorCode(), e.getMessage());
    }

    // 处理其他异常
    @ExceptionHandler(Exception.class)
    public ResponseResultVO handleException(Exception e) {
        logger.error("其他异常：{}", e.getMessage());
        return ResponseResultVO.error(500, "服务器内部错误");
    }
}
