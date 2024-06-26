<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="sku_id" prop="skuId">
              <el-input v-model="queryParams.skuId" placeholder="请输入sku_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="attr_id" prop="attrId">
              <el-input v-model="queryParams.attrId" placeholder="请输入attr_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="销售属性名" prop="attrName">
              <el-input v-model="queryParams.attrName" placeholder="请输入销售属性名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="销售属性值" prop="attrValue">
              <el-input v-model="queryParams.attrValue" placeholder="请输入销售属性值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="顺序" prop="attrSort">
              <el-input v-model="queryParams.attrSort" placeholder="请输入顺序" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:skuSaleAttrValue:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:skuSaleAttrValue:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:skuSaleAttrValue:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:skuSaleAttrValue:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="skuSaleAttrValueList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="sku_id" align="center" prop="skuId" />
        <el-table-column label="attr_id" align="center" prop="attrId" />
        <el-table-column label="销售属性名" align="center" prop="attrName" />
        <el-table-column label="销售属性值" align="center" prop="attrValue" />
        <el-table-column label="顺序" align="center" prop="attrSort" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:skuSaleAttrValue:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:skuSaleAttrValue:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改sku销售属性&值对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="skuSaleAttrValueFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="sku_id" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入sku_id" />
        </el-form-item>
        <el-form-item label="attr_id" prop="attrId">
          <el-input v-model="form.attrId" placeholder="请输入attr_id" />
        </el-form-item>
        <el-form-item label="销售属性名" prop="attrName">
          <el-input v-model="form.attrName" placeholder="请输入销售属性名" />
        </el-form-item>
        <el-form-item label="销售属性值" prop="attrValue">
          <el-input v-model="form.attrValue" placeholder="请输入销售属性值" />
        </el-form-item>
        <el-form-item label="顺序" prop="attrSort">
          <el-input v-model="form.attrSort" placeholder="请输入顺序" />
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

<script setup name="SkuSaleAttrValue" lang="ts">
import { listSkuSaleAttrValue, getSkuSaleAttrValue, delSkuSaleAttrValue, addSkuSaleAttrValue, updateSkuSaleAttrValue } from '@/api/pms/skuSaleAttrValue';
import { SkuSaleAttrValueVO, SkuSaleAttrValueQuery, SkuSaleAttrValueForm } from '@/api/pms/skuSaleAttrValue/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const skuSaleAttrValueList = ref<SkuSaleAttrValueVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const skuSaleAttrValueFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SkuSaleAttrValueForm = {
  id: undefined,
  skuId: undefined,
  attrId: undefined,
  attrName: undefined,
  attrValue: undefined,
  attrSort: undefined
}
const data = reactive<PageData<SkuSaleAttrValueForm, SkuSaleAttrValueQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    skuId: undefined,
    attrId: undefined,
    attrName: undefined,
    attrValue: undefined,
    attrSort: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "不能为空", trigger: "blur" }
    ],
    skuId: [
      { required: true, message: "sku_id不能为空", trigger: "blur" }
    ],
    attrId: [
      { required: true, message: "attr_id不能为空", trigger: "blur" }
    ],
    attrName: [
      { required: true, message: "销售属性名不能为空", trigger: "blur" }
    ],
    attrValue: [
      { required: true, message: "销售属性值不能为空", trigger: "blur" }
    ],
    attrSort: [
      { required: true, message: "顺序不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询sku销售属性&值列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSkuSaleAttrValue(queryParams.value);
  skuSaleAttrValueList.value = res.rows;
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
  skuSaleAttrValueFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SkuSaleAttrValueVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加sku销售属性&值";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: SkuSaleAttrValueVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getSkuSaleAttrValue(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改sku销售属性&值";
}

/** 提交按钮 */
const submitForm = () => {
  skuSaleAttrValueFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSkuSaleAttrValue(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addSkuSaleAttrValue(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: SkuSaleAttrValueVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除sku销售属性&值编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delSkuSaleAttrValue(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/skuSaleAttrValue/export', {
    ...queryParams.value
  }, `skuSaleAttrValue_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
