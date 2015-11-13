package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.maimengapp.hsh.MainActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/***
 * 充值Fragment界面
 */
public class RechargeFragment extends BaseFragment
{
    public static RechargeFragment newInstance()
    {
        RechargeFragment fragment = new RechargeFragment();
        return fragment;
    }

    /***
     * 充值卡卡号
     */
    @Bind(R.id.et_card_no)
    EditText mEtCardNo;
    /***
     * 充值卡密码
     */
    @Bind(R.id.et_card_pwd)
    EditText mEtCardPwd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_recharge, null);
        return view;
    }

    /**
     * 充值按钮的点击事件
     */
    @OnClick(R.id.btn_ok)
    void doRecharge()
    {
        String cardNo = mEtCardNo.getText().toString();
        if (TextUtils.isEmpty(cardNo))
        {
            mActivity.showToast("请输入充值卡卡号");
            return;
        }
        String cardPwd = mEtCardPwd.getText().toString();
        if (TextUtils.isEmpty(cardPwd))
        {
            mActivity.showToast("请输入充值卡密码");
            return;
        }

        actionMain();

    }

    /**
     * 跳转到首界面
     */
    private void actionMain()
    {
        MainActivity.actionMain(mActivity);
        mActivity.finish();
        mActivity.hideSoftKeyBorard();
    }

    @Override
    public String getFragmentTitle()
    {
        return "登录界面";
    }
}
