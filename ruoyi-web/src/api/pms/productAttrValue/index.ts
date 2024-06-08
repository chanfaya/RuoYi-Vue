import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { ProductAttrValueVO, ProductAttrValueForm, ProductAttrValueQuery } from '@/api/pms/productAttrValue/types';

/**
 * 查询spu属性值列表
 * @param query
 * @returns {*}
 */

export const listProductAttrValue = (query?: ProductAttrValueQuery): AxiosPromise<ProductAttrValueVO[]> => {
  return request({
    url: '/pms/productAttrValue/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询spu属性值详细
 * @param id
 */
export const getProductAttrValue = (id: string | number): AxiosPromise<ProductAttrValueVO> => {
  return request({
    url: '/pms/productAttrValue/' + id,
    method: 'get'
  });
};

/**
 * 新增spu属性值
 * @param data
 */
export const addProductAttrValue = (data: ProductAttrValueForm) => {
  return request({
    url: '/pms/productAttrValue',
    method: 'post',
    data: data
  });
};

/**
 * 修改spu属性值
 * @param data
 */
export const updateProductAttrValue = (data: ProductAttrValueForm) => {
  return request({
    url: '/pms/productAttrValue',
    method: 'put',
    data: data
  });
};

/**
 * 删除spu属性值
 * @param id
 */
export const delProductAttrValue = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/productAttrValue/' + id,
    method: 'delete'
  });
};
