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
import org.dromara.mall.oms.domain.vo.PaymentInfoVo;
import org.dromara.mall.oms.domain.bo.PaymentInfoBo;
import org.dromara.mall.oms.service.IPaymentInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 支付信息
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/paymentInfo")
public class PaymentInfoController extends BaseController {

    private final IPaymentInfoService paymentInfoService;

    /**
     * 查询支付信息列表
     */
    @SaCheckPermission("oms:paymentInfo:list")
    @GetMapping("/list")
    public TableDataInfo<PaymentInfoVo> list(PaymentInfoBo bo, PageQuery pageQuery) {
        return paymentInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出支付信息列表
     */
    @SaCheckPermission("oms:paymentInfo:export")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(PaymentInfoBo bo, HttpServletResponse response) {
        List<PaymentInfoVo> list = paymentInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "支付信息", PaymentInfoVo.class, response);
    }

    /**
     * 获取支付信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:paymentInfo:query")
    @GetMapping("/{id}")
    public R<PaymentInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(paymentInfoService.queryById(id));
    }

    /**
     * 新增支付信息
     */
    @SaCheckPermission("oms:paymentInfo:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody PaymentInfoBo bo) {
        return toAjax(paymentInfoService.insertByBo(bo));
    }

    /**
     * 修改支付信息
     */
    @SaCheckPermission("oms:paymentInfo:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody PaymentInfoBo bo) {
        return toAjax(paymentInfoService.updateByBo(bo));
    }

    /**
     * 删除支付信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:paymentInfo:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(paymentInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
