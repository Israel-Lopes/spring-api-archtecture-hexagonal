package com.hexagonal.architecture.app.core.exception;

public class NotFoundException extends BusinessException {

  public NotFoundException(String message) {
    super(message);
  }

}