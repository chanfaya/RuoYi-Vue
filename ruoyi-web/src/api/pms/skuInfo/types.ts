export interface SkuInfoVO {
  /**
   * skuId
   */
  skuId: string | number;

  /**
   * spuId
   */
  spuId: string | number;

  /**
   * sku名称
   */
  skuName: string;

  /**
   * sku介绍描述
   */
  skuDesc: string;

  /**
   * 所属分类id
   */
  catalogId: string | number;

  /**
   * 品牌id
   */
  brandId: string | number;

  /**
   * 默认图片
   */
  skuDefaultImg: string;

  /**
   * 标题
   */
  skuTitle: string;

  /**
   * 副标题
   */
  skuSubtitle: string;

  /**
   * 价格
   */
  price: number;

  /**
   * 销量
   */
  saleCount: number;

}

export interface SkuInfoForm extends BaseEntity {
  /**
   * skuId
   */
  skuId?: string | number;

  /**
   * spuId
   */
  spuId?: string | number;

  /**
   * sku名称
   */
  skuName?: string;

  /**
   * sku介绍描述
   */
  skuDesc?: string;

  /**
   * 所属分类id
   */
  catalogId?: string | number;

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 默认图片
   */
  skuDefaultImg?: string;

  /**
   * 标题
   */
  skuTitle?: string;

  /**
   * 副标题
   */
  skuSubtitle?: string;

  /**
   * 价格
   */
  price?: number;

  /**
   * 销量
   */
  saleCount?: number;

}

export interface SkuInfoQuery extends PageQuery {

  /**
   * spuId
   */
  spuId?: string | number;

  /**
   * sku名称
   */
  skuName?: string;

  /**
   * sku介绍描述
   */
  skuDesc?: string;

  /**
   * 所属分类id
   */
  catalogId?: string | number;

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 默认图片
   */
  skuDefaultImg?: string;

  /**
   * 标题
   */
  skuTitle?: string;

  /**
   * 副标题
   */
  skuSubtitle?: string;

  /**
   * 价格
   */
  price?: number;

  /**
   * 销量
   */
  saleCount?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



