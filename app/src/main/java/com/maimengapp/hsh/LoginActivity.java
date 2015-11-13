package com.maimengapp.hsh;

import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseNoTitleActivity;
import com.maimengapp.hsh.fragment.LoginFragment;

/**
 *  登录Activity
 */
public class LoginActivity extends BaseNoTitleActivity
{
    @Override
    public BaseFragment fragmentAsView()
    {
        return LoginFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return "登录";
    }
}
