<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="sku_id" prop="skuId">
              <el-input v-model="queryParams.skuId" placeholder="请输入sku_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="spu_id" prop="spuId">
              <el-input v-model="queryParams.spuId" placeholder="请输入spu_id" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="商品名字" prop="spuName">
              <el-input v-model="queryParams.spuName" placeholder="请输入商品名字" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="会员昵称" prop="memberNickName">
              <el-input v-model="queryParams.memberNickName" placeholder="请输入会员昵称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="星级" prop="star">
              <el-input v-model="queryParams.star" placeholder="请输入星级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="会员ip" prop="memberIp">
              <el-input v-model="queryParams.memberIp" placeholder="请输入会员ip" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="购买时属性组合" prop="spuAttributes">
              <el-input v-model="queryParams.spuAttributes" placeholder="请输入购买时属性组合" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="点赞数" prop="likesCount">
              <el-input v-model="queryParams.likesCount" placeholder="请输入点赞数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="回复数" prop="replyCount">
              <el-input v-model="queryParams.replyCount" placeholder="请输入回复数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" prop="resources">
              <el-input v-model="queryParams.resources" placeholder="请输入评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="用户头像" prop="memberIcon">
              <el-input v-model="queryParams.memberIcon" placeholder="请输入用户头像" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['pms:spuComment:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['pms:spuComment:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['pms:spuComment:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['pms:spuComment:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" :data="spuCommentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="" align="center" prop="id" v-if="true" />
        <el-table-column label="sku_id" align="center" prop="skuId" />
        <el-table-column label="spu_id" align="center" prop="spuId" />
        <el-table-column label="商品名字" align="center" prop="spuName" />
        <el-table-column label="会员昵称" align="center" prop="memberNickName" />
        <el-table-column label="星级" align="center" prop="star" />
        <el-table-column label="会员ip" align="center" prop="memberIp" />
        <el-table-column label="显示状态[0-不显示，1-显示]" align="center" prop="showStatus" />
        <el-table-column label="购买时属性组合" align="center" prop="spuAttributes" />
        <el-table-column label="点赞数" align="center" prop="likesCount" />
        <el-table-column label="回复数" align="center" prop="replyCount" />
        <el-table-column label="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" align="center" prop="resources" />
        <el-table-column label="内容" align="center" prop="content" />
        <el-table-column label="用户头像" align="center" prop="memberIcon" />
        <el-table-column label="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]" align="center" prop="commentType" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['pms:spuComment:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['pms:spuComment:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改商品评价对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="spuCommentFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="sku_id" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入sku_id" />
        </el-form-item>
        <el-form-item label="spu_id" prop="spuId">
          <el-input v-model="form.spuId" placeholder="请输入spu_id" />
        </el-form-item>
        <el-form-item label="商品名字" prop="spuName">
          <el-input v-model="form.spuName" placeholder="请输入商品名字" />
        </el-form-item>
        <el-form-item label="会员昵称" prop="memberNickName">
          <el-input v-model="form.memberNickName" placeholder="请输入会员昵称" />
        </el-form-item>
        <el-form-item label="星级" prop="star">
          <el-input v-model="form.star" placeholder="请输入星级" />
        </el-form-item>
        <el-form-item label="会员ip" prop="memberIp">
          <el-input v-model="form.memberIp" placeholder="请输入会员ip" />
        </el-form-item>
        <el-form-item label="购买时属性组合" prop="spuAttributes">
          <el-input v-model="form.spuAttributes" placeholder="请输入购买时属性组合" />
        </el-form-item>
        <el-form-item label="点赞数" prop="likesCount">
          <el-input v-model="form.likesCount" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="回复数" prop="replyCount">
          <el-input v-model="form.replyCount" placeholder="请输入回复数" />
        </el-form-item>
        <el-form-item label="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" prop="resources">
            <el-input v-model="form.resources" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="用户头像" prop="memberIcon">
          <el-input v-model="form.memberIcon" placeholder="请输入用户头像" />
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

<script setup name="SpuComment" lang="ts">
import { listSpuComment, getSpuComment, delSpuComment, addSpuComment, updateSpuComment } from '@/api/pms/spuComment';
import { SpuCommentVO, SpuCommentQuery, SpuCommentForm } from '@/api/pms/spuComment/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const spuCommentList = ref<SpuCommentVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const spuCommentFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SpuCommentForm = {
  id: undefined,
  skuId: undefined,
  spuId: undefined,
  spuName: undefined,
  memberNickName: undefined,
  star: undefined,
  memberIp: undefined,
  showStatus: undefined,
  spuAttributes: undefined,
  likesCount: undefined,
  replyCount: undefined,
  resources: undefined,
  content: undefined,
  memberIcon: undefined,
  commentType: undefined
}
const data = reactive<PageData<SpuCommentForm, SpuCommentQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    skuId: undefined,
    spuId: undefined,
    spuName: undefined,
    memberNickName: undefined,
    star: undefined,
    memberIp: undefined,
    showStatus: undefined,
    spuAttributes: undefined,
    likesCount: undefined,
    replyCount: undefined,
    resources: undefined,
    content: undefined,
    memberIcon: undefined,
    commentType: undefined,
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
    spuId: [
      { required: true, message: "spu_id不能为空", trigger: "blur" }
    ],
    spuName: [
      { required: true, message: "商品名字不能为空", trigger: "blur" }
    ],
    memberNickName: [
      { required: true, message: "会员昵称不能为空", trigger: "blur" }
    ],
    star: [
      { required: true, message: "星级不能为空", trigger: "blur" }
    ],
    memberIp: [
      { required: true, message: "会员ip不能为空", trigger: "blur" }
    ],
    showStatus: [
      { required: true, message: "显示状态[0-不显示，1-显示]不能为空", trigger: "change" }
    ],
    spuAttributes: [
      { required: true, message: "购买时属性组合不能为空", trigger: "blur" }
    ],
    likesCount: [
      { required: true, message: "点赞数不能为空", trigger: "blur" }
    ],
    replyCount: [
      { required: true, message: "回复数不能为空", trigger: "blur" }
    ],
    resources: [
      { required: true, message: "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]不能为空", trigger: "blur" }
    ],
    content: [
      { required: true, message: "内容不能为空", trigger: "blur" }
    ],
    memberIcon: [
      { required: true, message: "用户头像不能为空", trigger: "blur" }
    ],
    commentType: [
      { required: true, message: "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]不能为空", trigger: "change" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询商品评价列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSpuComment(queryParams.value);
  spuCommentList.value = res.rows;
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
  spuCommentFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: SpuCommentVO[]) => {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加商品评价";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: SpuCommentVO) => {
  reset();
  const _id = row?.id || ids.value[0]
  const res = await getSpuComment(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改商品评价";
}

/** 提交按钮 */
const submitForm = () => {
  spuCommentFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSpuComment(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addSpuComment(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: SpuCommentVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除商品评价编号为"' + _ids + '"的数据项？').finally(() => loading.value = false);
  await delSpuComment(_ids);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('pms/spuComment/export', {
    ...queryParams.value
  }, `spuComment_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
