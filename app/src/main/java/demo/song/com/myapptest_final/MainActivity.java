package demo.song.com.myapptest_final;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import demo.song.com.myapptest_final.adapter.MyFragmentAdapter;
import demo.song.com.myapptest_final.fragment.Fragment01;
import demo.song.com.myapptest_final.fragment.Fragment02;
import demo.song.com.myapptest_final.fragment.Fragment03;
import demo.song.com.myapptest_final.fragment.Fragment04;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTab();

    }

    private void initTab() {
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());
        MyFragmentAdapter fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.setFragment(list);

        viewPager.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("最新日报");
        tabLayout.getTabAt(1).setText("专栏");
        tabLayout.getTabAt(2).setText("热门");
        tabLayout.getTabAt(3).setText("主题日报");
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.myTab);
        viewPager = (ViewPager) findViewById(R.id.myPager);
    }
}
