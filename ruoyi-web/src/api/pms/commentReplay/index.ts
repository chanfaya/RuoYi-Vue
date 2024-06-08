import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CommentReplayVO, CommentReplayForm, CommentReplayQuery } from '@/api/pms/commentReplay/types';

/**
 * 查询商品评价回复关系列表
 * @param query
 * @returns {*}
 */

export const listCommentReplay = (query?: CommentReplayQuery): AxiosPromise<CommentReplayVO[]> => {
  return request({
    url: '/pms/commentReplay/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询商品评价回复关系详细
 * @param id
 */
export const getCommentReplay = (id: string | number): AxiosPromise<CommentReplayVO> => {
  return request({
    url: '/pms/commentReplay/' + id,
    method: 'get'
  });
};

/**
 * 新增商品评价回复关系
 * @param data
 */
export const addCommentReplay = (data: CommentReplayForm) => {
  return request({
    url: '/pms/commentReplay',
    method: 'post',
    data: data
  });
};

/**
 * 修改商品评价回复关系
 * @param data
 */
export const updateCommentReplay = (data: CommentReplayForm) => {
  return request({
    url: '/pms/commentReplay',
    method: 'put',
    data: data
  });
};

/**
 * 删除商品评价回复关系
 * @param id
 */
export const delCommentReplay = (id: string | number | Array<string | number>) => {
  return request({
    url: '/pms/commentReplay/' + id,
    method: 'delete'
  });
};
