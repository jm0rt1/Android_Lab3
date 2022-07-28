package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    boolean showFrag1 = false;
    boolean showFrag2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this::onClickBackButton);
        showFrag1 = intent.getBooleanExtra(first.SHOW_FRAG1, false);
        showFrag2 = intent.getBooleanExtra(first.SHOW_FRAG2, false);
        if(showFrag1) {
            createFrag1();
        }
        if (showFrag2) {

            createFrag2();
        }
    }

    private void onClickBackButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void createFrag1(){
        Log.i(TAG,"createFrag1");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        second frag2 = new second();

        fragmentTransaction.add(R.id.fragment_container,frag2);

        fragmentTransaction.commit();
    }

    private void createFrag2(){
        Log.i(TAG,"createFrag2");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        second frag2 = new second();

        fragmentTransaction.add(R.id.fragment_container,frag2);
        fragmentTransaction.commit();

    }

}