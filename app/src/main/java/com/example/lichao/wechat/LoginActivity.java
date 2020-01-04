package com.example.lichao.wechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarCompat.setStatusBarColor(this, 255, true);

//        点击注册
        TextView reg_btn = (TextView) findViewById(R.id.reg);
        //给reg_btn绑定监听事件
        reg_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 给bnt1添加点击响应事件
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                //启动
                startActivity(intent);
            }
        });
//        点击登录
        Button login_submit = (Button) findViewById(R.id.submit);
        login_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 给bnt1添加点击响应事件
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //启动
                startActivity(intent);
                //销毁，防止返回
                LoginActivity.this.finish();
            }
        });
    }
}
