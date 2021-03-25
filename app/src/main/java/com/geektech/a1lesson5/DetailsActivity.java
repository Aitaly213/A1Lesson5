package com.geektech.a1lesson5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;



public class DetailsActivity extends AppCompatActivity {

    private String title;
    private String subTitle;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null){
            title = intent.getStringExtra(MainActivity.KEY1);
            subTitle = intent.getStringExtra(MainActivity.KEY2);
            image = intent.getIntExtra(MainActivity.KEY3,0);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TextFragment fragment = TextFragment.newInstance(title,subTitle,image);
        transaction.add(R.id.details_fragment,fragment);
//        fragment.showText(title,subTitle,image);
        transaction.commit();
    }

}