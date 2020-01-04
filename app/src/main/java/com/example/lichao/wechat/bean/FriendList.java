package com.example.lichao.wechat.bean;

public class FriendList {
    private String nick;
    private int img;
    private String uid;

    public FriendList(String nick, int img, String uid) {
        this.nick = nick;
        this.img = img;
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public int getImg() {
        return img;
    }

    public String getUid() {
        return uid;
    }
}
