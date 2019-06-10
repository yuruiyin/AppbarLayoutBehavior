package com.yuruiyin.sample.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.yuruiyin.sample.R;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author yuruiyin
 * @version 2017/7/4
 */

public class ItemSmallDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint dividerPaint;

    public ItemSmallDecoration(Context context) {
        this(context, (int) context.getResources().getDimension(R.dimen.common_divider_small_height));
    }

    public ItemSmallDecoration(Context context, int dividerHeight) {
        this.dividerHeight = dividerHeight;
        dividerPaint = new Paint();
        dividerPaint.setColor(ContextCompat.getColor(context, R.color.divider));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount() - 1;
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
