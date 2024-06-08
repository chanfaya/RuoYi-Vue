export interface PaymentInfoVO {
  /**
   * 
   */
  id: string | number;

  /**
   * 订单号（对外业务号）
   */
  orderSn: string;

  /**
   * 订单id
   */
  orderId: string | number;

  /**
   * 支付宝交易流水号
   */
  alipayTradeNo: string;

  /**
   * 支付总金额
   */
  totalAmount: number;

  /**
   * 交易内容
   */
  subject: string;

  /**
   * 支付状态
   */
  paymentStatus: string;

  /**
   * 确认时间
   */
  confirmTime: string;

  /**
   * 回调内容
   */
  callbackContent: string;

  /**
   * 回调时间
   */
  callbackTime: string;

}

export interface PaymentInfoForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * 订单号（对外业务号）
   */
  orderSn?: string;

  /**
   * 订单id
   */
  orderId?: string | number;

  /**
   * 支付宝交易流水号
   */
  alipayTradeNo?: string;

  /**
   * 支付总金额
   */
  totalAmount?: number;

  /**
   * 交易内容
   */
  subject?: string;

  /**
   * 支付状态
   */
  paymentStatus?: string;

  /**
   * 确认时间
   */
  confirmTime?: string;

  /**
   * 回调内容
   */
  callbackContent?: string;

  /**
   * 回调时间
   */
  callbackTime?: string;

}

export interface PaymentInfoQuery extends PageQuery {

  /**
   * 订单号（对外业务号）
   */
  orderSn?: string;

  /**
   * 订单id
   */
  orderId?: string | number;

  /**
   * 支付宝交易流水号
   */
  alipayTradeNo?: string;

  /**
   * 支付总金额
   */
  totalAmount?: number;

  /**
   * 交易内容
   */
  subject?: string;

  /**
   * 支付状态
   */
  paymentStatus?: string;

  /**
   * 确认时间
   */
  confirmTime?: string;

  /**
   * 回调内容
   */
  callbackContent?: string;

  /**
   * 回调时间
   */
  callbackTime?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



