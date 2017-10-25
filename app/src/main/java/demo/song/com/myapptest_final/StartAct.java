package demo.song.com.myapptest_final;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import demo.song.com.myapptest_final.custom.Huayuan;
import demo.song.com.myapptest_final.fragment.MyAct;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */

public class StartAct extends AppCompatActivity {
    private  Huayuan huayuan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        huayuan= (Huayuan) findViewById(R.id.yuan);
//        尝试一下获取屏幕的宽度和高度
        WindowManager wm=this.getWindowManager();
        int w= wm.getDefaultDisplay().getWidth();
        int h=wm.getDefaultDisplay().getHeight();


        ObjectAnimator animator = ObjectAnimator.ofFloat(huayuan, "translationX", 0, w-120);
        ObjectAnimator animatory = ObjectAnimator.ofFloat(huayuan, "translationY", 0, h-200);
//        创建一个存放动画的集合
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animatory);
        set.setDuration(4000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(StartAct.this,"动画执行完了需要跳转",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }
}
