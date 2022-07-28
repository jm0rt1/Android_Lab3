package com.example.lab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link first#newInstance} factory method to
 * create an instance of this fragment.
 */
public class first extends Fragment implements View.OnClickListener {
    public final String TAG = "first fragment";
    public static final String SHOW_FRAG1 = "show frag 1";
    public static final String SHOW_FRAG2 = "show frag 2";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public first() {

    }

    public static class MyAlertDialog extends DialogFragment {
        public static MyAlertDialog newInstance(int title, int list) {
            MyAlertDialog frag = new MyAlertDialog();
            Bundle args = new Bundle();
            args.putInt("title", title);
            args.putInt("list", list);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            //arguments should not be null, normally should use an assert
            int title = getArguments().getInt("title"); //id of the string resource for the title
            int list = getArguments().getInt("list"); //id of the string-array for the elements
            String[] responses = getResources().getStringArray(list);
            boolean[] checkedItems = new boolean[responses.length];
            builder.setTitle(title);
            //set the multi choice listener


            //set the positive button
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                }
            });
            return builder.create();
        }
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment first.
     */
    // TODO: Rename and change types and number of parameters
    public static first newInstance(String param1, String param2) {
        first fragment = new first();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        Button showButton =  view.findViewById(R.id.showButton);
        showButton.setOnClickListener(this);
        Button optionsButton =  view.findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(this);
        return view;
    }

    public void clickedShowButton(View v){
        Log.i(TAG, "clicked showButton");
        Intent intent = new Intent(getActivity(), SubActivity.class);
//        EditText edit = (EditText) findViewById(R.id.message);
//        String message = edit.getText().toString();
        CheckBox frag1 =  getActivity().findViewById(R.id.frag1);
        CheckBox frag2 =  getActivity().findViewById(R.id.frag2);
        try{
            intent.putExtra(SHOW_FRAG1, frag1.isChecked());
            intent.putExtra(SHOW_FRAG2, frag2.isChecked());
        } catch (Exception e){
            Log.e(TAG, e.toString());
        }

        startActivity(intent);
    }

    public void clickedOptionsButton(View v){
        Log.i(TAG, "clicked optionsButton");
        DialogFragment newFragment = MyAlertDialog.newInstance(R.string.dialog_title,R.array.list_items);
        newFragment.show(this.getChildFragmentManager(),"alert");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.showButton:
                clickedShowButton(v);
                break;
            case R.id.optionsButton:
                clickedOptionsButton(v);
                break;
        }
    }



}