package com.cauvong.softwarearchitecture.MVC.Controllers;

import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVC.Models.MessagesModel;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesController
{
    private MessagesModel _messages;

    public MessagesController()
    {
    }

    public void onClicked(String content, String senderName)
    {
        //gui tin nhan len firebase
    }

    public void onMessageReceived(MessageItemModel message){
        _messages.addMessage(message);
    }

    public void setOnMessageChangeListener(IMessageListener listener)
    {
        _messages.setOnMessageChangeListener(listener);
    }

}
