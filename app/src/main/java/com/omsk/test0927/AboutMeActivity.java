package com.omsk.test0927;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class AboutMeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        Log.w("OMSK", "[AboutActivity -> on create]");


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
