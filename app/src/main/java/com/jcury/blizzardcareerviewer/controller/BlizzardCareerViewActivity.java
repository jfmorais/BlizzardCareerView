package com.jcury.blizzardcareerviewer.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jcury.blizzardheroviewer.R;
import com.jcury.blizzardcareerviewer.binding.BlizzardCareerViewAction;
import com.jcury.blizzardheroviewer.databinding.BlizzardCareerViewBinding;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;
import com.jcury.blizzardcareerviewer.ws.BlizzardEndpoint;

import java.sql.SQLOutput;

/**
 * Created by jcury on 19/07/2017.
 */

public class BlizzardCareerViewActivity extends MotherActitivity {

    EditText battletagView;
    TextView responseView;
    Button procurarView;
    DiabloProfile b;
    BlizzardEndpoint endpoint;
    private BlizzardCareerViewBinding binding;


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("BLIZZARD", "Receiver recebeu-------");
            Bundle extra = intent.getExtras();
            Toast.makeText(context,"RECEBEU",Toast.LENGTH_LONG).show();
            DiabloProfile d = (DiabloProfile) extra.get("profile");
            System.out.println(d.getBattleTag());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blizzard_career_view);
        battletagView = (EditText) findViewById(R.id.battletag);
        binding = DataBindingUtil.setContentView(this, R.layout.blizzard_career_view);
        binding.setController(new BlizzardCareerViewAction(binding));

    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("diablo"));
    }

    @Override
    protected void onPause() {

        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
}
