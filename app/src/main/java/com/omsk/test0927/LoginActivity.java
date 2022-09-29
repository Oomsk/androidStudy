package com.omsk.test0927;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.omsk.test0927.domain.AccessToken;
import com.omsk.test0927.domain.LoginBean;
import com.omsk.test0927.util.SPUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button submit;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.w("OMSK", "onCreate -->> ");

        submit = findViewById(R.id.submit);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        username.setText("浙江总队");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameText = LoginActivity.this.username.getText().toString();
                String passwordText = LoginActivity.this.password.getText().toString();

                if (!TextUtils.isEmpty(usernameText) && !TextUtils.isEmpty(passwordText)) {
                    Log.w("Login", "username =" + usernameText);
                    Log.w("Login", "password =" + passwordText);
                    doLogin(usernameText, passwordText);

                } else {
                    Toast.makeText(LoginActivity.this, "请输入用户名和密码!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void doLogin(String username, String password) {
        Toast.makeText(LoginActivity.this, "登录中!", Toast.LENGTH_LONG).show();

        LoginBean loginBean = new LoginBean();

        loginBean.setMac("123");
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        //String data = JSON.toJSONString(loginBean);

        String data = new Gson().toJson(loginBean);

        String url = "https://ionia-dev.zsrxit.com/account/v2/login";

        new Thread() {
            @Override
            public void run() {
                super.run();

                RequestBody requestBody = RequestBody.create(data, MediaType.get("application/json; charset=utf-8"));

                Request request = new Request.Builder().url(url).post(requestBody).build();

                OkHttpClient client = new OkHttpClient();

                try {
                    Response response = client.newCall(request).execute();

                    String  resp =  response.body().string();

                    System.out.println(resp);

                    //AccessToken accessToken = JSON.parseObject(resp, AccessToken.class);

                    AccessToken accessToken = new Gson().fromJson(resp, AccessToken.class);


                    SPUtil.save(LoginActivity.this  , "token" , new Gson().toJson(accessToken));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        String token = SPUtil.get(LoginActivity.this, "token");

        JSONObject jsonObject = JSONObject.parseObject(token);

        if (jsonObject.getString("msg").equals("success")) {

            //Toast.makeText(LoginActivity.this, "登录成功!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, AboutMeActivity.class);
            startActivity(intent);
        }


        Log.w("Login", token);
        Toast.makeText(LoginActivity.this, "登录失败!", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
