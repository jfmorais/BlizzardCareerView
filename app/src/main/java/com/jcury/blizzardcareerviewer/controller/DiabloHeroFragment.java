package com.jcury.blizzardcareerviewer.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jcury.blizzardcareerviewer.domain.model.DiabloHero;
import com.jcury.blizzardheroviewer.R;

/**
 * Created by jcury on 23/08/2017.
 */

public class DiabloHeroFragment extends  BlizzardFragment{
    TextView nomeView, classeView, hardcoreView, levelView, genderView, deadView;
    DiabloHero heroi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroi = (DiabloHero) getArguments().getSerializable("heroi");
        System.out.println("________CREATET___"+heroi.getName() +heroi.getIsClass()+ heroi.getHardcore()+heroi.getLevel()+heroi.getGender()+heroi.getDead());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout;

        layout = inflater.inflate(R.layout.diablo_hero_fragment_view, container, false);
        nomeView = (TextView) layout.findViewById(R.id.heroi_nome);
        classeView = (TextView) layout.findViewById(R.id.heroi_classe);
        hardcoreView = (TextView) layout.findViewById(R.id.heroi_hardcore);
        levelView = (TextView) layout.findViewById(R.id.heroi_lvl);
        genderView = (TextView) layout.findViewById(R.id.heroi_gender);
        deadView = (TextView) layout.findViewById(R.id.heroi_dead);

        if (heroi != null) {
            System.out.println("___________"+heroi.getName() +heroi.getIsClass()+ heroi.getHardcore()+heroi.getLevel()+heroi.getGender()+heroi.getDead());
            nomeView.setText(heroi.getName());
            classeView.setText(heroi.getIsClass());
            hardcoreView.setText(heroi.getHardcore().equalsIgnoreCase("true")? "Sim" : "Nao");
            levelView.setText(heroi.getLevel());
            genderView.setText(heroi.getGender().equalsIgnoreCase("0")? "Masculino" : "Feminino");
            deadView.setText(heroi.getDead().equalsIgnoreCase("true")? "Morto" : "Vivo");
        }

        return layout;
    }
}
