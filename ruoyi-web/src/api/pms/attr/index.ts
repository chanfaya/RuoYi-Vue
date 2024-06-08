import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AttrVO, AttrForm, AttrQuery } from '@/api/pms/attr/types';

/**
 * 查询商品属性列表
 * @param query
 * @returns {*}
 */

export const listAttr = (query?: AttrQuery): AxiosPromise<AttrVO[]> => {
  return request({
    url: '/pms/attr/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询商品属性详细
 * @param attrId
 */
export const getAttr = (attrId: string | number): AxiosPromise<AttrVO> => {
  return request({
    url: '/pms/attr/' + attrId,
    method: 'get'
  });
};

/**
 * 新增商品属性
 * @param data
 */
export const addAttr = (data: AttrForm) => {
  return request({
    url: '/pms/attr',
    method: 'post',
    data: data
  });
};

/**
 * 修改商品属性
 * @param data
 */
export const updateAttr = (data: AttrForm) => {
  return request({
    url: '/pms/attr',
    method: 'put',
    data: data
  });
};

/**
 * 删除商品属性
 * @param attrId
 */
export const delAttr = (attrId: string | number | Array<string | number>) => {
  return request({
    url: '/pms/attr/' + attrId,
    method: 'delete'
  });
};
