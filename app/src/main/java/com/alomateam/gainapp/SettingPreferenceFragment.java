package com.alomateam.gainapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingPreferenceFragment extends PreferenceFragment {
    SharedPreferences prefs;
    PreferenceScreen businessScreen;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);
        businessScreen = (PreferenceScreen)findPreference("select_business");

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }
}
