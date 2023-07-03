package com.example.android_lab_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import android.provider.MediaStore;

public class TableActivity extends AppCompatActivity {

    ArrayList<String> entries = new ArrayList<String>();
    ArrayList<String> selectedEntries = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView entriesList;
    private Button cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Collections.addAll(entries);

        Log.i("AppLogger", "Переопределение onCreate у TableActivity");
        String accountName = getIntent().getExtras().getString("Lab3");
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(accountName);

        entriesList = findViewById(R.id.entriesList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, entries);
        entriesList.setAdapter(adapter);

        entriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                String entrie = adapter.getItem(position);
                if(entriesList.isItemChecked(position))
                    selectedEntries.add(entrie);
                else
                    selectedEntries.remove(entrie);
            }
        });

        cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    //startActivity(cameraIntent);
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("AppLogger", "Переопределение onStop у TableActivity");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("AppLogger", "Переопределение onStart у TableActivity");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("AppLogger", "Переопределение onPause у TableActivity");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("AppLogger", "Переопределение onResume у TableActivity");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("AppLogger", "Переопределение onRestart у TableActivity");
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
}