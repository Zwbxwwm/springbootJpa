package com.example.girl.Handle;


import com.example.girl.common.ResponseCode;
import com.example.girl.common.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ExceptionHandle {


    private final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ServerResponse HandleException(Exception e){
        logger.info("【自定义异常】{}",e.toString());
        return ServerResponse.error(ResponseCode.ILLEGAL_ARGUMENT.getCode(),e.getMessage());
    }
}
