export interface OrderSettingVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 秒杀订单超时关闭时间(分)
   */
  flashOrderOvertime: number;

  /**
   * 正常订单超时时间(分)
   */
  normalOrderOvertime: number;

  /**
   * 发货后自动确认收货时间（天）
   */
  confirmOvertime: number;

  /**
   * 自动完成交易时间，不能申请退货（天）
   */
  finishOvertime: number;

  /**
   * 订单完成后自动好评时间（天）
   */
  commentOvertime: number;

  /**
   * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
   */
  memberLevel: number;

}

export interface OrderSettingForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 秒杀订单超时关闭时间(分)
   */
  flashOrderOvertime?: number;

  /**
   * 正常订单超时时间(分)
   */
  normalOrderOvertime?: number;

  /**
   * 发货后自动确认收货时间（天）
   */
  confirmOvertime?: number;

  /**
   * 自动完成交易时间，不能申请退货（天）
   */
  finishOvertime?: number;

  /**
   * 订单完成后自动好评时间（天）
   */
  commentOvertime?: number;

  /**
   * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
   */
  memberLevel?: number;

}

export interface OrderSettingQuery extends PageQuery {

  /**
   * 秒杀订单超时关闭时间(分)
   */
  flashOrderOvertime?: number;

  /**
   * 正常订单超时时间(分)
   */
  normalOrderOvertime?: number;

  /**
   * 发货后自动确认收货时间（天）
   */
  confirmOvertime?: number;

  /**
   * 自动完成交易时间，不能申请退货（天）
   */
  finishOvertime?: number;

  /**
   * 订单完成后自动好评时间（天）
   */
  commentOvertime?: number;

  /**
   * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
   */
  memberLevel?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



