package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SkuInfoVo;
import org.dromara.mall.pms.domain.bo.SkuInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * sku信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISkuInfoService {

    /**
     * 查询sku信息
     *
     * @param skuId 主键
     * @return sku信息
     */
    SkuInfoVo queryById(Long skuId);

    /**
     * 分页查询sku信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return sku信息分页列表
     */
    TableDataInfo<SkuInfoVo> queryPageList(SkuInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的sku信息列表
     *
     * @param bo 查询条件
     * @return sku信息列表
     */
    List<SkuInfoVo> queryList(SkuInfoBo bo);

    /**
     * 新增sku信息
     *
     * @param bo sku信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SkuInfoBo bo);

    /**
     * 修改sku信息
     *
     * @param bo sku信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SkuInfoBo bo);

    /**
     * 校验并批量删除sku信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
