package com.achmadqomarudin.animatedbottombar;

import android.graphics.Bitmap;

public class KakaoUser {

    public static String nickname;
    public static String myplace;

    private String member_kakaoname;
    private String member_profile;
    private String member_id;
    private String member_title;
    private String member_context;
    private String member_date;
    private Bitmap member_image;

    public KakaoUser(){

    }
    public KakaoUser(String nickname,String myplace){
        this.nickname = nickname;
        this.myplace = myplace;
    }
    public String getMember_id() {
        return member_id;
    }

    public String getMember_title() {
        return member_title;
    }

    public String getMember_context() {
        return member_context;
    }

    public String getMember_date() {
        return member_date;
    }

    public String getMember_kakaoname() {
        return member_kakaoname;
    }

    public Bitmap getMember_image() {
        return member_image;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setMember_title(String member_title) {
        this.member_title = member_title;
    }

    public void setMember_context(String member_context) {
        this.member_context = member_context;
    }

    public void setMember_date(String member_date) {
        this.member_date = member_date;
    }
    public void setMember_kakaoname(String member_kakaoname) {
        this.member_kakaoname = member_kakaoname;
    }

    public void setMember_image(Bitmap member_image) {
        this.member_image = member_image;
    }
}