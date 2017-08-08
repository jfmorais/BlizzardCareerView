package com.jcury.blizzardcareerviewer.util;

import android.content.Context;

import com.jcury.blizzardcareerviewer.ws.BlizzardEndpoint;
import com.jcury.blizzardheroviewer.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcury on 20/07/2017.
 */

public class RetrofitHelper {
    private Context context;
    private Retrofit retrofit;

    private RetrofitHelper(Context context){
        super();
        this.context = context;
        this.retrofit = new Retrofit
                .Builder()
                .baseUrl(context.getString(R.string.battlet_tag_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public BlizzardEndpoint createBlizzardEndpoint(){
        return retrofit.create(BlizzardEndpoint.class);
    }

    public static RetrofitHelper with(Context c){
        return new RetrofitHelper(c);
    }
}
