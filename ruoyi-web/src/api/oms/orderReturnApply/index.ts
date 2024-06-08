import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { OrderReturnApplyVO, OrderReturnApplyForm, OrderReturnApplyQuery } from '@/api/oms/orderReturnApply/types';

/**
 * 查询订单退货申请列表
 * @param query
 * @returns {*}
 */

export const listOrderReturnApply = (query?: OrderReturnApplyQuery): AxiosPromise<OrderReturnApplyVO[]> => {
  return request({
    url: '/oms/orderReturnApply/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询订单退货申请详细
 * @param id
 */
export const getOrderReturnApply = (id: string | number): AxiosPromise<OrderReturnApplyVO> => {
  return request({
    url: '/oms/orderReturnApply/' + id,
    method: 'get'
  });
};

/**
 * 新增订单退货申请
 * @param data
 */
export const addOrderReturnApply = (data: OrderReturnApplyForm) => {
  return request({
    url: '/oms/orderReturnApply',
    method: 'post',
    data: data
  });
};

/**
 * 修改订单退货申请
 * @param data
 */
export const updateOrderReturnApply = (data: OrderReturnApplyForm) => {
  return request({
    url: '/oms/orderReturnApply',
    method: 'put',
    data: data
  });
};

/**
 * 删除订单退货申请
 * @param id
 */
export const delOrderReturnApply = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/orderReturnApply/' + id,
    method: 'delete'
  });
};
