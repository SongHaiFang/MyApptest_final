package demo.song.com.myapptest_final.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import demo.song.com.myapptest_final.MainActivity;
import demo.song.com.myapptest_final.R;
import demo.song.com.myapptest_final.StartAct;
import demo.song.com.myapptest_final.adapter.NewAdapter;
import demo.song.com.myapptest_final.bean.Bean;
import demo.song.com.myapptest_final.header.MultipleItemQuickAdapter;
import okhttp3.Call;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */
public class Fragment01 extends android.support.v4.app.Fragment {
    private String url = "http://news-at.zhihu.com/api/4/news/latest";
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private NewAdapter adapter;
    private MultipleItemQuickAdapter adapter1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);


        initView(view);
        okGet();



//        adapter.addHeaderView(view1);
        return view;
    }

    private void okGet() {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        String string = response.toString();
                        Bean bean = new Gson().fromJson(string, Bean.class);

                        adapter1 = new MultipleItemQuickAdapter(bean.stories);

                        adapter = new NewAdapter(R.layout.item_one, bean.stories);
                        recyclerView.setAdapter(adapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(linearLayoutManager);

                        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();

                            }
                        });
                        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                            @Override
                            public void onLoadMoreRequested() {
                                Toast.makeText(getActivity(),"上拉",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recy_index);
    }
}
