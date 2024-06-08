export interface SpuCommentVO {
  /**
   * 
   */
  id: string | number;

  /**
   * sku_id
   */
  skuId: string | number;

  /**
   * spu_id
   */
  spuId: string | number;

  /**
   * 商品名字
   */
  spuName: string;

  /**
   * 会员昵称
   */
  memberNickName: string;

  /**
   * 星级
   */
  star: number;

  /**
   * 会员ip
   */
  memberIp: string;

  /**
   * 显示状态[0-不显示，1-显示]
   */
  showStatus: number;

  /**
   * 购买时属性组合
   */
  spuAttributes: string;

  /**
   * 点赞数
   */
  likesCount: number;

  /**
   * 回复数
   */
  replyCount: number;

  /**
   * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
   */
  resources: string;

  /**
   * 内容
   */
  content: string;

  /**
   * 用户头像
   */
  memberIcon: string;

  /**
   * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
   */
  commentType: number;

}

export interface SpuCommentForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * 商品名字
   */
  spuName?: string;

  /**
   * 会员昵称
   */
  memberNickName?: string;

  /**
   * 星级
   */
  star?: number;

  /**
   * 会员ip
   */
  memberIp?: string;

  /**
   * 显示状态[0-不显示，1-显示]
   */
  showStatus?: number;

  /**
   * 购买时属性组合
   */
  spuAttributes?: string;

  /**
   * 点赞数
   */
  likesCount?: number;

  /**
   * 回复数
   */
  replyCount?: number;

  /**
   * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
   */
  resources?: string;

  /**
   * 内容
   */
  content?: string;

  /**
   * 用户头像
   */
  memberIcon?: string;

  /**
   * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
   */
  commentType?: number;

}

export interface SpuCommentQuery extends PageQuery {

  /**
   * sku_id
   */
  skuId?: string | number;

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * 商品名字
   */
  spuName?: string;

  /**
   * 会员昵称
   */
  memberNickName?: string;

  /**
   * 星级
   */
  star?: number;

  /**
   * 会员ip
   */
  memberIp?: string;

  /**
   * 显示状态[0-不显示，1-显示]
   */
  showStatus?: number;

  /**
   * 购买时属性组合
   */
  spuAttributes?: string;

  /**
   * 点赞数
   */
  likesCount?: number;

  /**
   * 回复数
   */
  replyCount?: number;

  /**
   * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
   */
  resources?: string;

  /**
   * 内容
   */
  content?: string;

  /**
   * 用户头像
   */
  memberIcon?: string;

  /**
   * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
   */
  commentType?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



