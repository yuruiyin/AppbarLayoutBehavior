package com.yuruiyin.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuruiyin.sample.adapter.RecyclerViewAdapter;
import com.yuruiyin.sample.divider.ItemSmallDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <P>Company: 17173</p>
 *
 * @author yuruiyin
 * @version 2018/7/16
 */
public class MyListFragment extends Fragment {

    private static final String PARAM_LIST_DATA = "param_list_data";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    public static MyListFragment getInstance(int tabPos) {
        MyListFragment fragment = new MyListFragment();

        List<String> listData = new ArrayList<>();
        for (int i = 0; i < 30; i ++) {
            listData.add("tab" + (tabPos + 1) + " - item" + (i + 1));
        }

        Bundle bundle = new Bundle();
        bundle.putStringArrayList(PARAM_LIST_DATA, (ArrayList<String>) listData);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this, getView());

        // 初始化RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        List<String> listData = getArguments().getStringArrayList(PARAM_LIST_DATA);
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getContext(), listData));
        mRecyclerView.addItemDecoration(new ItemSmallDecoration(getContext()));
    }

}
