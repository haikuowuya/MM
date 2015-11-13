package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.maimengapp.hsh.MainActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 付款Fragment界面
 */
public class PayFragment extends BaseFragment
{
    public static final String ARG_PAY_COUNT = "pay_count";

    public static PayFragment newInstance(String payCount)
    {

        PayFragment fragment = new PayFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PAY_COUNT, payCount);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 支付宝付款
     */
    @Bind(R.id.ctv_alipay)
    CheckedTextView mCtvAlipay;
    /***
     * 微信付款
     */
    @Bind(R.id.ctv_wechat)
    CheckedTextView mCtvWechat;
    /**
     * 银联付款
     */
    @Bind(R.id.ctv_unionpay)
    CheckedTextView mCtvUnionpay;
    /***
     * 支付的金额
     */
    @Bind(R.id.tv_pay_count)
    TextView mTvPayCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_pay, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        String payCount = getArguments().getString(ARG_PAY_COUNT);
        mTvPayCount.setText(payCount);

    }

    @OnClick(R.id.ctv_alipay)
    void onAlipay()
    {
        mCtvAlipay.setCheckMarkDrawable(R.mipmap.ic_pay_checked);
        mCtvUnionpay.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
        mCtvWechat.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
    }

    @OnClick(R.id.ctv_unionpay)
    void onUnionpay()
    {
        mCtvUnionpay.setCheckMarkDrawable(R.mipmap.ic_pay_checked);
        mCtvWechat.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
        mCtvAlipay.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
    }

    @OnClick(R.id.ctv_wechat)
    void onWechat()
    {
        mCtvWechat.setCheckMarkDrawable(R.mipmap.ic_pay_checked);
        mCtvUnionpay.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
        mCtvAlipay.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
    }

    @OnClick(R.id.btn_ok)
    void onPayOk()
    {
        MainActivity.actionMain(mActivity);
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_pay);
    }

}
