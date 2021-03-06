package com.junhyeoklee.som.ui.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junhyeoklee.som.R;
import com.junhyeoklee.som.data.model.WaterEntry;
import com.junhyeoklee.som.ui.holder.AddWaterViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class WaterListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "TaskAdapter";
    private static final String DATE_FORMAT = "yyy/MM/dd";
    private Context mContext;
    private List<WaterEntry> mWaterEntries;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

    public WaterListAdapter(Context context){
        mContext = context;
    }

    @Override
    public AddWaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_water,parent,false);
        return new AddWaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AddWaterViewHolder waterViewHolder = (AddWaterViewHolder) holder;
        WaterEntry waterEntry = mWaterEntries.get(position);
        if(position == 0){
            waterViewHolder.img_up.setVisibility(View.VISIBLE);
            waterViewHolder.img_down.setVisibility(View.GONE);
        }
        else if(position == mWaterEntries.size()-1){
            waterViewHolder.img_up.setVisibility(View.GONE);
            waterViewHolder.img_down.setVisibility(View.VISIBLE);
            waterViewHolder.v_step.setVisibility(View.VISIBLE);
        }
        else{
            waterViewHolder.img_up.setVisibility(View.GONE);
            waterViewHolder.img_down.setVisibility(View.GONE);
        }

        int waterAmount = waterEntry.getAmount();
        String updateAt = (waterEntry.getDateTime().toString());

        waterViewHolder.waterAmountView.setText(String.valueOf(waterAmount));
        waterViewHolder.updatedAtView.setText(updateAt);

    }

    @Override
    public int getItemCount() {
        if(mWaterEntries == null) {
            return 0;
        }
        return mWaterEntries.size();
    }

    public List<WaterEntry> getmWaterEntries() {
        return mWaterEntries;
    }

    public void setmWaterEntries(List<WaterEntry> waterEntries){
        mWaterEntries = waterEntries;
        notifyDataSetChanged();
    }
}
