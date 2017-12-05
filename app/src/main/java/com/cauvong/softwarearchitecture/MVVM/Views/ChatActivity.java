package com.cauvong.softwarearchitecture.MVVM.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.ViewModels.ChatViewModel;
import com.cauvong.softwarearchitecture.databinding.MvvmChatActivityBinding;
import com.cauvong.softwarearchitecture.R;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatActivity extends AppCompatActivity {

    //region DECLARE VARIABLE
    private MvvmChatActivityBinding _binding;
    private ChatViewModel _viewModel;
    private EditText _edtContent;
    private EditText _edtSenderName;
    private RecyclerView _recyclerView;
    //endregion

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.mvvm_chat_activity);

        _binding = DataBindingUtil.setContentView(this,R.layout.mvvm_chat_activity);
        _viewModel = new ChatViewModel();
        _binding.setViewModel(_viewModel);
        _binding.setActivity(this);

        _edtContent = (EditText) findViewById(R.id.edittext_chat_message);
        _edtSenderName = (EditText) findViewById(R.id.edt_sender_name);

        _recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void sendMessage()
    {
        _viewModel.sendMessage(_edtContent.getText().toString(),_edtSenderName.getText().toString());
        clearText();
    }

    public void clearText()
    {
        _edtContent.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _viewModel.destroy();
    }

    public void onMessageChange(ArrayList<MessageItemModel> messages)
    {
        ChatAdapter chatAdapter = new ChatAdapter(this,messages);
        _recyclerView.setAdapter(chatAdapter);
        _recyclerView.scrollToPosition(messages.size()-1);
    }
}
