package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.PostDetailFragment;

/**
 * Created by Steven on 2015/11/4 0004.
 */
public class PostDetailActivity extends BaseTitleActivity
{

    public static  void  actionPostDetail(BaseActivity activity)
    {
        Intent intent = new Intent(activity, PostDetailActivity.class);
        activity.startActivity(intent);
    }
    @Override
    public BaseFragment fragmentAsView()
    {
        return PostDetailFragment.newInstance();
    }
    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.store_name)+"最经济实惠";
    }
}
