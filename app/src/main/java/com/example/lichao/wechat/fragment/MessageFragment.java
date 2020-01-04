package com.example.lichao.wechat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lichao.wechat.ChatActivity;
import com.example.lichao.wechat.R;
import com.example.lichao.wechat.adapter.MessageListAdapter;
import com.example.lichao.wechat.bean.MessageList;

import java.util.ArrayList;


public class MessageFragment extends Fragment implements AdapterView.OnItemClickListener {
    ArrayList<MessageList> lists = new ArrayList<MessageList>();
    View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        contentView = inflater.inflate(R.layout.fragment_message, container, false);
        return contentView;
    }

    @Override
    public void onStart() {
        //        获取消息
        getMessageList();
        //得到listView
        ListView listView = (ListView) contentView.findViewById(R.id.message_list);
        //第一个参数表示上下文，第二个表示要显示的布局id，第三个表示传入的参数
        MessageListAdapter listViewAdapter = new MessageListAdapter(getActivity(), R.layout.message_list_layout, lists);
        //将item_activity.xml中的布局导入ListView中
        //先清空以前的数据
        listView.removeAllViewsInLayout();
        listView.setAdapter(listViewAdapter);
        //监听点击
        listView.setOnItemClickListener(this);
        super.onStart();
    }

    //获取消息列表

    public void getMessageList() {
        lists.clear();
        int resID0 = getResources().getIdentifier("tx0", "drawable", "com.example.lichao.wechat");
        int resID1 = getResources().getIdentifier("tx1", "drawable", "com.example.lichao.wechat");
        int resID2 = getResources().getIdentifier("tx2", "drawable", "com.example.lichao.wechat");
        MessageList list1 = new MessageList("执酒高歌语", "关于山东省第一次人工智能大赛的有关情况说明，请各位同学仔细阅读！！！", "22:00", resID0, "1258");
        MessageList list2 = new MessageList("梧桐碎梦", "王者荣耀来不来？", "19:20", resID1, "1258");
        MessageList list3 = new MessageList("文.", "下午帮我带课本啊！", "12:21", resID2, "1258");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        startActivity(intent);
    }
}
