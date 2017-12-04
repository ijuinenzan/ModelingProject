package com.cauvong.softwarearchitecture.MVC.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cauvong.softwarearchitecture.MVC.Controllers.MessagesController;
import com.cauvong.softwarearchitecture.R;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatActivity extends AppCompatActivity
{
    private Button _btnSend;
    private MessagesController _controller;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _controller.onClicked();
            }
        });
    }


}
