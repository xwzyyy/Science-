<template>
  <div>
    <!-- 顶部多条件搜索 -->
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="稿件编号">
        <el-input v-model="searchForm.gaojianbianhao" placeholder="稿件编号"></el-input>
      </el-form-item>
      <el-form-item label="稿件标题">
        <el-input v-model="searchForm.gaojianbiaoti" placeholder="稿件标题"></el-input>
      </el-form-item>
      <el-form-item label="作者姓名">
        <el-input v-model="searchForm.zuozhexingming" placeholder="作者姓名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">查询</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 数据表格 -->
    <el-table :data="data" style="width: 100%">
      <el-table-column prop="gaojianbianhao" label="稿件编号"></el-table-column>
      <el-table-column prop="gaojianbiaoti" label="稿件标题"></el-table-column>
      <el-table-column prop="zuozhexingming" label="作者姓名"></el-table-column>
      <el-table-column prop="zuozhezhanghao" label="作者账号"></el-table-column>
      <el-table-column prop="zuozheshouji" label="作者手机"></el-table-column>
<!--      <el-table-column prop="bianjizhanghao" label="编辑账号"></el-table-column>
      <el-table-column prop="bianjixingming" label="编辑姓名"></el-table-column>-->
      <el-table-column prop="huifuzhuangtai" label="稿件" width="100">
        <template slot-scope="scope">
          <el-button type="primary" @click="download(scope.row)">下载</el-button>
        </template>
      </el-table-column>
      <el-table-column prop="shengaozhanghao" label="审稿账号"></el-table-column>
      <el-table-column prop="shengaoxingming" label="审稿姓名"></el-table-column>
      <el-table-column prop="tongzhishijian" label="通知时间"></el-table-column>
      <el-table-column prop="gaigaoneirong" label="改稿内容"></el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">修改</el-button>
          <el-button size="mini" type="primary" @click="gaigaosongshen(scope.row)">改稿送审</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>

    <!-- 详情/修改对话框 -->
    <el-dialog :title="isEdit ? '修改' : '详情'" :visible.sync="dialogVisible">
      <el-form :model="form" label-width="100px">
        <el-form-item label="稿件编号">
          <el-input v-model="form.gaojianbianhao" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="稿件标题">
          <el-input v-model="form.gaojiantiaomu" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="稿件">
          <file-upload
              tip="点击上传稿件"
              action="/file/upload"
              :limit="1"
              :multiple="false"
              :fileUrls="form.huifuzhuangtai ? form.huifuzhuangtai : ''"
              @change="gaojianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item label="上传时间">
          <el-input v-model="form.shangchuanshijian" :disabled="!isEdit"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="isEdit">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveEdit">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchForm: {
        gaojianbianhao: '',
        gaojiantiaomu: '',
        zuozhexingming: '',
        huifuzhuangtai: ''
      },
      data: [],
      total: 0,
      flag: '',
      pageSize: 10,
      currentPage: 1,
      dialogVisible: false,
      isEdit: false,
      shenheForm: {
      },
      form: {
        gaojianbianhao: '',
        gaojiantiaomu: '',
        zuozhexingming: '',
        shangchuanshijian: '',
        huifuzhuangtai: ''
      },
    };
  },
  methods: {
    fetchData() {
      for (const searchFormKey in this.searchForm) {
        if (!this.searchForm[searchFormKey]) delete this.searchForm[searchFormKey]
      }
      this.$http.get('/gaigaotongzhi/' + (this.flag === 'zuozhe' ? 'page' : 'list'), {
        params: {
          ...this.searchForm,
          page: this.currentPage,
          limit: this.pageSize
        }
      }).then(response => {
        this.data = response.data.data.list;
        this.total = response.data.data.total;
      });
    },
    download(row) {
      window.open(row.huifuzhuangtai)
    },
    handleSearch() {
      this.currentPage = 1;
      this.fetchData();
    },
    gaojianUploadChange(fileUrls) {
      console.log('fileUrls',fileUrls)
      this.form.huifuzhuangtai = fileUrls;
    },
    handleReset() {
      this.searchForm = {
        gaojianbianhao: '',
        gaojiantiaomu: '',
        zuozhexingming: '',
        huifuzhuangtai: ''
      };
      this.currentPage = 1;
      this.fetchData();
    },
    handleEdit(row) {
      this.form = Object.assign({}, row);
      this.isEdit = true;
      this.dialogVisible = true;
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.fetchData();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
    },
    handleDetail(row) {
      this.isEdit = false;
      this.form = { ...row };
      this.dialogVisible = true;
    },
    handleReply(row) {
      this.isEdit = true;
      this.form = { ...row };
      this.dialogVisible = true;
    },
    saveEdit() {
      this.$http.post('/gaigaotongzhi/update', this.form).then(response => {
        this.dialogVisible = false;
        this.fetchData();
      });
    },
    handleDelete(row) {
      this.$confirm('确定要删除这条记录吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('/gaigaotongzhi/delete', [row.id]).then(response => {
          this.fetchData();
        });
      }).catch(() => {});
    },
    gaigaosongshen(row) {
      this.shenheForm.id = row.id
      this.$confirm('是否送审', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('/gaigaotongzhi/gaigaosongshen/'+this.shenheForm.id)
            .then(response => {
              if (response.data.code === 0) {
                this.$message.success('送审成功');
                this.fetchData()
              } else {
                this.$message.error(response.data.msg || '送审失败');
              }
            })
            .catch(error => {
              console.error('送审错误:', error);
              this.$message.error('送审错误');
            });
      });
    },
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.fetchData();
  }
};
</script>

<style scoped>
.el-menu-vertical-demo {
  width: 200px;
  height: 100vh;
  border-right: 1px solid #ddd;
}
.demo-form-inline {
  padding: 20px;
}
</style>
