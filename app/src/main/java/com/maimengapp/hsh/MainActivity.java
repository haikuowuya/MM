package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseSlidingMenuActivity;
import com.maimengapp.hsh.fragment.MainFragment;

public class MainActivity extends BaseSlidingMenuActivity
{
    public static void actionMain(BaseActivity activity)
    {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        setOnRightClickListener(
                R.mipmap.ic_search, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        SearchActivity.actionSearch(mActivity);
                    }
                });

    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.store_name);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return MainFragment.newInstance();
    }
}
