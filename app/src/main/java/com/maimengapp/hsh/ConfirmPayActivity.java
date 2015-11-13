package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.ConfirmPayFragment;

/**
 * 确认付款信息Activity界面
 */
public class ConfirmPayActivity extends BaseTitleActivity
{

    public static void actionConfirmPay(BaseActivity activity)
    {
        Intent intent = new Intent(activity, ConfirmPayActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return ConfirmPayFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_confirm_pay);
    }
}
