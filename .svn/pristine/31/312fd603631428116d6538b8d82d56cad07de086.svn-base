package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.ActivityDetailFragment;

import java.io.Serializable;

/**
 * 活动详情Activity界面
 */
public class ActivityDetailActivity extends BaseTitleActivity
{

    public static final String EXTRA_ITEM = "item";

    public static void actionActivityDetail(BaseActivity activity, Serializable serializable)
    {
        Intent intent = new Intent(activity, ActivityDetailActivity.class);
        intent.putExtra(EXTRA_ITEM, serializable);
        activity.startActivity(intent);
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return ActivityDetailFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_activity_detail);
    }
}
