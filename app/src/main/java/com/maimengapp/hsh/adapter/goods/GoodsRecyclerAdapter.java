package com.maimengapp.hsh.adapter.goods;

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
import android.widget.TextView;

import com.maimengapp.hsh.GoodsDetailActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.model.GoodsItem;

import java.util.List;

/**
 * 商品RecyclerView的适配器
 */
public class GoodsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private LayoutInflater mLayoutInflater;
    private List<GoodsItem> mGoodsItems;
    private BaseActivity mActivity;

    public GoodsRecyclerAdapter(BaseActivity activity, List<GoodsItem> list)
    {
        setHasStableIds(true);
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mGoodsItems = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = mLayoutInflater.inflate(R.layout.recycler_goods_grid_item, null);
        RecyclerView.ViewHolder viewHolder = new ListItemVH(itemView);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
        if (holder instanceof ListItemVH)
        {
            ListItemVH itemVH = (ListItemVH) holder;
            final GoodsItem goodsItem = mGoodsItems.get(position);
            if (null != goodsItem)
            {
                itemVH.mTvZambia.setText(goodsItem.zambiaCount);
                itemVH.mTvPrice.setText(goodsItem.price);
                itemVH.mTvName.setText(goodsItem.name);
                String goodsImage = goodsItem.image;
//                System.out.println("goodsImage = " + goodsImage );
                int resId = mActivity.getResources().getIdentifier(goodsImage, "mipmap", mActivity.getPackageName());
                if (resId == 0)
                {
                    resId = R.mipmap.ic_shoe_0;
                }
                itemVH.mImageView.setImageResource(resId);
                String price = "￥" + goodsItem.price + "  ";
                String originPrice = "￥" + goodsItem.originPrice;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
                spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                itemVH.mTvPrice.setText(spannableStringBuilder);

                itemVH.mTvZambia.setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                goodsItem.zambiaCount = (Integer.parseInt(goodsItem.zambiaCount) + 1) + "";
                                notifyItemChanged(position);
                            }
                        });
                itemVH.mItemView.setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                GoodsDetailActivity.actionGoodsDetail(mActivity, goodsItem);
                            }
                        });
            }
        }
    }

    @Override
    public int getItemCount()
    {
        return mGoodsItems.size();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public static final class ListItemVH extends RecyclerView.ViewHolder
    {
        private View mItemView;

        /***
         * 名称
         */
        private TextView mTvName;
        /***
         * 价格
         */
        private TextView mTvPrice;
        /***
         * 点赞个数
         */
        private TextView mTvZambia;

        /***
         * 显示图片
         */
        private ImageView mImageView;

        public ListItemVH(View itemView)
        {
            super(itemView);
            mItemView = itemView;
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            mTvZambia = (TextView) itemView.findViewById(R.id.tv_zambia);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }
}
