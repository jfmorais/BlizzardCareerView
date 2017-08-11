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
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent resposta = new Intent("diablo");
        Log.i("BLIZZARD", "iniciando o servico..." );
        if (intent != null) {
            String btag = intent.getStringExtra("battletag");

            Call<DiabloProfileDTO> call = b.consultaDiablo(btag);
            Response<DiabloProfileDTO> response;

            try{

                response = call.execute();

                if(response.isSuccessful()){
                    Log.i("BLIZZARD", "resposta com sucesso!!!");
                    DiabloProfileDTO profileDTO = response.body();
                    DiabloHeroDTO[] heroDTO = profileDTO.getHeroes();
                    if (profileDTO != null){
                        DiabloProfile profile = new DiabloProfile();
                        profile.setBattleTag(profile.getBattleTag());
                        profile.setParagonLevel(profileDTO.getParagonLevel());
                        for(DiabloHeroDTO h : heroDTO){
                            profile.addHero(new DiabloHero(h.getId(), h.getName(), h.getGender(), h.getIsClass(),h.getLevel()));
                            Log.i("HEROIS", h.toString());
                        }

                        resposta.putExtra("profile", profile);
                        LocalBroadcastManager.getInstance(this).sendBroadcast(resposta);
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        sendBroadcast(resposta);
    }
}
