package com.duy.screenfilter.ui;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duy.screenfilter.R;
import com.duy.screenfilter.utils.AppSetting;

/**
 * Created by Duy on 21-Aug-17.
 */

class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    @ColorInt
    private final int[] colors;
    private LayoutInflater inflater;
    private AppSetting setting;

    public ColorAdapter(Context context) {
        this.colors = context.getResources().getIntArray(R.array.filter_colors);
        this.inflater = LayoutInflater.from(context);
        this.setting = AppSetting.newInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_color, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.color.setBackgroundColor(colors[position]);
        holder.color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting.setFilterColor(colors[holder.getAdapterPosition()]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return colors.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView color;

        public ViewHolder(View itemView) {
            super(itemView);
            color = itemView.findViewById(R.id.card_color);
        }
    }
}