package com.cauvong.softwarearchitecture.MVP.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.R;
import com.cauvong.softwarearchitecture.utils.MyUtils;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.FollowerViewHolder> {
    private ArrayList<MessageItemModel> _chatList;
    private Context context;

    ChatAdapter(Context context, ArrayList<MessageItemModel> chatList) {
        this._chatList =chatList;
        this.context=context;
    }

    @Override
    public FollowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.mvp_chat_row_adapter, parent, false);
        return new FollowerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FollowerViewHolder holder, final int position) {

        if (_chatList.get(position).getSenderName().equals("Khanh")) {

            holder.layoutLeftMessages.setVisibility(View.GONE);
            holder.layoutRightMessages.setVisibility(View.VISIBLE);

            holder.messagesTextRight.setText(_chatList.get(position).getContent());
            holder.timeMessagesRight.setText(MyUtils.convertTime(_chatList.get(position).getTimeStamp()));

        } else {

            holder.layoutLeftMessages.setVisibility(View.VISIBLE);
            holder.layoutRightMessages.setVisibility(View.GONE);

            holder.messagesTextLeft.setText(_chatList.get(position).getContent());
            holder.timeMessagesLeft.setText(MyUtils.convertTime(_chatList.get(position).getTimeStamp()));
        }
    }

    @Override
    public int getItemCount() {
        return _chatList.size();
    }


    class FollowerViewHolder extends RecyclerView.ViewHolder {

        private TextView messagesTextLeft, timeMessagesLeft, messagesTextRight,timeMessagesRight;
        private LinearLayout layoutLeftMessages, layoutRightMessages;

        FollowerViewHolder(View convertView) {
            super(convertView);

            messagesTextLeft = (TextView) convertView.findViewById(R.id.text_message_left);
            timeMessagesLeft =(TextView) convertView.findViewById(R.id.text_time_messages_left);
            messagesTextRight =(TextView) convertView.findViewById(R.id.text_message_right);
            timeMessagesRight=(TextView) convertView.findViewById(R.id.text_time_message_right);

            layoutLeftMessages =(LinearLayout) convertView.findViewById(R.id.layout_message_left);
            layoutRightMessages =(LinearLayout) convertView.findViewById(R.id.layout_message_right);
        }
    }
}
