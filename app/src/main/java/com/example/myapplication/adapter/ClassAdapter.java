package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ClassModel;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder>{
    private List<ClassModel> classModelList;

    public ClassAdapter(List<ClassModel> classModelList) {
        this.classModelList = classModelList;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent,false);
        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ClassModel classModel = classModelList.get(position);
        if (classModel == null){
            return;
        }
        holder.txtClassCode.setText(classModel.getCode());
        holder.txtClassName.setText(classModel.getName());
    }

    @Override
    public int getItemCount() {
        if(classModelList != null){
            return classModelList.size();
        }
        return 0;
    }

    class ClassViewHolder extends RecyclerView.ViewHolder{
        private TextView txtClassCode;
        private TextView txtClassName;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClassCode = itemView.findViewById(R.id.txt_class_code);
            txtClassName = itemView.findViewById(R.id.txt_class_name);
        }
    }
}
