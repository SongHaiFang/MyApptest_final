package demo.song.com.myapptest_final.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.song.com.myapptest_final.R;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */
public class Fragment03 extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);

        return view;
    }
}
