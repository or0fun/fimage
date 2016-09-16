package com.baiwanlu.android.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.baiwanlu.android.image.fresco.FrescoImageView;

/**
 * Created by benren.fj on 6/11/16.
 */
public class FImageView extends FrescoImageView {

    public FImageView(Context context) {
        super(context);
    }

    public FImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setImageUrl(String url) {
        super.setImageUrl(url);
    }

    @Override
    public void setFailureImage() {
        super.setFailureImage();
    }

    @Override
    public void placeholderImage(int resource) {
        super.placeholderImage(resource);
    }

    @Override
    public void placeholderImage(Drawable drawable) {
        super.placeholderImage(drawable);
    }

    @Override
    public void setImageRes(int resId) {
        super.setImageRes(resId);
    }

    @Override
    public void setWrapContentEnable(boolean enable) {
        super.setWrapContentEnable(enable);
    }

    public static void clearMemoryCaches() {
        FrescoImageView.clearMemoryCaches();
    }

    public static void clearDiskCaches() {
        FrescoImageView.clearDiskCaches();
    }

    public static void clearCaches() {
        FrescoImageView.clearCaches();
    }

    public static void init(Context context) {
        FrescoImageView.init(context);
    }
}