package com.ainnaya.timber.lastfmapi.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.ainnaya.timber.lastfmapi.LastFmClient;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christoph on 17.07.16.
 */
public class LastfmUserSession {
    private static final String USERNAME = "name";
    private static final String TOKEN = "key";
    private static LastfmUserSession session;
    @SerializedName(USERNAME)
    public String mUsername;
    @SerializedName(TOKEN)
    public String mToken;

    public static LastfmUserSession getSession(Context context) {
        if (session != null) return session;
        SharedPreferences preferences = context.getSharedPreferences(LastFmClient.PREFERENCES_NAME, Context.MODE_PRIVATE);
        session = new LastfmUserSession();
        session.mToken = preferences.getString(TOKEN, null);
        session.mUsername = preferences.getString(USERNAME, null);
        return session;
    }

    public boolean isLogedin() {
        return session.mToken != null && session.mUsername != null;
    }

    public void update(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(LastFmClient.PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (this.mToken == null || this.mUsername == null) {
            editor.clear();
        } else {
            editor.putString(TOKEN, this.mToken);
            editor.putString(USERNAME, this.mUsername);
        }
        editor.apply();
    }
}
