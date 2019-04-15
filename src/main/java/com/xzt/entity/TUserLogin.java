package com.xzt.entity;


public class TUserLogin {

  private long seqNum;
  private String userId;
  private String userPassword;
  private long userPermission;


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


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public long getUserPermission() {
    return userPermission;
  }

  public void setUserPermission(long userPermission) {
    this.userPermission = userPermission;
  }

}
