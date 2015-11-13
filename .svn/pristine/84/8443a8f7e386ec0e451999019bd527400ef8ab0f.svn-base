package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.main.MainRecyclerAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.ActivityItem;
import com.maimengapp.hsh.util.DataUtils;

import java.util.LinkedList;

import butterknife.Bind;

/**
 * Created by Steven on 2015/11/3 0003.
 */
public class MainFragment extends BaseFragment
{
    public static MainFragment newInstance()
    {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;

    private LinkedList<ActivityItem> mActivityItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mActivityItems = DataUtils.genMockActivityItems();
        if(null != mActivityItems)
        {
            mActivityItems.addFirst(new ActivityItem());
            mRecyclerView.setAdapter(new MainRecyclerAdapter(mActivity, mActivityItems));
        }
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }


}
