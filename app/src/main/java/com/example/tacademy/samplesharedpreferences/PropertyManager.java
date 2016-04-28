package com.example.tacademy.samplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Tacademy on 2016-04-28.
 */
public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if(instance==null){
            instance=new PropertyManager();
        }
        return instance;
    }
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;       //이걸 얻어오려면 context가 필요하다

    public PropertyManager() {
        Context context=MyApplication.getContext();
        mPref= PreferenceManager.getDefaultSharedPreferences(context);
        mEditor=mPref.edit();
    }
    public static final String KEY_EMAIL="email";
    public static final String KEY_PASSWORD="password";
    public String getEmail(){
        return mPref.getString(KEY_EMAIL,"");

    }
    public String getPassword(){
        return mPref.getString(KEY_PASSWORD,"");
    }
    public void setEmail(String s)
    {
        this.mEditor.putString(KEY_EMAIL,s);
        this.mEditor.commit();

    }
    public void setPassword(String s){
        this.mEditor.putString(KEY_PASSWORD,s);
        this.mEditor.commit();
    }
}
