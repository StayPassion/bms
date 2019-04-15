package com.xzt.entity;


public class TBookingRecornd {

  private long seqNum;
  private long userId;
  private long bookId;
  private java.sql.Date bookingTime;
  private java.sql.Date bookingDeadline;


  public long getSeqNum() {
    return seqNum;
  }

  public void setSeqNum(long seqNum) {
    this.seqNum = seqNum;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }


  public java.sql.Date getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(java.sql.Date bookingTime) {
    this.bookingTime = bookingTime;
  }


  public java.sql.Date getBookingDeadline() {
    return bookingDeadline;
  }

  public void setBookingDeadline(java.sql.Date bookingDeadline) {
    this.bookingDeadline = bookingDeadline;
  }

}
