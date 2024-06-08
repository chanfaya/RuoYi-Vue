export interface OrderOperateHistoryVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 订单id
   */
  orderId: string | number;

  /**
   * 操作人[用户；系统；后台管理员]
   */
  operateMan: string;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  orderStatus: number;

  /**
   * 备注
   */
  note: string;

}

export interface OrderOperateHistoryForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 订单id
   */
  orderId?: string | number;

  /**
   * 操作人[用户；系统；后台管理员]
   */
  operateMan?: string;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  orderStatus?: number;

  /**
   * 备注
   */
  note?: string;

}

export interface OrderOperateHistoryQuery extends PageQuery {

  /**
   * 订单id
   */
  orderId?: string | number;

  /**
   * 操作人[用户；系统；后台管理员]
   */
  operateMan?: string;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  orderStatus?: number;

  /**
   * 备注
   */
  note?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



