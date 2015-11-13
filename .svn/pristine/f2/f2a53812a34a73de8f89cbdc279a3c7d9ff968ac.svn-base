package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseNoTitleActivity;
import com.maimengapp.hsh.fragment.AboutFragment;

/**
 * 关于本店Activity界面
 */
public class AboutActivity extends BaseNoTitleActivity
{

    public static void actionAbout(BaseActivity activity)
    {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return AboutFragment.newInstance();
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);


    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_about);
    }
}
