package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SpuInfoDescVo;
import org.dromara.mall.pms.domain.bo.SpuInfoDescBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * spu信息介绍Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISpuInfoDescService {

    /**
     * 查询spu信息介绍
     *
     * @param spuId 主键
     * @return spu信息介绍
     */
    SpuInfoDescVo queryById(Long spuId);

    /**
     * 分页查询spu信息介绍列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu信息介绍分页列表
     */
    TableDataInfo<SpuInfoDescVo> queryPageList(SpuInfoDescBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的spu信息介绍列表
     *
     * @param bo 查询条件
     * @return spu信息介绍列表
     */
    List<SpuInfoDescVo> queryList(SpuInfoDescBo bo);

    /**
     * 新增spu信息介绍
     *
     * @param bo spu信息介绍
     * @return 是否新增成功
     */
    Boolean insertByBo(SpuInfoDescBo bo);

    /**
     * 修改spu信息介绍
     *
     * @param bo spu信息介绍
     * @return 是否修改成功
     */
    Boolean updateByBo(SpuInfoDescBo bo);

    /**
     * 校验并批量删除spu信息介绍信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
