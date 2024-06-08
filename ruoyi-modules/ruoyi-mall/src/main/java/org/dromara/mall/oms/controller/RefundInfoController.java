package org.dromara.mall.oms.controller;

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
import org.dromara.mall.oms.domain.vo.RefundInfoVo;
import org.dromara.mall.oms.domain.bo.RefundInfoBo;
import org.dromara.mall.oms.service.IRefundInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 退款信息
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/refundInfo")
public class RefundInfoController extends BaseController {

    private final IRefundInfoService refundInfoService;

    /**
     * 查询退款信息列表
     */
    @SaCheckPermission("oms:refundInfo:list")
    @GetMapping("/list")
    public TableDataInfo<RefundInfoVo> list(RefundInfoBo bo, PageQuery pageQuery) {
        return refundInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出退款信息列表
     */
    @SaCheckPermission("oms:refundInfo:export")
    @Log(title = "退款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RefundInfoBo bo, HttpServletResponse response) {
        List<RefundInfoVo> list = refundInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "退款信息", RefundInfoVo.class, response);
    }

    /**
     * 获取退款信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:refundInfo:query")
    @GetMapping("/{id}")
    public R<RefundInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(refundInfoService.queryById(id));
    }

    /**
     * 新增退款信息
     */
    @SaCheckPermission("oms:refundInfo:add")
    @Log(title = "退款信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RefundInfoBo bo) {
        return toAjax(refundInfoService.insertByBo(bo));
    }

    /**
     * 修改退款信息
     */
    @SaCheckPermission("oms:refundInfo:edit")
    @Log(title = "退款信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RefundInfoBo bo) {
        return toAjax(refundInfoService.updateByBo(bo));
    }

    /**
     * 删除退款信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:refundInfo:remove")
    @Log(title = "退款信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(refundInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
