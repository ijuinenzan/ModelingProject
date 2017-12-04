package com.cauvong.softwarearchitecture.MVP.Models;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class MessageModel {
    private ArrayList<MessageItemModel> _messages;

    public void addMessage(MessageItemModel message)
    {
        if(_messages == null)
        {
            _messages = new ArrayList<>();
        }
        _messages.add(message);
    }

    public ArrayList<MessageItemModel> getMessages() {
        return _messages;
    }
}
