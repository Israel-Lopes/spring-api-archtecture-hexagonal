package com.hexagonal.architecture.app.core.exception;

public class CreditCardInvalidException extends BusinessException {

  public CreditCardInvalidException(String message) {
    super(message);
  }
}