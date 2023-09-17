
package com.zhou.asm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ActivityTag", "原逻辑-MainActivity-> onCreate");
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_jump).setOnClickListener(v -> {
            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
        });
    }
}
