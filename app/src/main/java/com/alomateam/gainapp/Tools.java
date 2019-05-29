package com.alomateam.gainapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Tools {
    private Context context;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEdit;

    public void putStringItem(String key, String value, String fileName) {
        mEdit.putString(key, value);
        mEdit.apply();
    }

    public String getStringItem(String key, String value, String fileName) {
        return context.getSharedPreferences(fileName, 0).getString(key, value);
    }

    public void setStringArrayPref(Context context, String key, ArrayList<String> values) {
   /*     SharedPreferences prefs = context.getSharedPreferences(key, values);
        SharedPreferences.Editor editor = prefs.edit();

        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++)
            a.put(values.get(i));

        if (!values.isEmpty())
            editor.putString(key, a.toString());
        else
            editor.putString(key, null);
        editor.apply(); */
    }

    public ArrayList<String> getStringArrayPref(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }



}