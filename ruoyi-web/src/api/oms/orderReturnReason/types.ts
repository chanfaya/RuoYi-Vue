export interface OrderReturnReasonVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 退货原因名
   */
  name: string;

  /**
   * 排序
   */
  sort: number;

  /**
   * 启用状态
   */
  status: number;

}

export interface OrderReturnReasonForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 退货原因名
   */
  name?: string;

  /**
   * 排序
   */
  sort?: number;

  /**
   * 启用状态
   */
  status?: number;

}

export interface OrderReturnReasonQuery extends PageQuery {

  /**
   * 退货原因名
   */
  name?: string;

  /**
   * 排序
   */
  sort?: number;

  /**
   * 启用状态
   */
  status?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



