package com.hlxy.syc.fragmentbestpractice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlxy.syc.fragmentbestpractice.NewsContentActivity;
import com.hlxy.syc.fragmentbestpractice.R;
import com.hlxy.syc.fragmentbestpractice.model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sunYuChen on 2018-09-26
 */
public class NewsTitleFragment extends Fragment{
    private View mView;
    private Boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitleRecyclerView = mView.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        return mView;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++){
            News news = new News();
            news.setTitles("title" + i);
            news.setContent(getRandomLengthContent("content" + i + "."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++){
            builder.append(content);
        }
        return builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }

    //将adapter作为内部类的目的是方便引用内部变量
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> mNewsList;

        public NewsAdapter(List<News> mNewsList) {
            this.mNewsList = mNewsList;
        }

        @NonNull
        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane){
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitles(), news.getContent());
                    }else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitles(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
            News news = mNewsList.get(i);
            viewHolder.newsTitleText.setText(news.getTitles());
        }


        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                newsTitleText = itemView.findViewById(R.id.news_title);
            }
        }

    }

}
