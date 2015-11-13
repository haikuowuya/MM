package com.maimengapp.hsh.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.adapter.contact.ContactRecyclerAdapter;
import com.maimengapp.hsh.base.BaseFragment;
import com.maimengapp.hsh.model.ActivityItem;
import com.maimengapp.hsh.model.ContactItem;

import java.util.LinkedList;

import butterknife.Bind;

/**
 * Created by Steven on 2015/11/3 0003.
 */
public class ContactFragment extends BaseFragment
{
    public static ContactFragment newInstance()
    {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    @Bind(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;
    private LinkedList<ContactItem> mContactItems = new LinkedList<>();

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            mActivity.dismissProgressDialog();
            if (!mContactItems.isEmpty())
            {
                mRecyclerView.setAdapter(new ContactRecyclerAdapter(mActivity, mContactItems));
            } else
            {
                mActivity.showToast("联系人列表为空！");
            }

        }
    };

    private LinkedList<ActivityItem> mActivityItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_contact, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        doGetPhoneContact();
    }

    @Override
    public String getFragmentTitle()
    {
        return "首页";
    }

    private void doGetPhoneContact()
    {
        mActivity.showProgressDialog();
        new Thread(new ContactRunnable()).start();
    }

    private class ContactRunnable implements Runnable
    {
        public void run()
        {
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = mActivity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, null);
            if (null != cursor && cursor.getCount() > 0)
            {
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
                {
                    ContactItem contactItem = new ContactItem();
                    contactItem.name = cursor.getString(0);
                    contactItem.phone = cursor.getString(1);
                    mContactItems.add(contactItem);
                }
            }

            mHandler.sendEmptyMessage(0);
        }
    }

}
