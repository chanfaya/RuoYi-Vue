import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SkuSaleAttrValueVO, SkuSaleAttrValueForm, SkuSaleAttrValueQuery } from '@/api/pms/skuSaleAttrValue/types';

/**
 * 查询sku销售属性&值列表
 * @param query
 * @returns {*}
 */

export const listSkuSaleAttrValue = (query?: SkuSaleAttrValueQuery): AxiosPromise<SkuSaleAttrValueVO[]> => {
  return request({
    url: '/pms/skuSaleAttrValue/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询sku销售属性&值详细
 * @param id
 */
export const getSkuSaleAttrValue = (id: string | number): AxiosPromise<SkuSaleAttrValueVO> => {
  return request({
    url: '/pms/skuSaleAttrValue/' + id,
    method: 'get'
  });
};

/**
 * 新增sku销售属性&值
 * @param data
 */
export const addSkuSaleAttrValue = (data: SkuSaleAttrValueForm) => {
  return request({
    url: '/pms/skuSaleAttrValue',
    method: 'post',
    data: data
  });
};

/**
 * 修改sku销售属性&值
 * @param data
 */
export const updateSkuSaleAttrValue = (data: SkuSaleAttrValueForm) => {
  return request({
    url: '/pms/skuSaleAttrValue',
    method: 'put',
    data: data
  });
};

/**
 * 删除sku销售属性&值
 * @param id
 */
export const delSkuSaleAttrValue = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/skuSaleAttrValue/' + id,
    method: 'delete'
  });
};
