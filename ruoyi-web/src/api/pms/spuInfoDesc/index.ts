import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SpuInfoDescVO, SpuInfoDescForm, SpuInfoDescQuery } from '@/api/pms/spuInfoDesc/types';

/**
 * 查询spu信息介绍列表
 * @param query
 * @returns {*}
 */

export const listSpuInfoDesc = (query?: SpuInfoDescQuery): AxiosPromise<SpuInfoDescVO[]> => {
  return request({
    url: '/pms/spuInfoDesc/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询spu信息介绍详细
 * @param spuId
 */
export const getSpuInfoDesc = (spuId: string | number): AxiosPromise<SpuInfoDescVO> => {
  return request({
    url: '/pms/spuInfoDesc/' + spuId,
    method: 'get'
  });
};

/**
 * 新增spu信息介绍
 * @param data
 */
export const addSpuInfoDesc = (data: SpuInfoDescForm) => {
  return request({
    url: '/pms/spuInfoDesc',
    method: 'post',
    data: data
  });
};

/**
 * 修改spu信息介绍
 * @param data
 */
export const updateSpuInfoDesc = (data: SpuInfoDescForm) => {
  return request({
    url: '/pms/spuInfoDesc',
    method: 'put',
    data: data
  });
};

/**
 * 删除spu信息介绍
 * @param spuId
 */
export const delSpuInfoDesc = (spuId: string | number | Array<string | number>) => {
  return request({
    url: '/pms/spuInfoDesc/' + spuId,
    method: 'delete'
  });
};
