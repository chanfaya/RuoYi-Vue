import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SkuInfoVO, SkuInfoForm, SkuInfoQuery } from '@/api/pms/skuInfo/types';

/**
 * 查询sku信息列表
 * @param query
 * @returns {*}
 */

export const listSkuInfo = (query?: SkuInfoQuery): AxiosPromise<SkuInfoVO[]> => {
  return request({
    url: '/pms/skuInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询sku信息详细
 * @param skuId
 */
export const getSkuInfo = (skuId: string | number): AxiosPromise<SkuInfoVO> => {
  return request({
    url: '/pms/skuInfo/' + skuId,
    method: 'get'
  });
};

/**
 * 新增sku信息
 * @param data
 */
export const addSkuInfo = (data: SkuInfoForm) => {
  return request({
    url: '/pms/skuInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改sku信息
 * @param data
 */
export const updateSkuInfo = (data: SkuInfoForm) => {
  return request({
    url: '/pms/skuInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除sku信息
 * @param skuId
 */
export const delSkuInfo = (skuId: string | number | Array<string | number>) => {
  return request({
    url: '/pms/skuInfo/' + skuId,
    method: 'delete'
  });
};
