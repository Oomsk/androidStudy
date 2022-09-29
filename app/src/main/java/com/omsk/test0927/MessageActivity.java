package com.omsk.test0927;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Log.w("OMSK" , "[MessageActivity -> onCreate]");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w("OMSK" , "[MessageActivity -> onResume]");
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.w("OMSK" , "[MessageActivity -> onPause]");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("OMSK" , "[MessageActivity -> onDestroy]");
    }


}
