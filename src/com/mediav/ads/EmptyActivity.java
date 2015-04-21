package com.mediav.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EmptyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmptyActivity.this,"toask!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
