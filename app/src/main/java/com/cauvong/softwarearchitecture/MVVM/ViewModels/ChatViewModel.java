package com.cauvong.softwarearchitecture.MVVM.ViewModels;

import android.databinding.BaseObservable;

import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageModel;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatViewModel extends BaseObservable
{
    private MessageModel _messages;

    public void sendMessage(String content, String senderName)
    {
        //gui len firebase
    }

    public void onMessageReceived(MessageItemModel message)
    {
        _messages.addMessage(message);
    }
    
}
