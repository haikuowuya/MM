package com.maimengapp.hsh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.util.DensityUtils;

import butterknife.Bind;

/**
 * 活动详情Fragment界面
 */
public class ActivityDetailFragment extends BaseFragment
{
    public static final int COUNT_IMGES = 5;

    public static ActivityDetailFragment newInstance()
    {
        ActivityDetailFragment fragment = new ActivityDetailFragment();
        return fragment;
    }

    /**
     * 价格
     */
    @Bind(R.id.tv_price)
    TextView mTvPrice;

    @Bind(R.id.vp_viewpager)
    ViewPager mViewPager;

    @Bind(R.id.linear_view_container)
    LinearLayout mLinearViewContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_activity_detail, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        String price = "￥" + 226 + "  ";
        String originPrice = "￥" + 359;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.5f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvPrice.setText(spannableStringBuilder);

        int width = DensityUtils.getScreenWidthInPx(mActivity);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, width);
        mViewPager.setLayoutParams(layoutParams);
        mViewPager.setAdapter(genPagerAdapter());

        int viewWidth = DensityUtils.dpToPx(mActivity, 10.f);
        for (int i = 0; i < COUNT_IMGES; i++)
        {
            View view = new View(mActivity);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewWidth, DensityUtils.dpToPx(mActivity, 1f));
            params.gravity = Gravity.CENTER_VERTICAL;
            params.leftMargin = viewWidth / 2;
            params.rightMargin = viewWidth / 2;
            view.setBackgroundResource(R.drawable.actived_indicator_line);
            mLinearViewContainer.addView(view, params);
            if (i == 0)
            {
                view.setActivated(true);

            }
        }
        mViewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener()
                {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
                    {

                    }

                    @Override
                    public void onPageSelected(int position)
                    {
                        for (int i = 0; i < mLinearViewContainer.getChildCount(); i++)
                        {
                            mLinearViewContainer.getChildAt(i).setActivated(false);
                        }
                        mLinearViewContainer.getChildAt(position).setActivated(true);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state)
                    {

                    }
                });
    }

    private PagerAdapter genPagerAdapter()
    {
        PagerAdapter pagerAdapter = new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return COUNT_IMGES;
            }

            @Override
            public boolean isViewFromObject(View view, Object object)

            {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {

                ImageView imageView = new ImageView(mActivity);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(R.mipmap.ic_goods_detail_image);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                container.addView(imageView, params);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View) object);
            }
        };

        return pagerAdapter;
    }

    @Override
    public String getFragmentTitle()
    {
        return getString(R.string.fragment_activity_detail);
    }

}
