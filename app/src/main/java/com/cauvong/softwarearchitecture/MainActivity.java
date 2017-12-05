package com.cauvong.softwarearchitecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMVP(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, com.cauvong.softwarearchitecture.MVP.Views.ChatView.class);
        startActivity(mvpIntent);
    }

    public void goToMVC(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, com.cauvong.softwarearchitecture.MVC.Views.ChatActivity.class);
        startActivity(mvpIntent);
    }


    public void goToMVVM(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, com.cauvong.softwarearchitecture.MVVM.Views.ChatActivity.class);
        startActivity(mvpIntent);
    }
}
