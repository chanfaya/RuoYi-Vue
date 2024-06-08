export interface AttrGroupVO {
  /**
   * 分组id
   */
  attrGroupId: string | number;

  /**
   * 组名
   */
  attrGroupName: string;

  /**
   * 排序
   */
  sort: number;

  /**
   * 描述
   */
  descript: string;

  /**
   * 组图标
   */
  icon: string;

  /**
   * 所属分类id
   */
  catelogId: string | number;

}

export interface AttrGroupForm extends BaseEntity {
  /**
   * 分组id
   */
  attrGroupId?: string | number;

  /**
   * 组名
   */
  attrGroupName?: string;

  /**
   * 排序
   */
  sort?: number;

  /**
   * 描述
   */
  descript?: string;

  /**
   * 组图标
   */
  icon?: string;

  /**
   * 所属分类id
   */
  catelogId?: string | number;

}

export interface AttrGroupQuery extends PageQuery {

  /**
   * 组名
   */
  attrGroupName?: string;

  /**
   * 排序
   */
  sort?: number;

  /**
   * 描述
   */
  descript?: string;

  /**
   * 组图标
   */
  icon?: string;

  /**
   * 所属分类id
   */
  catelogId?: string | number;

    /**
     * 日期范围参数
     */
    params?: any;
}



