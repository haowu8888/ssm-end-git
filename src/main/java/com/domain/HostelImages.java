package com.domain;

import java.io.Serializable;

/**
 * 客房图片类
 */
public class HostelImages implements Serializable {
    private int id;
    private int hid;
    private String smallPic;
    private String bigPic;

    @Override
    public String toString() {
        return "HostelImages{" +
                "id=" + id +
                ", hid=" + hid +
                ", smallPic='" + smallPic + '\'' +
                ", bigPic='" + bigPic + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }
}
