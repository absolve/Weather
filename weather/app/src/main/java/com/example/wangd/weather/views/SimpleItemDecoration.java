package com.example.wangd.weather.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wangd.weather.R;

/**
 * 简单的分割线
 */
public class SimpleItemDecoration extends RecyclerView.ItemDecoration{

    private int dividerHeight; //分割线的长度

    public SimpleItemDecoration(Context context) {
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.item_divider);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;//底部增加分割先
    }
}
