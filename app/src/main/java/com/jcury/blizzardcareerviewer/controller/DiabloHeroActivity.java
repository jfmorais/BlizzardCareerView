package com.jcury.blizzardcareerviewer.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jcury.blizzardheroviewer.R;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroActivity extends BlizzardActitivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diablo_hero_list_view);
    }
}