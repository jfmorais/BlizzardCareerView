package com.jcury.blizzardcareerviewer.ws;

import com.jcury.blizzardcareerviewer.domain.dto.DiabloProfileDTO;
import com.jcury.blizzardcareerviewer.domain.dto.WowCharacterDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jcury on 20/07/2017.
 */

public interface BlizzardEndpoint {

    @GET("d3/profile/{valor}/?locale=en_US&apikey=cyy2xem4kthr77b786svv6du49f3t9em")
    Call<DiabloProfileDTO> consultaDiablo(@Path(value = "valor", encoded = false) String valor);

    @GET("wow/character/nemesis/{valor}?locale=pt_BR&apikey=cyy2xem4kthr77b786svv6du49f3t9em")
    Call<WowCharacterDTO> consultaWow(@Path( value = "valor", encoded = false) String valor);


}
