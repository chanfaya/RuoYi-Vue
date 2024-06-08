package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SpuImagesVo;
import org.dromara.mall.pms.domain.bo.SpuImagesBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * spu图片Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISpuImagesService {

    /**
     * 查询spu图片
     *
     * @param id 主键
     * @return spu图片
     */
    SpuImagesVo queryById(Long id);

    /**
     * 分页查询spu图片列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu图片分页列表
     */
    TableDataInfo<SpuImagesVo> queryPageList(SpuImagesBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的spu图片列表
     *
     * @param bo 查询条件
     * @return spu图片列表
     */
    List<SpuImagesVo> queryList(SpuImagesBo bo);

    /**
     * 新增spu图片
     *
     * @param bo spu图片
     * @return 是否新增成功
     */
    Boolean insertByBo(SpuImagesBo bo);

    /**
     * 修改spu图片
     *
     * @param bo spu图片
     * @return 是否修改成功
     */
    Boolean updateByBo(SpuImagesBo bo);

    /**
     * 校验并批量删除spu图片信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
