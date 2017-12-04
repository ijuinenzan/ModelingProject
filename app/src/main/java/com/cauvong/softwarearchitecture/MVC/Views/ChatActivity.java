package com.cauvong.softwarearchitecture.MVC.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cauvong.softwarearchitecture.MVC.Controllers.MessagesController;
import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.R;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatActivity extends AppCompatActivity
        implements IMessageListener
{
    private Button _btnSend;
    private EditText _edtContent;
    private EditText _edtSenderName;
    private MessagesController _controller;
    private RecyclerView _recyclerView;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.mvc_chat_activity);

        _edtSenderName = (EditText) findViewById(R.id.edt_sender_name);
        _edtContent = (EditText) findViewById(R.id.edittext_chat_message);
        _btnSend = (Button) findViewById(R.id.button_send_message);

        _controller = new MessagesController();
        _controller.setOnMessageChangeListener(ChatActivity.this);

        _recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onSend(View v)
    {
        _controller.onClicked(_edtContent.getText().toString(), _edtSenderName.getText().toString());
        clearText();
    }



    @Override
    public void onMessageChange(ArrayList<MessageItemModel> messages)
    {
        ChatAdapter chatAdapter = new ChatAdapter(this,messages);
        _recyclerView.setAdapter(chatAdapter);
        _recyclerView.scrollToPosition(messages.size()-1);
    }


    public void clearText(){
        _edtContent.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _controller.destroy();
    }

}
