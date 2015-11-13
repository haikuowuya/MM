package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.SearchFragment;

/**
 * 搜索Activity界面
 */
public class SearchActivity extends BaseTitleActivity
{

    public static void actionSearch(BaseActivity activity)
    {
        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        hideToolBar();
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return SearchFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_about);
    }
}
