package com.cauvong.softwarearchitecture.MVVM.Models;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessageItemModel {

    private String _messageKey;
    private String _senderName;
    private String _content;
    private String _timeStamp;

    public MessageItemModel()
    {    }

    public MessageItemModel(String messageKey, String senderName, String content, String timeStamp)
    {
        this._messageKey = messageKey;
        this._senderName = senderName;
        this._content = content;
        this._timeStamp = timeStamp;
    }

    //region GET-SET
    public String getMessageKey()
    {   return _messageKey;    }

    public void setMessageKey(String messageKey)
    {   this._messageKey = messageKey;  }

    public String getSenderName()
    {   return _senderName;    }

    public void setSenderName(String senderName)
    {   this._senderName = senderName;  }

    public String getContent()
    {   return _content;    }

    public void setContent(String content)
    {   this._content = content;    }

    public String getTimeStamp()
    {   return _timeStamp;    }

    public void setTimeStamp(String timeStamp)
    {   this._timeStamp = timeStamp;   }
    //endregion


}
