package com.geektech.a1lesson5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ChangeFragment extends Fragment implements IFragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<RecyclerModel> list;
    private RecyclerAdapter adapter;

    public ChangeFragment() {

    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
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
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        initializeViews(view);
        setupRecyclerView();

        return view;
    }

    private void initializeViews(View view) {
        recyclerView = view.findViewById(R.id.resyslerView);
    }

    private void setupRecyclerView(){
        list = new ArrayList<>();
        list.add(new RecyclerModel("Август","Привет!",R.drawable.user2));
        list.add(new RecyclerModel("Агата","Hello",R.drawable.user2));
        list.add(new RecyclerModel("Агафон","Hi",R.drawable.user2));
        list.add(new RecyclerModel("Агафья","Здравствуйте",R.drawable.user2));
        list.add(new RecyclerModel("Агнес","Привет",R.drawable.user2));
        list.add(new RecyclerModel("Агнесса","Hello",R.drawable.user2));
        list.add(new RecyclerModel("Агния","Привет",R.drawable.user2));
        list.add(new RecyclerModel("Адам","Hello",R.drawable.user2));
        list.add(new RecyclerModel("Аделина","Здравствуйте",R.drawable.user2));
        list.add(new RecyclerModel("Адель","Hello",R.drawable.user2));
        list.add(new RecyclerModel("Адольф","Hi",R.drawable.user2));
        list.add(new RecyclerModel("Азамат","Здравствуйте",R.drawable.user2));
        list.add(new RecyclerModel("Айдар","Hello",R.drawable.user2));
        list.add(new RecyclerModel("Айгерим","Привет",R.drawable.user2));
        list.add(new RecyclerModel("Бенедикт","Hi",R.drawable.user2));
        list.add(new RecyclerModel("ttcxgf","Hi",R.drawable.user2));



        recyclerView.setLayoutManager(new LinearLayoutManager((MainActivity)getActivity()));
        adapter = new RecyclerAdapter(list,requireContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void displayDetails(String title, String subTitle,int image) {
        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        activity.displayDetails(title,subTitle,image);
    }
}