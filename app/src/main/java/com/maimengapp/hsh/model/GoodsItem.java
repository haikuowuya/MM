package com.maimengapp.hsh.model;

/**
 * 商品实体item
 */
public class GoodsItem extends  BaseItem
{
    /**
     * 商品类型
     */
    public String type;
    /***
     * 图片
     */
    public String image;
    /***
     * 名称
     */
    public String name;
    /***
     * 优惠价
     */
    public String price;
    /***
     * 原价
     */
    public String  originPrice;

    /***
     * 点赞总数
     */
    public String zambiaCount;
    /***
     * 类型的文字颜色
     */
    public int typeTextColor;


    public int typeFlag;

    public boolean showType;
    public GoodsItem()
    {
    }

    public GoodsItem(String type,  String name, String zambiaCount,  String price, String originPrice,String image,int typeFlag )
    {
        this.type = type;
        this.image = image;
        this.name = name;
        this.price = price;
        this.originPrice = originPrice;
        this.zambiaCount = zambiaCount;
       this.typeFlag = typeFlag;
    }
    public GoodsItem(String type,  String name, String zambiaCount,  String price, String originPrice,String image,int typeFlag ,boolean showType)
    {
        this.type = type;
        this.image = image;
        this.name = name;
        this.price = price;
        this.originPrice = originPrice;
        this.zambiaCount = zambiaCount;
        this.typeFlag = typeFlag;
        this.showType = showType;
    }
}
