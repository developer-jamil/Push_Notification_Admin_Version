package com.jamillabltd.pushnotificationadminversion.model;

import static com.jamillabltd.pushnotificationadminversion.Constants.SERVER_KEY;
import static com.jamillabltd.pushnotificationadminversion.Constants.CONTENT_TYPE;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface { //select interface java class creating time

    @Headers({"Authorization: key = " + SERVER_KEY, "Content-Type:" + CONTENT_TYPE})
    @POST("fcm/send")
    Call<PushNotification> sendNotification(@Body PushNotification notification);

}