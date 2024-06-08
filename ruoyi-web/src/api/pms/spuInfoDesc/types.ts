export interface SpuInfoDescVO {
  /**
   * 商品id
   */
  spuId: string | number;

  /**
   * 商品介绍
   */
  decript: string;

}

export interface SpuInfoDescForm extends BaseEntity {
  /**
   * 商品id
   */
  spuId?: string | number;

  /**
   * 商品介绍
   */
  decript?: string;

}

export interface SpuInfoDescQuery extends PageQuery {

  /**
   * 商品介绍
   */
  decript?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



