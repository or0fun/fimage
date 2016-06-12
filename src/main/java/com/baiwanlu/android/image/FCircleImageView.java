package com.baiwanlu.android.image;

import android.content.Context;
import android.util.AttributeSet;

import com.baiwanlu.android.image.fresco.FrescoCircleImageView;

/**
 * Created by benren.fj on 6/11/16.
 */
public class FCircleImageView extends FrescoCircleImageView {

    public FCircleImageView(Context context) {
        super(context);
    }

    public FCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FCircleImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setBorderColor(int color) {
        super.setBorderColor(color);
    }

    @Override
    public void setBorderWidth(int width) {
        super.setBorderWidth(width);
    }
}
