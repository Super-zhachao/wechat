package com.example.lichao.wechat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lichao.wechat.ChatActivity;
import com.example.lichao.wechat.R;
import com.example.lichao.wechat.adapter.FriendListAdapter;
import com.example.lichao.wechat.bean.FriendList;

import java.util.ArrayList;


public class FrinedsFragment extends Fragment implements AdapterView.OnItemClickListener {


    ArrayList<FriendList> lists = new ArrayList<FriendList>();
    View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        contentView = inflater.inflate(R.layout.fragment_frineds, container, false);
        return contentView;
    }

    @Override
    public void onStart() {
        //        获取消息
        getMessageList();
        //得到listView
        ListView listView = (ListView) contentView.findViewById(R.id.friend_list);
        //第一个参数表示上下文，第二个表示要显示的布局id，第三个表示传入的参数
        FriendListAdapter listViewAdapter = new FriendListAdapter(getActivity(), R.layout.friend_list_layout, lists);
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
        int resID3 = getResources().getIdentifier("tx3", "drawable", "com.example.lichao.wechat");
        int resID4 = getResources().getIdentifier("tx4", "drawable", "com.example.lichao.wechat");
        int resID5 = getResources().getIdentifier("tx5", "drawable", "com.example.lichao.wechat");
        FriendList list1 = new FriendList("执酒高歌语", resID0, "1258");
        FriendList list2 = new FriendList("梧桐碎梦", resID1, "1258");
        FriendList list3 = new FriendList("Debug.", resID2, "1258");
        FriendList list4 = new FriendList("淡若如初", resID3, "1258");
        FriendList list5 = new FriendList("文.", resID4, "1258");
        FriendList list6 = new FriendList("WTF", resID5, "1258");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        lists.add(list6);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        startActivity(intent);
    }
}
