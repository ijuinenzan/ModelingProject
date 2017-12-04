package com.cauvong.softwarearchitecture.MVC.Controllers;

import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVC.Models.MessagesModel;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesController implements FirebaseCallbacks
{
    private MessagesModel _messages;

    public MessagesController()
    {
        _messages = new MessagesModel();
        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    public void onClicked(String content, String senderName)
    {
        //gui tin nhan len firebase
        FirebaseManager.getInstance().sendMessageToFirebase(content, senderName);
    }

    public void onMessageReceived(MessageItemModel message){
        _messages.addMessage(message);
    }

    public void setOnMessageChangeListener(IMessageListener listener)
    {
        _messages.setOnMessageChangeListener(listener);
    }


    @Override
    public void onNewMessage(String messageKey, long timeStamp, String content, String senderName)
    {
        MessageItemModel message = new MessageItemModel();
        message.setMessageKey(messageKey);
        message.setTimeStamp(timeStamp);
        message.setContent(content);
        message.setSenderName(senderName);

        onMessageReceived(message);
    }

    public void destroy(){
        FirebaseManager.getInstance().removeListeners();
        FirebaseManager.getInstance().destroy();
    }
}
