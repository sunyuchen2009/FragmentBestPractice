package com.hlxy.syc.fragmentbestpractice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlxy.syc.fragmentbestpractice.R;

/**
 * Created by sunYuChen on 2018-09-26
 * 单页加载
 */
public class NewsContentFragment extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_content_frag, container, false);
        return mView;
    }

    public  void refresh(String newsTitle, String newsContent){
        View visibilityLayout = mView.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = mView.findViewById(R.id.news_title);
        TextView newsContentText = mView.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}
