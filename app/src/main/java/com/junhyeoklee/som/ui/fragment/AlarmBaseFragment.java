package com.junhyeoklee.som.ui.fragment;

import android.os.Bundle;

import com.junhyeoklee.som.Alarmio;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class AlarmBaseFragment extends Fragment implements Alarmio.AlarmioListener {

    private Alarmio alarmio;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alarmio = (Alarmio) getContext().getApplicationContext();
        alarmio.addListener(this);
    }

    @Override
    public void onDestroy() {
        alarmio.removeListener(this);
        super.onDestroy();
    }

    Alarmio getAlarmio() {
        return alarmio;
    }

    public void notifyDataSetChanged() {
    }

    @Override
    public void onAlarmsChanged() {
    }

    @Override
    public void onTimersChanged() {
    }
}
