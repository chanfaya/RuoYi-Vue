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
import org.dromara.mall.oms.domain.vo.OrderItemVo;
import org.dromara.mall.oms.domain.bo.OrderItemBo;
import org.dromara.mall.oms.service.IOrderItemService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单项信息
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/orderItem")
public class OrderItemController extends BaseController {

    private final IOrderItemService orderItemService;

    /**
     * 查询订单项信息列表
     */
    @SaCheckPermission("oms:orderItem:list")
    @GetMapping("/list")
    public TableDataInfo<OrderItemVo> list(OrderItemBo bo, PageQuery pageQuery) {
        return orderItemService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单项信息列表
     */
    @SaCheckPermission("oms:orderItem:export")
    @Log(title = "订单项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderItemBo bo, HttpServletResponse response) {
        List<OrderItemVo> list = orderItemService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单项信息", OrderItemVo.class, response);
    }

    /**
     * 获取订单项信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:orderItem:query")
    @GetMapping("/{id}")
    public R<OrderItemVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(orderItemService.queryById(id));
    }

    /**
     * 新增订单项信息
     */
    @SaCheckPermission("oms:orderItem:add")
    @Log(title = "订单项信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderItemBo bo) {
        return toAjax(orderItemService.insertByBo(bo));
    }

    /**
     * 修改订单项信息
     */
    @SaCheckPermission("oms:orderItem:edit")
    @Log(title = "订单项信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderItemBo bo) {
        return toAjax(orderItemService.updateByBo(bo));
    }

    /**
     * 删除订单项信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:orderItem:remove")
    @Log(title = "订单项信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(orderItemService.deleteWithValidByIds(List.of(ids), true));
    }
}
