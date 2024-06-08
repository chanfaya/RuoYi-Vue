package org.dromara.mall.pms.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.dromara.mall.pms.domain.Brand;
import org.dromara.mall.pms.domain.vo.BrandVo;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

/**
 * 品牌Mapper接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
@DS("slave")
public interface BrandMapper extends BaseMapperPlus<Brand, BrandVo> {

}
