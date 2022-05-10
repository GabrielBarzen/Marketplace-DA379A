package com.life.marketplace.model;


public class Notifications {

  private String id;
  private String recipient;
  private String read;
  private String message;
  private java.sql.Date date;


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


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

}
