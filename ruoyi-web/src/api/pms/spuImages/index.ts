import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SpuImagesVO, SpuImagesForm, SpuImagesQuery } from '@/api/pms/spuImages/types';

/**
 * 查询spu图片列表
 * @param query
 * @returns {*}
 */

export const listSpuImages = (query?: SpuImagesQuery): AxiosPromise<SpuImagesVO[]> => {
  return request({
    url: '/pms/spuImages/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询spu图片详细
 * @param id
 */
export const getSpuImages = (id: string | number): AxiosPromise<SpuImagesVO> => {
  return request({
    url: '/pms/spuImages/' + id,
    method: 'get'
  });
};

/**
 * 新增spu图片
 * @param data
 */
export const addSpuImages = (data: SpuImagesForm) => {
  return request({
    url: '/pms/spuImages',
    method: 'post',
    data: data
  });
};

/**
 * 修改spu图片
 * @param data
 */
export const updateSpuImages = (data: SpuImagesForm) => {
  return request({
    url: '/pms/spuImages',
    method: 'put',
    data: data
  });
};

/**
 * 删除spu图片
 * @param id
 */
export const delSpuImages = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/spuImages/' + id,
    method: 'delete'
  });
};
