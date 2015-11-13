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

import java.util.LinkedList;

import butterknife.Bind;

/**
 *  精选Fragment界面
 */
public class SelectFragment extends BaseFragment
{
    public static SelectFragment newInstance()
    {
        SelectFragment fragment = new SelectFragment();
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

        mActivityItems = genMockData();
        if(null != mActivityItems)
        {
            mActivityItems.addFirst(new ActivityItem());
            mRecyclerView.setAdapter(new MainRecyclerAdapter(mActivity, mActivityItems));
        }
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_select);
    }

    private LinkedList<ActivityItem> genMockData()
    {
        LinkedList<ActivityItem> items = new LinkedList<>();
        ActivityItem item0 = new ActivityItem("最热人气TOP榜", "男款超轻跑鞋", "84", "169", "279", "ic_shoe_0", true);
        ActivityItem item1 = new ActivityItem("最热人气TOP榜", "女款超轻跑鞋", "99", "169", "299", "ic_shoe_1", false);
        ActivityItem item2 = new ActivityItem("热销爆款", "时尚复古跑鞋", "84", "169", "279", "ic_shoe_2", true);
        ActivityItem item3 = new ActivityItem("热销爆款", "男鞋秋冬复古跑步鞋", "78", "169", "189", "ic_shoe_3", false);
        items.add(item0);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        return items;

    }
}
