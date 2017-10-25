package demo.song.com.myapptest_final.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import demo.song.com.myapptest_final.R;
import demo.song.com.myapptest_final.adapter.ViewPagerAdapter;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */

public class Ban extends Activity {

    private ViewPager viewPager;
    private List<View> list;
    private RadioGroup radioGroup;
    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            //自动轮播
            if(msg.what==0){
                int i=viewPager.getCurrentItem();
                viewPager.setCurrentItem(i+1);
                //再次发送
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunbo);
        viewPager=(ViewPager) findViewById(R.id.img_pager);
        radioGroup=(RadioGroup) findViewById(R.id.rg);
        list=new ArrayList<View>();
        //动态添加图片
        ImageView imageView=new ImageView(this);
        //设置图片
        imageView.setImageResource(R.drawable.a8);
        //全屏显示
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //拿到动画
//        Animation animation= AnimationUtils.loadAnimation(this, R.anim.set);
        //设置动画
//        imageView.setAnimation(animation);


        //动态添加图片
        ImageView imageView2=new ImageView(this);
        //设置图片
        imageView2.setImageResource(R.drawable.a8);
        //全屏显示
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);

        //动态添加图片
        ImageView imageView3=new ImageView(this);
        //设置图片
        imageView3.setImageResource(R.drawable.a8);
        //全屏显示
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

        //动态添加图片
        ImageView imageView4=new ImageView(this);
        //设置图片
        imageView4.setImageResource(R.drawable.a8);
        //全屏显示
        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);

        //动态添加RadioButton
        for (int i = 0; i < 4; i++) {
            //创建RadioButton
            RadioButton radioButton=new RadioButton(this);
            radioButton.setPadding(80, 0, 0, 0);
            //对当前radioGroup动态添加radioButton
            radioGroup.addView(radioButton);
            //第一个button默认设置为true
            if(i==0){
                radioButton.setChecked(true);
            }
        }




        //添加数据
        list.add(imageView);
        list.add(imageView2);
        list.add(imageView3);
        list.add(imageView4);


        //将数据交给适配器
        ViewPagerAdapter adapter=new ViewPagerAdapter(list);

        //设置适配器
        viewPager.setAdapter(adapter);
        //设置当前默认的页数
        viewPager.setCurrentItem(list.size()*10000);
        //向Handler发送一条消息
        handler.sendEmptyMessageDelayed(0, 2000);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                //根据位置检查radioGroup下button的ID
                radioGroup.check(radioGroup.getChildAt(arg0%list.size()).getId());
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });




    }

}
