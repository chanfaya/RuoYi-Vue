<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="order_id" prop="orderId">
              <el-input v-model="queryParams.orderId" placeholder="请输入order_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="退货商品id" prop="skuId">
              <el-input v-model="queryParams.skuId" placeholder="请输入退货商品id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="订单编号" prop="orderSn">
              <el-input v-model="queryParams.orderSn" placeholder="请输入订单编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="会员用户名" prop="memberUsername">
              <el-input v-model="queryParams.memberUsername" placeholder="请输入会员用户名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="退款金额" prop="returnAmount">
              <el-input v-model="queryParams.returnAmount" placeholder="请输入退款金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="退货人姓名" prop="returnName">
              <el-input v-model="queryParams.returnName" placeholder="请输入退货人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="退货人电话" prop="returnPhone">
              <el-input v-model="queryParams.returnPhone" placeholder="请输入退货人电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处理时间" prop="handleTime">
              <el-date-picker clearable
                v-model="queryParams.handleTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择处理时间"
              />
            </el-form-item>
            <el-form-item label="商品图片" prop="skuImg">
              <el-input v-model="queryParams.skuImg" placeholder="请输入商品图片" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品名称" prop="skuName">
              <el-input v-model="queryParams.skuName" placeholder="请输入商品名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品品牌" prop="skuBrand">
              <el-input v-model="queryParams.skuBrand" placeholder="请输入商品品牌" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品销售属性(JSON)" prop="skuAttrsVals">
              <el-input v-model="queryParams.skuAttrsVals" placeholder="请输入商品销售属性(JSON)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="退货数量" prop="skuCount">
              <el-input v-model="queryParams.skuCount" placeholder="请输入退货数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品单价" prop="skuPrice">
              <el-input v-model="queryParams.skuPrice" placeholder="请输入商品单价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品实际支付单价" prop="skuRealPrice">
              <el-input v-model="queryParams.skuRealPrice" placeholder="请输入商品实际支付单价" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="原因" prop="reason">
              <el-input v-model="queryParams.reason" placeholder="请输入原因" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="描述" prop="description述">
              <el-input v-model="queryParams.description述" placeholder="请输入描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="凭证图片，以逗号隔开" prop="descPics">
              <el-input v-model="queryParams.descPics" placeholder="请输入凭证图片，以逗号隔开" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处理备注" prop="handleNote">
              <el-input v-model="queryParams.handleNote" placeholder="请输入处理备注" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="处理人员" prop="handleMan">
              <el-input v-model="queryParams.handleMan" placeholder="请输入处理人员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="收货人" prop="receiveMan">
              <el-input v-model="queryParams.receiveMan" placeholder="请输入收货人" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="收货时间" prop="receiveTime">
              <el-date-picker clearable
                v-model="queryParams.receiveTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择收货时间"
              />
            </el-form-item>
            <el-form-item label="收货备注" prop="receiveNote">
              <el-input v-model="queryParams.receiveNote" placeholder="请输入收货备注" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="收货电话" prop="receivePhone">
              <el-input v-model="queryParams.receivePhone" placeholder="请输入收货电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="公司收货地址" prop="companyAddress">
              <el-input v-model="queryParams.companyAddress" placeholder="请输入公司收货地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['oms:orderReturnApply:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['oms:orderReturnApply:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['oms:orderReturnApply:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['oms:orderReturnApply:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="orderReturnApplyList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="order_id" align="center" prop="orderId" />
        <el-table-column label="退货商品id" align="center" prop="skuId" />
        <el-table-column label="订单编号" align="center" prop="orderSn" />
        <el-table-column label="会员用户名" align="center" prop="memberUsername" />
        <el-table-column label="退款金额" align="center" prop="returnAmount" />
        <el-table-column label="退货人姓名" align="center" prop="returnName" />
        <el-table-column label="退货人电话" align="center" prop="returnPhone" />
        <el-table-column label="申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]" align="center" prop="status" />
        <el-table-column label="处理时间" align="center" prop="handleTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.handleTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="商品图片" align="center" prop="skuImg" />
        <el-table-column label="商品名称" align="center" prop="skuName" />
        <el-table-column label="商品品牌" align="center" prop="skuBrand" />
        <el-table-column label="商品销售属性(JSON)" align="center" prop="skuAttrsVals" />
        <el-table-column label="退货数量" align="center" prop="skuCount" />
        <el-table-column label="商品单价" align="center" prop="skuPrice" />
        <el-table-column label="商品实际支付单价" align="center" prop="skuRealPrice" />
        <el-table-column label="原因" align="center" prop="reason" />
        <el-table-column label="描述" align="center" prop="description述" />
        <el-table-column label="凭证图片，以逗号隔开" align="center" prop="descPics" />
        <el-table-column label="处理备注" align="center" prop="handleNote" />
        <el-table-column label="处理人员" align="center" prop="handleMan" />
        <el-table-column label="收货人" align="center" prop="receiveMan" />
        <el-table-column label="收货时间" align="center" prop="receiveTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.receiveTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="收货备注" align="center" prop="receiveNote" />
        <el-table-column label="收货电话" align="center" prop="receivePhone" />
        <el-table-column label="公司收货地址" align="center" prop="companyAddress" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['oms:orderReturnApply:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['oms:orderReturnApply:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改订单退货申请对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="orderReturnApplyFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="order_id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入order_id" />
        </el-form-item>
        <el-form-item label="退货商品id" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入退货商品id" />
        </el-form-item>
        <el-form-item label="订单编号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="会员用户名" prop="memberUsername">
          <el-input v-model="form.memberUsername" placeholder="请输入会员用户名" />
        </el-form-item>
        <el-form-item label="退款金额" prop="returnAmount">
          <el-input v-model="form.returnAmount" placeholder="请输入退款金额" />
        </el-form-item>
        <el-form-item label="退货人姓名" prop="returnName">
          <el-input v-model="form.returnName" placeholder="请输入退货人姓名" />
        </el-form-item>
        <el-form-item label="退货人电话" prop="returnPhone">
          <el-input v-model="form.returnPhone" placeholder="请输入退货人电话" />
        </el-form-item>
        <el-form-item label="处理时间" prop="handleTime">
          <el-date-picker clearable
            v-model="form.handleTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择处理时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="商品图片" prop="skuImg">
            <el-input v-model="form.skuImg" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品名称" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品品牌" prop="skuBrand">
          <el-input v-model="form.skuBrand" placeholder="请输入商品品牌" />
        </el-form-item>
        <el-form-item label="商品销售属性(JSON)" prop="skuAttrsVals">
            <el-input v-model="form.skuAttrsVals" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="退货数量" prop="skuCount">
          <el-input v-model="form.skuCount" placeholder="请输入退货数量" />
        </el-form-item>
        <el-form-item label="商品单价" prop="skuPrice">
          <el-input v-model="form.skuPrice" placeholder="请输入商品单价" />
        </el-form-item>
        <el-form-item label="商品实际支付单价" prop="skuRealPrice">
          <el-input v-model="form.skuRealPrice" placeholder="请输入商品实际支付单价" />
        </el-form-item>
        <el-form-item label="原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入原因" />
        </el-form-item>
        <el-form-item label="描述" prop="description述">
            <el-input v-model="form.description述" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="凭证图片，以逗号隔开" prop="descPics">
            <el-input v-model="form.descPics" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理备注" prop="handleNote">
            <el-input v-model="form.handleNote" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理人员" prop="handleMan">
          <el-input v-model="form.handleMan" placeholder="请输入处理人员" />
        </el-form-item>
        <el-form-item label="收货人" prop="receiveMan">
          <el-input v-model="form.receiveMan" placeholder="请输入收货人" />
        </el-form-item>
        <el-form-item label="收货时间" prop="receiveTime">
          <el-date-picker clearable
            v-model="form.receiveTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择收货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="收货备注" prop="receiveNote">
            <el-input v-model="form.receiveNote" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="收货电话" prop="receivePhone">
          <el-input v-model="form.receivePhone" placeholder="请输入收货电话" />
        </el-form-item>
        <el-form-item label="公司收货地址" prop="companyAddress">
            <el-input v-model="form.companyAddress" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="OrderReturnApply" lang="ts">
import { listOrderReturnApply, getOrderReturnApply, delOrderReturnApply, addOrderReturnApply, updateOrderReturnApply } from '@/api/oms/orderReturnApply';
import { OrderReturnApplyVO, OrderReturnApplyQuery, OrderReturnApplyForm } from '@/api/oms/orderReturnApply/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const orderReturnApplyList = ref<OrderReturnApplyVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const orderReturnApplyFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: OrderReturnApplyForm = {
  id: undefined,
  orderId: undefined,
  skuId: undefined,
  orderSn: undefined,
  memberUsername: undefined,
  returnAmount: undefined,
  returnName: undefined,
  returnPhone: undefined,
  status: undefined,
  handleTime: undefined,
  skuImg: undefined,
  skuName: undefined,
  skuBrand: undefined,
  skuAttrsVals: undefined,
  skuCount: undefined,
  skuPrice: undefined,
  skuRealPrice: undefined,
  reason: undefined,
  description述: undefined,
  descPics: undefined,
  handleNote: undefined,
  handleMan: undefined,
  receiveMan: undefined,
  receiveTime: undefined,
  receiveNote: undefined,
  receivePhone: undefined,
  companyAddress: undefined
}
const data = reactive<PageData<OrderReturnApplyForm, OrderReturnApplyQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    orderId: undefined,
    skuId: undefined,
    orderSn: undefined,
    memberUsername: undefined,
    returnAmount: undefined,
    returnName: undefined,
    returnPhone: undefined,
    status: undefined,
    handleTime: undefined,
    skuImg: undefined,
    skuName: undefined,
    skuBrand: undefined,
    skuAttrsVals: undefined,
    skuCount: undefined,
    skuPrice: undefined,
    skuRealPrice: undefined,
    reason: undefined,
    description述: undefined,
    descPics: undefined,
    handleNote: undefined,
    handleMan: undefined,
    receiveMan: undefined,
    receiveTime: undefined,
    receiveNote: undefined,
    receivePhone: undefined,
    companyAddress: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "不能为空", trigger: "blur" }
    ],
    orderId: [
      { required: true, message: "order_id不能为空", trigger: "blur" }
    ],
    skuId: [
      { required: true, message: "退货商品id不能为空", trigger: "blur" }
    ],
    orderSn: [
      { required: true, message: "订单编号不能为空", trigger: "blur" }
    ],
    memberUsername: [
      { required: true, message: "会员用户名不能为空", trigger: "blur" }
    ],
    returnAmount: [
      { required: true, message: "退款金额不能为空", trigger: "blur" }
    ],
    returnName: [
      { required: true, message: "退货人姓名不能为空", trigger: "blur" }
    ],
    returnPhone: [
      { required: true, message: "退货人电话不能为空", trigger: "blur" }
    ],
    status: [
      { required: true, message: "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]不能为空", trigger: "change" }
    ],
    handleTime: [
      { required: true, message: "处理时间不能为空", trigger: "blur" }
    ],
    skuImg: [
      { required: true, message: "商品图片不能为空", trigger: "blur" }
    ],
    skuName: [
      { required: true, message: "商品名称不能为空", trigger: "blur" }
    ],
    skuBrand: [
      { required: true, message: "商品品牌不能为空", trigger: "blur" }
    ],
    skuAttrsVals: [
      { required: true, message: "商品销售属性(JSON)不能为空", trigger: "blur" }
    ],
    skuCount: [
      { required: true, message: "退货数量不能为空", trigger: "blur" }
    ],
    skuPrice: [
      { required: true, message: "商品单价不能为空", trigger: "blur" }
    ],
    skuRealPrice: [
      { required: true, message: "商品实际支付单价不能为空", trigger: "blur" }
    ],
    reason: [
      { required: true, message: "原因不能为空", trigger: "blur" }
    ],
    description述: [
      { required: true, message: "描述不能为空", trigger: "blur" }
    ],
    descPics: [
      { required: true, message: "凭证图片，以逗号隔开不能为空", trigger: "blur" }
    ],
    handleNote: [
      { required: true, message: "处理备注不能为空", trigger: "blur" }
    ],
    handleMan: [
      { required: true, message: "处理人员不能为空", trigger: "blur" }
    ],
    receiveMan: [
      { required: true, message: "收货人不能为空", trigger: "blur" }
    ],
    receiveTime: [
      { required: true, message: "收货时间不能为空", trigger: "blur" }
    ],
    receiveNote: [
      { required: true, message: "收货备注不能为空", trigger: "blur" }
    ],
    receivePhone: [
      { required: true, message: "收货电话不能为空", trigger: "blur" }
    ],
    companyAddress: [
      { required: true, message: "公司收货地址不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询订单退货申请列表 */
const getList = async () => {
  loading.value = true;
  const res = await listOrderReturnApply(queryParams.value);
  orderReturnApplyList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  orderReturnApplyFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: OrderReturnApplyVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加订单退货申请";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: OrderReturnApplyVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getOrderReturnApply(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改订单退货申请";
}

/** 提交按钮 */
const submitForm = () => {
  orderReturnApplyFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateOrderReturnApply(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addOrderReturnApply(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: OrderReturnApplyVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除订单退货申请编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delOrderReturnApply(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('oms/orderReturnApply/export', {
    ...queryParams.value
  }, `orderReturnApply_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
