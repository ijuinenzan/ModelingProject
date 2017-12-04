package com.cauvong.softwarearchitecture.MVC.Models;

import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesModel
{
    private ArrayList<MessageItemModel> _messages;
    private IMessageListener _onMessageChange;

    public void addMessage(MessageItemModel messageItemModel)
    {
        if(_messages == null)
        {
            _messages = new ArrayList<MessageItemModel>();
        }

        _messages.add(messageItemModel);

        if(_onMessageChange != null)
        {
            _onMessageChange.onMessageChange(_messages);
        }
    }

    public void setOnMessageChangeListener(IMessageListener listener)
    {
        this._onMessageChange = listener;
    }
}
