package com.example.administrator.daihuobangv10.Dao;

/**
 * Created by wsj on 16/7/8.
 */
public class User {
    public static String id;
    public static String username;
    public static String password;
    public static String phoneNum;
    public static String idcardNum;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setPhoneNum (String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setIdcardNum (String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getIdcardNum() {
        return idcardNum;
    }
}
