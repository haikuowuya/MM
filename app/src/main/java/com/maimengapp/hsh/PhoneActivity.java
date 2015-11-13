package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.PhoneFragment;

/**
 * 电话界面Activity界面
 */
public class PhoneActivity extends BaseTitleActivity
{

    public static void actionFreePhone(BaseActivity activity)
    {
        Intent intent = new Intent(activity, PhoneActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return PhoneFragment.newInstance();
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        setOnRightClickListener(
                R.mipmap.ic_contacts, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ContactActivity.actionContact(mActivity);
                    }
                });

    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_free_phone);
    }
}
