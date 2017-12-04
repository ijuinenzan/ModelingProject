package com.cauvong.softwarearchitecture.MVP.Models;

/**
 * Created by ijuin on 12/4/2017.
 */

public class MessageItemModel {
    private String _messageKey;
    private long _timeStamp;
    private String _content;
    private String _senderName;

    public String getSenderName() {
        return _senderName;
    }

    public void setSenderName(String senderName) {
        this._senderName = senderName;
    }

    public long getTimeStamp() {
        return _timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this._timeStamp = timeStamp;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        this._content = content;
    }

    public String getMessageKey() {
        return _messageKey;
    }

    public void setMessageKey(String messageKey) {
        this._messageKey = messageKey;
    }
}
