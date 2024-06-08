export interface OrderVO {
  /**
   * 
   */
  id: string | number;

  /**
   * member_id
   */
  memberId: string | number;

  /**
   * 订单号
   */
  orderSn: string;

  /**
   * 使用的优惠券
   */
  couponId: string | number;

  /**
   * 用户名
   */
  memberUsername: string;

  /**
   * 订单总额
   */
  totalAmount: number;

  /**
   * 应付总额
   */
  payAmount: number;

  /**
   * 运费金额
   */
  freightAmount: number;

  /**
   * 促销优化金额（促销价、满减、阶梯价）
   */
  promotionAmount: number;

  /**
   * 积分抵扣金额
   */
  integrationAmount: number;

  /**
   * 优惠券抵扣金额
   */
  couponAmount: number;

  /**
   * 后台调整订单使用的折扣金额
   */
  discountAmount: number;

  /**
   * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
   */
  payType: number;

  /**
   * 订单来源[0->PC订单；1->app订单]
   */
  sourceType: number;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  status: number;

  /**
   * 物流公司(配送方式)
   */
  deliveryCompany: string;

  /**
   * 物流单号
   */
  deliverySn: string;

  /**
   * 自动确认时间（天）
   */
  autoConfirmDay: number;

  /**
   * 可以获得的积分
   */
  integration: number;

  /**
   * 可以获得的成长值
   */
  growth: number;

  /**
   * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
   */
  billType: number;

  /**
   * 发票抬头
   */
  billHeader: string;

  /**
   * 发票内容
   */
  billContent: string;

  /**
   * 收票人电话
   */
  billReceiverPhone: string;

  /**
   * 收票人邮箱
   */
  billReceiverEmail: string;

  /**
   * 收货人姓名
   */
  receiverName: string;

  /**
   * 收货人电话
   */
  receiverPhone: string;

  /**
   * 收货人邮编
   */
  receiverPostCode: string;

  /**
   * 省份/直辖市
   */
  receiverProvince: string;

  /**
   * 城市
   */
  receiverCity: string;

  /**
   * 区
   */
  receiverRegion: string;

  /**
   * 详细地址
   */
  receiverDetailAddress: string;

  /**
   * 订单备注
   */
  note: string;

  /**
   * 确认收货状态[0->未确认；1->已确认]
   */
  confirmStatus: number;

  /**
   * 删除状态【0->未删除；1->已删除】
   */
  deleteStatus: number;

  /**
   * 下单时使用的积分
   */
  useIntegration: number;

  /**
   * 支付时间
   */
  paymentTime: string;

  /**
   * 发货时间
   */
  deliveryTime: string;

  /**
   * 确认收货时间
   */
  receiveTime: string;

  /**
   * 评价时间
   */
  commentTime: string;

  /**
   * 修改时间
   */
  modifyTime: string;

}

export interface OrderForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * member_id
   */
  memberId?: string | number;

  /**
   * 订单号
   */
  orderSn?: string;

  /**
   * 使用的优惠券
   */
  couponId?: string | number;

  /**
   * 用户名
   */
  memberUsername?: string;

  /**
   * 订单总额
   */
  totalAmount?: number;

  /**
   * 应付总额
   */
  payAmount?: number;

  /**
   * 运费金额
   */
  freightAmount?: number;

  /**
   * 促销优化金额（促销价、满减、阶梯价）
   */
  promotionAmount?: number;

  /**
   * 积分抵扣金额
   */
  integrationAmount?: number;

  /**
   * 优惠券抵扣金额
   */
  couponAmount?: number;

  /**
   * 后台调整订单使用的折扣金额
   */
  discountAmount?: number;

  /**
   * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
   */
  payType?: number;

  /**
   * 订单来源[0->PC订单；1->app订单]
   */
  sourceType?: number;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  status?: number;

  /**
   * 物流公司(配送方式)
   */
  deliveryCompany?: string;

  /**
   * 物流单号
   */
  deliverySn?: string;

  /**
   * 自动确认时间（天）
   */
  autoConfirmDay?: number;

  /**
   * 可以获得的积分
   */
  integration?: number;

  /**
   * 可以获得的成长值
   */
  growth?: number;

  /**
   * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
   */
  billType?: number;

  /**
   * 发票抬头
   */
  billHeader?: string;

  /**
   * 发票内容
   */
  billContent?: string;

  /**
   * 收票人电话
   */
  billReceiverPhone?: string;

  /**
   * 收票人邮箱
   */
  billReceiverEmail?: string;

  /**
   * 收货人姓名
   */
  receiverName?: string;

  /**
   * 收货人电话
   */
  receiverPhone?: string;

  /**
   * 收货人邮编
   */
  receiverPostCode?: string;

  /**
   * 省份/直辖市
   */
  receiverProvince?: string;

  /**
   * 城市
   */
  receiverCity?: string;

  /**
   * 区
   */
  receiverRegion?: string;

  /**
   * 详细地址
   */
  receiverDetailAddress?: string;

  /**
   * 订单备注
   */
  note?: string;

  /**
   * 确认收货状态[0->未确认；1->已确认]
   */
  confirmStatus?: number;

  /**
   * 删除状态【0->未删除；1->已删除】
   */
  deleteStatus?: number;

  /**
   * 下单时使用的积分
   */
  useIntegration?: number;

  /**
   * 支付时间
   */
  paymentTime?: string;

  /**
   * 发货时间
   */
  deliveryTime?: string;

  /**
   * 确认收货时间
   */
  receiveTime?: string;

  /**
   * 评价时间
   */
  commentTime?: string;

  /**
   * 修改时间
   */
  modifyTime?: string;

}

export interface OrderQuery extends PageQuery {

  /**
   * member_id
   */
  memberId?: string | number;

  /**
   * 订单号
   */
  orderSn?: string;

  /**
   * 使用的优惠券
   */
  couponId?: string | number;

  /**
   * 用户名
   */
  memberUsername?: string;

  /**
   * 订单总额
   */
  totalAmount?: number;

  /**
   * 应付总额
   */
  payAmount?: number;

  /**
   * 运费金额
   */
  freightAmount?: number;

  /**
   * 促销优化金额（促销价、满减、阶梯价）
   */
  promotionAmount?: number;

  /**
   * 积分抵扣金额
   */
  integrationAmount?: number;

  /**
   * 优惠券抵扣金额
   */
  couponAmount?: number;

  /**
   * 后台调整订单使用的折扣金额
   */
  discountAmount?: number;

  /**
   * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
   */
  payType?: number;

  /**
   * 订单来源[0->PC订单；1->app订单]
   */
  sourceType?: number;

  /**
   * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
   */
  status?: number;

  /**
   * 物流公司(配送方式)
   */
  deliveryCompany?: string;

  /**
   * 物流单号
   */
  deliverySn?: string;

  /**
   * 自动确认时间（天）
   */
  autoConfirmDay?: number;

  /**
   * 可以获得的积分
   */
  integration?: number;

  /**
   * 可以获得的成长值
   */
  growth?: number;

  /**
   * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
   */
  billType?: number;

  /**
   * 发票抬头
   */
  billHeader?: string;

  /**
   * 发票内容
   */
  billContent?: string;

  /**
   * 收票人电话
   */
  billReceiverPhone?: string;

  /**
   * 收票人邮箱
   */
  billReceiverEmail?: string;

  /**
   * 收货人姓名
   */
  receiverName?: string;

  /**
   * 收货人电话
   */
  receiverPhone?: string;

  /**
   * 收货人邮编
   */
  receiverPostCode?: string;

  /**
   * 省份/直辖市
   */
  receiverProvince?: string;

  /**
   * 城市
   */
  receiverCity?: string;

  /**
   * 区
   */
  receiverRegion?: string;

  /**
   * 详细地址
   */
  receiverDetailAddress?: string;

  /**
   * 订单备注
   */
  note?: string;

  /**
   * 确认收货状态[0->未确认；1->已确认]
   */
  confirmStatus?: number;

  /**
   * 删除状态【0->未删除；1->已删除】
   */
  deleteStatus?: number;

  /**
   * 下单时使用的积分
   */
  useIntegration?: number;

  /**
   * 支付时间
   */
  paymentTime?: string;

  /**
   * 发货时间
   */
  deliveryTime?: string;

  /**
   * 确认收货时间
   */
  receiveTime?: string;

  /**
   * 评价时间
   */
  commentTime?: string;

  /**
   * 修改时间
   */
  modifyTime?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



