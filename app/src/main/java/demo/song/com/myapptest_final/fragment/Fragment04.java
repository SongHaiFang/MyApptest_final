package demo.song.com.myapptest_final.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import demo.song.com.myapptest_final.MainActivity;
import demo.song.com.myapptest_final.R;
import demo.song.com.myapptest_final.StartAct;
import demo.song.com.myapptest_final.adapter.NewAdapter;
import demo.song.com.myapptest_final.adapter.OldAdapter;
import demo.song.com.myapptest_final.bean.Bean;
import demo.song.com.myapptest_final.bean.F_Bean;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */
public class Fragment04 extends android.support.v4.app.Fragment {
    String url = "http://news-at.zhihu.com/api/4/themes";
    private View view;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment04, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recy_f);
        okGet();

        return view;
    }
    private void okGet() {
//        new OkHttpClient().newBuilder().addInterceptor();
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
                        F_Bean bean = new Gson().fromJson(string, F_Bean.class);

                        OldAdapter adapter = new OldAdapter(R.layout.item_one, bean.others);
                        recyclerView.setAdapter(adapter);
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),3);
                        recyclerView.setLayoutManager(linearLayoutManager);

                        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(getActivity(), Ban.class);
                                startActivity(intent);
                            }
                        });

                    }
                });
    }
}
