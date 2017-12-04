package com.cauvong.softwarearchitecture.MVP.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVP.Presenters.ChatPresenter;
import com.cauvong.softwarearchitecture.R;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatView extends AppCompatActivity {
    private ChatPresenter _chatPresenter;

    private EditText _chatText;
    private EditText _nameText;

    private RecyclerView _recyclerView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_chat_activity);

        _chatPresenter = new ChatPresenter();
        _chatPresenter.setView(this);

        _chatText = findViewById(R.id.edittext_chat_message);
        _nameText = findViewById(R.id.edt_sender_name);

        _recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void updateMessageList(ArrayList<MessageItemModel> messages) {
        ChatAdapter chatAdapter = new ChatAdapter(this, messages);
        _recyclerView.setAdapter(chatAdapter);
        _recyclerView.scrollToPosition(messages.size()-1);
    }

    public void onSendMessage(View v)
    {
        if(v.getId() == R.id.button_send_message){
            _chatPresenter.sendMessage(_chatText.getText().toString(), _nameText.getText().toString());
        }
    }

    public void clearText(){
        _chatText.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _chatPresenter.destroy();
    }
}
