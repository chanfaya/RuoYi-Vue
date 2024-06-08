package org.dromara.mall.pms.service;

import org.dromara.mall.pms.domain.vo.SpuCommentVo;
import org.dromara.mall.pms.domain.bo.SpuCommentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 商品评价Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface ISpuCommentService {

    /**
     * 查询商品评价
     *
     * @param id 主键
     * @return 商品评价
     */
    SpuCommentVo queryById(Long id);

    /**
     * 分页查询商品评价列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 商品评价分页列表
     */
    TableDataInfo<SpuCommentVo> queryPageList(SpuCommentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的商品评价列表
     *
     * @param bo 查询条件
     * @return 商品评价列表
     */
    List<SpuCommentVo> queryList(SpuCommentBo bo);

    /**
     * 新增商品评价
     *
     * @param bo 商品评价
     * @return 是否新增成功
     */
    Boolean insertByBo(SpuCommentBo bo);

    /**
     * 修改商品评价
     *
     * @param bo 商品评价
     * @return 是否修改成功
     */
    Boolean updateByBo(SpuCommentBo bo);

    /**
     * 校验并批量删除商品评价信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
