package com.achmadqomarudin.animatedbottombar;


import com.google.android.gms.maps.model.LatLng;

public class KakaoUser {

    public static String nickname;
    public static String profile;
    public static String myplace;
    public KakaoUser() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public KakaoUser(String nickname, String profile,String myplace) {
        this.nickname = nickname;
        this.profile = profile;
        this.myplace = myplace;
    }

}