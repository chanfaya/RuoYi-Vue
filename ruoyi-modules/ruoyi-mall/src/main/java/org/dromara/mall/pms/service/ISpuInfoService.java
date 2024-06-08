package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SpuInfoVo;
import org.dromara.mall.pms.domain.bo.SpuInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * spu信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISpuInfoService {

    /**
     * 查询spu信息
     *
     * @param id 主键
     * @return spu信息
     */
    SpuInfoVo queryById(Long id);

    /**
     * 分页查询spu信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu信息分页列表
     */
    TableDataInfo<SpuInfoVo> queryPageList(SpuInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的spu信息列表
     *
     * @param bo 查询条件
     * @return spu信息列表
     */
    List<SpuInfoVo> queryList(SpuInfoBo bo);

    /**
     * 新增spu信息
     *
     * @param bo spu信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SpuInfoBo bo);

    /**
     * 修改spu信息
     *
     * @param bo spu信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SpuInfoBo bo);

    /**
     * 校验并批量删除spu信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
