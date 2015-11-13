package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maimengapp.hsh.GoodsDetailActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 社区Fragment界面
 */
public class PostDetailFragment extends BaseFragment
{
    public static PostDetailFragment newInstance()
    {
        PostDetailFragment fragment = new PostDetailFragment();
        return fragment;
    }

    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.linear_msg_container)
    LinearLayout mLinearMsgContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_post_detail, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        String price = "￥" + 139 + "  ";
        String originPrice = "￥" + 179;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvPrice.setText(spannableStringBuilder);
        fillMsgContainer();
    }

    private void fillMsgContainer()
    {
        String name1 = "小顽皮";
        String name2 = "大小王";
        String reply = "回复";
        String msg1 = "：穿着跑步很舒服的样子，帅气的一塌糊涂呀！~~~";
        String msg2 = "：哈哈，那咱们一起去买吧~~~！";
        for (int i = 0; i < 3; i++)
        {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_post_detail_msg_item, null);
            TextView tvText = (TextView) view.findViewById(R.id.tv_text);
            TextView tvTime = (TextView) view.findViewById(R.id.tv_time);
            if (i == 0)
            {
                SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(name1 + msg1);
                spannableStringBuilder1.setSpan(new ForegroundColorSpan(0xFFFC1570), 0, name1.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                tvText.setText(spannableStringBuilder1);
                tvTime.setText("5分钟前");

            } else if (i == 1)
            {
                SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(name2 + reply + name1 + msg1);
                spannableStringBuilder1.setSpan(new ForegroundColorSpan(0xFFFC1570), 0, name2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableStringBuilder1.setSpan(new ForegroundColorSpan(0xFFFC1570), (name2 + reply).length(), (name2 + reply + name1).length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                tvText.setText(spannableStringBuilder1);
                tvTime.setText("2分钟前");
            } else if (i == 2)
            {
                SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(name1 + msg2);
                spannableStringBuilder1.setSpan(new ForegroundColorSpan(0xFFFC1570), 0, name1.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                tvText.setText(spannableStringBuilder1);
                tvTime.setText("1分钟前");
            }
            mLinearMsgContainer.addView(view);
        }

    }

    /***
     * 查看详情点击
     */
    @OnClick(R.id.tv_detail)
    void onDetailClick()
    {
        GoodsDetailActivity.actionGoodsDetail(mActivity, null);
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

}
