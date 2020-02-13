package com.example.urbandictonaryapp.repository.remote;

import com.example.urbandictonaryapp.model.UrbanResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UrbanService {

    @Headers({
            "x-rapidapi-key: 957c300581msh26618c202f98780p14065fjsn9f59b06a0015"
    })
    @GET("/define")
    Observable<UrbanResponse> getDefinitions(
            @Query("term") String term
    );

    @GET("/define")
    Single<UrbanResponse> getDefinitionsSingle(
            @Query("term") String term
    );
}
