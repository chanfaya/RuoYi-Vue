import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RefundInfoVO, RefundInfoForm, RefundInfoQuery } from '@/api/oms/refundInfo/types';

/**
 * 查询退款信息列表
 * @param query
 * @returns {*}
 */

export const listRefundInfo = (query?: RefundInfoQuery): AxiosPromise<RefundInfoVO[]> => {
  return request({
    url: '/oms/refundInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询退款信息详细
 * @param id
 */
export const getRefundInfo = (id: string | number): AxiosPromise<RefundInfoVO> => {
  return request({
    url: '/oms/refundInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增退款信息
 * @param data
 */
export const addRefundInfo = (data: RefundInfoForm) => {
  return request({
    url: '/oms/refundInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改退款信息
 * @param data
 */
export const updateRefundInfo = (data: RefundInfoForm) => {
  return request({
    url: '/oms/refundInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除退款信息
 * @param id
 */
export const delRefundInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/oms/refundInfo/' + id,
    method: 'delete'
  });
};
