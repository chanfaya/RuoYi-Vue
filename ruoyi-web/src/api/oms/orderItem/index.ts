import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { OrderItemVO, OrderItemForm, OrderItemQuery } from '@/api/oms/orderItem/types';

/**
 * 查询订单项信息列表
 * @param query
 * @returns {*}
 */

export const listOrderItem = (query?: OrderItemQuery): AxiosPromise<OrderItemVO[]> => {
  return request({
    url: '/oms/orderItem/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询订单项信息详细
 * @param id
 */
export const getOrderItem = (id: string | number): AxiosPromise<OrderItemVO> => {
  return request({
    url: '/oms/orderItem/' + id,
    method: 'get'
  });
};

/**
 * 新增订单项信息
 * @param data
 */
export const addOrderItem = (data: OrderItemForm) => {
  return request({
    url: '/oms/orderItem',
    method: 'post',
    data: data
  });
};

/**
 * 修改订单项信息
 * @param data
 */
export const updateOrderItem = (data: OrderItemForm) => {
  return request({
    url: '/oms/orderItem',
    method: 'put',
    data: data
  });
};

/**
 * 删除订单项信息
 * @param id
 */
export const delOrderItem = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/orderItem/' + id,
    method: 'delete'
  });
};
