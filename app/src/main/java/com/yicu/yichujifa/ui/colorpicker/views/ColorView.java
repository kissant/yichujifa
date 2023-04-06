package com.yicu.yichujifa.ui.colorpicker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import android.util.AttributeSet;

import com.xieqing.codeutils.util.SizeUtils;

public class ColorView extends RenderableView {

    @ColorInt
    int color = Color.BLACK;
    float outlineSize;
    Paint tilePaint;

    public ColorView(final Context context) {
        super(context);
    }

    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        outlineSize = SizeUtils.dp2px(2);

        tilePaint = new Paint();
        tilePaint.setAntiAlias(true);
        tilePaint.setStyle(Paint.Style.FILL);
        tilePaint.setColor(Color.LTGRAY);
    }

    /**
     * Set the color int for this view to draw.
     *
     * This starts an asynchronous "render" of a bitmap
     * in a background thread that will draw the color
     * on top of a tiled grid of alternating squares
     * that will be drawn as the view content upon
     * completion.
     *
     * @param color         The color int for the view to draw.
     */
    public void setColor(@ColorInt int color) {
        this.color = color;
        startRender();
    }

    @Override
    public void render(Canvas canvas) {
        if (Color.alpha(color) < 255) {
            int outline = Math.round(outlineSize) * 4;
            for (int x = 0; x < canvas.getWidth(); x += outline) {
                for (int y = x % (outline * 2) == 0 ? 0 : outline; y < canvas.getWidth(); y += (outline * 2)) {
                    canvas.drawRect(x, y, x + outline, y + outline, tilePaint);
                }
            }
        }

        canvas.drawColor(color);
    }
}