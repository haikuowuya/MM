package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.Goods2Fragment;

/**
 * 商品Activity界面
 */
public class GoodsActivity extends BaseTitleActivity
{

    public static void actionGoods(BaseActivity activity)
    {
        Intent intent = new Intent(activity, GoodsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public BaseFragment fragmentAsView()
    {
//        return GoodsFragment.newInstance();
        return Goods2Fragment.newInstance();
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
        return getString(R.string.activity_goods);
    }
}
