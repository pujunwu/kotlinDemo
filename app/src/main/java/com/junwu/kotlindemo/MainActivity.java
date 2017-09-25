package com.junwu.kotlindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    AppKot mAppKot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppKot.Companion.getAppkot().getComponent().inject(this);

        Toast.makeText(this,mAppKot.toString(),Toast.LENGTH_SHORT).show();
    }

    public void onClickListener(View view) {
        switch (view.getId()) {
            case R.id.tv_text:
                //跳转到kotlin activity
                startActivity(new Intent(this, KotlinActivity.class));
                break;
            case R.id.tv_text1:
                //跳转到kotlin activity
                startActivity(new Intent(this, KotlinDaggerActivity.class));
                break;
        }


    }

}
