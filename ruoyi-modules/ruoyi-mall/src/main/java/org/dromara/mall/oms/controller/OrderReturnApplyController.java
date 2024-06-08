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
import org.dromara.mall.oms.domain.vo.OrderReturnApplyVo;
import org.dromara.mall.oms.domain.bo.OrderReturnApplyBo;
import org.dromara.mall.oms.service.IOrderReturnApplyService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单退货申请
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/orderReturnApply")
public class OrderReturnApplyController extends BaseController {

    private final IOrderReturnApplyService orderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
    @SaCheckPermission("oms:orderReturnApply:list")
    @GetMapping("/list")
    public TableDataInfo<OrderReturnApplyVo> list(OrderReturnApplyBo bo, PageQuery pageQuery) {
        return orderReturnApplyService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单退货申请列表
     */
    @SaCheckPermission("oms:orderReturnApply:export")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderReturnApplyBo bo, HttpServletResponse response) {
        List<OrderReturnApplyVo> list = orderReturnApplyService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单退货申请", OrderReturnApplyVo.class, response);
    }

    /**
     * 获取订单退货申请详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:orderReturnApply:query")
    @GetMapping("/{id}")
    public R<OrderReturnApplyVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(orderReturnApplyService.queryById(id));
    }

    /**
     * 新增订单退货申请
     */
    @SaCheckPermission("oms:orderReturnApply:add")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderReturnApplyBo bo) {
        return toAjax(orderReturnApplyService.insertByBo(bo));
    }

    /**
     * 修改订单退货申请
     */
    @SaCheckPermission("oms:orderReturnApply:edit")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderReturnApplyBo bo) {
        return toAjax(orderReturnApplyService.updateByBo(bo));
    }

    /**
     * 删除订单退货申请
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:orderReturnApply:remove")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(orderReturnApplyService.deleteWithValidByIds(List.of(ids), true));
    }
}
