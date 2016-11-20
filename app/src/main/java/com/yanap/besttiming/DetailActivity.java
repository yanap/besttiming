package com.yanap.besttiming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mToolBar.setTitle("BEST TIMING");

        mToolBar.setNavigationIcon(R.mipmap.ic_back);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }
}
