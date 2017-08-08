package com.jcury.blizzardcareerviewer.controller;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jcury.blizzardheroviewer.R;
import com.jcury.blizzardcareerviewer.binding.BlizzardCareerViewAction;
import com.jcury.blizzardheroviewer.databinding.BlizzardCareerViewBinding;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;
import com.jcury.blizzardcareerviewer.ws.BlizzardEndpoint;

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
    }
}
