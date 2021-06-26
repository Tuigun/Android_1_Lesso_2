package com.example.android_1_lesso_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        fab = findViewById(R.id.fab);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        ArrayList<Students> list = new ArrayList<>();



        adapter.setList(list);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormActivity.class);
            startActivityForResult(intent,100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null);
        adapter.addStudents(new Students(data.getStringExtra("name"),data.getStringExtra("surname")));
    }
}