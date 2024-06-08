import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AttrGroupVO, AttrGroupForm, AttrGroupQuery } from '@/api/pms/attrGroup/types';

/**
 * 查询属性分组列表
 * @param query
 * @returns {*}
 */

export const listAttrGroup = (query?: AttrGroupQuery): AxiosPromise<AttrGroupVO[]> => {
  return request({
    url: '/pms/attrGroup/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询属性分组详细
 * @param attrGroupId
 */
export const getAttrGroup = (attrGroupId: string | number): AxiosPromise<AttrGroupVO> => {
  return request({
    url: '/pms/attrGroup/' + attrGroupId,
    method: 'get'
  });
};

/**
 * 新增属性分组
 * @param data
 */
export const addAttrGroup = (data: AttrGroupForm) => {
  return request({
    url: '/pms/attrGroup',
    method: 'post',
    data: data
  });
};

/**
 * 修改属性分组
 * @param data
 */
export const updateAttrGroup = (data: AttrGroupForm) => {
  return request({
    url: '/pms/attrGroup',
    method: 'put',
    data: data
  });
};

/**
 * 删除属性分组
 * @param attrGroupId
 */
export const delAttrGroup = (attrGroupId: string | number | Array<string | number>) => {
  return request({
    url: '/pms/attrGroup/' + attrGroupId,
    method: 'delete'
  });
};
