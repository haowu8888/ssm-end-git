package com.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 账户
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private double  money;

    //日期格式化注解
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
