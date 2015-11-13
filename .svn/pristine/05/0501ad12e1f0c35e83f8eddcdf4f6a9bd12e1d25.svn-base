package com.maimengapp.hsh.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.goods.GoodsRecyclerAdapter;
import com.maimengapp.hsh.adapter.search.SearchKeyGridAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.GoodsItem;
import com.maimengapp.hsh.util.DataUtils;
import com.maimengapp.hsh.util.DensityUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 搜索Fragment界面
 */
public class SearchFragment extends BaseFragment
{
    public static SearchFragment newInstance()
    {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    /***
     * 搜索输入框
     */
    @Bind(R.id.et_search)
    EditText mEtSearch;

    /**
     * 搜索结果展示
     */
    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;
    /**
     * 默认的搜索关键字
     */
    @Bind(R.id.gv_gridview)
    GridView mGridView;

    private LinkedList<GoodsItem> mGoodsItems = new LinkedList<>();
    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (!mGoodsItems.isEmpty())
            {
                mGridView.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
                GoodsRecyclerAdapter goodsRecyclerAdapter = new GoodsRecyclerAdapter(mActivity, mGoodsItems);
                mRecyclerView.setAdapter(goodsRecyclerAdapter);
            } else
            {
                mActivity.showToast("搜索结果为空");
                mRecyclerView.setVisibility(View.GONE);
                if (mGridView.getVisibility() == View.GONE)
                {
                    mGridView.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search, null);
        return view;
    }

    @OnClick(R.id.btn_cancle)
    void onCancle()
    {
        mActivity.hideSoftKeyBorard(mEtSearch);
        mActivity.onBackPressed();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        int paddingLRTB = DensityUtils.dpToPx(mActivity, 10.f);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setVisibility(View.GONE);
        mRecyclerView.setPadding(paddingLRTB / 2, paddingLRTB / 2, paddingLRTB / 2, paddingLRTB / 2);
        mGridView.setVisibility(View.VISIBLE);
        mGridView.setBackgroundColor(0xFFFFFFFF);
        mGridView.setSelector(new ColorDrawable(0x00000000));
        mGridView.setHorizontalSpacing(paddingLRTB);
        mGridView.setVerticalSpacing(paddingLRTB);
        mGridView.setPadding(paddingLRTB, paddingLRTB, paddingLRTB, paddingLRTB);
        mGridView.setNumColumns(4);
        mGridView.setAdapter(new SearchKeyGridAdapter(mActivity, Arrays.asList(getResources().getStringArray(R.array.array_search_key))));
        mGridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        doSearch(parent.getAdapter().getItem(position).toString());
                    }
                });

        mEtSearch.setOnEditorActionListener(
                new TextView.OnEditorActionListener()
                {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
                    {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH)
                        {
                            doSearch(mEtSearch.getText().toString());
                            return true;
                        }
                        return false;
                    }
                });

    }

    /**
     * 执行搜索商品
     */
    private void doSearch(String searchKey)
    {
        if (TextUtils.isEmpty(searchKey))
        {
            mActivity.showToast("请输入搜索关键字");
            return;
        }
        mGoodsItems.clear();
        new Thread(new SearchRunnable(searchKey)).start();
        mActivity.hideSoftKeyBorard(mEtSearch);
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

    private class SearchRunnable implements Runnable
    {

        private String searchKey;

        public SearchRunnable(String searchKey)
        {
            this.searchKey = searchKey;
        }

        @Override
        public void run()
        {
            List<GoodsItem> goodsItemlist = DataUtils.genMockGoodsItems();

            for (GoodsItem goodsItem : goodsItemlist)
            {
                if (goodsItem.name.contains(searchKey))
                {
                    mGoodsItems.add(goodsItem);
                }
            }

            mHandler.sendEmptyMessage(0);
        }
    }

}
