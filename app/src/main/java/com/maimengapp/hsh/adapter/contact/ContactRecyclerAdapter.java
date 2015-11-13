package com.maimengapp.hsh.adapter.contact;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.model.ContactItem;

import java.util.LinkedList;

/**
 * Created by Steven on 2015/11/9 0009.
 */
public class ContactRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private LinkedList<ContactItem> mContactItems;
    private BaseActivity mActivity;

    public ContactRecyclerAdapter(BaseActivity activity, LinkedList<ContactItem> contactItems)
    {
        mActivity = activity;
        mContactItems = contactItems;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(mActivity).inflate(R.layout.recycler_contact_list_item, null);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        ListItemVH listItemVH = new ListItemVH(itemView);
        return listItemVH;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        final ContactItem contactItem = mContactItems.get(position);
        if (null != contactItem)
        {
            if (holder instanceof ListItemVH)
            {
                ListItemVH listItemVh = (ListItemVH) holder;
                listItemVh.mTvText.setText(contactItem.name);
                listItemVh.mItemView.setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                  showAlertDialog(contactItem);
                            }
                        });
            }
        }
    }

    @Override
    public int getItemCount()
    {
        return null == mContactItems ? null : mContactItems.size();
    }

    private static class ListItemVH extends RecyclerView.ViewHolder
    {
        private View mItemView;
        private TextView mTvText;

        public ListItemVH(View itemView)
        {
            super(itemView);
            mItemView = itemView;
            mTvText = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

    private void showAlertDialog(ContactItem  item )
    {
          new AlertDialog.Builder(mActivity).setTitle("提示")
                .setMessage("你是否要拨打："+ item.phone)
                .setPositiveButton(
                        "确定", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        })
                .setNegativeButton("取消", null).show();
    }
}
