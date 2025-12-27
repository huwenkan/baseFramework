package org.vectorcontroller.baseframework.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.vectorcontroller.baseframework.exeception.BusinessException;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;

import java.util.logging.Logger;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    // 处理所有的运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseResultVO handleRuntimeException(RuntimeException e) {
        logger.warning("运行时异常：" + e.getMessage());
        return ResponseResultVO.error(500, "服务器内部错误");
    }

    // 处理自定义的业务异常
    @ExceptionHandler(BusinessException.class)
    public ResponseResultVO handleBusinessException(BusinessException e) {
        logger.warning("业务异常：" + e.getMessage());
        return ResponseResultVO.error(e.getErrorCode(), e.getMessage());
    }

    // 处理其他异常
    @ExceptionHandler(Exception.class)
    public ResponseResultVO handleException(Exception e) {
        logger.warning("其他异常：" + e.getMessage());
        return ResponseResultVO.error(500, "服务器内部错误");
    }
}
