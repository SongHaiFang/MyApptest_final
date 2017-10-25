package demo.song.com.myapptest_final.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import demo.song.com.myapptest_final.R;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */
public class MyAct extends AppCompatActivity{
    String url = "http://news-at.zhihu.com/api/4/theme/11";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myact);
        recyclerView = (RecyclerView) findViewById(R.id.recy_my);


    }
}
