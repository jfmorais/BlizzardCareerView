package com.jcury.blizzardcareerviewer.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.jcury.blizzardcareerviewer.domain.model.DiabloHero;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroListFragment extends BlizzardFragment {
    List<DiabloHero> listaHeroi;
    ArrayAdapter<DiabloHero> adapter;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DiabloProfile profile = (DiabloProfile) getActivity().getIntent().getSerializableExtra("profile");
        Log.i("BLIZZARD_HERO_FRAGMENT", profile.getBattleTag());
        listaHeroi = profile.getHerois();
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, listaHeroi);
        setListAdapter(adapter);
    }
}
