package com.maimengapp.hsh.adapter.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maimengapp.hsh.PostDetailActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.model.CommunityItem;

import java.util.List;

/**
 * 社区RecyclerView适配器
 */
public class CommunityRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_LIST = 1;
    private BaseActivity mActivity;
    private List<CommunityItem> mCommunityItemList;

    public CommunityRecyclerAdapter(BaseActivity activity, List<CommunityItem> communityItemList)
    {
        mActivity = activity;
        mCommunityItemList = communityItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;
        View itemView = null;
        switch (viewType)
        {
            case TYPE_TITLE:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_community_title_item, null);
                viewHolder = new TitleVH(itemView);
                break;
            case TYPE_LIST:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_community_list_item, null);
                viewHolder = new ListItemVH(itemView);
        }
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        CommunityItem communityItem = mCommunityItemList.get(position);
        if (holder instanceof TitleVH)
        {
            TitleVH titleVH = (TitleVH) holder;
            titleVH.mLinearMsgContainer.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            mActivity.showToast("我的消息");
                        }
                    });
            titleVH.mLinearPostContainer.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            mActivity.showToast("我的帖子");
                        }
                    });
        } else if (holder instanceof ListItemVH)
        {
            ListItemVH listItemVH = (ListItemVH) holder;
            if (communityItem != null)
            {
                listItemVH.mIvImage.setImageResource(communityItem.image);
                listItemVH.mTvEditCount.setText(communityItem.editCount);
                listItemVH.mTvSearchCount.setText(communityItem.searchCount);
                listItemVH.mTvZambiaCount.setText(communityItem.zambiaCount);
                listItemVH.mTvTime.setText(communityItem.dateTime);
                listItemVH.mTvTitle.setText(communityItem.title);
                listItemVH.mTvName.setText(communityItem.name);
                if (communityItem.showType)
                {
                    listItemVH.mTvType.setText(communityItem.type);
                    listItemVH.mTvType.setTextColor(communityItem.typeTextColor);
                    listItemVH.mTvType.setCompoundDrawablesWithIntrinsicBounds(communityItem.typeImage, 0, 0, 0);
                    ((View) listItemVH.mTvType.getParent()).setVisibility(View.VISIBLE);
                } else
                {
                    ((View) listItemVH.mTvType.getParent()).setVisibility(View.GONE);
                }
            }
            listItemVH.mLinearListContainer.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            PostDetailActivity.actionPostDetail(mActivity);
                        }
                    });
        }
    }

    @Override
    public int getItemCount()
    {
        return 5;
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == 0)
        {
            return TYPE_TITLE;
        }
        return TYPE_LIST;
    }

    public static class TitleVH extends RecyclerView.ViewHolder
    {
        private View mItemView;

        private LinearLayout mLinearPostContainer;
        private LinearLayout mLinearMsgContainer;

        public TitleVH(View itemView)
        {
            super(itemView);
            mItemView = itemView;
            mLinearMsgContainer = (LinearLayout) itemView.findViewById(R.id.linear_msg_container);
            mLinearPostContainer = (LinearLayout) itemView.findViewById(R.id.linear_post_container);
        }
    }

    public static class ListItemVH extends RecyclerView.ViewHolder
    {
        private TextView mTvType;
        private TextView mTvTitle;
        private TextView mTvName;
        private ImageView mIvImage;
        private TextView mTvTime;
        private TextView mTvSearchCount;
        private TextView mTvEditCount;
        private TextView mTvZambiaCount;
        private LinearLayout mLinearListContainer;

        public ListItemVH(View itemView)
        {
            super(itemView);
            mTvType = (TextView) itemView.findViewById(R.id.tv_type);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_text);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
            mTvSearchCount = (TextView) itemView.findViewById(R.id.tv_search_count);
            mTvEditCount = (TextView) itemView.findViewById(R.id.tv_edit_count);
            mTvZambiaCount = (TextView) itemView.findViewById(R.id.tv_zambia_count);
            mIvImage = (ImageView) itemView.findViewById(R.id.iv_image);
            mLinearListContainer = (LinearLayout) itemView.findViewById(R.id.linear_list_container);

        }
    }
}
