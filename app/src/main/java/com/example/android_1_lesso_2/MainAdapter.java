package com.example.android_1_lesso_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private ArrayList<Students> list = new ArrayList<>();

            public MainAdapter(){

            }
            public void setList(ArrayList<Students> list){
        this.list = list;
        notifyDataSetChanged();

            }

         public void addStudents(Students students){
                this.list.add(students);
                notifyDataSetChanged();

         }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder holder, int position) {
        holder.onBind(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
                TextView name, surname;
        public MyViewHolder(View View) {
            super(View);
            name = View.findViewById(R.id.name);
            surname = View.findViewById(R.id.surname);
        }

        public void onBind(Students students) {
            name.setText(students.getName());
            surname.setText(students.getSurename());
        }
    }


}
