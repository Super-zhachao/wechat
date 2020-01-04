package com.example.lichao.wechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lichao.wechat.R;
import com.example.lichao.wechat.bean.MessageList;
import com.example.lichao.wechat.util.ImageLoader;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter {
    private final int resourceId;
    public ImageLoader imageLoader; //用来下载图片的类


    public MessageListAdapter(Context context, int resourceId1, List<MessageList> listItems) {
        super(context, resourceId1, listItems);
        resourceId = resourceId1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageList listItem = (MessageList) getItem(position);
        View view;
        ViewHolder viewHolder;
        //当用户为第一次访问的时候
        if (convertView == null) {
            //将item_activity布局解析成显示界面
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            //获取item_activity.xml中控件，并将其保存在viewHolder中
            viewHolder.imageView = (ImageView) view.findViewById(R.id.img);
            viewHolder.nick = (TextView) view.findViewById(R.id.nick);
            viewHolder.msg = (TextView) view.findViewById(R.id.msg);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            //设置将数据进行缓存
            view.setTag(viewHolder);
        } else {
            //第二次访问直接读取第一次访问使存取的数据
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //将数据返回到item_activity.xml中的每一个空间中

        viewHolder.imageView.setImageResource(listItem.getImg());
        viewHolder.nick.setText(listItem.getNick());
        viewHolder.msg.setText(listItem.getMsg());
        viewHolder.date.setText(listItem.getDate());
        return view;
    }


    static class ViewHolder {
        private ImageView imageView;
        private TextView nick;
        private TextView msg;
        private TextView date;
    }
}

