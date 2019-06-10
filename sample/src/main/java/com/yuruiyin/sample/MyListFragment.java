package com.yuruiyin.sample;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
