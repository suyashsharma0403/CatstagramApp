package com.example.catstagramv1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {
    //https://run.mocky.io/v3/f3e96481-a7ec-4416-99f6-522623c290cf
    @GET("v3/f3e96481-a7ec-4416-99f6-522623c290cf")
    Call<List<CatPost>> getData();
}
