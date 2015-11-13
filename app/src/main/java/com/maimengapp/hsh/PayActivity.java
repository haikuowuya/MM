package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.PayFragment;

/**
 * 付款Activity界面
 */
public class PayActivity extends BaseTitleActivity
{

    public static final String  EXTRA_PAY_COUNT="pay_count";
    public static void actionPay(BaseActivity activity,String payCount)
    {
        Intent intent = new Intent(activity, PayActivity.class);
        intent.putExtra(EXTRA_PAY_COUNT,payCount) ;
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return PayFragment.newInstance(getIntent().getStringExtra(EXTRA_PAY_COUNT));
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_pay);
    }
}
