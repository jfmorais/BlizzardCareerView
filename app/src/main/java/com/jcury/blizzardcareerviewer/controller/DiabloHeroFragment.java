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
    TextView nomeView, classeView;
    DiabloHero heroi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroi = (DiabloHero) getArguments().getSerializable("heroi");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout;

        layout = inflater.inflate(R.layout.diablo_hero_fragment_view, container, false);
        nomeView = (TextView) layout.findViewById(R.id.heroi_nome);
        classeView = (TextView) layout.findViewById(R.id.heroi_classe);

        if (heroi != null) {
            nomeView.setText(heroi.getName());
            classeView.setText(heroi.getIsClass());
        }

        return layout;
    }
}
