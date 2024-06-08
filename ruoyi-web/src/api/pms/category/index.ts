import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CategoryVO, CategoryForm, CategoryQuery } from '@/api/pms/category/types';

/**
 * 查询商品三级分类列表
 * @param query
 * @returns {*}
 */

export const listCategory = (query?: CategoryQuery): AxiosPromise<CategoryVO[]> => {
  return request({
    url: '/pms/category/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询商品三级分类详细
 * @param catId
 */
export const getCategory = (catId: string | number): AxiosPromise<CategoryVO> => {
  return request({
    url: '/pms/category/' + catId,
    method: 'get'
  });
};

/**
 * 新增商品三级分类
 * @param data
 */
export const addCategory = (data: CategoryForm) => {
  return request({
    url: '/pms/category',
    method: 'post',
    data: data
  });
};

/**
 * 修改商品三级分类
 * @param data
 */
export const updateCategory = (data: CategoryForm) => {
  return request({
    url: '/pms/category',
    method: 'put',
    data: data
  });
};

/**
 * 删除商品三级分类
 * @param catId
 */
export const delCategory = (catId: string | number | Array<string | number>) => {
  return request({
    url: '/pms/category/' + catId,
    method: 'delete'
  });
};
