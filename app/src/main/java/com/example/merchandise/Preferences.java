package com.example.merchandise;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static final String SHARED = "Marchandise";
    private static Preferences instance;
    private Context ctx;

    private Preferences (Context ctx) { this.ctx = ctx;}
    public static synchronized Preferences getInstance(Context ctx)
    {
        if (instance == null)
        {
            instance = new Preferences (ctx);
        }
        return instance;
    }

    public void SaveUser (String email, String password)
    {
        SharedPreferences sf = ctx.getSharedPreferences(SHARED,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }
    public boolean login()
    {
        SharedPreferences sf = ctx.getSharedPreferences(SHARED,Context.MODE_PRIVATE);
        return sf.getString("email", null) != null;
    }
    public void clear()
    {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
