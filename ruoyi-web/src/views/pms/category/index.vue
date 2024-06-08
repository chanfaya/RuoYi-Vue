<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="分类名称" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入分类名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="父分类id" prop="parentCid">
              <el-input v-model="queryParams.parentCid" placeholder="请输入父分类id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="层级" prop="catLevel">
              <el-input v-model="queryParams.catLevel" placeholder="请输入层级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="排序" prop="sort">
              <el-input v-model="queryParams.sort" placeholder="请输入排序" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="图标地址" prop="icon">
              <el-input v-model="queryParams.icon" placeholder="请输入图标地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="计量单位" prop="productUnit">
              <el-input v-model="queryParams.productUnit" placeholder="请输入计量单位" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品数量" prop="productCount">
              <el-input v-model="queryParams.productCount" placeholder="请输入商品数量" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:category:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:category:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:category:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:category:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="categoryList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="分类id" align="center" prop="catId" v-if="true" />
        <el-table-column label="分类名称" align="center" prop="name" />
        <el-table-column label="父分类id" align="center" prop="parentCid" />
        <el-table-column label="层级" align="center" prop="catLevel" />
        <el-table-column label="是否显示[0-不显示，1显示]" align="center" prop="showStatus" />
        <el-table-column label="排序" align="center" prop="sort" />
        <el-table-column label="图标地址" align="center" prop="icon" />
        <el-table-column label="计量单位" align="center" prop="productUnit" />
        <el-table-column label="商品数量" align="center" prop="productCount" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:category:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:category:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改商品三级分类对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="categoryFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="分类名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入分类名称" />
        </el-form-item>
        <el-form-item label="父分类id" prop="parentCid">
          <el-input v-model="form.parentCid" placeholder="请输入父分类id" />
        </el-form-item>
        <el-form-item label="层级" prop="catLevel">
          <el-input v-model="form.catLevel" placeholder="请输入层级" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="图标地址" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入图标地址" />
        </el-form-item>
        <el-form-item label="计量单位" prop="productUnit">
          <el-input v-model="form.productUnit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="商品数量" prop="productCount">
          <el-input v-model="form.productCount" placeholder="请输入商品数量" />
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

<script setup name="Category" lang="ts">
import { listCategory, getCategory, delCategory, addCategory, updateCategory } from '@/api/pms/category';
import { CategoryVO, CategoryQuery, CategoryForm } from '@/api/pms/category/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const categoryList = ref<CategoryVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const categoryFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CategoryForm = {
  catId: undefined,
  name: undefined,
  parentCid: undefined,
  catLevel: undefined,
  showStatus: undefined,
  sort: undefined,
  icon: undefined,
  productUnit: undefined,
  productCount: undefined
}
const data = reactive<PageData<CategoryForm, CategoryQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    name: undefined,
    parentCid: undefined,
    catLevel: undefined,
    showStatus: undefined,
    sort: undefined,
    icon: undefined,
    productUnit: undefined,
    productCount: undefined,
    params: {
    }
  },
  rules: {
    catId: [
      { required: true, message: "分类id不能为空", trigger: "blur" }
    ],
    name: [
      { required: true, message: "分类名称不能为空", trigger: "blur" }
    ],
    parentCid: [
      { required: true, message: "父分类id不能为空", trigger: "blur" }
    ],
    catLevel: [
      { required: true, message: "层级不能为空", trigger: "blur" }
    ],
    showStatus: [
      { required: true, message: "是否显示[0-不显示，1显示]不能为空", trigger: "change" }
    ],
    sort: [
      { required: true, message: "排序不能为空", trigger: "blur" }
    ],
    icon: [
      { required: true, message: "图标地址不能为空", trigger: "blur" }
    ],
    productUnit: [
      { required: true, message: "计量单位不能为空", trigger: "blur" }
    ],
    productCount: [
      { required: true, message: "商品数量不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询商品三级分类列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCategory(queryParams.value);
  categoryList.value = res.rows;
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
  categoryFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: CategoryVO[]) => {
  ids.value = selection.map(item => item.catId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加商品三级分类";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: CategoryVO) => {
  reset();
  const _catId = row?.catId || ids.value[0]
  const res = await getCategory(_catId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改商品三级分类";
}

/** 提交按钮 */
const submitForm = () => {
  categoryFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.catId) {
        await updateCategory(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addCategory(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: CategoryVO) => {
  const _catIds = row?.catId || ids.value;
  await proxy?.$modal.confirm('是否确认删除商品三级分类编号为"' + _catIds + '"的数据项？').finally(() => loading.value = false);
  await delCategory(_catIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/category/export', {
    ...queryParams.value
  }, `category_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
