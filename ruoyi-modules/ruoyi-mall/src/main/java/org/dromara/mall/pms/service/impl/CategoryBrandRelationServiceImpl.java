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
import org.dromara.mall.pms.domain.bo.CategoryBrandRelationBo;
import org.dromara.mall.pms.domain.vo.CategoryBrandRelationVo;
import org.dromara.mall.pms.domain.CategoryBrandRelation;
import org.dromara.mall.pms.mapper.CategoryBrandRelationMapper;
import org.dromara.mall.pms.service.ICategoryBrandRelationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 品牌分类关联Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class CategoryBrandRelationServiceImpl implements ICategoryBrandRelationService {

    private final CategoryBrandRelationMapper baseMapper;

    /**
     * 查询品牌分类关联
     *
     * @param id 主键
     * @return 品牌分类关联
     */
    @Override
    public CategoryBrandRelationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询品牌分类关联列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 品牌分类关联分页列表
     */
    @Override
    public TableDataInfo<CategoryBrandRelationVo> queryPageList(CategoryBrandRelationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CategoryBrandRelation> lqw = buildQueryWrapper(bo);
        Page<CategoryBrandRelationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的品牌分类关联列表
     *
     * @param bo 查询条件
     * @return 品牌分类关联列表
     */
    @Override
    public List<CategoryBrandRelationVo> queryList(CategoryBrandRelationBo bo) {
        LambdaQueryWrapper<CategoryBrandRelation> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CategoryBrandRelation> buildQueryWrapper(CategoryBrandRelationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CategoryBrandRelation> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getBrandId() != null, CategoryBrandRelation::getBrandId, bo.getBrandId());
        lqw.eq(bo.getCatelogId() != null, CategoryBrandRelation::getCatelogId, bo.getCatelogId());
        lqw.like(StringUtils.isNotBlank(bo.getBrandName()), CategoryBrandRelation::getBrandName, bo.getBrandName());
        lqw.like(StringUtils.isNotBlank(bo.getCatelogName()), CategoryBrandRelation::getCatelogName, bo.getCatelogName());
        return lqw;
    }

    /**
     * 新增品牌分类关联
     *
     * @param bo 品牌分类关联
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CategoryBrandRelationBo bo) {
        CategoryBrandRelation add = MapstructUtils.convert(bo, CategoryBrandRelation.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改品牌分类关联
     *
     * @param bo 品牌分类关联
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CategoryBrandRelationBo bo) {
        CategoryBrandRelation update = MapstructUtils.convert(bo, CategoryBrandRelation.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CategoryBrandRelation entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除品牌分类关联信息
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
