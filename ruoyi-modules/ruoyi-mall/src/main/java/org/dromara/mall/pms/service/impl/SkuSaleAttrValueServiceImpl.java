package org.dromara.mall.pms.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.mall.pms.domain.bo.SkuSaleAttrValueBo;
import org.dromara.mall.pms.domain.vo.SkuSaleAttrValueVo;
import org.dromara.mall.pms.domain.SkuSaleAttrValue;
import org.dromara.mall.pms.mapper.SkuSaleAttrValueMapper;
import org.dromara.mall.pms.service.ISkuSaleAttrValueService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * sku销售属性&值Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class SkuSaleAttrValueServiceImpl implements ISkuSaleAttrValueService {

    private final SkuSaleAttrValueMapper baseMapper;

    /**
     * 查询sku销售属性&值
     *
     * @param id 主键
     * @return sku销售属性&值
     */
    @Override
    public SkuSaleAttrValueVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询sku销售属性&值列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return sku销售属性&值分页列表
     */
    @Override
    public TableDataInfo<SkuSaleAttrValueVo> queryPageList(SkuSaleAttrValueBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SkuSaleAttrValue> lqw = buildQueryWrapper(bo);
        Page<SkuSaleAttrValueVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的sku销售属性&值列表
     *
     * @param bo 查询条件
     * @return sku销售属性&值列表
     */
    @Override
    public List<SkuSaleAttrValueVo> queryList(SkuSaleAttrValueBo bo) {
        LambdaQueryWrapper<SkuSaleAttrValue> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SkuSaleAttrValue> buildQueryWrapper(SkuSaleAttrValueBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SkuSaleAttrValue> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getSkuId() != null, SkuSaleAttrValue::getSkuId, bo.getSkuId());
        lqw.eq(bo.getAttrId() != null, SkuSaleAttrValue::getAttrId, bo.getAttrId());
        lqw.like(StringUtils.isNotBlank(bo.getAttrName()), SkuSaleAttrValue::getAttrName, bo.getAttrName());
        lqw.eq(StringUtils.isNotBlank(bo.getAttrValue()), SkuSaleAttrValue::getAttrValue, bo.getAttrValue());
        lqw.eq(bo.getAttrSort() != null, SkuSaleAttrValue::getAttrSort, bo.getAttrSort());
        return lqw;
    }

    /**
     * 新增sku销售属性&值
     *
     * @param bo sku销售属性&值
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SkuSaleAttrValueBo bo) {
        SkuSaleAttrValue add = MapstructUtils.convert(bo, SkuSaleAttrValue.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改sku销售属性&值
     *
     * @param bo sku销售属性&值
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SkuSaleAttrValueBo bo) {
        SkuSaleAttrValue update = MapstructUtils.convert(bo, SkuSaleAttrValue.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SkuSaleAttrValue entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除sku销售属性&值信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
