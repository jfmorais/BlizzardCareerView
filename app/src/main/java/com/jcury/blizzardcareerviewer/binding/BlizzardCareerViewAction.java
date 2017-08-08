package com.jcury.blizzardcareerviewer.binding;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jcury.blizzardheroviewer.R;
import com.jcury.blizzardheroviewer.databinding.BlizzardCareerViewBinding;
import com.jcury.blizzardcareerviewer.service.SearchDiabloProfileService;

/**
 * Created by jcury on 21/07/2017.
 */

public class BlizzardCareerViewAction {

    private  BlizzardCareerViewBinding binding;

    public BlizzardCareerViewAction(BlizzardCareerViewBinding b){
        this.binding = b;
    }

    public void searchDiablo(View v){
        Context c = v.getContext();
        Log.i("BLIZZARD", "procurando..." + binding.battletag.getText().toString());
        Toast.makeText(v.getContext(),R.string.search_diablo,Toast.LENGTH_LONG).show();

        Intent i = new Intent(c, SearchDiabloProfileService.class);
        i.putExtra("battletag", binding.battletag.getText().toString());
        c.startService(i);

    }

    //TODO
    public void searchWow(View v){

    }
}
