package com.maimengapp.hsh;

import android.content.Intent;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.ContactFragment;

/**
 * 电话界面Activity界面
 */
public class ContactActivity extends BaseTitleActivity
{

    public static void actionContact(BaseActivity activity)
    {
        Intent intent = new Intent(activity, ContactActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return ContactFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_contact);
    }
}
