package com.hexagonal.architecture.app.core.exception;

public class DuplicatedException extends BusinessException {
  public DuplicatedException(String message) {
    super(message);
  }
}
