package com.geektech.a1lesson5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public static final String KEY1 = "key1";
    public static final String KEY2 = "key2";
    public static final String KEY3 = "key3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

      changeFragment();
    }

    public void changeFragment(){
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_first,new ChangeFragment());
        transaction.commit();
    }

    public void displayDetails(String title, String subTitle,int image_display) {

        TextFragment textFragment = (TextFragment) fragmentManager.findFragmentById(R.id.text_fragment);

        if(textFragment != null && textFragment.isVisible()){
            textFragment.showText(title,subTitle,image_display);
        }else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY1, title);
            intent.putExtra(KEY2, subTitle);
            intent.putExtra(KEY3, image_display);

            startActivity(intent);
        }

//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Intent intent = new Intent(this, DetailsActivity.class);
//            intent.putExtra(KEY1, title);
//            intent.putExtra(KEY2, subTitle);
//            intent.putExtra(KEY3, image_display);
//
//            startActivity(intent);
//        }else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE && textFragment.isVisible()){
//            textFragment.showText(title,subTitle,image_display);
//
//        }else {
//            Toast.makeText(this,"????",Toast.LENGTH_LONG).show();
//        }


    }



}