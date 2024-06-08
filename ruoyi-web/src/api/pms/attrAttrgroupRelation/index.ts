import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { AttrAttrgroupRelationVO, AttrAttrgroupRelationForm, AttrAttrgroupRelationQuery } from '@/api/pms/attrAttrgroupRelation/types';

/**
 * 查询属性&属性分组关联列表
 * @param query
 * @returns {*}
 */

export const listAttrAttrgroupRelation = (query?: AttrAttrgroupRelationQuery): AxiosPromise<AttrAttrgroupRelationVO[]> => {
  return request({
    url: '/pms/attrAttrgroupRelation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询属性&属性分组关联详细
 * @param id
 */
export const getAttrAttrgroupRelation = (id: string | number): AxiosPromise<AttrAttrgroupRelationVO> => {
  return request({
    url: '/pms/attrAttrgroupRelation/' + id,
    method: 'get'
  });
};

/**
 * 新增属性&属性分组关联
 * @param data
 */
export const addAttrAttrgroupRelation = (data: AttrAttrgroupRelationForm) => {
  return request({
    url: '/pms/attrAttrgroupRelation',
    method: 'post',
    data: data
  });
};

/**
 * 修改属性&属性分组关联
 * @param data
 */
export const updateAttrAttrgroupRelation = (data: AttrAttrgroupRelationForm) => {
  return request({
    url: '/pms/attrAttrgroupRelation',
    method: 'put',
    data: data
  });
};

/**
 * 删除属性&属性分组关联
 * @param id
 */
export const delAttrAttrgroupRelation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/attrAttrgroupRelation/' + id,
    method: 'delete'
  });
};
