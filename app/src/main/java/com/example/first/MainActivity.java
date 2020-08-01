package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    TextView AppName;
    public  static  RecyclerView.Adapter adapter;
    public static ArrayList<ExampleItem> all_notes = new ArrayList<ExampleItem>();
    public static int position;
    public static boolean check_floatingActionButton = false ;
    public static Typeface typeface1,typeface2;
    public static ArrayList<String> ContentNote = new ArrayList<String>();
    public static ArrayList<String> ContentDate = new ArrayList<String>();
    public static String Date_Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeface1 = Typeface.createFromAsset(getAssets(),"Fonts/Ubuntu-Regular.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(),"Fonts/Ubuntu-Medium.ttf");
        Date_Edit = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(new Date());
        AppName = findViewById(R.id.Name);
        AppName.setTypeface(typeface2);
        recyclerView = findViewById(R.id.recyclerview);
        floatingActionButton = findViewById(R.id.new_note);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_floatingActionButton = true;
                ContentNote.add("AddNote");
                ContentDate.add(Date_Edit);
                all_notes.add(new ExampleItem(ContentNote));
                adapter = new ExampleAdapter(all_notes);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                Intent intent = new Intent(MainActivity.this,NoteEdit.class);
                startActivity(intent);

            }
        });

        adapter = new ExampleAdapter(all_notes);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


    }
}