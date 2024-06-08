import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SpuCommentVO, SpuCommentForm, SpuCommentQuery } from '@/api/pms/spuComment/types';

/**
 * 查询商品评价列表
 * @param query
 * @returns {*}
 */

export const listSpuComment = (query?: SpuCommentQuery): AxiosPromise<SpuCommentVO[]> => {
  return request({
    url: '/pms/spuComment/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询商品评价详细
 * @param id
 */
export const getSpuComment = (id: string | number): AxiosPromise<SpuCommentVO> => {
  return request({
    url: '/pms/spuComment/' + id,
    method: 'get'
  });
};

/**
 * 新增商品评价
 * @param data
 */
export const addSpuComment = (data: SpuCommentForm) => {
  return request({
    url: '/pms/spuComment',
    method: 'post',
    data: data
  });
};

/**
 * 修改商品评价
 * @param data
 */
export const updateSpuComment = (data: SpuCommentForm) => {
  return request({
    url: '/pms/spuComment',
    method: 'put',
    data: data
  });
};

/**
 * 删除商品评价
 * @param id
 */
export const delSpuComment = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/spuComment/' + id,
    method: 'delete'
  });
};
