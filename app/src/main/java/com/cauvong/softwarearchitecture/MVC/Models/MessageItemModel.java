package com.cauvong.softwarearchitecture.MVC.Models;

import android.os.Message;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessageItemModel
{
    private int _userId;
    private String _userName;
    private String _content;
    private String _timeStamp;

    public MessageItemModel()
    {    }

    public MessageItemModel(int userId, String userName, String content, String timeStamp)
    {
        this._userId = userId;
        this._userName = userName;
        this._content = content;
        this._timeStamp = timeStamp;
    }

    public int getUserId()
    {   return _userId;    }

    public void setUserId(int userId)
    {   this._userId = userId;  }

    public String getUserName()
    {   return _userName;    }

    public void setUserName(String userName)
    {   this._userName = userName;  }

    public String getContent()
    {   return _content;    }

    public void setContent(String content)
    {   this._content = content;    }

    public String getTimeStamp()
    {   return _timeStamp;    }

    public void setTimeStamp(String timeStamp)
    {   this._timeStamp = timeStamp;   }
}
