package com.example.androidwebviewusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.main_local_btn:
                intent.setClass(this, LocalActivity.class);
                break;
            case R.id.main_remote_btn:
                intent.setClass(this, RemoteActivity.class);
                break;
        }
        startActivity(intent);
    }
}