package demo.song.com.myapptest_final.adapter;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import demo.song.com.myapptest_final.R;
import demo.song.com.myapptest_final.bean.Bean;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */

public class NewAdapter extends BaseQuickAdapter<Bean.StoriesBean,BaseViewHolder>{

    public NewAdapter(@LayoutRes int layoutResId, @Nullable List<Bean.StoriesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean.StoriesBean item) {
//        helper.setText(R.id.tweetName, item.getUserName())
//                .setText(R.id.tweetText, item.getText())
//                .setText(R.id.tweetDate, item.getCreatedAt())
//                .setVisible(R.id.tweetRT, item.isRetweet())
//                .addOnClickListener(R.id.tweetAvatar)
//                .addOnClickListener(R.id.tweetName)
//                .linkify(R.id.tweetText);
//        helper.setText(R.id.item_name, item.title)
//                .setVisible(R.id.item_name,true)
//                .addOnClickListener(R.id.item_name)
//                .linkify(R.id.item_name);
        helper.setText(R.id.item_name,item.title).addOnClickListener(R.id.item_name);

//        helper.setText(R.id.item_name,item.title);

        loderImage(item.images.get(0).toString(),(ImageView) helper.getView(R.id.item_img));
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
