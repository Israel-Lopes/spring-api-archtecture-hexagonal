package com.hexagonal.architecture.app.core.exception;

public class InsufficientProductStockException extends BusinessException {

  public InsufficientProductStockException(long code) {
    super("Product " + code
        + " does not have enough stock to subtract.");
  }
}