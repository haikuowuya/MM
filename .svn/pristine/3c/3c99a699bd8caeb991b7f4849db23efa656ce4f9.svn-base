package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.maimengapp.hsh.MainActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/***
 * 登录Fragment界面
 */
public class LoginFragment extends BaseFragment
{
    public static LoginFragment newInstance()
    {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    /***
     * 登录用户名
     */
    @Bind(R.id.et_username)
    EditText mEtUserName;
    /***
     * 登录密码
     */
    @Bind(R.id.et_pwd)
    EditText mEtPwd;

    /***
     * 登录
     */
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    /**
     * 免费注册
     */
    @Bind(R.id.tv_register)
    TextView mTvRegister;

    /***
     * 找回密码
     */
    @Bind(R.id.tv_find_pwd)
    TextView mTvFindPwd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, null);
        return view;
    }

    @OnClick(R.id.btn_login)
    void doLogin()
    {
        String userName = mEtUserName.getText().toString();
        if (TextUtils.isEmpty(userName))
        {
            mActivity.showToast("请输入登录手机号码");
            return;
        }
        String pwd = mEtPwd.getText().toString();
        if (TextUtils.isEmpty(pwd))
        {
            mActivity.showToast("请输入登录密码");
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
