<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="spuId" prop="spuId">
              <el-input v-model="queryParams.spuId" placeholder="请输入spuId" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="sku名称" prop="skuName">
              <el-input v-model="queryParams.skuName" placeholder="请输入sku名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="sku介绍描述" prop="skuDesc">
              <el-input v-model="queryParams.skuDesc" placeholder="请输入sku介绍描述" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属分类id" prop="catalogId">
              <el-input v-model="queryParams.catalogId" placeholder="请输入所属分类id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="品牌id" prop="brandId">
              <el-input v-model="queryParams.brandId" placeholder="请输入品牌id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="默认图片" prop="skuDefaultImg">
              <el-input v-model="queryParams.skuDefaultImg" placeholder="请输入默认图片" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="标题" prop="skuTitle">
              <el-input v-model="queryParams.skuTitle" placeholder="请输入标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="副标题" prop="skuSubtitle">
              <el-input v-model="queryParams.skuSubtitle" placeholder="请输入副标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="价格" prop="price">
              <el-input v-model="queryParams.price" placeholder="请输入价格" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="销量" prop="saleCount">
              <el-input v-model="queryParams.saleCount" placeholder="请输入销量" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:skuInfo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:skuInfo:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:skuInfo:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:skuInfo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="skuInfoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="skuId" align="center" prop="skuId" v-if="true" />
        <el-table-column label="spuId" align="center" prop="spuId" />
        <el-table-column label="sku名称" align="center" prop="skuName" />
        <el-table-column label="sku介绍描述" align="center" prop="skuDesc" />
        <el-table-column label="所属分类id" align="center" prop="catalogId" />
        <el-table-column label="品牌id" align="center" prop="brandId" />
        <el-table-column label="默认图片" align="center" prop="skuDefaultImg" />
        <el-table-column label="标题" align="center" prop="skuTitle" />
        <el-table-column label="副标题" align="center" prop="skuSubtitle" />
        <el-table-column label="价格" align="center" prop="price" />
        <el-table-column label="销量" align="center" prop="saleCount" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:skuInfo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:skuInfo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改sku信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="skuInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="spuId" prop="spuId">
          <el-input v-model="form.spuId" placeholder="请输入spuId" />
        </el-form-item>
        <el-form-item label="sku名称" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入sku名称" />
        </el-form-item>
        <el-form-item label="sku介绍描述" prop="skuDesc">
            <el-input v-model="form.skuDesc" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属分类id" prop="catalogId">
          <el-input v-model="form.catalogId" placeholder="请输入所属分类id" />
        </el-form-item>
        <el-form-item label="品牌id" prop="brandId">
          <el-input v-model="form.brandId" placeholder="请输入品牌id" />
        </el-form-item>
        <el-form-item label="默认图片" prop="skuDefaultImg">
          <el-input v-model="form.skuDefaultImg" placeholder="请输入默认图片" />
        </el-form-item>
        <el-form-item label="标题" prop="skuTitle">
          <el-input v-model="form.skuTitle" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="副标题" prop="skuSubtitle">
            <el-input v-model="form.skuSubtitle" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="销量" prop="saleCount">
          <el-input v-model="form.saleCount" placeholder="请输入销量" />
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

<script setup name="SkuInfo" lang="ts">
import { listSkuInfo, getSkuInfo, delSkuInfo, addSkuInfo, updateSkuInfo } from '@/api/pms/skuInfo';
import { SkuInfoVO, SkuInfoQuery, SkuInfoForm } from '@/api/pms/skuInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const skuInfoList = ref<SkuInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const skuInfoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SkuInfoForm = {
  skuId: undefined,
  spuId: undefined,
  skuName: undefined,
  skuDesc: undefined,
  catalogId: undefined,
  brandId: undefined,
  skuDefaultImg: undefined,
  skuTitle: undefined,
  skuSubtitle: undefined,
  price: undefined,
  saleCount: undefined
}
const data = reactive<PageData<SkuInfoForm, SkuInfoQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    spuId: undefined,
    skuName: undefined,
    skuDesc: undefined,
    catalogId: undefined,
    brandId: undefined,
    skuDefaultImg: undefined,
    skuTitle: undefined,
    skuSubtitle: undefined,
    price: undefined,
    saleCount: undefined,
    params: {
    }
  },
  rules: {
    skuId: [
      { required: true, message: "skuId不能为空", trigger: "blur" }
    ],
    spuId: [
      { required: true, message: "spuId不能为空", trigger: "blur" }
    ],
    skuName: [
      { required: true, message: "sku名称不能为空", trigger: "blur" }
    ],
    skuDesc: [
      { required: true, message: "sku介绍描述不能为空", trigger: "blur" }
    ],
    catalogId: [
      { required: true, message: "所属分类id不能为空", trigger: "blur" }
    ],
    brandId: [
      { required: true, message: "品牌id不能为空", trigger: "blur" }
    ],
    skuDefaultImg: [
      { required: true, message: "默认图片不能为空", trigger: "blur" }
    ],
    skuTitle: [
      { required: true, message: "标题不能为空", trigger: "blur" }
    ],
    skuSubtitle: [
      { required: true, message: "副标题不能为空", trigger: "blur" }
    ],
    price: [
      { required: true, message: "价格不能为空", trigger: "blur" }
    ],
    saleCount: [
      { required: true, message: "销量不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询sku信息列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSkuInfo(queryParams.value);
  skuInfoList.value = res.rows;
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
  skuInfoFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SkuInfoVO[]) => {
  ids.value = selection.map(item => item.skuId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加sku信息";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: SkuInfoVO) => {
  reset();
  const _skuId = row?.skuId || ids.value[0]
  const res = await getSkuInfo(_skuId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改sku信息";
}

/** 提交按钮 */
const submitForm = () => {
  skuInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.skuId) {
        await updateSkuInfo(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addSkuInfo(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: SkuInfoVO) => {
  const _skuIds = row?.skuId || ids.value;
  await proxy?.$modal.confirm('是否确认删除sku信息编号为"' + _skuIds + '"的数据项？').finally(() => loading.value = false);
  await delSkuInfo(_skuIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/skuInfo/export', {
    ...queryParams.value
  }, `skuInfo_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
