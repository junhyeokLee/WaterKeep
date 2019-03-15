package com.junhyeoklee.som.ui.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.junhyeoklee.som.WaterRepository;
import com.junhyeoklee.som.data.model.WaterEntry;

import java.util.List;

public class WaterGraphViewModel extends ViewModel {

    private static final String TAG = AddWaterDateViewModel.class.getSimpleName();
    private final WaterRepository mRepository;

    public WaterGraphViewModel(WaterRepository repository) {
        this.mRepository = repository;
    }

    public LiveData<List<WaterEntry>> getWater_dateMonth(String dateMonth) {
        return mRepository.getWaterDateMonth(dateMonth);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
