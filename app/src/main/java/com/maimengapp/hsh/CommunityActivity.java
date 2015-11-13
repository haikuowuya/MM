package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.CommunityFragment;

/**
 * Created by Steven on 2015/11/4 0004.
 */
public class CommunityActivity extends BaseTitleActivity
{

    public static  void  actionCommunity(BaseActivity activity)
    {
        Intent intent = new Intent(activity, CommunityActivity.class);
        activity.startActivity(intent);
    }
    @Override
    public BaseFragment fragmentAsView()
    {
        return CommunityFragment.newInstance();
    }
    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.store_name)+"社区";
    }
}
