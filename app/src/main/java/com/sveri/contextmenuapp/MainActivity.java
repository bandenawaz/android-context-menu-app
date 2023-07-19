package com.sveri.contextmenuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvFruits;
    String[] fruits = {
            "Mango", "Chickoo","Grapes","Dragon Fruit",
            "Kiwi", "Papaya", "strawberry", "Cherry",
            "Apple"
    };

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruits = findViewById(R.id.listFruits);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits);
        lvFruits.setAdapter(adapter);
        //lets register our listview for context menu
        registerForContextMenu(lvFruits);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an action");
        menu.add(0,v.getId(),0,"Slice");
        menu.add(0,v.getId(),0,"Eat");
        menu.add(0,v.getId(),0,"Juice");
        menu.add(0,v.getId(),0,"Throw");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.listFruits){

            Toast.makeText(this, "You selected "+item.getTitle().toString(),
                    Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}