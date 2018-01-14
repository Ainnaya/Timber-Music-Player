package com.ainnaya.timber.lastfmapi.models;

import com.ainnaya.timber.lastfmapi.LastFmClient;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christoph on 17.07.16.
 */
public class UserLoginQuery {
    public static final String Method = "auth.getMobileSession";
    private static final String USERNAME_NAME = "username";
    private static final String PASSWORD_NAME = "password";
    @SerializedName(USERNAME_NAME)
    public String mUsername;
    @SerializedName(PASSWORD_NAME)
    public String mPassword;

    public UserLoginQuery(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getSignature() {
        return "api_key" + LastFmClient.API_KEY + "method" + Method + "password" + mPassword + "username" + mUsername + LastFmClient.API_SECRET;
    }
}
