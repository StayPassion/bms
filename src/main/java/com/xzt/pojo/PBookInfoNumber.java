package com.xzt.pojo;

import com.xzt.entity.TBookInfo;
import com.xzt.entity.TBookNumber;

public class PBookInfoNumber {
    private TBookInfo tBookInfo;
    private TBookNumber tBookNumber;

    public TBookInfo getBookInfo() {
        return tBookInfo;
    }

    public TBookNumber getBookNumber() {
        return tBookNumber;
    }

    public void setBookInfo(TBookInfo tBookInfo) {
        this.tBookInfo = tBookInfo;
    }

    public void setBookNumber(TBookNumber tBookNumber) {
        this.tBookNumber = tBookNumber;
    }
}
