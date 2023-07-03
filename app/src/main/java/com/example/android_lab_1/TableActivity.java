package com.example.android_lab_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class TableActivity extends AppCompatActivity {
    ArrayList<String> entries = new ArrayList<String>();
    ArrayList<String> selectedEntries = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView entriesList;
    ArrayList<String> entries1 = new ArrayList<String>();
    ArrayList<String> selectedEntries1 = new ArrayList<String>();
    ArrayAdapter<String> adapter1;
    ListView entriesList1;

    private Button removeEntrie;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_table);

            Collections.addAll(entries);
            entriesList = findViewById(R.id.entriesList);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, entries);
            entriesList.setAdapter(adapter);

            removeEntrie = findViewById(R.id.removeEntrie);
            removeEntrie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchByIndex();
                }
            });
        }

        public void addEntrie(View view){
        EditText entrieET = findViewById(R.id.entrie);
        String entrie  = entrieET.getText().toString();
        if(!entrie.isEmpty()){
            adapter.add(entrie);
            entrieET.setText("");
            adapter.notifyDataSetChanged();
        }
    }
    public void searchByIndex(){
        EditText indexET = findViewById(R.id.entrie);
        int index = Integer.parseInt(indexET.getText().toString());
        EditText editText = findViewById(R.id.entrie);
        if (index >= 0 && index < adapter.getCount()) {
            String item = adapter.getItem(index);
            editText.setText(item);
        } else {
            editText.setText("Строка не найдена");
        }
    }
}

