package com.baiwanlu.android.image.fresco;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * gif动图
 * Created by benren.fj on 6/11/16.
 */
public class FrescoGifImageView extends FrescoImageView {
    public FrescoGifImageView(Context context) {
        super(context);
    }

    public FrescoGifImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrescoGifImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FrescoGifImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setImageUrl(String url, int width, int height) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri uri = Uri.parse(url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(getController())
                .setControllerListener(new BaseControllerListener<>())
                .setAutoPlayAnimations(true)
                .build();
        setController(controller);
    }

    @Override
    public void setImageURI(Uri uri) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        setController(controller);

    }
}