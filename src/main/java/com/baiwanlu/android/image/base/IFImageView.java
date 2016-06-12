package com.baiwanlu.android.image.base;

import android.graphics.drawable.Drawable;

/**
 * 普通图片
 * Created by benren.fj on 6/11/16.
 */
public interface IFImageView {
    void setImageUrl(String url);

    void setImageUrl(String url, int width, int height);

    void setFailureImage();

    void placeholderImage(int resource);

    void placeholderImage(Drawable drawable);

    void setImageRes(int resId);

}
