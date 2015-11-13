package com.maimengapp.hsh.model;

/**
 * 首页活动实体item
 */
public class ActivityItem extends  BaseItem
{
    /**
     * 活动名称
     */
    public String activityName;
    /***
     * 商品名称
     */
    public String name;
    /***
     * 点赞总数
     */
    public String zambiaCount;
    /***
     * 当前优惠价
     */
    public String price;
    /***
     * 原价
     */
    public String originPrice;

    public String image;
    /***
     * 是否显示活动名称
     */
    public boolean showActivityName;

    public ActivityItem()
    {
    }

    public ActivityItem(String activityName, String name, String zambiaCount, String price, String originPrice, String image,boolean showActivityName)
    {
        this.activityName = activityName;
        this.name = name;
        this.zambiaCount = zambiaCount;
        this.price = price;
        this.originPrice = originPrice;
        this.image = image;
        this.showActivityName = showActivityName;
    }
}
