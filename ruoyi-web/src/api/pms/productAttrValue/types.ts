export interface ProductAttrValueVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 商品id
   */
  spuId: string | number;

  /**
   * 属性id
   */
  attrId: string | number;

  /**
   * 属性名
   */
  attrName: string;

  /**
   * 属性值
   */
  attrValue: string;

  /**
   * 顺序
   */
  attrSort: number;

  /**
   * 快速展示【是否展示在介绍上；0-否 1-是】
   */
  quickShow: number;

}

export interface ProductAttrValueForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 商品id
   */
  spuId?: string | number;

  /**
   * 属性id
   */
  attrId?: string | number;

  /**
   * 属性名
   */
  attrName?: string;

  /**
   * 属性值
   */
  attrValue?: string;

  /**
   * 顺序
   */
  attrSort?: number;

  /**
   * 快速展示【是否展示在介绍上；0-否 1-是】
   */
  quickShow?: number;

}

export interface ProductAttrValueQuery extends PageQuery {

  /**
   * 商品id
   */
  spuId?: string | number;

  /**
   * 属性id
   */
  attrId?: string | number;

  /**
   * 属性名
   */
  attrName?: string;

  /**
   * 属性值
   */
  attrValue?: string;

  /**
   * 顺序
   */
  attrSort?: number;

  /**
   * 快速展示【是否展示在介绍上；0-否 1-是】
   */
  quickShow?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



