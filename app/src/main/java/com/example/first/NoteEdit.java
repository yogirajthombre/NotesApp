package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static com.example.first.MainActivity.ContentNote;
import static com.example.first.MainActivity.ContentDate;

public class NoteEdit extends AppCompatActivity {
    EditText edit_note;
    TextView edit_date;
    public static int NoteId;

    ImageButton imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        edit_date = findViewById(R.id.editnote_dateTime);
        edit_note = findViewById(R.id.text_note);
        imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(NoteEdit.this,MainActivity.class);
                startActivity(back);

            }
        });
        if (MainActivity.check_floatingActionButton){
            NoteId = (ContentNote.size())-1;
            MainActivity.check_floatingActionButton = false;
        }else {
            Intent in = getIntent();
            NoteId =  in.getIntExtra("position",0);
        }


        edit_note.setText(ContentNote.get(NoteId));
        edit_date.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(new Date()));
        edit_note.setTypeface(MainActivity.typeface1);
        edit_date.setTypeface(MainActivity.typeface2);
        edit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ContentNote.set(NoteId,String.valueOf(charSequence));
                ExampleItem item = new ExampleItem(ContentNote);
                MainActivity.all_notes.set(NoteId,item);
                MainActivity.adapter.notifyDataSetChanged();

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });









    }
}