package com.example.lichao.wechat.bean;

public class MessageList {
    private String nick;
    private String msg;
    private String date;
    private int img;
    private String uid;

    public MessageList(String nick, String msg, String date, int img, String uid) {
        this.nick = nick;
        this.msg = msg;
        this.date = date;
        this.img = img;
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }

    public int getImg() {
        return img;
    }

    public String getUid() {
        return uid;
    }
}
