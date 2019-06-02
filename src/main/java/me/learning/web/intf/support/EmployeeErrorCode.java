package me.learning.web.intf.support;


import org.springframework.http.HttpStatus;

public enum EmployeeErrorCode {

  EMPLOYEE_NOT_FOUND("E0001", HttpStatus.NOT_FOUND),
  
  EMPLOYEE_ALREADY_EXITS("E0002", HttpStatus.CONFLICT),
  
  UKNOWN_SEVER_ERROR("00000", HttpStatus.INTERNAL_SERVER_ERROR);
  
  
  private final String code;
  private final HttpStatus status;
  
  private EmployeeErrorCode(String code, HttpStatus status) {
    this.code = code;
    this.status = status;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public HttpStatus getStatus() {
    return this.status;
  }
}
