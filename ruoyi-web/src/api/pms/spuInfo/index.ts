import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SpuInfoVO, SpuInfoForm, SpuInfoQuery } from '@/api/pms/spuInfo/types';

/**
 * 查询spu信息列表
 * @param query
 * @returns {*}
 */

export const listSpuInfo = (query?: SpuInfoQuery): AxiosPromise<SpuInfoVO[]> => {
  return request({
    url: '/pms/spuInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询spu信息详细
 * @param id
 */
export const getSpuInfo = (id: string | number): AxiosPromise<SpuInfoVO> => {
  return request({
    url: '/pms/spuInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增spu信息
 * @param data
 */
export const addSpuInfo = (data: SpuInfoForm) => {
  return request({
    url: '/pms/spuInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改spu信息
 * @param data
 */
export const updateSpuInfo = (data: SpuInfoForm) => {
  return request({
    url: '/pms/spuInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除spu信息
 * @param id
 */
export const delSpuInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/spuInfo/' + id,
    method: 'delete'
  });
};
