package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.community.CommunityRecyclerAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.util.DataUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 社区Fragment界面
 */
public class CommunityFragment extends BaseFragment
{
    public static CommunityFragment newInstance()
    {
        CommunityFragment fragment = new CommunityFragment();
        return fragment;
    }

    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_community, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(new CommunityRecyclerAdapter(mActivity, DataUtils.genMockCommunityItems()));
    }

    /**
     * 发帖
     */
    @OnClick(R.id.btn_send_post)
    void sendPost()
    {
        mActivity.showToast("发帖");
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

}
