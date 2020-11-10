package com.comit.advice;

import com.comit.execption.ProductNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductNotFoundExecption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String preschoolNotFoundHandler(ProductNotFoundExecption ex) {
        return ex.getMessage();
    }
}
