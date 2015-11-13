package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.RechargeActivity;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * 免费电话Fragment界面
 */
public class PhoneFragment extends BaseFragment
{
    public static PhoneFragment newInstance()
    {
        PhoneFragment fragment = new PhoneFragment();
        return fragment;
    }

    /***
     * 话费余额
     */
    @Bind(R.id.tv_balance)
    TextView mTvBalance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_phone, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        String Y_E = "余额\n";
        String balance = "100元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Y_E + balance);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFFFC1570), Y_E.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvBalance.setText(spannableStringBuilder);
    }

    /***
     * 充话费
     */
    @OnClick(R.id.relative_recharge_container)
    void onRechargeClick()
    {
        RechargeActivity.actionRecharge(mActivity);

    }

    /**
     * 长按拨打本店号码
     *
     * @return
     */
    @OnLongClick(R.id.btn_call)
    boolean onCallLongClick()
    {

        return true;
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_free_phone);
    }

}
