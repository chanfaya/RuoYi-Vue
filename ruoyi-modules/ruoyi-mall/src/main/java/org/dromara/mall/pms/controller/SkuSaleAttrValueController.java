package org.dromara.mall.pms.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.mall.pms.domain.vo.SkuSaleAttrValueVo;
import org.dromara.mall.pms.domain.bo.SkuSaleAttrValueBo;
import org.dromara.mall.pms.service.ISkuSaleAttrValueService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * sku销售属性&值
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pms/skuSaleAttrValue")
public class SkuSaleAttrValueController extends BaseController {

    private final ISkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @SaCheckPermission("pms:skuSaleAttrValue:list")
    @GetMapping("/list")
    public TableDataInfo<SkuSaleAttrValueVo> list(SkuSaleAttrValueBo bo, PageQuery pageQuery) {
        return skuSaleAttrValueService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出sku销售属性&值列表
     */
    @SaCheckPermission("pms:skuSaleAttrValue:export")
    @Log(title = "sku销售属性&值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SkuSaleAttrValueBo bo, HttpServletResponse response) {
        List<SkuSaleAttrValueVo> list = skuSaleAttrValueService.queryList(bo);
        ExcelUtil.exportExcel(list, "sku销售属性&值", SkuSaleAttrValueVo.class, response);
    }

    /**
     * 获取sku销售属性&值详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("pms:skuSaleAttrValue:query")
    @GetMapping("/{id}")
    public R<SkuSaleAttrValueVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(skuSaleAttrValueService.queryById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @SaCheckPermission("pms:skuSaleAttrValue:add")
    @Log(title = "sku销售属性&值", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SkuSaleAttrValueBo bo) {
        return toAjax(skuSaleAttrValueService.insertByBo(bo));
    }

    /**
     * 修改sku销售属性&值
     */
    @SaCheckPermission("pms:skuSaleAttrValue:edit")
    @Log(title = "sku销售属性&值", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SkuSaleAttrValueBo bo) {
        return toAjax(skuSaleAttrValueService.updateByBo(bo));
    }

    /**
     * 删除sku销售属性&值
     *
     * @param ids 主键串
     */
    @SaCheckPermission("pms:skuSaleAttrValue:remove")
    @Log(title = "sku销售属性&值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(skuSaleAttrValueService.deleteWithValidByIds(List.of(ids), true));
    }
}
