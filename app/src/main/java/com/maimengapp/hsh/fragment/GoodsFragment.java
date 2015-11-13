package com.maimengapp.hsh.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eowise.recyclerview.stickyheaders.DrawOrder;
import com.eowise.recyclerview.stickyheaders.HeaderStore;
import com.eowise.recyclerview.stickyheaders.OnHeaderClickListener;
import com.eowise.recyclerview.stickyheaders.StickyHeadersAdapter;
import com.eowise.recyclerview.stickyheaders.StickyHeadersBuilder;
import com.eowise.recyclerview.stickyheaders.StickyHeadersItemDecoration;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.goods.GoodsRecyclerAdapter;
import com.maimengapp.hsh.adapter.goods.InitialGoodsHeaderAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.GoodsItem;
import com.maimengapp.hsh.util.DataUtils;
import com.maimengapp.hsh.util.DensityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * 商品Fragment界面
 */
public class GoodsFragment extends BaseFragment
{
    public static GoodsFragment newInstance()
    {
        GoodsFragment fragment = new GoodsFragment();
        return fragment;
    }

    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;

    private List<GoodsItem> mGoodsItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_goods, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mGoodsItems = DataUtils.genMockGoodsItems();
        if (null != mGoodsItems)
        {
            GoodsRecyclerAdapter goodsRecyclerAdapter = new GoodsRecyclerAdapter(mActivity, mGoodsItems);
            mRecyclerView.setAdapter(goodsRecyclerAdapter);
            boolean isOverlay = true;
            boolean isSticky = true;
            InitialGoodsHeaderAdapter headersAdapter = new InitialGoodsHeaderAdapter(mGoodsItems);
            StickyHeadersItemDecoration decoration = new StickyHeadersBuilder().setSticky(isSticky).setDrawOrder(DrawOrder.OverItems).setAdapter(goodsRecyclerAdapter).setOnHeaderClickListener(new OnHeaderClickListenerImpl()).setRecyclerView(mRecyclerView).setStickyHeadersAdapter(new InitialGoodsHeaderAdapter(mGoodsItems), isOverlay).build();
//            mRecyclerView.addItemDecoration(decoration);

            GoodsHeaderStore store = new GoodsHeaderStore(mRecyclerView, headersAdapter, isSticky);
            GoodsStickyHeadersItemDecoration goodsStickyHeadersItemDecoration = new GoodsStickyHeadersItemDecoration(store, true, DrawOrder.OverItems);
            mRecyclerView.addItemDecoration(goodsStickyHeadersItemDecoration);

        }
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
        private GoodsHeaderStore mGoodsHeaderStore;

        public GoodsStickyHeadersItemDecoration(GoodsHeaderStore headerStore, boolean overlay, DrawOrder drawOrder)
        {
            super(headerStore, overlay, drawOrder);
            mGoodsHeaderStore = headerStore;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
        {
            int top = DensityUtils.dpToPx(mActivity, 40.f);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
            RecyclerView.ViewHolder holder = parent.getChildViewHolder(view);
            int itemPosition = RecyclerViewHelper.convertPreLayoutPositionToPostLayout(parent, holder.getPosition());
            System.out.println("position = " + itemPosition +"  " +mGoodsHeaderStore.isHeader(holder));
            if (mGoodsItems.get(itemPosition).showType)
            {
                outRect.set(0, top, 0, 0);
            } else
            {
                outRect.set(0, 0, 0, 0);
            }
        }
    }

    private class GoodsHeaderStore extends HeaderStore
    {

        private RecyclerView parent = null;
        private StickyHeadersAdapter adapter = null;
        private HashMap<Long, View> headersViewByHeadersIds = null;
        private HashMap<Long, Boolean> wasHeaderByItemId = null;
        private ArrayList<Boolean> isHeaderByItemPosition = null;
        private HashMap<Long, Integer> headersHeightsByItemsIds = null;
        private boolean isSticky;

        public GoodsHeaderStore(RecyclerView parent, StickyHeadersAdapter adapter, boolean isSticky)
        {
            super(parent, adapter, isSticky);
            this.parent = parent;
            this.adapter = adapter;
            this.isSticky = isSticky;
            this.headersViewByHeadersIds = new HashMap<Long, View>();
            this.wasHeaderByItemId = new HashMap<Long, Boolean>();
            this.isHeaderByItemPosition = new ArrayList<Boolean>();
            this.headersHeightsByItemsIds = new HashMap<Long, Integer>();
        }

        public View getHeaderViewByItem(RecyclerView.ViewHolder itemHolder)
        {
            int itemPosition = RecyclerViewHelper.convertPreLayoutPositionToPostLayout(parent, itemHolder.getPosition());

            if (itemPosition == -1) return null;

            long headerId = adapter.getHeaderId(itemPosition);

            if (!headersViewByHeadersIds.containsKey(headerId))
            {
                RecyclerView.ViewHolder headerViewHolder = adapter.onCreateViewHolder(parent);

                adapter.onBindViewHolder(headerViewHolder, itemPosition);
                layoutHeader(headerViewHolder.itemView);

                headersViewByHeadersIds.put(headerId, headerViewHolder.itemView);
            }

            return headersViewByHeadersIds.get(headerId);

        }

        public long getHeaderId(int itemPosition)
        {
            return adapter.getHeaderId(itemPosition);
        }

        public int getHeaderHeight(RecyclerView.ViewHolder itemHolder)
        {
            if (!headersHeightsByItemsIds.containsKey(itemHolder.getItemId()))
            {
                View header = getHeaderViewByItem(itemHolder);
                headersHeightsByItemsIds.put(itemHolder.getItemId(), header.getVisibility() == View.GONE ? 0 : header.getMeasuredHeight());
            }
            return headersHeightsByItemsIds.get(itemHolder.getItemId());
        }

        public boolean isHeader(RecyclerView.ViewHolder itemHolder)
        {
            int itemPosition = RecyclerViewHelper.convertPreLayoutPositionToPostLayout(parent, itemHolder.getPosition());
            if (isHeaderByItemPosition.size() < itemPosition)
            {
                for (int i = 0; i < itemPosition; i++)
                {
                    isHeaderByItemPosition.add(null);
                }
            }
            if (isHeaderByItemPosition.size() <= itemPosition)
            {
                isHeaderByItemPosition.add(itemPosition, itemPosition == 0 || adapter.getHeaderId(itemPosition) != adapter.getHeaderId(itemPosition - 1));
            } else if (isHeaderByItemPosition.get(itemPosition) == null)
            {
                isHeaderByItemPosition.set(itemPosition, itemPosition == 0 || adapter.getHeaderId(itemPosition) != adapter.getHeaderId(itemPosition - 2));
            }

            return isHeaderByItemPosition.get(itemPosition);

        }

        public boolean wasHeader(RecyclerView.ViewHolder itemHolder)
        {
            if (!wasHeaderByItemId.containsKey(itemHolder.getItemId()))
            {
                int itemPosition = RecyclerViewHelper.convertPreLayoutPositionToPostLayout(parent, itemHolder.getPosition());

                if (itemPosition == -1)
                { // we are deleting the last item
                    return false;
                }

                wasHeaderByItemId.put(itemHolder.getItemId(), itemPosition == 0 || adapter.getHeaderId(itemPosition) != adapter.getHeaderId(itemPosition - 2));
            }
            return wasHeaderByItemId.get(itemHolder.getItemId());
        }

        public boolean isSticky()
        {
            return isSticky;
        }

        public void onItemRangeRemoved(int positionStart, int itemCount)
        {
            headersViewByHeadersIds.clear();

            if (isHeaderByItemPosition.size() > positionStart + itemCount)
            {
                for (int i = 0; i < itemCount; i++)
                {
                    RecyclerView.ViewHolder holder = parent.findViewHolderForPosition(positionStart + i);
                    if (holder != null)
                    {
                        wasHeaderByItemId.put(holder.getItemId(), isHeaderByItemPosition.get(positionStart + i));
                    }
                }
                isHeaderByItemPosition.set(positionStart + itemCount, null);
                for (int i = 0; i < itemCount; i++)
                {
                    isHeaderByItemPosition.remove(positionStart);
                }
            }
        }

        public void onItemRangeInserted(int positionStart, int itemCount)
        {
            headersViewByHeadersIds.clear();

            if (isHeaderByItemPosition.size() > positionStart)
            {
                for (int i = 0; i < itemCount; i++)
                {
                    isHeaderByItemPosition.add(positionStart, null);
                }
            }
            if (isHeaderByItemPosition.size() > positionStart + itemCount)
            {
                isHeaderByItemPosition.set(positionStart + itemCount, null);
            }
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)
        {
            headersViewByHeadersIds.clear();
            int min = Math.min(fromPosition, toPosition);
            int max = Math.max(fromPosition, toPosition);
            for (int i = min; i <= max; i++)
            {
                if (i >= isHeaderByItemPosition.size())
                {
                    isHeaderByItemPosition.add(null);
                }
            }

            if (fromPosition < toPosition)
            {
                if (fromPosition == 0)
                {
                    isHeaderByItemPosition.set(0, true);
                } else
                {
                    long fromPositionId = adapter.getHeaderId(fromPosition);
                    long beforeFromPositionId = adapter.getHeaderId(fromPosition - 1);
                    long afterFromPositionId = adapter.getHeaderId(fromPosition + 1);
                    isHeaderByItemPosition.set(fromPosition, fromPositionId != beforeFromPositionId);
                    isHeaderByItemPosition.set(fromPosition + 1, fromPositionId != afterFromPositionId);
                }

                long toPositionId = adapter.getHeaderId(toPosition);
                long beforeToPositionId = adapter.getHeaderId(toPosition - 1);
                isHeaderByItemPosition.set(toPosition, toPositionId != beforeToPositionId);
                if (toPosition < isHeaderByItemPosition.size() - 1)
                {
                    long afterToPositionId = adapter.getHeaderId(toPosition + 1);
                    isHeaderByItemPosition.set(toPosition + 1, toPositionId != afterToPositionId);
                }
            } else if (fromPosition > toPosition)
            {
                if (toPosition == 0)
                {
                    isHeaderByItemPosition.set(0, true);
                } else
                {
                    long toPositionId = adapter.getHeaderId(toPosition);
                    long beforeToPositionId = adapter.getHeaderId(toPosition - 1);
                    long afterToPositionId = adapter.getHeaderId(toPosition + 1);
                    isHeaderByItemPosition.set(toPosition, toPositionId != beforeToPositionId);
                    isHeaderByItemPosition.set(toPosition + 1, toPositionId != afterToPositionId);
                }

                long fromPositionId = adapter.getHeaderId(fromPosition);
                long beforeFromPositionId = adapter.getHeaderId(fromPosition - 1);
                isHeaderByItemPosition.set(fromPosition, fromPositionId != beforeFromPositionId);

                if (fromPosition < isHeaderByItemPosition.size() - 1)
                {
                    long afterFromPositionId = adapter.getHeaderId(fromPosition + 1);
                    isHeaderByItemPosition.set(fromPosition + 1, fromPositionId != afterFromPositionId);
                }
            } else
            {
                if (fromPosition == 0)
                {
                    isHeaderByItemPosition.set(0, true);
                } else
                {
                    long fromPositionId = adapter.getHeaderId(fromPosition);
                    long beforeFromPositionId = adapter.getHeaderId(fromPosition - 1);
                    isHeaderByItemPosition.set(fromPosition, fromPositionId != beforeFromPositionId);

                    if (fromPosition < isHeaderByItemPosition.size() - 1)
                    {
                        long afterFromPositionId = adapter.getHeaderId(fromPosition + 1);
                        isHeaderByItemPosition.set(fromPosition + 1, fromPositionId != afterFromPositionId);
                    }
                }
            }
        }

        public void onItemRangeChanged(int startPosition, int itemCount)
        {
            headersViewByHeadersIds.clear();

            if (startPosition + itemCount >= isHeaderByItemPosition.size())
            {
                for (int i = startPosition; i < startPosition + itemCount; i++)
                {
                    if (i >= isHeaderByItemPosition.size())
                    {
                        isHeaderByItemPosition.add(null);
                    }
                }
            }

            for (int i = 0; i < itemCount; i++)
            {
                isHeaderByItemPosition.set(i + startPosition, null);
            }

            long startPositionId = adapter.getHeaderId(startPosition);
            if (startPosition > 0)
            {
                long beforeStartPositionId = adapter.getHeaderId(startPosition - 1);
                isHeaderByItemPosition.set(startPosition - 1, startPositionId != beforeStartPositionId);
            }
            if (startPosition + itemCount < isHeaderByItemPosition.size())
            {
                long afterStartPositionId = adapter.getHeaderId(startPosition + itemCount);
                isHeaderByItemPosition.set(startPosition + itemCount, startPositionId != afterStartPositionId);
            }
        }

        public void clear()
        {
            headersViewByHeadersIds.clear();
            isHeaderByItemPosition.clear();
            wasHeaderByItemId.clear();
        }

        private void layoutHeader(View header)
        {
            int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            header.measure(widthSpec, heightSpec);
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
        }

    }
}
