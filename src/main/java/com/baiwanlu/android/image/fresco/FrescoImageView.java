package com.baiwanlu.android.image.fresco;


import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.baiwanlu.android.image.base.IFImageLoadListener;
import com.baiwanlu.android.image.base.IFImageView;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 *
 * Created by benren.fj on 6/11/16.
 */
public class FrescoImageView extends SimpleDraweeView implements IFImageView {

    GenericDraweeHierarchyBuilder builder;
    GenericDraweeHierarchy hierarchy;
    IFImageLoadListener loadListener;

    public FrescoImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
        init();
    }

    public FrescoImageView(Context context) {
        super(context);
        init();
    }

    public FrescoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FrescoImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FrescoImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    protected void init() {
        hierarchy = getHierarchy();
        if (null == hierarchy) {
            builder = new GenericDraweeHierarchyBuilder(getResources());
            hierarchy = builder.build();
            setHierarchy(hierarchy);
        }
    }

    @Override
    public void setImageUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        ViewGroup.LayoutParams params = getLayoutParams();
        if (null != params) {
            int width = params.width;
            int height = params.height;
            if (width > 0 && height > 0) {
                setImageUrl(url, width, height);
                return;
            }
        }
        Uri uri = Uri.parse(url);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setControllerListener(controllerListener)
                .build();
        setController(controller);
    }

    @Override
    public void setImageUrl(String url, IFImageLoadListener loadListener) {
        this.loadListener = loadListener;
        setImageUrl(url);
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
                .setControllerListener(controllerListener)
                .setOldController(getController())
                .build();
        setController(controller);
    }

    @Override
    public void setImageUrl(String url, int width, int height, IFImageLoadListener loadListener) {
        this.loadListener = loadListener;
        setImageUrl(url, width, height);
    }

    @Override
    public void setFailureImage() {

    }

    @Override
    public void placeholderImage(int resource) {
        hierarchy.setPlaceholderImage(resource);
    }
    @Override
    public void placeholderImage(Drawable drawable) {
        hierarchy.setPlaceholderImage(drawable);
    }

    @Override
    public void setImageRes(int resId) {
        setImageUrl("res://" + getContext().getPackageName() +  "/" + resId);
    }

    @Override
    public void setImageRes(int resId, IFImageLoadListener loadListener) {
        this.loadListener = loadListener;
        setImageRes(resId);
    }

    public static void clearMemoryCaches() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearMemoryCaches();
    }

    public static void clearDiskCaches() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearDiskCaches();
    }

    public static void clearCaches() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearMemoryCaches();
        imagePipeline.clearDiskCaches();
    }

    public static void init(Context context) {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setDownsampleEnabled(true).build();
        Fresco.initialize(context, config);
    }

    ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        @Override
        public void onFinalImageSet(
                String id,
                @Nullable ImageInfo imageInfo,
                @Nullable Animatable anim) {
            if (imageInfo == null) {
                if (null != loadListener) {
                    loadListener.onSuccess(id, 0, 0);
                }
                return;
            }
            if (null != loadListener) {
                loadListener.onSuccess(id, imageInfo.getWidth(), imageInfo.getHeight());
            }
        }

        @Override
        public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
            FLog.d("FrescoImageView", "Intermediate image received");
        }

        @Override
        public void onFailure(String id, Throwable throwable) {
            FLog.e(getClass(), throwable, "Error loading %s", id);
            if (null != loadListener) {
                loadListener.onFailure(id, throwable);
            }
        }
    };
}
