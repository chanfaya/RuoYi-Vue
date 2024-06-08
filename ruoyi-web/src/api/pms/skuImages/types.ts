export interface SkuImagesVO {
  /**
   * 
   */
  id: string | number;

  /**
   * sku_id
   */
  skuId: string | number;

  /**
   * 图片地址
   */
  imgUrl: string;

  /**
   * 排序
   */
  imgSort: number;

  /**
   * 默认图[0 - 不是默认图，1 - 是默认图]
   */
  defaultImg: number;

}

export interface SkuImagesForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * 图片地址
   */
  imgUrl?: string;

  /**
   * 排序
   */
  imgSort?: number;

  /**
   * 默认图[0 - 不是默认图，1 - 是默认图]
   */
  defaultImg?: number;

}

export interface SkuImagesQuery extends PageQuery {

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * 图片地址
   */
  imgUrl?: string;

  /**
   * 排序
   */
  imgSort?: number;

  /**
   * 默认图[0 - 不是默认图，1 - 是默认图]
   */
  defaultImg?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



