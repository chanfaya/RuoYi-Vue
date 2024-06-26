<template>
  <div class="p-2">
    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:brand:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:brand:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:brand:remove']">删除</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="brandList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="品牌id" align="center" prop="brandId" v-if="true" />
        <el-table-column label="品牌名" align="center" prop="name" />
        <el-table-column label="介绍" align="center" prop="descript" />
        <el-table-column label="显示状态" align="center" prop="showStatus" />
        <el-table-column label="检索首字母" align="center" prop="firstLetter" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:brand:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:brand:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改品牌对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="brandFormRef" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入品牌名" />
        </el-form-item>
        <el-form-item label="首字母" prop="firstLetter">
          <el-input v-model="form.firstLetter" placeholder="请输入检索首字母" />
        </el-form-item>
          <el-form-item label="LOGO" prop="name">
              <el-input v-model="form.logo" placeholder="请输入logo" />
          </el-form-item>
          <el-form-item label="介绍" prop="descript">
              <el-input v-model="form.descript" type="textarea" placeholder="请输入内容" />
          </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
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

<script setup name="Brand" lang="ts">
import { listBrand, getBrand, delBrand, addBrand, updateBrand } from '@/api/pms/brand';
import { BrandVO, BrandQuery, BrandForm } from '@/api/pms/brand/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const brandList = ref<BrandVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const brandFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: BrandForm = {
  brandId: undefined,
  name: undefined,
  logo: undefined,
  descript: undefined,
  showStatus: undefined,
  firstLetter: undefined,
  sort: undefined
}
const data = reactive<PageData<BrandForm, BrandQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    name: undefined,
    logo: undefined,
    descript: undefined,
    showStatus: undefined,
    firstLetter: undefined,
    sort: undefined,
    params: {
    }
  },
  rules: {
    brandId: [
      { required: true, message: "品牌id不能为空", trigger: "blur" }
    ],
    name: [
      { required: true, message: "品牌名不能为空", trigger: "blur" }
    ],
    logo: [
      { required: true, message: "品牌logo地址不能为空", trigger: "blur" }
    ],
    descript: [
      { required: true, message: "介绍不能为空", trigger: "blur" }
    ],
    showStatus: [
      { required: true, message: "显示状态[0-不显示；1-显示]不能为空", trigger: "change" }
    ],
    firstLetter: [
      { required: true, message: "检索首字母不能为空", trigger: "blur" }
    ],
    sort: [
      { required: true, message: "排序不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询品牌列表 */
const getList = async () => {
  loading.value = true;
  const res = await listBrand(queryParams.value);
  brandList.value = res.rows;
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
  brandFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: BrandVO[]) => {
  ids.value = selection.map(item => item.brandId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加品牌";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: BrandVO) => {
  reset();
  const _brandId = row?.brandId || ids.value[0]
  const res = await getBrand(_brandId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改品牌";
}

/** 提交按钮 */
const submitForm = () => {
  brandFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.brandId) {
        await updateBrand(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addBrand(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: BrandVO) => {
  const _brandIds = row?.brandId || ids.value;
  await proxy?.$modal.confirm('是否确认删除品牌编号为"' + _brandIds + '"的数据项？').finally(() => loading.value = false);
  await delBrand(_brandIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

onMounted(() => {
  getList();
});
</script>
