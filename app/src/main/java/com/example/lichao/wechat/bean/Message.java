package com.example.lichao.wechat.bean;

import android.graphics.Bitmap;

public class Message {
    private int type;
    private String content;
    private int icon;

    public Message() {
    }

    public Message(int type, String content, int icon) {
        this.type = type;
        this.content = content;
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

