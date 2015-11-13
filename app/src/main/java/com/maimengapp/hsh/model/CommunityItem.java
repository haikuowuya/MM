package com.maimengapp.hsh.model;

/**
 * Created by Steven on 2015/11/5 0005.
 */
public class CommunityItem extends  BaseItem
{
    /***
     * 类型
     */
    public  String type;
    /***
     * 类型图片
     */
    public int  typeImage;
    /**
     * 标题
     */
    public String title;
    /***
     * 图片
     */
    public int  image;
    /***
     * 姓名
     */
    public  String name;
    /**
     * 时间
     */
    public String  dateTime;
    /***
     * 搜索总数
     */
    public String searchCount;
    /**
     * 编辑总数
     */
    public String editCount;
    /**
     * 点赞总数
     */
    public String zambiaCount;
    public boolean showType;

    public int typeTextColor ;

    public CommunityItem()
    {
    }

    public CommunityItem(String type, int  typeImage, String title, int  image, String name, String dateTime, String searchCount, String editCount, String zambiaCount, boolean showType)
    {
        this.type = type;
        this.typeImage = typeImage;
        this.title = title;
        this.image = image;
        this.name = name;
        this.dateTime = dateTime;
        this.searchCount = searchCount;
        this.editCount = editCount;
        this.zambiaCount = zambiaCount;
        this.showType = showType;
    }

    public CommunityItem(String type, int  typeImage, String title, int  image, String name, String dateTime, String searchCount, String editCount, String zambiaCount, boolean showType,int typeTextColor)
    {
        this.type = type;
        this.typeImage = typeImage;
        this.title = title;
        this.image = image;
        this.name = name;
        this.dateTime = dateTime;
        this.searchCount = searchCount;
        this.editCount = editCount;
        this.zambiaCount = zambiaCount;
        this.showType = showType;
        this.typeTextColor = typeTextColor;
    }


}
