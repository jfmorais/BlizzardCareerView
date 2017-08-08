package com.jcury.blizzardcareerviewer.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by jcury on 21/07/2017.
 */

public abstract class MotherActitivity extends Activity {

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
}
