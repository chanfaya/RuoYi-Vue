import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { OrderReturnReasonVO, OrderReturnReasonForm, OrderReturnReasonQuery } from '@/api/oms/orderReturnReason/types';

/**
 * 查询退货原因列表
 * @param query
 * @returns {*}
 */

export const listOrderReturnReason = (query?: OrderReturnReasonQuery): AxiosPromise<OrderReturnReasonVO[]> => {
  return request({
    url: '/oms/orderReturnReason/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询退货原因详细
 * @param id
 */
export const getOrderReturnReason = (id: string | number): AxiosPromise<OrderReturnReasonVO> => {
  return request({
    url: '/oms/orderReturnReason/' + id,
    method: 'get'
  });
};

/**
 * 新增退货原因
 * @param data
 */
export const addOrderReturnReason = (data: OrderReturnReasonForm) => {
  return request({
    url: '/oms/orderReturnReason',
    method: 'post',
    data: data
  });
};

/**
 * 修改退货原因
 * @param data
 */
export const updateOrderReturnReason = (data: OrderReturnReasonForm) => {
  return request({
    url: '/oms/orderReturnReason',
    method: 'put',
    data: data
  });
};

/**
 * 删除退货原因
 * @param id
 */
export const delOrderReturnReason = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/orderReturnReason/' + id,
    method: 'delete'
  });
};
