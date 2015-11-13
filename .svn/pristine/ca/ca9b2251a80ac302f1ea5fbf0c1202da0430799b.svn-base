package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.ActivityItem;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 关于Fragment界面
 */
public class AboutFragment extends BaseFragment
{
    public static AboutFragment newInstance()
    {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Bind(R.id.tv_desc)
    TextView mTvDesc;

    private LinkedList<ActivityItem> mActivityItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_about, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mTvDesc.setBackgroundResource(0);
    }

    @OnClick(R.id.iv_back)
    void onBack()
    {
        mActivity.onBackPressed();
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_about);
    }

}
