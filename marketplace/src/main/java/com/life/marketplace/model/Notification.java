package com.life.marketplace.model;


public class Notification {

  private String id;
  private String recipient;
  private String read;
  private String message;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }


  public String getRead() {
    return read;
  }

  public void setRead(String read) {
    this.read = read;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
