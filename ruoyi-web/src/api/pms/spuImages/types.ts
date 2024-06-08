export interface SpuImagesVO {
  /**
   * 
   */
  id: string | number;

  /**
   * spu_id
   */
  spuId: string | number;

  /**
   * 图片名
   */
  imgName: string;

  /**
   * 图片地址
   */
  imgUrl: string;

  /**
   * 顺序
   */
  imgSort: number;

  /**
   * 是否默认图
   */
  defaultImg: number;

}

export interface SpuImagesForm extends BaseEntity {
  /**
   * 
   */
  id?: string | number;

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * 图片名
   */
  imgName?: string;

  /**
   * 图片地址
   */
  imgUrl?: string;

  /**
   * 顺序
   */
  imgSort?: number;

  /**
   * 是否默认图
   */
  defaultImg?: number;

}

export interface SpuImagesQuery extends PageQuery {

  /**
   * spu_id
   */
  spuId?: string | number;

  /**
   * 图片名
   */
  imgName?: string;

  /**
   * 图片地址
   */
  imgUrl?: string;

  /**
   * 顺序
   */
  imgSort?: number;

  /**
   * 是否默认图
   */
  defaultImg?: number;

    /**
     * 日期范围参数
     */
    params?: any;
}



