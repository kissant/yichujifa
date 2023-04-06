package com.yicu.yichujifa.ui.colorpicker.views.color;

import android.annotation.TargetApi;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import com.xieqing.codeutils.util.SizeUtils;

public class VerticalSmoothColorView extends SmoothColorView {

    public VerticalSmoothColorView(Context context) {
        super(context);
    }

    public VerticalSmoothColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSmoothColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public VerticalSmoothColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size = getMeasuredHeight();
        setMeasuredDimension(Math.min(SizeUtils.dp2px(200), size), size);
    }
}
