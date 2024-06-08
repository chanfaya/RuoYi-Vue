package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SkuSaleAttrValueVo;
import org.dromara.mall.pms.domain.bo.SkuSaleAttrValueBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * sku销售属性&值Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISkuSaleAttrValueService {

    /**
     * 查询sku销售属性&值
     *
     * @param id 主键
     * @return sku销售属性&值
     */
    SkuSaleAttrValueVo queryById(Long id);

    /**
     * 分页查询sku销售属性&值列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return sku销售属性&值分页列表
     */
    TableDataInfo<SkuSaleAttrValueVo> queryPageList(SkuSaleAttrValueBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的sku销售属性&值列表
     *
     * @param bo 查询条件
     * @return sku销售属性&值列表
     */
    List<SkuSaleAttrValueVo> queryList(SkuSaleAttrValueBo bo);

    /**
     * 新增sku销售属性&值
     *
     * @param bo sku销售属性&值
     * @return 是否新增成功
     */
    Boolean insertByBo(SkuSaleAttrValueBo bo);

    /**
     * 修改sku销售属性&值
     *
     * @param bo sku销售属性&值
     * @return 是否修改成功
     */
    Boolean updateByBo(SkuSaleAttrValueBo bo);

    /**
     * 校验并批量删除sku销售属性&值信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
