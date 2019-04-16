package com.xzt.entity;


public class TLendBook {

  private long seqNum;
  private String userId;
  private long bookId;
  private java.sql.Date lendTime;
  private long isReturn;


  public long getSeqNum() {
    return seqNum;
  }

  public void setSeqNum(long seqNum) {
    this.seqNum = seqNum;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }


  public java.sql.Date getLendTime() {
    return lendTime;
  }

  public void setLendTime(java.sql.Date lendTime) {
    this.lendTime = lendTime;
  }


  public long getIsReturn() {
    return isReturn;
  }

  public void setIsReturn(long isReturn) {
    this.isReturn = isReturn;
  }

}
