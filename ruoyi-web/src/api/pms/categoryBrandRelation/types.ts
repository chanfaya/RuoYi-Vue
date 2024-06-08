export interface CategoryBrandRelationVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 品牌id
   */
  brandId: string | number;

  /**
   * 分类id
   */
  catelogId: string | number;

  /**
   * 
   */
  brandName: string;

  /**
   * 
   */
  catelogName: string;

}

export interface CategoryBrandRelationForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 分类id
   */
  catelogId?: string | number;

  /**
   * 
   */
  brandName?: string;

  /**
   * 
   */
  catelogName?: string;

}

export interface CategoryBrandRelationQuery extends PageQuery {

  /**
   * 品牌id
   */
  brandId?: string | number;

  /**
   * 分类id
   */
  catelogId?: string | number;

  /**
   * 
   */
  brandName?: string;

  /**
   * 
   */
  catelogName?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



