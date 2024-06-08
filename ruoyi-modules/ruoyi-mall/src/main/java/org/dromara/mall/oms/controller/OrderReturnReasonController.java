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
import org.dromara.mall.oms.domain.vo.OrderReturnReasonVo;
import org.dromara.mall.oms.domain.bo.OrderReturnReasonBo;
import org.dromara.mall.oms.service.IOrderReturnReasonService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 退货原因
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/orderReturnReason")
public class OrderReturnReasonController extends BaseController {

    private final IOrderReturnReasonService orderReturnReasonService;

    /**
     * 查询退货原因列表
     */
    @SaCheckPermission("oms:orderReturnReason:list")
    @GetMapping("/list")
    public TableDataInfo<OrderReturnReasonVo> list(OrderReturnReasonBo bo, PageQuery pageQuery) {
        return orderReturnReasonService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出退货原因列表
     */
    @SaCheckPermission("oms:orderReturnReason:export")
    @Log(title = "退货原因", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderReturnReasonBo bo, HttpServletResponse response) {
        List<OrderReturnReasonVo> list = orderReturnReasonService.queryList(bo);
        ExcelUtil.exportExcel(list, "退货原因", OrderReturnReasonVo.class, response);
    }

    /**
     * 获取退货原因详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:orderReturnReason:query")
    @GetMapping("/{id}")
    public R<OrderReturnReasonVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(orderReturnReasonService.queryById(id));
    }

    /**
     * 新增退货原因
     */
    @SaCheckPermission("oms:orderReturnReason:add")
    @Log(title = "退货原因", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderReturnReasonBo bo) {
        return toAjax(orderReturnReasonService.insertByBo(bo));
    }

    /**
     * 修改退货原因
     */
    @SaCheckPermission("oms:orderReturnReason:edit")
    @Log(title = "退货原因", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderReturnReasonBo bo) {
        return toAjax(orderReturnReasonService.updateByBo(bo));
    }

    /**
     * 删除退货原因
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:orderReturnReason:remove")
    @Log(title = "退货原因", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(orderReturnReasonService.deleteWithValidByIds(List.of(ids), true));
    }
}
