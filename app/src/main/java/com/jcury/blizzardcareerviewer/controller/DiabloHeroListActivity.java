package com.jcury.blizzardcareerviewer.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;
import com.jcury.blizzardheroviewer.R;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroListActivity extends BlizzardActitivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diablo_hero_list_view);

        Intent intent = getIntent();
        DiabloProfile profile = (DiabloProfile) intent.getSerializableExtra("profile");
        Log.i("BLIZZARD_HERO_LIST", profile.getBattleTag());
    }
}
