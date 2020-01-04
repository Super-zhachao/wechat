package com.example.lichao.wechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lichao.wechat.R;
import com.example.lichao.wechat.bean.Message;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    private ArrayList<Message> msgList;
    private LayoutInflater mInflater;

    public MessageAdapter(ArrayList<Message> msgList, Context context) {
        this.msgList = msgList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return msgList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = msgList.get(position);
        return msg.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                view = mInflater.inflate(R.layout.message_receive_list, null);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) view.findViewById(R.id.iconLeft);
                viewHolder.text = (TextView) view.findViewById(R.id.textLeft);
            } else {
                view = mInflater.inflate(R.layout.message_sender_list, null);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) view.findViewById(R.id.iconRight);
                viewHolder.text = (TextView) view.findViewById(R.id.textRight);
            }
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

//        viewHolder.icon.setImageBitmap(msgList.get(position).getIcon());
        viewHolder.icon.setImageResource(msgList.get(position).getIcon());
        viewHolder.text.setText(msgList.get(position).getContent());
        return view;
    }

    static class ViewHolder {
        ImageView icon;
        TextView text;
    }
}
