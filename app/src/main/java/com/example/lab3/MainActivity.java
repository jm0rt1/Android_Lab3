package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MainActivity.OnCreate Running" );
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onStart() {
        Log.d(TAG, "onStart called (Main)");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume called (Main)");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause called (Main)");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop called (Main)");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy called (Main)");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart called (Main)");
        super.onRestart();
    }

    public void showOptions(){

    }


}