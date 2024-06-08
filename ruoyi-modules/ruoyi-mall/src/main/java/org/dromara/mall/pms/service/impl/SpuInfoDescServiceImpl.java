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
import org.dromara.mall.pms.domain.bo.SpuInfoDescBo;
import org.dromara.mall.pms.domain.vo.SpuInfoDescVo;
import org.dromara.mall.pms.domain.SpuInfoDesc;
import org.dromara.mall.pms.mapper.SpuInfoDescMapper;
import org.dromara.mall.pms.service.ISpuInfoDescService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * spu信息介绍Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class SpuInfoDescServiceImpl implements ISpuInfoDescService {

    private final SpuInfoDescMapper baseMapper;

    /**
     * 查询spu信息介绍
     *
     * @param spuId 主键
     * @return spu信息介绍
     */
    @Override
    public SpuInfoDescVo queryById(Long spuId){
        return baseMapper.selectVoById(spuId);
    }

    /**
     * 分页查询spu信息介绍列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu信息介绍分页列表
     */
    @Override
    public TableDataInfo<SpuInfoDescVo> queryPageList(SpuInfoDescBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpuInfoDesc> lqw = buildQueryWrapper(bo);
        Page<SpuInfoDescVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的spu信息介绍列表
     *
     * @param bo 查询条件
     * @return spu信息介绍列表
     */
    @Override
    public List<SpuInfoDescVo> queryList(SpuInfoDescBo bo) {
        LambdaQueryWrapper<SpuInfoDesc> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpuInfoDesc> buildQueryWrapper(SpuInfoDescBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpuInfoDesc> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getDecript()), SpuInfoDesc::getDecript, bo.getDecript());
        return lqw;
    }

    /**
     * 新增spu信息介绍
     *
     * @param bo spu信息介绍
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpuInfoDescBo bo) {
        SpuInfoDesc add = MapstructUtils.convert(bo, SpuInfoDesc.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setSpuId(add.getSpuId());
        }
        return flag;
    }

    /**
     * 修改spu信息介绍
     *
     * @param bo spu信息介绍
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpuInfoDescBo bo) {
        SpuInfoDesc update = MapstructUtils.convert(bo, SpuInfoDesc.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpuInfoDesc entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除spu信息介绍信息
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
