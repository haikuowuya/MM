package com.maimengapp.hsh.adapter.goods;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eowise.recyclerview.stickyheaders.StickyHeadersAdapter;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.model.GoodsItem;

import java.util.List;

/**
 * Created by Steven on 2015/11/4 0004.
 */
public class InitialGoodsHeaderAdapter implements StickyHeadersAdapter<InitialGoodsHeaderAdapter.ViewHolder>
{
    private List<GoodsItem> mGoodsItems;

    public InitialGoodsHeaderAdapter(List<GoodsItem> goodsItems)
    {
        mGoodsItems = goodsItems;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_goods_header_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        viewHolder.mTvType.setText(mGoodsItems.get(position).type);
        viewHolder.mViewView.setBackgroundColor(mGoodsItems.get(position).typeTextColor);
        viewHolder.mTvType.setTextColor(mGoodsItems.get(position).typeTextColor);
    }

    @Override
    public long getHeaderId(int position)
    {
        long typeFlag = -1;
        try
        {
            typeFlag = mGoodsItems.get(position).typeFlag;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return  typeFlag;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvType;
        private View mItemView;
        private View mViewView;


        public ViewHolder(View itemView)
        {
            super(itemView);
            mItemView = itemView;
            mTvType = (TextView) itemView.findViewById(R.id.tv_text);
            mViewView = itemView.findViewById(R.id.view_view);

        }
    }
}
