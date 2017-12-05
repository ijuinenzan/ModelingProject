package com.cauvong.softwarearchitecture.MVVM.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.cauvong.softwarearchitecture.BR;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageModel;
import com.cauvong.softwarearchitecture.MVVM.Views.ChatActivity;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatViewModel extends BaseObservable implements FirebaseCallbacks
{
    private MessageModel _messages;
    private String _senderName = "";
    private String _content ="";
    private ChatActivity _view;

    public ChatViewModel(ChatActivity view)
    {
        _view = view;
        _messages = new MessageModel();
        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    @Bindable
    public String getSenderName()
    {
        return _senderName;
    }

    public void setSenderName(String senderName)
    {
        _senderName = senderName;
        notifyPropertyChanged(BR.senderName);
    }

    @Bindable
    public String getContent()
    {
        return _content;
    }

    public void setContent(String content)
    {
        _content = content;
        notifyPropertyChanged(BR.content);
    }

    public void sendMessage()
    {
        //gui len firebase
        FirebaseManager.getInstance().sendMessageToFirebase(_content, _senderName);
    }

    public void onMessageReceived(MessageItemModel message)
    {
        _messages.addMessage(message);

        //binding len View
        _view.onMessageChange(_messages.getArrListMessage());
        setContent("");
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
