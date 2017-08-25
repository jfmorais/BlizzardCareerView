package com.jcury.blizzardcareerviewer.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jcury.blizzardheroviewer.R;

import java.io.Serializable;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroActivity extends BlizzardActitivity {

    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diablo_hero_view);
        fm = getSupportFragmentManager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Serializable model;
        DiabloHeroFragment heroiFragment;
        FragmentTransaction transaction;

        model = getIntent().getSerializableExtra("heroi");
        heroiFragment = new DiabloHeroFragment();
        Bundle b = new Bundle();
        b.putSerializable("heroi", model);
        heroiFragment.setArguments(b);

        transaction = fm.beginTransaction();
        transaction.replace(R.id.heroi_detalhe, heroiFragment, "LAB");
        transaction.commit();
    }
}