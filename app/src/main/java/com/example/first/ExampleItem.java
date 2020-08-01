package com.example.first;

import java.util.ArrayList;

public class ExampleItem {
    ArrayList<String> note_content;

    public ExampleItem( ArrayList<String> note_content){
        this.note_content = note_content;
    }

    public String getNote_content(int position) {
        return note_content.get(position);
    }

}
