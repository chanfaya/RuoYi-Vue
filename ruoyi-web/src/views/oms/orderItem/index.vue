<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="order_id" prop="orderId">
              <el-input v-model="queryParams.orderId" placeholder="请输入order_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="order_sn" prop="orderSn">
              <el-input v-model="queryParams.orderSn" placeholder="请输入order_sn" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="spu_id" prop="spuId">
              <el-input v-model="queryParams.spuId" placeholder="请输入spu_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="spu_name" prop="spuName">
              <el-input v-model="queryParams.spuName" placeholder="请输入spu_name" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="spu_pic" prop="spuPic">
              <el-input v-model="queryParams.spuPic" placeholder="请输入spu_pic" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="品牌" prop="spuBrand">
              <el-input v-model="queryParams.spuBrand" placeholder="请输入品牌" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品分类id" prop="categoryId">
              <el-input v-model="queryParams.categoryId" placeholder="请输入商品分类id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品sku编号" prop="skuId">
              <el-input v-model="queryParams.skuId" placeholder="请输入商品sku编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品sku名字" prop="skuName">
              <el-input v-model="queryParams.skuName" placeholder="请输入商品sku名字" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品sku图片" prop="skuPic">
              <el-input v-model="queryParams.skuPic" placeholder="请输入商品sku图片" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品sku价格" prop="skuPrice">
              <el-input v-model="queryParams.skuPrice" placeholder="请输入商品sku价格" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品购买的数量" prop="skuQuantity">
              <el-input v-model="queryParams.skuQuantity" placeholder="请输入商品购买的数量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品销售属性组合" prop="skuAttrsVals">
              <el-input v-model="queryParams.skuAttrsVals" placeholder="请输入商品销售属性组合" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品促销分解金额" prop="promotionAmount">
              <el-input v-model="queryParams.promotionAmount" placeholder="请输入商品促销分解金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="优惠券优惠分解金额" prop="couponAmount">
              <el-input v-model="queryParams.couponAmount" placeholder="请输入优惠券优惠分解金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="积分优惠分解金额" prop="integrationAmount">
              <el-input v-model="queryParams.integrationAmount" placeholder="请输入积分优惠分解金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="该商品经过优惠后的分解金额" prop="realAmount">
              <el-input v-model="queryParams.realAmount" placeholder="请输入该商品经过优惠后的分解金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="赠送积分" prop="giftIntegration">
              <el-input v-model="queryParams.giftIntegration" placeholder="请输入赠送积分" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="赠送成长值" prop="giftGrowth">
              <el-input v-model="queryParams.giftGrowth" placeholder="请输入赠送成长值" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['oms:orderItem:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['oms:orderItem:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['oms:orderItem:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['oms:orderItem:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="orderItemList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="order_id" align="center" prop="orderId" />
        <el-table-column label="order_sn" align="center" prop="orderSn" />
        <el-table-column label="spu_id" align="center" prop="spuId" />
        <el-table-column label="spu_name" align="center" prop="spuName" />
        <el-table-column label="spu_pic" align="center" prop="spuPic" />
        <el-table-column label="品牌" align="center" prop="spuBrand" />
        <el-table-column label="商品分类id" align="center" prop="categoryId" />
        <el-table-column label="商品sku编号" align="center" prop="skuId" />
        <el-table-column label="商品sku名字" align="center" prop="skuName" />
        <el-table-column label="商品sku图片" align="center" prop="skuPic" />
        <el-table-column label="商品sku价格" align="center" prop="skuPrice" />
        <el-table-column label="商品购买的数量" align="center" prop="skuQuantity" />
        <el-table-column label="商品销售属性组合" align="center" prop="skuAttrsVals" />
        <el-table-column label="商品促销分解金额" align="center" prop="promotionAmount" />
        <el-table-column label="优惠券优惠分解金额" align="center" prop="couponAmount" />
        <el-table-column label="积分优惠分解金额" align="center" prop="integrationAmount" />
        <el-table-column label="该商品经过优惠后的分解金额" align="center" prop="realAmount" />
        <el-table-column label="赠送积分" align="center" prop="giftIntegration" />
        <el-table-column label="赠送成长值" align="center" prop="giftGrowth" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['oms:orderItem:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['oms:orderItem:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改订单项信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="orderItemFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="order_id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入order_id" />
        </el-form-item>
        <el-form-item label="order_sn" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入order_sn" />
        </el-form-item>
        <el-form-item label="spu_id" prop="spuId">
          <el-input v-model="form.spuId" placeholder="请输入spu_id" />
        </el-form-item>
        <el-form-item label="spu_name" prop="spuName">
          <el-input v-model="form.spuName" placeholder="请输入spu_name" />
        </el-form-item>
        <el-form-item label="spu_pic" prop="spuPic">
            <el-input v-model="form.spuPic" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="品牌" prop="spuBrand">
          <el-input v-model="form.spuBrand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="商品分类id" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入商品分类id" />
        </el-form-item>
        <el-form-item label="商品sku编号" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入商品sku编号" />
        </el-form-item>
        <el-form-item label="商品sku名字" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入商品sku名字" />
        </el-form-item>
        <el-form-item label="商品sku图片" prop="skuPic">
            <el-input v-model="form.skuPic" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品sku价格" prop="skuPrice">
          <el-input v-model="form.skuPrice" placeholder="请输入商品sku价格" />
        </el-form-item>
        <el-form-item label="商品购买的数量" prop="skuQuantity">
          <el-input v-model="form.skuQuantity" placeholder="请输入商品购买的数量" />
        </el-form-item>
        <el-form-item label="商品销售属性组合" prop="skuAttrsVals">
            <el-input v-model="form.skuAttrsVals" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品促销分解金额" prop="promotionAmount">
          <el-input v-model="form.promotionAmount" placeholder="请输入商品促销分解金额" />
        </el-form-item>
        <el-form-item label="优惠券优惠分解金额" prop="couponAmount">
          <el-input v-model="form.couponAmount" placeholder="请输入优惠券优惠分解金额" />
        </el-form-item>
        <el-form-item label="积分优惠分解金额" prop="integrationAmount">
          <el-input v-model="form.integrationAmount" placeholder="请输入积分优惠分解金额" />
        </el-form-item>
        <el-form-item label="该商品经过优惠后的分解金额" prop="realAmount">
          <el-input v-model="form.realAmount" placeholder="请输入该商品经过优惠后的分解金额" />
        </el-form-item>
        <el-form-item label="赠送积分" prop="giftIntegration">
          <el-input v-model="form.giftIntegration" placeholder="请输入赠送积分" />
        </el-form-item>
        <el-form-item label="赠送成长值" prop="giftGrowth">
          <el-input v-model="form.giftGrowth" placeholder="请输入赠送成长值" />
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

<script setup name="OrderItem" lang="ts">
import { listOrderItem, getOrderItem, delOrderItem, addOrderItem, updateOrderItem } from '@/api/oms/orderItem';
import { OrderItemVO, OrderItemQuery, OrderItemForm } from '@/api/oms/orderItem/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const orderItemList = ref<OrderItemVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const orderItemFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: OrderItemForm = {
  id: undefined,
  orderId: undefined,
  orderSn: undefined,
  spuId: undefined,
  spuName: undefined,
  spuPic: undefined,
  spuBrand: undefined,
  categoryId: undefined,
  skuId: undefined,
  skuName: undefined,
  skuPic: undefined,
  skuPrice: undefined,
  skuQuantity: undefined,
  skuAttrsVals: undefined,
  promotionAmount: undefined,
  couponAmount: undefined,
  integrationAmount: undefined,
  realAmount: undefined,
  giftIntegration: undefined,
  giftGrowth: undefined
}
const data = reactive<PageData<OrderItemForm, OrderItemQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    orderId: undefined,
    orderSn: undefined,
    spuId: undefined,
    spuName: undefined,
    spuPic: undefined,
    spuBrand: undefined,
    categoryId: undefined,
    skuId: undefined,
    skuName: undefined,
    skuPic: undefined,
    skuPrice: undefined,
    skuQuantity: undefined,
    skuAttrsVals: undefined,
    promotionAmount: undefined,
    couponAmount: undefined,
    integrationAmount: undefined,
    realAmount: undefined,
    giftIntegration: undefined,
    giftGrowth: undefined,
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
    orderSn: [
      { required: true, message: "order_sn不能为空", trigger: "blur" }
    ],
    spuId: [
      { required: true, message: "spu_id不能为空", trigger: "blur" }
    ],
    spuName: [
      { required: true, message: "spu_name不能为空", trigger: "blur" }
    ],
    spuPic: [
      { required: true, message: "spu_pic不能为空", trigger: "blur" }
    ],
    spuBrand: [
      { required: true, message: "品牌不能为空", trigger: "blur" }
    ],
    categoryId: [
      { required: true, message: "商品分类id不能为空", trigger: "blur" }
    ],
    skuId: [
      { required: true, message: "商品sku编号不能为空", trigger: "blur" }
    ],
    skuName: [
      { required: true, message: "商品sku名字不能为空", trigger: "blur" }
    ],
    skuPic: [
      { required: true, message: "商品sku图片不能为空", trigger: "blur" }
    ],
    skuPrice: [
      { required: true, message: "商品sku价格不能为空", trigger: "blur" }
    ],
    skuQuantity: [
      { required: true, message: "商品购买的数量不能为空", trigger: "blur" }
    ],
    skuAttrsVals: [
      { required: true, message: "商品销售属性组合不能为空", trigger: "blur" }
    ],
    promotionAmount: [
      { required: true, message: "商品促销分解金额不能为空", trigger: "blur" }
    ],
    couponAmount: [
      { required: true, message: "优惠券优惠分解金额不能为空", trigger: "blur" }
    ],
    integrationAmount: [
      { required: true, message: "积分优惠分解金额不能为空", trigger: "blur" }
    ],
    realAmount: [
      { required: true, message: "该商品经过优惠后的分解金额不能为空", trigger: "blur" }
    ],
    giftIntegration: [
      { required: true, message: "赠送积分不能为空", trigger: "blur" }
    ],
    giftGrowth: [
      { required: true, message: "赠送成长值不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询订单项信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listOrderItem(queryParams.value);
  orderItemList.value = res.rows;
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
  orderItemFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: OrderItemVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加订单项信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: OrderItemVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getOrderItem(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改订单项信息";
}

/** 提交按钮 */
const submitForm = () => {
  orderItemFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateOrderItem(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addOrderItem(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: OrderItemVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除订单项信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delOrderItem(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('oms/orderItem/export', {
    ...queryParams.value
  }, `orderItem_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
