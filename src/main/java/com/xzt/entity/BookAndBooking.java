package com.xzt.entity;

import java.sql.Date;

/**
 * 包含图书和预约记录
 * @Author PengBo
 * @CreateTime 2019/4/20 19:36
 * @Version 1.0.0
 */
public class BookAndBooking {
    private long bookId;
    private String name;

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    private String author;
    private String userId;
    private String publish;
    private java.sql.Date bookingTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getBookingDeadline() {
        return bookingDeadline;
    }

    public void setBookingDeadline(Date bookingDeadline) {
        this.bookingDeadline = bookingDeadline;
    }

    private java.sql.Date bookingDeadline;

}
