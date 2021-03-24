package com.geektech.a1lesson5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TextFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";



    private String mParam1;
    private String mParam2;
    private int mParam3;

    private TextView textTitle;
    private TextView textSubTitle;
    private ImageView textImage;

    public static TextFragment newInstance(String param1, String param2,int param3) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeViews(view);
        getArgs();

    }

    private void initializeViews(View view) {
        textTitle = view.findViewById(R.id.title_text);
        textSubTitle = view.findViewById(R.id.subTitle);
        textImage = view.findViewById(R.id.image_text);
    }

    private void getArgs() {
        if (mParam1 != null ){
            showText(mParam1,mParam2,mParam3);
        }
    }

    public void showText(String text, String description, int image) {
        if (text != null){
            textTitle.setText(text);
            textSubTitle.setText(description);
            textImage.setImageResource(image);
            //Log.d("TAG",text);
        }


    }
}