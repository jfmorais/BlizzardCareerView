package com.jcury.blizzardcareerviewer.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.jcury.blizzardcareerviewer.domain.dto.DiabloProfileDTO;
import com.jcury.blizzardcareerviewer.domain.model.DiabloHero;
import com.jcury.blizzardcareerviewer.domain.model.DiabloProfile;
import com.jcury.blizzardcareerviewer.ws.BlizzardEndpoint;
import com.jcury.blizzardcareerviewer.domain.dto.DiabloHeroDTO;
import com.jcury.blizzardcareerviewer.util.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Response;

public class SearchDiabloProfileService extends IntentService {

    private static final String TAG = "BLIZZARD";
    BlizzardEndpoint b;

    public SearchDiabloProfileService() {
        super("SearchDiabloProfileService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        b = RetrofitHelper.with(this).createBlizzardEndpoint();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("BLIZZARD_SERVICE", " passei pelo DESTROY" + getClass().getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent resposta = new Intent("diablo");
        Log.i("BLIZZARD_SERVICE", "iniciando o servico..." );
        if (intent != null) {
            String btag = intent.getStringExtra("battletag");

            Call<DiabloProfileDTO> call = b.consultaDiablo(btag);
            Response<DiabloProfileDTO> response;

            try{

                response = call.execute();

                if(response.isSuccessful()){
                    Log.i("BLIZZARD_SERVICE", "resposta com sucesso!!!");
                    DiabloProfileDTO profileDTO = response.body();
                    DiabloHeroDTO[] heroDTO = profileDTO.getHeroes();
                    if ( heroDTO != null){
                        Log.i("BLIZZARD_SERVICE", "encontrou a BTAG!!!");
                        DiabloProfile profile = new DiabloProfile();
                        profile.setBattleTag(profileDTO.getBattleTag());
                        profile.setParagonLevel(profileDTO.getParagonLevel());
                        for(DiabloHeroDTO h : heroDTO){
                            profile.addHero(h);
                            Log.i("HEROIS", h.toString());
                        }

                        resposta.putExtra("encontrou", Boolean.TRUE);
                        resposta.putExtra("profile", profile);

                    }else{
                        Log.i("BLIZZARD_SERVICE", "NAO encontrou a BTAG!!!");
                        resposta.putExtra("encontrou", Boolean.FALSE);
                    }
                }
                LocalBroadcastManager.getInstance(this).sendBroadcast(resposta);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        sendBroadcast(resposta);
    }
}
