<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="秒杀订单超时关闭时间(分)" prop="flashOrderOvertime">
              <el-input v-model="queryParams.flashOrderOvertime" placeholder="请输入秒杀订单超时关闭时间(分)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="正常订单超时时间(分)" prop="normalOrderOvertime">
              <el-input v-model="queryParams.normalOrderOvertime" placeholder="请输入正常订单超时时间(分)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="发货后自动确认收货时间" prop="confirmOvertime">
              <el-input v-model="queryParams.confirmOvertime" placeholder="请输入发货后自动确认收货时间" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="自动完成交易时间，不能申请退货" prop="finishOvertime">
              <el-input v-model="queryParams.finishOvertime" placeholder="请输入自动完成交易时间，不能申请退货" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="订单完成后自动好评时间" prop="commentOvertime">
              <el-input v-model="queryParams.commentOvertime" placeholder="请输入订单完成后自动好评时间" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" prop="memberLevel">
              <el-input v-model="queryParams.memberLevel" placeholder="请输入会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['oms:orderSetting:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['oms:orderSetting:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['oms:orderSetting:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['oms:orderSetting:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="orderSettingList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="秒杀订单超时关闭时间(分)" align="center" prop="flashOrderOvertime" />
        <el-table-column label="正常订单超时时间(分)" align="center" prop="normalOrderOvertime" />
        <el-table-column label="发货后自动确认收货时间" align="center" prop="confirmOvertime" />
        <el-table-column label="自动完成交易时间，不能申请退货" align="center" prop="finishOvertime" />
        <el-table-column label="订单完成后自动好评时间" align="center" prop="commentOvertime" />
        <el-table-column label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" align="center" prop="memberLevel" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['oms:orderSetting:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['oms:orderSetting:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改订单配置信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="orderSettingFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="秒杀订单超时关闭时间(分)" prop="flashOrderOvertime">
          <el-input v-model="form.flashOrderOvertime" placeholder="请输入秒杀订单超时关闭时间(分)" />
        </el-form-item>
        <el-form-item label="正常订单超时时间(分)" prop="normalOrderOvertime">
          <el-input v-model="form.normalOrderOvertime" placeholder="请输入正常订单超时时间(分)" />
        </el-form-item>
        <el-form-item label="发货后自动确认收货时间" prop="confirmOvertime">
          <el-input v-model="form.confirmOvertime" placeholder="请输入发货后自动确认收货时间" />
        </el-form-item>
        <el-form-item label="自动完成交易时间，不能申请退货" prop="finishOvertime">
          <el-input v-model="form.finishOvertime" placeholder="请输入自动完成交易时间，不能申请退货" />
        </el-form-item>
        <el-form-item label="订单完成后自动好评时间" prop="commentOvertime">
          <el-input v-model="form.commentOvertime" placeholder="请输入订单完成后自动好评时间" />
        </el-form-item>
        <el-form-item label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" prop="memberLevel">
          <el-input v-model="form.memberLevel" placeholder="请输入会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" />
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

<script setup name="OrderSetting" lang="ts">
import { listOrderSetting, getOrderSetting, delOrderSetting, addOrderSetting, updateOrderSetting } from '@/api/oms/orderSetting';
import { OrderSettingVO, OrderSettingQuery, OrderSettingForm } from '@/api/oms/orderSetting/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const orderSettingList = ref<OrderSettingVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const orderSettingFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: OrderSettingForm = {
  id: undefined,
  flashOrderOvertime: undefined,
  normalOrderOvertime: undefined,
  confirmOvertime: undefined,
  finishOvertime: undefined,
  commentOvertime: undefined,
  memberLevel: undefined
}
const data = reactive<PageData<OrderSettingForm, OrderSettingQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    flashOrderOvertime: undefined,
    normalOrderOvertime: undefined,
    confirmOvertime: undefined,
    finishOvertime: undefined,
    commentOvertime: undefined,
    memberLevel: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "不能为空", trigger: "blur" }
    ],
    flashOrderOvertime: [
      { required: true, message: "秒杀订单超时关闭时间(分)不能为空", trigger: "blur" }
    ],
    normalOrderOvertime: [
      { required: true, message: "正常订单超时时间(分)不能为空", trigger: "blur" }
    ],
    confirmOvertime: [
      { required: true, message: "发货后自动确认收货时间不能为空", trigger: "blur" }
    ],
    finishOvertime: [
      { required: true, message: "自动完成交易时间，不能申请退货不能为空", trigger: "blur" }
    ],
    commentOvertime: [
      { required: true, message: "订单完成后自动好评时间不能为空", trigger: "blur" }
    ],
    memberLevel: [
      { required: true, message: "会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询订单配置信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listOrderSetting(queryParams.value);
  orderSettingList.value = res.rows;
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
  orderSettingFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: OrderSettingVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加订单配置信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: OrderSettingVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getOrderSetting(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改订单配置信息";
}

/** 提交按钮 */
const submitForm = () => {
  orderSettingFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateOrderSetting(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addOrderSetting(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: OrderSettingVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除订单配置信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delOrderSetting(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('oms/orderSetting/export', {
    ...queryParams.value
  }, `orderSetting_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
