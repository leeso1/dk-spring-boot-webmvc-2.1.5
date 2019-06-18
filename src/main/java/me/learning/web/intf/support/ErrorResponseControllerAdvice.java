package me.learning.web.intf.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import me.learning.domain.service.ResourceNotFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorResponseControllerAdvice {
  
  @Autowired
  MessageSource messageSource;
  
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<?> handleException(Throwable ex, HttpServletRequest req, HttpServletResponse res) {
    // ErrorCode Mapping
    EmployeeErrorCode code = exceptionMapping(ex);
    
    // ErrorResponse 정의
    ErrorResponse error = ErrorResponse.builder()
        .status(code.getStatus().value())
        .code(code.getCode())
        .message("from messageSources") // TODO message resolver 필요
        .build();
    
    log.warn("error={}", error);
    
    return ResponseEntity
        .status(code.getStatus())
        .body(Maps.immutableEntry("error", error));
  }

  private EmployeeErrorCode exceptionMapping(Throwable ex) {
    if (ex instanceof ResourceNotFoundException)
      return EmployeeErrorCode.EMPLOYEE_NOT_FOUND;
    
    return EmployeeErrorCode.UKNOWN_SEVER_ERROR;
  }

}
