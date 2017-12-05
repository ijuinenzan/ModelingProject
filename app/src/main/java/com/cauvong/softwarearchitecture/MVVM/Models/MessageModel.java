package com.cauvong.softwarearchitecture.MVVM.Models;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessageModel {

    private ArrayList<MessageItemModel> _messages;

    public void addMessage(MessageItemModel messageItem)
    {
        if(_messages == null)
        {
            _messages = new ArrayList<MessageItemModel>();
        }

        MessageItemModel messageItemModel = messageItem;

        _messages.add(messageItemModel);
    }

    public ArrayList<MessageItemModel> getArrListMessage()
    {
        return _messages;
    }
}
