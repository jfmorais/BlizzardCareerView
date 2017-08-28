package com.jcury.blizzardcareerviewer.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.jcury.blizzardcareerviewer.domain.model.DiabloHero;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;
import com.jcury.blizzardheroviewer.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroListFragment extends BlizzardListFragment {
    List<DiabloHero> listaHeroi;
    List<String> nomesHerois;
    ArrayAdapter<DiabloHero> adapter;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DiabloProfile profile = (DiabloProfile) getActivity().getIntent().getSerializableExtra("profile");
        Log.i("BLIZZARD_HERO_FRAGMENT", profile.getBattleTag());
        listaHeroi = profile.getHerois();

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaHeroi);
        setListAdapter(adapter);


//        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
//        for (int i=0;i<listaHeroi.size();i++)
//        {
//            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
//            hashMap.put("name",listaHeroi.get(i).getName());
//            arrayList.add(hashMap);//add the hashmap into arrayList
//        }
//        String[] from={"name"};//string array
//        int[] to={R.id.heroi_nome};//int array of views id's
//        SimpleAdapter simpleAdapter=new SimpleAdapter(getContext(),arrayList,R.layout.diablo_hero_item_view,from,to);//Create object and set the parameters for simpleAdapter
//        setListAdapter(simpleAdapter);//sets the adapter for listView

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Serializable heroi = (Serializable) l.getItemAtPosition(position);

        View heroiDetalhe = getActivity().findViewById(R.id.heroi_detalhe);

        if (heroiDetalhe ==  null){
            Intent i = new Intent(getActivity(), DiabloHeroActivity.class);
            i.putExtra("heroi", heroi);
            getActivity().startActivity(i);
        }else{
            DiabloHeroFragment heroiFragment = new DiabloHeroFragment();
            Bundle b = new Bundle();
            b.putSerializable("heroi", heroi);
            heroiFragment.setArguments(b);

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.heroi_detalhe, heroiFragment, "BLIZZARD_HERO_FRAGMENT")
                    .commit();
        }
    }
}
