package com.geektech.a1lesson5;

import android.app.admin.DeviceAdminInfo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.service.controls.DeviceTypes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<RecyclerModel> list;
    private Context context;
    private IFragment listener;

    public RecyclerAdapter(ArrayList<RecyclerModel> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
       holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;
        private RecyclerModel model;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView1 = itemView.findViewById(R.id.textTitle);
            textView2 = itemView.findViewById(R.id.textSubtitle);
            imageView = itemView.findViewById(R.id.image_in_item);
        }

        private void onBind(RecyclerModel model){
            this.model = model;
            textView1.setText(model.getTitle());
            textView2.setText(model.getSubtitle());
            imageView.setImageResource(model.getImage1());
        }

        @Override
        public void onClick(View v) {

            if (listener!=null){

                listener.displayDetails(model.getTitle(), model.getSubtitle(), model.getImage1());

            }
        }
    }
    public void setOnClickListener(IFragment mListener){
        this.listener=mListener;

    }
}
