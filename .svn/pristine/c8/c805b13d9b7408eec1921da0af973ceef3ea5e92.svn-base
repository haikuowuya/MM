package com.maimengapp.hsh;

import android.content.Intent;
import android.os.Bundle;

import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.base.BaseTitleActivity;
import com.maimengapp.hsh.fragment.GoodsDetailFragment;
import com.maimengapp.hsh.model.GoodsItem;

import java.io.Serializable;

/**
 * 商品详情Activity界面
 */
public class GoodsDetailActivity extends BaseTitleActivity
{

    public static final String EXTRA_ITEM="item";

    private GoodsItem mGoodsItem ;
    public static void actionGoodsDetail(BaseActivity activity, Serializable serializable)
    {
        Intent intent = new Intent(activity, GoodsDetailActivity.class);
        intent.putExtra(EXTRA_ITEM, serializable);
        activity.startActivity(intent);
    }

    @Override
    public void afterOnCreate(Bundle savedInstanceState)
    {
        super.afterOnCreate(savedInstanceState);
        mGoodsItem = getIntent().getSerializableExtra(EXTRA_ITEM)==null?null: (GoodsItem) getIntent().getSerializableExtra(EXTRA_ITEM);

    }

    @Override
    public BaseFragment fragmentAsView()
    {
        return GoodsDetailFragment.newInstance();
    }

    @Override
    public CharSequence getActivityTitle()
    {
        return getString(R.string.activity_goods_detail);
    }
}
