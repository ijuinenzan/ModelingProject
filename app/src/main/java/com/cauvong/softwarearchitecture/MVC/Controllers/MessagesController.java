package com.cauvong.softwarearchitecture.MVC.Controllers;

import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVC.Models.MessagesModel;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesController
{
    private MessagesModel _messages;
    private MessageItemModel _messagesItem;

    public MessagesController()
    {
    }

    public void onClicked()
    {
        _messages.addMessages(_messagesItem);
    }

    public void setMessageItem(MessageItemModel messagesItem)
    {
        _messagesItem.setUserId(messagesItem.getUserId());
        _messagesItem.setUserName(messagesItem.getUserName());
        _messagesItem.setContent(messagesItem.getContent());
        _messagesItem.setTimeStamp(messagesItem.getTimeStamp());
    }
}
