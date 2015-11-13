package com.maimengapp.hsh.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eowise.recyclerview.stickyheaders.DrawOrder;
import com.eowise.recyclerview.stickyheaders.HeaderStore;
import com.eowise.recyclerview.stickyheaders.OnHeaderClickListener;
import com.eowise.recyclerview.stickyheaders.StickyHeadersItemDecoration;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.GoodsItem;
import com.maimengapp.hsh.util.DensityUtils;

import java.util.List;

import butterknife.Bind;

/**
 * 商品详情Fragment界面
 */
public class GoodsDetailFragment extends BaseFragment
{
    public static GoodsDetailFragment newInstance()
    {
        GoodsDetailFragment fragment = new GoodsDetailFragment();
        return fragment;
    }

    /**
     * 价格
     */
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    /***
     * 图片
     */
    @Bind(R.id.iv_image)
    ImageView mIvImage;

    private List<GoodsItem> mGoodsItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_goods_detail, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        int width = DensityUtils.getScreenWidthInPx(mActivity);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, width);
        mIvImage.setLayoutParams(layoutParams);

        String price = "￥" + 226 + "  ";
        String originPrice = "￥" + 359;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvPrice.setText(spannableStringBuilder);
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

    private class GoodsStickyHeadersItemDecoration extends StickyHeadersItemDecoration
    {
        public GoodsStickyHeadersItemDecoration(HeaderStore headerStore, boolean overlay, DrawOrder drawOrder)
        {
            super(headerStore, overlay, drawOrder);
        }

        public GoodsStickyHeadersItemDecoration(HeaderStore headerStore, boolean overlay)
        {
            super(headerStore, overlay);
        }

        public GoodsStickyHeadersItemDecoration(HeaderStore headerStore)
        {
            super(headerStore);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
        {
            int top = DensityUtils.dpToPx(mActivity, 40.f);
            outRect.set(0, top, 0, 0);
        }
    }
}
