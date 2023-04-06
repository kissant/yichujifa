package com.yicu.yichujifa.ui.colorpicker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.ColorInt;
import android.util.AttributeSet;

import com.yicu.yichujifa.ui.colorpicker.utils.ColorUtils;

import esqeee.xieqing.com.eeeeee.R;

public class CircleColorView extends ColorView {

    Paint outlinePaint;

    public CircleColorView(Context context) {
        super(context);
    }

    public CircleColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleColorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        outlinePaint = new Paint();
        outlinePaint.setAntiAlias(true);
        outlinePaint.setDither(true);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setStrokeWidth(outlineSize);
        outlinePaint.setColor(Color.BLACK);
    }

    @Override
    public void setColor(@ColorInt int color) {
        int neutralColor = ColorUtils.fromAttr(getContext(), R.attr.neutralColor,
                ColorUtils.fromAttrRes(getContext(), android.R.attr.textColorPrimary, R.color.colorPickerDialog_neutral));

        outlinePaint.setColor(ColorUtils.isColorDark(neutralColor)
                ? (ColorUtils.isColorDark(color) ? Color.TRANSPARENT : neutralColor)
                : (ColorUtils.isColorDark(color) ? neutralColor : Color.TRANSPARENT));

        super.setColor(color);
    }

    @Override
    public void render(Canvas canvas) {
        int size = Math.min(canvas.getWidth(), canvas.getHeight());

        Path path = new Path();
        path.addCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, size / 2, Path.Direction.CW);
        canvas.clipPath(path);

        super.render(canvas);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (size / 2) - (outlineSize / 2), outlinePaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size = getMeasuredWidth();
        setMeasuredDimension(size, size);
    }

}