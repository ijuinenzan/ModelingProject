package com.cauvong.softwarearchitecture.MVP.Presenters;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVP.Models.MessageModel;
import com.cauvong.softwarearchitecture.MVP.Views.ChatView;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatPresenter implements IPresenter<ChatView>, FirebaseCallbacks {
    private ChatView _view;
    private MessageModel _messageModel;

    @Override
    public void setView(ChatView view) {
        _view = view;
        _messageModel = new MessageModel();

        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    public void sendMessage(String message, String sender){
        _view.clearText();

        FirebaseManager.getInstance().sendMessageToFirebase(message, sender);
    }

    @Override
    public void onNewMessage(String messageKey, long timeStamp, String content, String senderName) {
        MessageItemModel message = new MessageItemModel();
        message.setMessageKey(messageKey);
        message.setTimeStamp(timeStamp);
        message.setContent(content);
        message.setSenderName(senderName);
        _messageModel.addMessage(message);

        _view.updateMessageList(_messageModel.getMessages());
    }

    public void destroy(){
        FirebaseManager.getInstance().removeListeners();
        FirebaseManager.getInstance().destroy();
    }
}
