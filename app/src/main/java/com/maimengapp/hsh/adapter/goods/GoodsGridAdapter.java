package com.maimengapp.hsh.adapter.goods;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;

import com.maimengapp.hsh.GoodsDetailActivity;
import com.maimengapp.hsh.R;
import com.maimengapp.hsh.base.BaseActivity;
import com.maimengapp.hsh.base.BaseAdapter;
import com.maimengapp.hsh.model.GoodsItem;
import com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapter;

import java.util.List;

/**
 *
 */
public class GoodsGridAdapter extends BaseAdapter<GoodsItem> implements StickyGridHeadersSimpleAdapter
{
    public GoodsGridAdapter(BaseActivity activity, List<GoodsItem> data)
    {
        super(activity, data);
    }

    @Override
    public void bindDataToView(View convertView, final GoodsItem goodsItem)
    {

        if (null != goodsItem)
        {
            setTextViewText(convertView, R.id.tv_zambia, goodsItem.zambiaCount);
            setTextViewText(convertView, R.id.tv_price, goodsItem.price);
            setTextViewText(convertView, R.id.tv_name, goodsItem.name);
            String goodsImage = goodsItem.image;
            System.out.println("goodsImage = " + goodsImage);
            int resId = getActivity().getResources().getIdentifier(goodsImage, "mipmap", getActivity().getPackageName());
            if (resId == 0)
            {
                resId = R.mipmap.ic_shoe_0;
            }
            setImageViewResId(convertView, R.id.iv_image, resId);

            String price = "￥" + goodsItem.price + "  ";
            String originPrice = "￥" + goodsItem.originPrice;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(price + originPrice);
            spannableStringBuilder.setSpan(new StrikethroughSpan(), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(0xFF999999), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), price.length(), spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            setTextViewText(convertView, R.id.tv_price, spannableStringBuilder);
            setConvertViewOnClick(
                    convertView, new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            GoodsDetailActivity.actionGoodsDetail(getActivity(), goodsItem);
                        }
                    });
        }
    }

    @Override
    public int layoutResId()
    {
        return R.layout.recycler_goods_grid_item;
    }

    @Override
    public long getHeaderId(int position)
    {
        return getPositionData(position).typeFlag;

    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent)
    {
        convertView = getInflater().inflate(R.layout.grid_goods_header_item, parent, false);
        setTextViewText(convertView, R.id.tv_text, getPositionData(position).type);
        setTextViewTextColor(convertView, R.id.tv_text, getPositionData(position).typeTextColor);
        setViewBackgroundColor(convertView, R.id.view_view, getPositionData(position).typeTextColor);
        return convertView;
    }
}
