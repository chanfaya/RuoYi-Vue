export interface SpuInfoVO {
  /**
   * 商品id
   */
  id: string | number;

  /**
   * 商品名称
   */
  spuName: string;

  /**
   * 商品描述
   */
  spuDescription: string;

  /**
   * 所属分类id
   */
  catalogId: string | number;

  /**
   * 品牌id
   */
  brandId: string | number;

  /**
   * 
   */
  weight: number;

  /**
   * 上架状态[0 - 下架，1 - 上架]
   */
  publishStatus: number;

}

export interface SpuInfoForm extends BaseEntity {
  /**
   * 商品id
   */
  id?: string | number;

  /**
   * 商品名称
   */
  spuName?: string;

  /**
   * 商品描述
   */
  spuDescription?: string;

  /**
   * 所属分类id
   */
  catalogId?: string | number;

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 
   */
  weight?: number;

  /**
   * 上架状态[0 - 下架，1 - 上架]
   */
  publishStatus?: number;

}

export interface SpuInfoQuery extends PageQuery {

  /**
   * 商品名称
   */
  spuName?: string;

  /**
   * 商品描述
   */
  spuDescription?: string;

  /**
   * 所属分类id
   */
  catalogId?: string | number;

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 
   */
  weight?: number;

  /**
   * 上架状态[0 - 下架，1 - 上架]
   */
  publishStatus?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



