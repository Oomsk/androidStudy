package com.omsk.test0927;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button myButton, myButton2, aboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("OMSK", "[MainActivity -> on create]");

        myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(onMessageClick);

        myButton2 = findViewById(R.id.myButton2);
        myButton2.setOnClickListener(onMessageClick);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w("OMSK" , "[MainActivity -> onResume]");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.w("OMSK" , "[MainActivity -> onPause]");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("OMSK" , "[MainActivity -> onDestroy]");
    }

    private View.OnClickListener onMessageClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.w("OMSK", "主页跳转我的登录按钮被点击了!");
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    };


}