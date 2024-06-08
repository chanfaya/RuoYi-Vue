<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="商品名称" prop="spuName">
              <el-input v-model="queryParams.spuName" placeholder="请输入商品名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品描述" prop="spuDescription">
              <el-input v-model="queryParams.spuDescription" placeholder="请输入商品描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属分类id" prop="catalogId">
              <el-input v-model="queryParams.catalogId" placeholder="请输入所属分类id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="品牌id" prop="brandId">
              <el-input v-model="queryParams.brandId" placeholder="请输入品牌id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="" prop="weight">
              <el-input v-model="queryParams.weight" placeholder="请输入" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:spuInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:spuInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:spuInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:spuInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="spuInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="商品id" align="center" prop="id" v-if="true" />
        <el-table-column label="商品名称" align="center" prop="spuName" />
        <el-table-column label="商品描述" align="center" prop="spuDescription" />
        <el-table-column label="所属分类id" align="center" prop="catalogId" />
        <el-table-column label="品牌id" align="center" prop="brandId" />
        <el-table-column label="" align="center" prop="weight" />
        <el-table-column label="上架状态[0 - 下架，1 - 上架]" align="center" prop="publishStatus" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:spuInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:spuInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改spu信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="spuInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名称" prop="spuName">
          <el-input v-model="form.spuName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品描述" prop="spuDescription">
            <el-input v-model="form.spuDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属分类id" prop="catalogId">
          <el-input v-model="form.catalogId" placeholder="请输入所属分类id" />
        </el-form-item>
        <el-form-item label="品牌id" prop="brandId">
          <el-input v-model="form.brandId" placeholder="请输入品牌id" />
        </el-form-item>
        <el-form-item label="" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入" />
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

<script setup name="SpuInfo" lang="ts">
import { listSpuInfo, getSpuInfo, delSpuInfo, addSpuInfo, updateSpuInfo } from '@/api/pms/spuInfo';
import { SpuInfoVO, SpuInfoQuery, SpuInfoForm } from '@/api/pms/spuInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const spuInfoList = ref<SpuInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const spuInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SpuInfoForm = {
  id: undefined,
  spuName: undefined,
  spuDescription: undefined,
  catalogId: undefined,
  brandId: undefined,
  weight: undefined,
  publishStatus: undefined,
}
const data = reactive<PageData<SpuInfoForm, SpuInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    spuName: undefined,
    spuDescription: undefined,
    catalogId: undefined,
    brandId: undefined,
    weight: undefined,
    publishStatus: undefined,
    params: {
    }
  },
  rules: {
    id: [
      { required: true, message: "商品id不能为空", trigger: "blur" }
    ],
    spuName: [
      { required: true, message: "商品名称不能为空", trigger: "blur" }
    ],
    spuDescription: [
      { required: true, message: "商品描述不能为空", trigger: "blur" }
    ],
    catalogId: [
      { required: true, message: "所属分类id不能为空", trigger: "blur" }
    ],
    brandId: [
      { required: true, message: "品牌id不能为空", trigger: "blur" }
    ],
    weight: [
      { required: true, message: "不能为空", trigger: "blur" }
    ],
    publishStatus: [
      { required: true, message: "上架状态[0 - 下架，1 - 上架]不能为空", trigger: "change" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询spu信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSpuInfo(queryParams.value);
  spuInfoList.value = res.rows;
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
  spuInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SpuInfoVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加spu信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: SpuInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getSpuInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改spu信息";
}

/** 提交按钮 */
const submitForm = () => {
  spuInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSpuInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addSpuInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: SpuInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除spu信息编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delSpuInfo(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/spuInfo/export', {
    ...queryParams.value
  }, `spuInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
