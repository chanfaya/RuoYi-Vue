export interface AttrAttrgroupRelationVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 属性id
   */
  attrId: string | number;

  /**
   * 属性分组id
   */
  attrGroupId: string | number;

  /**
   * 属性组内排序
   */
  attrSort: number;

}

export interface AttrAttrgroupRelationForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 属性id
   */
  attrId?: string | number;

  /**
   * 属性分组id
   */
  attrGroupId?: string | number;

  /**
   * 属性组内排序
   */
  attrSort?: number;

}

export interface AttrAttrgroupRelationQuery extends PageQuery {

  /**
   * 属性id
   */
  attrId?: string | number;

  /**
   * 属性分组id
   */
  attrGroupId?: string | number;

  /**
   * 属性组内排序
   */
  attrSort?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



