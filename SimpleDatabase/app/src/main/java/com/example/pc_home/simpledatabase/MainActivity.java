package com.example.pc_home.simpledatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabase helper = new MyDatabase(this);
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        helper.Delete();

        helper.INSERT("Umer Khalid","012345678");

        helper.INSERT("Random","+921234567");

        helper.INSERT("Random Value","9876543");


        ArrayList<String> arr = helper.getAppCategoryDetail();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
        listView.setAdapter(arrayAdapter);

    }
}
