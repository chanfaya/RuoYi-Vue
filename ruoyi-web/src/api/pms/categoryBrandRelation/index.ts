import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CategoryBrandRelationVO, CategoryBrandRelationForm, CategoryBrandRelationQuery } from '@/api/pms/categoryBrandRelation/types';

/**
 * 查询品牌分类关联列表
 * @param query
 * @returns {*}
 */

export const listCategoryBrandRelation = (query?: CategoryBrandRelationQuery): AxiosPromise<CategoryBrandRelationVO[]> => {
  return request({
    url: '/pms/categoryBrandRelation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询品牌分类关联详细
 * @param id
 */
export const getCategoryBrandRelation = (id: string | number): AxiosPromise<CategoryBrandRelationVO> => {
  return request({
    url: '/pms/categoryBrandRelation/' + id,
    method: 'get'
  });
};

/**
 * 新增品牌分类关联
 * @param data
 */
export const addCategoryBrandRelation = (data: CategoryBrandRelationForm) => {
  return request({
    url: '/pms/categoryBrandRelation',
    method: 'post',
    data: data
  });
};

/**
 * 修改品牌分类关联
 * @param data
 */
export const updateCategoryBrandRelation = (data: CategoryBrandRelationForm) => {
  return request({
    url: '/pms/categoryBrandRelation',
    method: 'put',
    data: data
  });
};

/**
 * 删除品牌分类关联
 * @param id
 */
export const delCategoryBrandRelation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/categoryBrandRelation/' + id,
    method: 'delete'
  });
};
