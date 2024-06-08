import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SkuImagesVO, SkuImagesForm, SkuImagesQuery } from '@/api/pms/skuImages/types';

/**
 * 查询sku图片列表
 * @param query
 * @returns {*}
 */

export const listSkuImages = (query?: SkuImagesQuery): AxiosPromise<SkuImagesVO[]> => {
  return request({
    url: '/pms/skuImages/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询sku图片详细
 * @param id
 */
export const getSkuImages = (id: string | number): AxiosPromise<SkuImagesVO> => {
  return request({
    url: '/pms/skuImages/' + id,
    method: 'get'
  });
};

/**
 * 新增sku图片
 * @param data
 */
export const addSkuImages = (data: SkuImagesForm) => {
  return request({
    url: '/pms/skuImages',
    method: 'post',
    data: data
  });
};

/**
 * 修改sku图片
 * @param data
 */
export const updateSkuImages = (data: SkuImagesForm) => {
  return request({
    url: '/pms/skuImages',
    method: 'put',
    data: data
  });
};

/**
 * 删除sku图片
 * @param id
 */
export const delSkuImages = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/skuImages/' + id,
    method: 'delete'
  });
};
