package com.cauvong.softwarearchitecture.MVVM.ViewModels;

import android.databinding.BaseObservable;

import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageModel;
import com.cauvong.softwarearchitecture.MVVM.Views.ChatActivity;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatViewModel extends BaseObservable implements FirebaseCallbacks
{
    private MessageModel _messages;
    private ChatActivity _view;

    public ChatViewModel()
    {
        _messages = new MessageModel();
        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    public void sendMessage(String content, String senderName)
    {
        //gui len firebase
        FirebaseManager.getInstance().sendMessageToFirebase(content, senderName);
    }

    public void onMessageReceived(MessageItemModel message)
    {
        _messages.addMessage(message);

        //binding len View
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
