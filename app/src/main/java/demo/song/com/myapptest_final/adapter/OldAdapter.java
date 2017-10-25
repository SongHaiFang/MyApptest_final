package demo.song.com.myapptest_final.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import demo.song.com.myapptest_final.R;
import demo.song.com.myapptest_final.bean.Bean;
import demo.song.com.myapptest_final.bean.F_Bean;
import demo.song.com.myapptest_final.custom.RoundImageView;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */

public class OldAdapter extends BaseQuickAdapter<F_Bean.OthersBean,BaseViewHolder>{

    public OldAdapter(@LayoutRes int layoutResId, @Nullable List<F_Bean.OthersBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, F_Bean.OthersBean item) {
        helper.setText(R.id.item_name,item.name).addOnClickListener(R.id.item_name);
            loderImage(item.thumbnail
                    , (ImageView) helper.getView(R.id.item_img));
    }
    public  void loderImage(String url,ImageView imageView){
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                    .createDefault(mContext);
        //            String path = Environment.getExternalStorageDirectory().getPath()+"/"+"Pictrues";
    //            File file = new File(path);
    //
    //            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getActivity())
    //                .diskCache(new UnlimitedDiskCache(file))//UnlimitedDiskCache 限制这个图片的缓存路径
    //                .memoryCacheSize(2 * 1024 * 1024)//配置内存缓存的大小  例如 : 2* 1024 * 1024 = 2MB
    //                .build();//配置构建完成   修改缓存位置
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .showImageOnFail(R.mipmap.ic_launcher)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();

            ImageLoader instance = ImageLoader.getInstance();
            instance.init(configuration);
            instance.displayImage(url, imageView ,options);

            //compile 'com.nostra13.universalimageloader:universal-image-loader:1.9.5'
        }


}
