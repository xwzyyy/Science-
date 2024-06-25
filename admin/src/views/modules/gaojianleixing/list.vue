<template>
  <div>
    <el-form :inline="true" :model="searchForm" class="demo-form-inline" label-width="100px">
      <el-form-item label="稿件类型">
        <el-input v-model="searchForm.gaojianleixing"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">查询</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
      <el-button type="primary" @click="showAddForm">添加稿件类型</el-button>
    </el-form>
    <el-table :data="types" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="gaojianleixing" label="稿件类型" width="200"></el-table-column>
      <el-table-column prop="addtime" label="创建时间" width="200"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="showEditForm(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteType(scope.row.id)">删除</el-button>
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
    <el-dialog title="稿件类型信息" :visible.sync="formVisible">
      <el-form :model="form" label-width="100px">
        <el-form-item label="稿件类型">
          <el-input v-model="form.gaojianleixing"></el-input>
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
      types: [],
      formVisible: false,
      isEdit: false,
      searchForm: {
        gaojianleixing: ''
      },
      form: {
        id: '',
        gaojianleixing: '',
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
        if (!this.searchForm[searchFormKey]) delete this.searchForm[searchFormKey];
      }
      const params = {
        page: this.currentPage,
        limit: this.pageSize,
        ...this.searchForm
      };
      this.$http.get('/gaojianleixing/list', { params })
          .then(response => {
            this.types = response.data.data.list;
            this.total = response.data.data.total;
          })
          .catch(error => {
            console.error('Failed to fetch types:', error);
          });
    },
    showAddForm() {
      this.isEdit = false;
      this.form = {
        id: '',
        gaojianleixing: '',
        addtime: ''
      };
      this.formVisible = true;
    },
    showEditForm(type) {
      this.isEdit = true;
      this.form = { ...type };
      this.formVisible = true;
    },
    submitForm() {
      if (this.isEdit) {
        this.$http.post('/gaojianleixing/update', this.form)
            .then(() => {
              this.fetchData();
              this.formVisible = false;
            })
            .catch(error => {
              console.error('Failed to update type:', error);
            });
      } else {
        this.$http.post('/gaojianleixing/add', this.form)
            .then(() => {
              this.fetchData();
              this.formVisible = false;
            })
            .catch(error => {
              console.error('Failed to add type:', error);
            });
      }
    },
    deleteType(id) {
      this.$http.post('/gaojianleixing/delete', [id])
          .then(() => {
            this.fetchData();
          })
          .catch(error => {
            console.error('Failed to delete type:', error);
          });
    },
    handleSearch() {
      this.currentPage = 1;
      this.fetchData();
    },
    handleReset() {
      this.searchForm = {
        gaojianleixing: ''
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
    }
  }
};
</script>

<style scoped>
.dialog-footer {
  text-align: right;
}
</style>
