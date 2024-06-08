export interface RefundInfoVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 退款的订单
   */
  orderReturnId: string | number;

  /**
   * 退款金额
   */
  refund: number;

  /**
   * 退款交易流水号
   */
  refundSn: string;

  /**
   * 退款状态
   */
  refundStatus: number;

  /**
   * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
   */
  refundChannel: number;

  /**
   * 
   */
  refundContent: string;

}

export interface RefundInfoForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 退款的订单
   */
  orderReturnId?: string | number;

  /**
   * 退款金额
   */
  refund?: number;

  /**
   * 退款交易流水号
   */
  refundSn?: string;

  /**
   * 退款状态
   */
  refundStatus?: number;

  /**
   * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
   */
  refundChannel?: number;

  /**
   * 
   */
  refundContent?: string;

}

export interface RefundInfoQuery extends PageQuery {

  /**
   * 退款的订单
   */
  orderReturnId?: string | number;

  /**
   * 退款金额
   */
  refund?: number;

  /**
   * 退款交易流水号
   */
  refundSn?: string;

  /**
   * 退款状态
   */
  refundStatus?: number;

  /**
   * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
   */
  refundChannel?: number;

  /**
   * 
   */
  refundContent?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



