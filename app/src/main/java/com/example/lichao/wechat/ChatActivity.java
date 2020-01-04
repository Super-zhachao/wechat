package com.example.lichao.wechat;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lichao.wechat.adapter.MessageAdapter;
import com.example.lichao.wechat.bean.Message;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ArrayList<Message> msgList;
    private MessageAdapter mAdapter;
    EditText chatEditView;
    ListView chatListView;
    int imgSelf;
    int imgReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatListView = (ListView) findViewById(R.id.listView);
        chatEditView = (EditText) findViewById(R.id.input);
        msgList = new ArrayList<>();
        mAdapter = new MessageAdapter(msgList, ChatActivity.this);
        chatListView.setAdapter(mAdapter);
        //        点击发送
        Button sub = (Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                send(v);
            }
        });
//        点击返回
        ImageView back_btn = (ImageView) findViewById(R.id.back);
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ChatActivity.this.finish();
            }
        });
        //内容装载
        imgSelf = getResources().getIdentifier("self", "drawable", "com.example.lichao.wechat");
        imgReceiver = getResources().getIdentifier("tx2", "drawable", "com.example.lichao.wechat");
        initMessage();
    }

    //    消息发送
    public void send(View v) {
        String content = chatEditView.getText().toString();
        if (!"".equals(content)) {
            Message message = new Message(1, content, imgSelf);
            msgList.add(message);
            mAdapter.notifyDataSetChanged();
            chatListView.setSelection(msgList.size());
            chatEditView.setText("");
        }
    }

    private void initMessage() {
        msgList.clear();

        Message message1 = new Message(0, "纪锋是我的男神", imgReceiver);
        msgList.add(message1);
        Message message2 = new Message(1, "WTF！他竟然是你男神！！？？？", imgSelf);
        msgList.add(message2);
        Message message3 = new Message(0, "嗯嗯！！", imgReceiver);
        msgList.add(message3);
        Message message4 = new Message(1, "到底他的哪一点魅力吸引到你了？让你认他为男神？", imgSelf);
        msgList.add(message4);
        Message message5 = new Message(0, "我错了。。。", imgReceiver);
        msgList.add(message5);

    }

}
