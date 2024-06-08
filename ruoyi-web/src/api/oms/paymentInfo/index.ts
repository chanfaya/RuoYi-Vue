import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { PaymentInfoVO, PaymentInfoForm, PaymentInfoQuery } from '@/api/oms/paymentInfo/types';

/**
 * 查询支付信息列表
 * @param query
 * @returns {*}
 */

export const listPaymentInfo = (query?: PaymentInfoQuery): AxiosPromise<PaymentInfoVO[]> => {
  return request({
    url: '/oms/paymentInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询支付信息详细
 * @param id
 */
export const getPaymentInfo = (id: string | number): AxiosPromise<PaymentInfoVO> => {
  return request({
    url: '/oms/paymentInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增支付信息
 * @param data
 */
export const addPaymentInfo = (data: PaymentInfoForm) => {
  return request({
    url: '/oms/paymentInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改支付信息
 * @param data
 */
export const updatePaymentInfo = (data: PaymentInfoForm) => {
  return request({
    url: '/oms/paymentInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除支付信息
 * @param id
 */
export const delPaymentInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/paymentInfo/' + id,
    method: 'delete'
  });
};
