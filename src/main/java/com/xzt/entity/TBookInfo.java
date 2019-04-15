package com.xzt.entity;


public class TBookInfo {

  private long seqNum;
  private long bookId;
  private String name;
  private String author;
  private String publish;
  private String introduction;
  private String language;
  private double price;
  private java.sql.Date pubdate;


  public long getSeqNum() {
    return seqNum;
  }

  public void setSeqNum(long seqNum) {
    this.seqNum = seqNum;
  }


  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getPublish() {
    return publish;
  }

  public void setPublish(String publish) {
    this.publish = publish;
  }


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public java.sql.Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(java.sql.Date pubdate) {
    this.pubdate = pubdate;
  }

}
