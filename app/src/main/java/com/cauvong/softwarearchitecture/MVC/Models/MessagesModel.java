package com.cauvong.softwarearchitecture.MVC.Models;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesModel
{
    private ArrayList<MessageItemModel> _messages;

    public void addMessages(MessageItemModel messageItemModel)
    {
        if(_messages == null)
        {
            _messages = new ArrayList<MessageItemModel>();
        }

        _messages.add(messageItemModel);
    }
}
