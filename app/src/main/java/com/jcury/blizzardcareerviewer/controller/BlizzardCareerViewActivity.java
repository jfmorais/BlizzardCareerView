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
import android.widget.EditText;
import android.widget.Toast;

import com.jcury.blizzardheroviewer.R;
import com.jcury.blizzardcareerviewer.binding.BlizzardCareerViewAction;
import com.jcury.blizzardheroviewer.databinding.BlizzardCareerViewBinding;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;

/**
 * Created by jcury on 19/07/2017.
 */

public class BlizzardCareerViewActivity extends BlizzardActitivity {

    EditText battletagView;
    Boolean encontrado = false;
    private BlizzardCareerViewBinding binding;


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("BLIZZARD_MAIN", "Receiver recebeu!");
            DiabloProfile d = (DiabloProfile) intent.getSerializableExtra("profile");
            encontrado = (Boolean) intent.getSerializableExtra("encontrou");

            if (encontrado){
                binding.setProfile(d);
                Intent listarHerois = new Intent(BlizzardCareerViewActivity.this, DiabloHeroListActivity.class);
                listarHerois.putExtra("profile", d);
                startActivity(listarHerois);
            }else{
                Toast.makeText(getApplicationContext(),"BattleTag nao encontrada!!",Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("BLIZZARD_MAIN", "passou pelo CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blizzard_career_view);
        battletagView = (EditText) findViewById(R.id.battletag);
        binding = DataBindingUtil.setContentView(this, R.layout.blizzard_career_view);
        binding.setController(new BlizzardCareerViewAction(binding));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BLIZZARD_MAIN", "passou pelo RESUME");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("diablo"));
    }

    @Override
    protected void onPause() {
        Log.i("BLIZZARD_MAIN", "passou pelo PAUSE");
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
}
