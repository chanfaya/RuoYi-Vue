import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { OrderSettingVO, OrderSettingForm, OrderSettingQuery } from '@/api/oms/orderSetting/types';

/**
 * 查询订单配置信息列表
 * @param query
 * @returns {*}
 */

export const listOrderSetting = (query?: OrderSettingQuery): AxiosPromise<OrderSettingVO[]> => {
  return request({
    url: '/oms/orderSetting/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询订单配置信息详细
 * @param id
 */
export const getOrderSetting = (id: string | number): AxiosPromise<OrderSettingVO> => {
  return request({
    url: '/oms/orderSetting/' + id,
    method: 'get'
  });
};

/**
 * 新增订单配置信息
 * @param data
 */
export const addOrderSetting = (data: OrderSettingForm) => {
  return request({
    url: '/oms/orderSetting',
    method: 'post',
    data: data
  });
};

/**
 * 修改订单配置信息
 * @param data
 */
export const updateOrderSetting = (data: OrderSettingForm) => {
  return request({
    url: '/oms/orderSetting',
    method: 'put',
    data: data
  });
};

/**
 * 删除订单配置信息
 * @param id
 */
export const delOrderSetting = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/orderSetting/' + id,
    method: 'delete'
  });
};
