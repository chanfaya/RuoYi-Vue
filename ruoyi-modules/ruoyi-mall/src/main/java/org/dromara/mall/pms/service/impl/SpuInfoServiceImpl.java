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
import org.dromara.mall.pms.domain.bo.SpuInfoBo;
import org.dromara.mall.pms.domain.vo.SpuInfoVo;
import org.dromara.mall.pms.domain.SpuInfo;
import org.dromara.mall.pms.mapper.SpuInfoMapper;
import org.dromara.mall.pms.service.ISpuInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * spu信息Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class SpuInfoServiceImpl implements ISpuInfoService {

    private final SpuInfoMapper baseMapper;

    /**
     * 查询spu信息
     *
     * @param id 主键
     * @return spu信息
     */
    @Override
    public SpuInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询spu信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu信息分页列表
     */
    @Override
    public TableDataInfo<SpuInfoVo> queryPageList(SpuInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpuInfo> lqw = buildQueryWrapper(bo);
        Page<SpuInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的spu信息列表
     *
     * @param bo 查询条件
     * @return spu信息列表
     */
    @Override
    public List<SpuInfoVo> queryList(SpuInfoBo bo) {
        LambdaQueryWrapper<SpuInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpuInfo> buildQueryWrapper(SpuInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpuInfo> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getSpuName()), SpuInfo::getSpuName, bo.getSpuName());
        lqw.eq(StringUtils.isNotBlank(bo.getSpuDescription()), SpuInfo::getSpuDescription, bo.getSpuDescription());
        lqw.eq(bo.getCatalogId() != null, SpuInfo::getCatalogId, bo.getCatalogId());
        lqw.eq(bo.getBrandId() != null, SpuInfo::getBrandId, bo.getBrandId());
        lqw.eq(bo.getWeight() != null, SpuInfo::getWeight, bo.getWeight());
        lqw.eq(bo.getPublishStatus() != null, SpuInfo::getPublishStatus, bo.getPublishStatus());
        return lqw;
    }

    /**
     * 新增spu信息
     *
     * @param bo spu信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpuInfoBo bo) {
        SpuInfo add = MapstructUtils.convert(bo, SpuInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改spu信息
     *
     * @param bo spu信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpuInfoBo bo) {
        SpuInfo update = MapstructUtils.convert(bo, SpuInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpuInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除spu信息信息
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
