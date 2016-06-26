package com.baiwanlu.android.image.base;

/**
 * Created by lufei on 6/27/16.
 */
public interface IFImageLoadListener {
    void onSuccess(String id, int width, int height);

    void onFailure(String id, Throwable throwable);
}
