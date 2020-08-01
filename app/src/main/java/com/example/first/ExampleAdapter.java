package com.example.first;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable {
    public ArrayList<ExampleItem> exampleItems ;
    public Filter getFilter() {
        return null;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.note_text);
            textView2 = itemView.findViewById(R.id.note_date);
            textView1.setTypeface(MainActivity.typeface1);
            textView2.setTypeface(MainActivity.typeface2);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleItems){
        this.exampleItems = exampleItems;


    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item,viewGroup,false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder exampleViewHolder, @SuppressLint("RecyclerView") final int i) {
        
        exampleViewHolder.textView1.setText(exampleItems.get(i).getNote_content(i));
        exampleViewHolder.textView2.setText(MainActivity.ContentDate.get(i));

        exampleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iot = new Intent(exampleViewHolder.itemView.getContext(),NoteEdit.class);
                iot.putExtra("position",i);
                exampleViewHolder.itemView.getContext().startActivity(iot);

            }
        });




    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }


}
