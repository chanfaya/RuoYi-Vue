export interface SkuSaleAttrValueVO {
  /**
   * 
   */
  id: string | number;

  /**
   * sku_id
   */
  skuId: string | number;

  /**
   * attr_id
   */
  attrId: string | number;

  /**
   * 销售属性名
   */
  attrName: string;

  /**
   * 销售属性值
   */
  attrValue: string;

  /**
   * 顺序
   */
  attrSort: number;

}

export interface SkuSaleAttrValueForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * attr_id
   */
  attrId?: string | number;

  /**
   * 销售属性名
   */
  attrName?: string;

  /**
   * 销售属性值
   */
  attrValue?: string;

  /**
   * 顺序
   */
  attrSort?: number;

}

export interface SkuSaleAttrValueQuery extends PageQuery {

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * attr_id
   */
  attrId?: string | number;

  /**
   * 销售属性名
   */
  attrName?: string;

  /**
   * 销售属性值
   */
  attrValue?: string;

  /**
   * 顺序
   */
  attrSort?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



