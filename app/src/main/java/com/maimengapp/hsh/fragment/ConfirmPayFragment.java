package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maimengapp.hsh.PayActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 确认付款信息Fragment界面
 */
public class ConfirmPayFragment extends BaseFragment
{
    public static ConfirmPayFragment newInstance()
    {
        ConfirmPayFragment fragment = new ConfirmPayFragment();
        return fragment;
    }

    /***
     * 不参与打折金额
     */
    @Bind(R.id.linear_discount_container)
    LinearLayout mLinearDiscountContainer;
    /**
     * 可用红包
     */
    @Bind(R.id.ctv_red_packet)
    CheckedTextView mCtvRedPacket;
    /**
     * 可用余额
     */
    @Bind(R.id.ctv_balance)
    CheckedTextView mCtvBalance;
    /***
     * 实付金额
     */
    @Bind(R.id.tv_pay_count)
    TextView mTvPayCount;
    /**
     * 是否参与打折
     */
    @Bind(R.id.tv_discount)
    TextView mTvDiscount;

    /***
     * 不参与打折金额
     */
    @Bind(R.id.et_discount_fee)
    EditText mEtDiscountFee;

    private int mPayCount;
    private int mRedPacketCount = 80;
    private int mBalanceCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_confirm_pay, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        calcPayMoney();

    }

    @OnClick(R.id.tv_discount)
    void onDiscount()
    {
        mEtDiscountFee.setText("");
        if (mLinearDiscountContainer.getVisibility() == View.GONE)
        {
            mLinearDiscountContainer.setVisibility(View.VISIBLE);
            mTvDiscount.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_pay_checked, 0, 0, 0);
        } else
        {
            mLinearDiscountContainer.setVisibility(View.GONE);
            mTvDiscount.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_pay_unchecked, 0, 0, 0);
        }

    }

    @OnClick(R.id.ctv_balance)
    void onBalance()
    {
        mCtvBalance.setCheckMarkDrawable(R.mipmap.ic_pay_checked);
        mCtvRedPacket.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
        mBalanceCount = 20;
        mRedPacketCount = 0;
        calcPayMoney();
    }

    @OnClick(R.id.ctv_red_packet)
    void onRedPacket()
    {
        mCtvRedPacket.setCheckMarkDrawable(R.mipmap.ic_pay_checked);
        mCtvBalance.setCheckMarkDrawable(R.mipmap.ic_pay_unchecked);
        mBalanceCount = 0;
        mRedPacketCount = 80;
        calcPayMoney();
    }

    private void calcPayMoney()
    {
        mPayCount = 100 - mBalanceCount - mRedPacketCount;
        String hintText = "实付金额：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(hintText + mPayCount + "元");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_price_color)), hintText.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvPayCount.setText(spannableStringBuilder);
    }

    /***
     * 点击确定按钮跳转到支付页面
     */
    @OnClick(R.id.btn_ok)
    void toPay()
    {
        PayActivity.actionPay(mActivity, mPayCount+"元");
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_pay);
    }

}
