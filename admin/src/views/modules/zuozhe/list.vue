<template>
  <div>
    <el-form :inline="true" :model="searchForm" class="demo-form-inline" label-width="100px">
      <el-form-item label="作者账号">
        <el-input v-model="searchForm.zuozhezhanghao"></el-input>
      </el-form-item>
      <el-form-item label="作者姓名">
        <el-input v-model="searchForm.zuozhexingming"></el-input>
      </el-form-item>
      <el-form-item label="作者手机">
        <el-input v-model="searchForm.zuozheshouji"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">查询</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
      <el-button type="primary" @click="showAddForm">添加作者</el-button>
    </el-form>
    <el-table :data="authors" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="zuozhezhanghao" label="作者账号" width="200"></el-table-column>
      <el-table-column prop="zuozhexingming" label="作者姓名" width="200"></el-table-column>
      <el-table-column prop="xingbie" label="性别" width="100"></el-table-column>
      <el-table-column prop="nianling" label="年龄" width="100"></el-table-column>
<!--      <el-table-column prop="touxiang" label="头像" width="200">
        <template slot-scope="scope">
          <el-image :src="scope.row.touxiang">
          </el-image>
        </template>
      </el-table-column>-->
      <el-table-column prop="zuozheshouji" label="作者手机" width="200"></el-table-column>
      <el-table-column prop="addtime" label="创建时间" width="200"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="showEditForm(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteAuthor(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
    <el-dialog title="作者信息" :visible.sync="formVisible">
      <el-form :model="form" label-width="100px">
        <el-form-item label="账号">
          <el-input v-model="form.zuozhezhanghao"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.mima" type="password"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="form.zuozhexingming"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="form.xingbie"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.nianling"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <el-input v-model="form.touxiang"></el-input>
        </el-form-item>
        <el-form-item label="手机">
          <el-input v-model="form.zuozheshouji"></el-input>
        </el-form-item>
        <el-form-item label="创建时间">
          <el-input v-model="form.addtime" :disabled="true"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="formVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm">确认</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      authors: [],
      formVisible: false,
      isEdit: false,
      searchForm: {
      },
      form: {
        id: '',
        zuozhezhanghao: '',
        mima: '',
        zuozhexingming: '',
        xingbie: '',
        nianling: '',
        touxiang: '',
        zuozheshouji: '',
        addtime: ''
      },
      currentPage: 1,
      pageSize: 10,
      total: 0
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      for (const searchFormKey in this.searchForm) {
        if (!this.searchForm[searchFormKey]) delete this.searchForm[searchFormKey]
      }
      const params = {
        page: this.currentPage,
        limit: this.pageSize,
        ...this.searchForm
      };
      this.$http.get('/zuozhe/list',{params})
          .then(response => {
            this.authors = response.data.data.list;
            this.total = response.data.data.total
          })
          .catch(error => {
            console.error('Failed to fetch authors:', error);
          });
    },
    showAddForm() {
      this.isEdit = false;
      this.form = {
        id: '',
        zuozhezhanghao: '',
        mima: '',
        zuozhexingming: '',
        xingbie: '',
        nianling: '',
        touxiang: '',
        zuozheshouji: '',
        addtime: ''
      };
      this.formVisible = true;
    },
    showEditForm(author) {
      this.isEdit = true;
      this.form = {...author};
      this.formVisible = true;
    },
    submitForm() {
      if (this.isEdit) {
        this.$http.post('/zuozhe/update', this.form)
            .then(() => {
              this.fetchData();
              this.formVisible = false;
            })
            .catch(error => {
              console.error('Failed to update author:', error);
            });
      } else {
        this.$http.post('/zuozhe/add', this.form)
            .then(() => {
              this.fetchData();
              this.formVisible = false;
            })
            .catch(error => {
              console.error('Failed to add author:', error);
            });
      }
    },
    deleteAuthor(id) {
      this.$http.post('/zuozhe/delete', [id])
          .then(() => {
            this.fetchData();
          })
          .catch(error => {
            console.error('Failed to delete author:', error);
          });
    },
    handleSearch() {
      this.currentPage = 1;
      this.fetchData();
    },
    handleReset() {
      this.searchForm = {
      };
      this.handleSearch();
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.fetchData();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
    },

  }
};
</script>

<style scoped>
.dialog-footer {
  text-align: right;
}
</style>
