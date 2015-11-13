package com.maimengapp.hsh.adapter.search;

import android.view.View;

import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseAdapter;

import java.util.List;

/**
 * Created by Steven on 2015/11/5 0005.
 */
public class SearchKeyGridAdapter extends BaseAdapter<String>
{
    public SearchKeyGridAdapter(BaseActivity activity, List<String> data)
    {
        super(activity, data);
    }

    @Override
    public void bindDataToView(View convertView, String s)
    {
        setTextViewText(convertView, R.id.tv_text, s);
    }

    @Override
    public int layoutResId()
    {
        return R.layout.search_key_grid_item;
    }
}
