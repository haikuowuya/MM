package com.maimengapp.hsh.adapter.main;

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

import com.maimengapp.hsh.ActivityDetailActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.model.ActivityItem;

import java.util.List;

/**
 * 首页RecyclerView的适配器
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    /***
     * 店铺信息
     */
    public static final int TYPE_STORE_INFO = 0;

    public static final int TYPE_LIST = 1;

    private LayoutInflater mLayoutInflater;
    private List<ActivityItem> mItemList;
    private BaseActivity mActivity;

    public MainRecyclerAdapter(BaseActivity activity, List<ActivityItem> list)
    {
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mItemList = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;
        View itemView = null;
        switch (viewType)
        {
            case TYPE_STORE_INFO:
                itemView = mLayoutInflater.inflate(R.layout.recycler_main_store_info_item, null);
                viewHolder = new StoreInfoVH(itemView);
                break;
            case TYPE_LIST:
                itemView = mLayoutInflater.inflate(R.layout.recycler_main_list_item, null);
                viewHolder = new ListItemVH(itemView);
                break;
        }
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
        if (holder instanceof ListItemVH)
        {
            ListItemVH itemVH = (ListItemVH) holder;
            final ActivityItem activityItem = mItemList.get(position);
            if (null != activityItem)
            {
                itemVH.mTvZambia.setText(activityItem.zambiaCount);
                itemVH.mTvPrice.setText(activityItem.price);
                itemVH.mTvName.setText(activityItem.name);
                if (activityItem.showActivityName)
                {
                    itemVH.mTvActivityName.setVisibility(View.VISIBLE);
                    itemVH.mTvActivityName.setText(activityItem.activityName);

                } else
                {
                    itemVH.mTvActivityName.setVisibility(View.GONE);
                }

                int resId = mActivity.getResources().getIdentifier(activityItem.image, "mipmap", mActivity.getPackageName());
                if (resId == 0)
                {
                    resId = R.mipmap.ic_shoe_0;
                }
                itemVH.mImageView.setImageResource(resId);

                String price = "￥" + activityItem.price + "  ";
                String originPrice = "￥" + activityItem.originPrice;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
                spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.5f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                itemVH.mTvPrice.setText(spannableStringBuilder);

                itemVH.mTvZambia.setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                activityItem.zambiaCount = (Integer.parseInt(activityItem.zambiaCount) + 1) + "";
                                notifyItemChanged(position);
                            }
                        });
                itemVH.mItemView.setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                ActivityDetailActivity.actionActivityDetail(mActivity, activityItem);
                            }
                        });
            }
        }
    }

    @Override
    public int getItemCount()
    {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == 0)
        {
            return TYPE_STORE_INFO;
        }
        return TYPE_LIST;
    }

    public static final class StoreInfoVH extends RecyclerView.ViewHolder
    {
        private View mItemView;

        public StoreInfoVH(View itemView)
        {
            super(itemView);
            mItemView = itemView;
        }
    }

    public static final class ListItemVH extends RecyclerView.ViewHolder
    {
        private View mItemView;
        /**
         * 活动名称
         */
        private TextView mTvActivityName;
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
            mTvActivityName = (TextView) itemView.findViewById(R.id.tv_activity_name);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            mTvZambia = (TextView) itemView.findViewById(R.id.tv_zambia);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }
}
