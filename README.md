# fimage

简便的图片库，封装了fresco,非常方便使用。

## gradle 依赖

    compile 'com.baiwanlu.android:fimage:1.0.0"

## 首先在application的onCreate里调用

    /**
    * Created by benren.fj on 6/11/16.
    */
    public class MainApplication extends Application {
       @Override
       public void onCreate() {
          super.onCreate();

          FImageView.init(this);
        }
    }
    
## 使用简单示例

    <com.baiwanlu.android.image.FImageView
        android:id="@+id/demo_image_view"
        android:layout_width="150dp"
        android:layout_height="150dp" />
        
        
    FImageView imageView = (FImageView) findViewById(R.id.demo_image_view);
    imageView.setImageUrl("http://t.cn/R5JfqHu");
        

### FImageView   普通图片

    //直接设置url，其他都不用管
    public void setImageUrl(String url);

    //直接设置res id，其他都不用管
    public void setImageRes(int resId);

    //静态方法，用来手动清除内存里的缓存
    public static void clearMemoryCaches();

    //静态方法，用来手动清除文件里的缓存
    public static void clearDiskCaches();
    
    //静态方法，用来手动清除所有缓存
    public static void clearCaches();

    //静态方法，初始化，放在application的oncreate里 
    public static void init(Context context);

### FCircleImageView  圆形图片

包含FImageView的接口，另外包含以下接口
    
    //设置边框颜色
    void setBorderColor(int color);
    
    //设置边框宽度
    void setBorderWidth(int width);
    

### FGifImageView  动态图

  包含FImageView的接口, 使用方法一致




