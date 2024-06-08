<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="订单号" prop="orderSn">
              <el-input v-model="queryParams.orderSn" placeholder="请输入订单号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="订单id" prop="orderId">
              <el-input v-model="queryParams.orderId" placeholder="请输入订单id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="支付宝交易流水号" prop="alipayTradeNo">
              <el-input v-model="queryParams.alipayTradeNo" placeholder="请输入支付宝交易流水号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="支付总金额" prop="totalAmount">
              <el-input v-model="queryParams.totalAmount" placeholder="请输入支付总金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="交易内容" prop="subject">
              <el-input v-model="queryParams.subject" placeholder="请输入交易内容" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="确认时间" prop="confirmTime">
              <el-date-picker clearable
                v-model="queryParams.confirmTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择确认时间"
              />
            </el-form-item>
            <el-form-item label="回调时间" prop="callbackTime">
              <el-date-picker clearable
                v-model="queryParams.callbackTime"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择回调时间"
              />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['oms:paymentInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['oms:paymentInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['oms:paymentInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['oms:paymentInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="paymentInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="订单号" align="center" prop="orderSn" />
        <el-table-column label="订单id" align="center" prop="orderId" />
        <el-table-column label="支付宝交易流水号" align="center" prop="alipayTradeNo" />
        <el-table-column label="支付总金额" align="center" prop="totalAmount" />
        <el-table-column label="交易内容" align="center" prop="subject" />
        <el-table-column label="支付状态" align="center" prop="paymentStatus" />
        <el-table-column label="确认时间" align="center" prop="confirmTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.confirmTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="回调内容" align="center" prop="callbackContent" />
        <el-table-column label="回调时间" align="center" prop="callbackTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.callbackTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['oms:paymentInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['oms:paymentInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改支付信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="paymentInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="订单id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入订单id" />
        </el-form-item>
        <el-form-item label="支付宝交易流水号" prop="alipayTradeNo">
          <el-input v-model="form.alipayTradeNo" placeholder="请输入支付宝交易流水号" />
        </el-form-item>
        <el-form-item label="支付总金额" prop="totalAmount">
          <el-input v-model="form.totalAmount" placeholder="请输入支付总金额" />
        </el-form-item>
        <el-form-item label="交易内容" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入交易内容" />
        </el-form-item>
        <el-form-item label="确认时间" prop="confirmTime">
          <el-date-picker clearable
            v-model="form.confirmTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择确认时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="回调内容">
          <editor v-model="form.callbackContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="回调时间" prop="callbackTime">
          <el-date-picker clearable
            v-model="form.callbackTime"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择回调时间">
          </el-date-picker>
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

<script setup name="PaymentInfo" lang="ts">
import { listPaymentInfo, getPaymentInfo, delPaymentInfo, addPaymentInfo, updatePaymentInfo } from '@/api/oms/paymentInfo';
import { PaymentInfoVO, PaymentInfoQuery, PaymentInfoForm } from '@/api/oms/paymentInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const paymentInfoList = ref<PaymentInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const paymentInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: PaymentInfoForm = {
  id: undefined,
  orderSn: undefined,
  orderId: undefined,
  alipayTradeNo: undefined,
  totalAmount: undefined,
  subject: undefined,
  paymentStatus: undefined,
  confirmTime: undefined,
  callbackContent: undefined,
  callbackTime: undefined
}
const data = reactive<PageData<PaymentInfoForm, PaymentInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    orderSn: undefined,
    orderId: undefined,
    alipayTradeNo: undefined,
    totalAmount: undefined,
    subject: undefined,
    paymentStatus: undefined,
    confirmTime: undefined,
    callbackContent: undefined,
    callbackTime: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "不能为空", trigger: "blur" }
    ],
    orderSn: [
      { required: true, message: "订单号不能为空", trigger: "blur" }
    ],
    orderId: [
      { required: true, message: "订单id不能为空", trigger: "blur" }
    ],
    alipayTradeNo: [
      { required: true, message: "支付宝交易流水号不能为空", trigger: "blur" }
    ],
    totalAmount: [
      { required: true, message: "支付总金额不能为空", trigger: "blur" }
    ],
    subject: [
      { required: true, message: "交易内容不能为空", trigger: "blur" }
    ],
    paymentStatus: [
      { required: true, message: "支付状态不能为空", trigger: "change" }
    ],
    confirmTime: [
      { required: true, message: "确认时间不能为空", trigger: "blur" }
    ],
    callbackContent: [
      { required: true, message: "回调内容不能为空", trigger: "blur" }
    ],
    callbackTime: [
      { required: true, message: "回调时间不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询支付信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listPaymentInfo(queryParams.value);
  paymentInfoList.value = res.rows;
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
  paymentInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: PaymentInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加支付信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: PaymentInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getPaymentInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改支付信息";
}

/** 提交按钮 */
const submitForm = () => {
  paymentInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updatePaymentInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addPaymentInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: PaymentInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除支付信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delPaymentInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('oms/paymentInfo/export', {
    ...queryParams.value
  }, `paymentInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
