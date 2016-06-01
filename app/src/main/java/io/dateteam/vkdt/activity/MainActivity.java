package io.dateteam.vkdt.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vk.sdk.VKSdk;

import io.dateteam.vkdt.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!VKSdk.isLoggedIn()) {
            LoginActivity.start(this);
            finish();
            return;
        }

        setContentView(R.layout.activity_main);
    }

    public static void start(Context c) {
        Intent intent = new Intent(c, MainActivity.class);
        c.startActivity(intent);
    }

}
