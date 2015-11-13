package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eowise.recyclerview.stickyheaders.OnHeaderClickListener;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.goods.GoodsGridAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.GoodsItem;
import com.maimengapp.hsh.util.DataUtils;
import com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView;

import java.util.List;

import butterknife.Bind;

/**
 * 商品Fragment界面
 */
public class Goods2Fragment extends BaseFragment
{
    public static Goods2Fragment newInstance()
    {
        Goods2Fragment fragment = new Goods2Fragment();
        return fragment;
    }

    @Bind(R.id.gv_sticky_gridview)
    StickyGridHeadersGridView mStickyGridHeadersGridView;

    private List<GoodsItem> mGoodsItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_goods2, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        mGoodsItems = DataUtils.genMockGoodsItems();
        if (null != mGoodsItems)
        {
            mStickyGridHeadersGridView.setAdapter(new GoodsGridAdapter(mActivity, mGoodsItems));
        }
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_goods);
    }

    public class OnHeaderClickListenerImpl implements OnHeaderClickListener
    {
        public void onHeaderClick(View header, long headerId)
        {
            mActivity.showToast("" + headerId);
        }
    }

}
