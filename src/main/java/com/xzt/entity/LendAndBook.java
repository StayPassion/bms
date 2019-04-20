package com.xzt.entity;

import java.sql.Date;

/**
 * @Author PengBo
 * @CreateTime 2019/4/20 20:00
 * @Version 1.0.0
 */
public class LendAndBook {
    private long seqNum;
    private String userId;
    private long bookId;
    private java.sql.Date lendTime;
    private long isReturn;
    private String name;
    private String author;
    private String language;

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

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public long getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(long isReturn) {
        this.isReturn = isReturn;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
