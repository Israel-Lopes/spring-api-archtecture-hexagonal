package com.hexagonal.architecture.app.core.exception;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }

}
