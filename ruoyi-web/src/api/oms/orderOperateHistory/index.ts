import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { OrderOperateHistoryVO, OrderOperateHistoryForm, OrderOperateHistoryQuery } from '@/api/oms/orderOperateHistory/types';

/**
 * 查询订单操作历史记录列表
 * @param query
 * @returns {*}
 */

export const listOrderOperateHistory = (query?: OrderOperateHistoryQuery): AxiosPromise<OrderOperateHistoryVO[]> => {
  return request({
    url: '/oms/orderOperateHistory/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询订单操作历史记录详细
 * @param id
 */
export const getOrderOperateHistory = (id: string | number): AxiosPromise<OrderOperateHistoryVO> => {
  return request({
    url: '/oms/orderOperateHistory/' + id,
    method: 'get'
  });
};

/**
 * 新增订单操作历史记录
 * @param data
 */
export const addOrderOperateHistory = (data: OrderOperateHistoryForm) => {
  return request({
    url: '/oms/orderOperateHistory',
    method: 'post',
    data: data
  });
};

/**
 * 修改订单操作历史记录
 * @param data
 */
export const updateOrderOperateHistory = (data: OrderOperateHistoryForm) => {
  return request({
    url: '/oms/orderOperateHistory',
    method: 'put',
    data: data
  });
};

/**
 * 删除订单操作历史记录
 * @param id
 */
export const delOrderOperateHistory = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/orderOperateHistory/' + id,
    method: 'delete'
  });
};
