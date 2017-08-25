package com.jcury.blizzardcareerviewer.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by jcury on 21/07/2017.
 */

public abstract class BlizzardActitivity extends AppCompatActivity {

    public void setOnClickActivity (int i, Class c) {
        View v = findViewById(i);

        setOnClickActivity(v,c);
    }

    public void setOnClickActivity (View v, final Class c){
        if (v != null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),c);
                    startActivity(i);
                }
            });
        }
    }
    @Override
    public void finish() {
        super.finish();

    }

    protected void populate(int idList, List<?> list) {
        populate(idList, android.R.layout.simple_list_item_1, list);
    }

    protected void populate(int idList, int idItem, List<?> list) {
        ListView lv = getViewById(idList);

        lv.setAdapter(new ArrayAdapter<>(this, idItem, list));
    }

    public <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }
}
