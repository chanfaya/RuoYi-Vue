export interface OrderItemVO {
  /**
   * 
   */
  id: string | number;

  /**
   * order_id
   */
  orderId: string | number;

  /**
   * order_sn
   */
  orderSn: string;

  /**
   * spu_id
   */
  spuId: string | number;

  /**
   * spu_name
   */
  spuName: string;

  /**
   * spu_pic
   */
  spuPic: string;

  /**
   * 品牌
   */
  spuBrand: string;

  /**
   * 商品分类id
   */
  categoryId: string | number;

  /**
   * 商品sku编号
   */
  skuId: string | number;

  /**
   * 商品sku名字
   */
  skuName: string;

  /**
   * 商品sku图片
   */
  skuPic: string;

  /**
   * 商品sku价格
   */
  skuPrice: number;

  /**
   * 商品购买的数量
   */
  skuQuantity: number;

  /**
   * 商品销售属性组合（JSON）
   */
  skuAttrsVals: string;

  /**
   * 商品促销分解金额
   */
  promotionAmount: number;

  /**
   * 优惠券优惠分解金额
   */
  couponAmount: number;

  /**
   * 积分优惠分解金额
   */
  integrationAmount: number;

  /**
   * 该商品经过优惠后的分解金额
   */
  realAmount: number;

  /**
   * 赠送积分
   */
  giftIntegration: number;

  /**
   * 赠送成长值
   */
  giftGrowth: number;

}

export interface OrderItemForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * order_id
   */
  orderId?: string | number;

  /**
   * order_sn
   */
  orderSn?: string;

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * spu_name
   */
  spuName?: string;

  /**
   * spu_pic
   */
  spuPic?: string;

  /**
   * 品牌
   */
  spuBrand?: string;

  /**
   * 商品分类id
   */
  categoryId?: string | number;

  /**
   * 商品sku编号
   */
  skuId?: string | number;

  /**
   * 商品sku名字
   */
  skuName?: string;

  /**
   * 商品sku图片
   */
  skuPic?: string;

  /**
   * 商品sku价格
   */
  skuPrice?: number;

  /**
   * 商品购买的数量
   */
  skuQuantity?: number;

  /**
   * 商品销售属性组合（JSON）
   */
  skuAttrsVals?: string;

  /**
   * 商品促销分解金额
   */
  promotionAmount?: number;

  /**
   * 优惠券优惠分解金额
   */
  couponAmount?: number;

  /**
   * 积分优惠分解金额
   */
  integrationAmount?: number;

  /**
   * 该商品经过优惠后的分解金额
   */
  realAmount?: number;

  /**
   * 赠送积分
   */
  giftIntegration?: number;

  /**
   * 赠送成长值
   */
  giftGrowth?: number;

}

export interface OrderItemQuery extends PageQuery {

  /**
   * order_id
   */
  orderId?: string | number;

  /**
   * order_sn
   */
  orderSn?: string;

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * spu_name
   */
  spuName?: string;

  /**
   * spu_pic
   */
  spuPic?: string;

  /**
   * 品牌
   */
  spuBrand?: string;

  /**
   * 商品分类id
   */
  categoryId?: string | number;

  /**
   * 商品sku编号
   */
  skuId?: string | number;

  /**
   * 商品sku名字
   */
  skuName?: string;

  /**
   * 商品sku图片
   */
  skuPic?: string;

  /**
   * 商品sku价格
   */
  skuPrice?: number;

  /**
   * 商品购买的数量
   */
  skuQuantity?: number;

  /**
   * 商品销售属性组合（JSON）
   */
  skuAttrsVals?: string;

  /**
   * 商品促销分解金额
   */
  promotionAmount?: number;

  /**
   * 优惠券优惠分解金额
   */
  couponAmount?: number;

  /**
   * 积分优惠分解金额
   */
  integrationAmount?: number;

  /**
   * 该商品经过优惠后的分解金额
   */
  realAmount?: number;

  /**
   * 赠送积分
   */
  giftIntegration?: number;

  /**
   * 赠送成长值
   */
  giftGrowth?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



