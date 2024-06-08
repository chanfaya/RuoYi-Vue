<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="属性名" prop="attrName">
              <el-input v-model="queryParams.attrName" placeholder="请输入属性名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="属性图标" prop="icon">
              <el-input v-model="queryParams.icon" placeholder="请输入属性图标" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="可选值列表[用逗号分隔]" prop="valueSelect">
              <el-input v-model="queryParams.valueSelect" placeholder="请输入可选值列表[用逗号分隔]" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="启用状态[0 - 禁用，1 - 启用]" prop="enable">
              <el-input v-model="queryParams.enable" placeholder="请输入启用状态[0 - 禁用，1 - 启用]" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="所属分类" prop="catelogId">
              <el-input v-model="queryParams.catelogId" placeholder="请输入所属分类" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" prop="showDesc">
              <el-input v-model="queryParams.showDesc" placeholder="请输入快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:attr:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:attr:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:attr:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:attr:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="attrList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="属性id" align="center" prop="attrId" v-if="true" />
        <el-table-column label="属性名" align="center" prop="attrName" />
        <el-table-column label="是否需要检索[0-不需要，1-需要]" align="center" prop="searchType" />
        <el-table-column label="值类型[0-为单个值，1-可以选择多个值]" align="center" prop="valueType" />
        <el-table-column label="属性图标" align="center" prop="icon" />
        <el-table-column label="可选值列表[用逗号分隔]" align="center" prop="valueSelect" />
        <el-table-column label="属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]" align="center" prop="attrType" />
        <el-table-column label="启用状态[0 - 禁用，1 - 启用]" align="center" prop="enable" />
        <el-table-column label="所属分类" align="center" prop="catelogId" />
        <el-table-column label="快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" align="center" prop="showDesc" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:attr:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:attr:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改商品属性对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="attrFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="属性名" prop="attrName">
          <el-input v-model="form.attrName" placeholder="请输入属性名" />
        </el-form-item>
        <el-form-item label="属性图标" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入属性图标" />
        </el-form-item>
        <el-form-item label="可选值列表[用逗号分隔]" prop="valueSelect">
          <el-input v-model="form.valueSelect" placeholder="请输入可选值列表[用逗号分隔]" />
        </el-form-item>
        <el-form-item label="启用状态[0 - 禁用，1 - 启用]" prop="enable">
          <el-input v-model="form.enable" placeholder="请输入启用状态[0 - 禁用，1 - 启用]" />
        </el-form-item>
        <el-form-item label="所属分类" prop="catelogId">
          <el-input v-model="form.catelogId" placeholder="请输入所属分类" />
        </el-form-item>
        <el-form-item label="快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" prop="showDesc">
          <el-input v-model="form.showDesc" placeholder="请输入快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整" />
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

<script setup name="Attr" lang="ts">
import { listAttr, getAttr, delAttr, addAttr, updateAttr } from '@/api/pms/attr';
import { AttrVO, AttrQuery, AttrForm } from '@/api/pms/attr/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const attrList = ref<AttrVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const attrFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: AttrForm = {
  attrId: undefined,
  attrName: undefined,
  searchType: undefined,
  valueType: undefined,
  icon: undefined,
  valueSelect: undefined,
  attrType: undefined,
  enable: undefined,
  catelogId: undefined,
  showDesc: undefined
}
const data = reactive<PageData<AttrForm, AttrQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    attrName: undefined,
    searchType: undefined,
    valueType: undefined,
    icon: undefined,
    valueSelect: undefined,
    attrType: undefined,
    enable: undefined,
    catelogId: undefined,
    showDesc: undefined,
    params: {
    }
  },
  rules: {
    attrId: [
      { required: true, message: "属性id不能为空", trigger: "blur" }
    ],
    attrName: [
      { required: true, message: "属性名不能为空", trigger: "blur" }
    ],
    searchType: [
      { required: true, message: "是否需要检索[0-不需要，1-需要]不能为空", trigger: "change" }
    ],
    valueType: [
      { required: true, message: "值类型[0-为单个值，1-可以选择多个值]不能为空", trigger: "change" }
    ],
    icon: [
      { required: true, message: "属性图标不能为空", trigger: "blur" }
    ],
    valueSelect: [
      { required: true, message: "可选值列表[用逗号分隔]不能为空", trigger: "blur" }
    ],
    attrType: [
      { required: true, message: "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]不能为空", trigger: "change" }
    ],
    enable: [
      { required: true, message: "启用状态[0 - 禁用，1 - 启用]不能为空", trigger: "blur" }
    ],
    catelogId: [
      { required: true, message: "所属分类不能为空", trigger: "blur" }
    ],
    showDesc: [
      { required: true, message: "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询商品属性列表 */
const getList = async () => {
  loading.value = true;
  const res = await listAttr(queryParams.value);
  attrList.value = res.rows;
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
  attrFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: AttrVO[]) => {
  ids.value = selection.map(item => item.attrId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加商品属性";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: AttrVO) => {
  reset();
  const _attrId = row?.attrId || ids.value[0]
  const res = await getAttr(_attrId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改商品属性";
}

/** 提交按钮 */
const submitForm = () => {
  attrFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.attrId) {
        await updateAttr(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addAttr(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: AttrVO) => {
  const _attrIds = row?.attrId || ids.value;
  await proxy?.$modal.confirm('是否确认删除商品属性编号为"' + _attrIds + '"的数据项？').finally(() => loading.value = false);
  await delAttr(_attrIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/attr/export', {
    ...queryParams.value
  }, `attr_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
