package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.RechargeFragment;

/**
 * Created by Steven on 2015/11/4 0004.
 */
public class RechargeActivity extends BaseTitleActivity
{

    public static  void actionRecharge(BaseActivity activity )
    {
        Intent intent = new Intent(activity, RechargeActivity.class);
        activity.startActivity(intent);
    }
    @Override
    public BaseFragment fragmentAsView()
    {
        return RechargeFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_recharge);
    }
}
