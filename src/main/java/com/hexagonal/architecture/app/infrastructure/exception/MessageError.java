package com.hexagonal.architecture.app.infrastructure.exception;

public class MessageError {
  private String message;
  public MessageError(String message) {
    this.message = message;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
}