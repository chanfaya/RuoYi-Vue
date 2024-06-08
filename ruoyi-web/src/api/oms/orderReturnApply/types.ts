export interface OrderReturnApplyVO {
  /**
   * 
   */
  id: string | number;

  /**
   * order_id
   */
  orderId: string | number;

  /**
   * 退货商品id
   */
  skuId: string | number;

  /**
   * 订单编号
   */
  orderSn: string;

  /**
   * 会员用户名
   */
  memberUsername: string;

  /**
   * 退款金额
   */
  returnAmount: number;

  /**
   * 退货人姓名
   */
  returnName: string;

  /**
   * 退货人电话
   */
  returnPhone: string;

  /**
   * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
   */
  status: number;

  /**
   * 处理时间
   */
  handleTime: string;

  /**
   * 商品图片
   */
  skuImg: string;

  /**
   * 商品名称
   */
  skuName: string;

  /**
   * 商品品牌
   */
  skuBrand: string;

  /**
   * 商品销售属性(JSON)
   */
  skuAttrsVals: string;

  /**
   * 退货数量
   */
  skuCount: number;

  /**
   * 商品单价
   */
  skuPrice: number;

  /**
   * 商品实际支付单价
   */
  skuRealPrice: number;

  /**
   * 原因
   */
  reason: string;

  /**
   * 描述
   */
  description述: string;

  /**
   * 凭证图片，以逗号隔开
   */
  descPics: string;

  /**
   * 处理备注
   */
  handleNote: string;

  /**
   * 处理人员
   */
  handleMan: string;

  /**
   * 收货人
   */
  receiveMan: string;

  /**
   * 收货时间
   */
  receiveTime: string;

  /**
   * 收货备注
   */
  receiveNote: string;

  /**
   * 收货电话
   */
  receivePhone: string;

  /**
   * 公司收货地址
   */
  companyAddress: string;

}

export interface OrderReturnApplyForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * order_id
   */
  orderId?: string | number;

  /**
   * 退货商品id
   */
  skuId?: string | number;

  /**
   * 订单编号
   */
  orderSn?: string;

  /**
   * 会员用户名
   */
  memberUsername?: string;

  /**
   * 退款金额
   */
  returnAmount?: number;

  /**
   * 退货人姓名
   */
  returnName?: string;

  /**
   * 退货人电话
   */
  returnPhone?: string;

  /**
   * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
   */
  status?: number;

  /**
   * 处理时间
   */
  handleTime?: string;

  /**
   * 商品图片
   */
  skuImg?: string;

  /**
   * 商品名称
   */
  skuName?: string;

  /**
   * 商品品牌
   */
  skuBrand?: string;

  /**
   * 商品销售属性(JSON)
   */
  skuAttrsVals?: string;

  /**
   * 退货数量
   */
  skuCount?: number;

  /**
   * 商品单价
   */
  skuPrice?: number;

  /**
   * 商品实际支付单价
   */
  skuRealPrice?: number;

  /**
   * 原因
   */
  reason?: string;

  /**
   * 描述
   */
  description述?: string;

  /**
   * 凭证图片，以逗号隔开
   */
  descPics?: string;

  /**
   * 处理备注
   */
  handleNote?: string;

  /**
   * 处理人员
   */
  handleMan?: string;

  /**
   * 收货人
   */
  receiveMan?: string;

  /**
   * 收货时间
   */
  receiveTime?: string;

  /**
   * 收货备注
   */
  receiveNote?: string;

  /**
   * 收货电话
   */
  receivePhone?: string;

  /**
   * 公司收货地址
   */
  companyAddress?: string;

}

export interface OrderReturnApplyQuery extends PageQuery {

  /**
   * order_id
   */
  orderId?: string | number;

  /**
   * 退货商品id
   */
  skuId?: string | number;

  /**
   * 订单编号
   */
  orderSn?: string;

  /**
   * 会员用户名
   */
  memberUsername?: string;

  /**
   * 退款金额
   */
  returnAmount?: number;

  /**
   * 退货人姓名
   */
  returnName?: string;

  /**
   * 退货人电话
   */
  returnPhone?: string;

  /**
   * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
   */
  status?: number;

  /**
   * 处理时间
   */
  handleTime?: string;

  /**
   * 商品图片
   */
  skuImg?: string;

  /**
   * 商品名称
   */
  skuName?: string;

  /**
   * 商品品牌
   */
  skuBrand?: string;

  /**
   * 商品销售属性(JSON)
   */
  skuAttrsVals?: string;

  /**
   * 退货数量
   */
  skuCount?: number;

  /**
   * 商品单价
   */
  skuPrice?: number;

  /**
   * 商品实际支付单价
   */
  skuRealPrice?: number;

  /**
   * 原因
   */
  reason?: string;

  /**
   * 描述
   */
  description述?: string;

  /**
   * 凭证图片，以逗号隔开
   */
  descPics?: string;

  /**
   * 处理备注
   */
  handleNote?: string;

  /**
   * 处理人员
   */
  handleMan?: string;

  /**
   * 收货人
   */
  receiveMan?: string;

  /**
   * 收货时间
   */
  receiveTime?: string;

  /**
   * 收货备注
   */
  receiveNote?: string;

  /**
   * 收货电话
   */
  receivePhone?: string;

  /**
   * 公司收货地址
   */
  companyAddress?: string;

    /**
     * 日期范围参数
     */
    params?: any;
}



