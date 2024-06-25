<template>
  <div>
    <!-- 搜索表单 -->
    <el-form :inline="true" :model="searchForm" class="demo-form-inline" label-width="100px">
        <el-form-item label="稿件编号">
          <el-input v-model="searchForm.gaojianbianhao"></el-input>
        </el-form-item>
        <el-form-item label="稿件标题">
          <el-input v-model="searchForm.gaojianbiaoti"></el-input>
        </el-form-item>
        <el-form-item label="作者姓名">
          <el-input v-model="searchForm.zuozhexingming"></el-input>
        </el-form-item>
        <el-form-item label="录用状态">
          <el-input v-model="searchForm.luyongzhuangtai"></el-input>
        </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">查询</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="data" style="width: 100%">
      <el-table-column type="index" label="索引" width="50"></el-table-column>
      <el-table-column prop="gaojianbianhao" label="稿件编号" width="100"></el-table-column>
      <el-table-column prop="gaojianbiaoti" label="稿件标题" width="100"></el-table-column>
      <el-table-column prop="gaojianleixing" label="稿件类型" width="100"></el-table-column>
      <el-table-column prop="zuozhezhanghao" label="作者账号" width="100"></el-table-column>
      <el-table-column prop="zuozhexingming" label="作者姓名" width="100"></el-table-column>
      <el-table-column prop="zuozheshouji" label="作者手机" width="100"></el-table-column>
      <el-table-column prop="shangchuanshijian" label="上传时间" width="150"></el-table-column>
      <el-table-column prop="gaojian" label="稿件" width="100">
        <template slot-scope="scope">
          <el-button type="primary" @click="download(scope.row)">下载</el-button>
        </template>
      </el-table-column>
<!--      <el-table-column prop="bianjizhanghao" label="编辑账号" width="100"></el-table-column>
      <el-table-column prop="bianjixingming" label="编辑姓名" width="100"></el-table-column>-->
      <el-table-column prop="shengaozhanghao" label="审稿账号" width="100"></el-table-column>
      <el-table-column prop="shougaoshijian" label="收稿时间" width="150"></el-table-column>
      <el-table-column prop="luyongzhuangtai" label="录用状态" width="100"></el-table-column>
<!--      <el-table-column prop="shhf" label="审稿回复" width="100"></el-table-column>-->
      <el-table-column v-if="flag === 'shengaoren'"  label="操作" fixed="right" :width="flag === 'shengaoren' ? 400 : 200">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" v-if="flag === 'shengaoren'"   @click="handleEdit(scope.row)">修改</el-button>
          <el-button size="mini" type="primary" v-if="flag === 'shengaoren'"  @click="tongzhiVisible = true; tongzhiForm.id = scope.row.id"> 改稿通知</el-button>
<!--          <el-button size="mini" type="primary"  v-if="flag === 'shengaoren'" @click="shenheVisible = true; shenheForm.id = scope.row.id">审核</el-button>-->
          <el-button size="mini" type="primary" v-if="flag === 'shengaoren'"  @click="gaojianluyong(scope.row)"> 录用稿件</el-button>
          <el-button size="mini" type="danger"   @click="handleDelete(scope.row)">删除</el-button>
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
    <el-dialog :title="isEdit ? '修改' : '详情'" :visible.sync="dialogVisible">
      <el-form :model="form" :disabled="!isEdit" label-width="100px">
        <el-form-item label="稿件编号" prop="gaojianbianhao">
          <el-input v-model="form.gaojianbianhao" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="稿件标题" prop="gaojiandengji">
          <el-input v-model="form.gaojianbiaoti" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="稿件类型" prop="gaojianleixing">
          <el-input v-model="form.gaojianleixing" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="作者账号" prop="zuozhezhanghao">
          <el-input v-model="form.zuozhezhanghao" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="作者姓名" prop="zuozhexingming">
          <el-input v-model="form.zuozhexingming" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="作者手机" prop="zuozheshouji">
          <el-input v-model="form.zuozheshouji" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="上传时间" prop="shangchuanshijian">
          <el-input v-model="form.shangchuanshijian" :disabled="!isEdit"></el-input>
        </el-form-item>
<!--        <el-form-item label="编辑账号" prop="bianjizhanghao">
          <el-input v-model="form.bianjizhanghao" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="编辑姓名" prop="bianjixingming">
          <el-input v-model="form.bianjixingming" :disabled="!isEdit"></el-input>
        </el-form-item>-->
        <el-form-item label="审稿账号" prop="shengaozhanghao">
          <el-input v-model="form.shenghaozhanghao" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="收稿时间" prop="shougaoshijian">
          <el-input v-model="form.shougaoshijian" :disabled="!isEdit"></el-input>
        </el-form-item>
        <el-form-item label="录用状态" prop="caiyongzhuangtai">
          <el-input v-model="form.luyongzhuangtai" :disabled="!isEdit"></el-input>
        </el-form-item>
<!--        <el-form-item label="审稿回复" prop="shhf">
          <el-input v-model="form.shenggaohuifu" :disabled="!isEdit"></el-input>
        </el-form-item>-->
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button v-if="isEdit" type="primary" @click="saveEdit">保存</el-button>
      </span>
    </el-dialog>

    <el-dialog title="审核稿件" :visible.sync="shenheVisible">
      <el-form  :model="shenheForm" label-width="120px">
        <el-form-item label="稿件id">
          {{ shenheForm.id }}
        </el-form-item>
        <el-form-item label="审核回复">
          <el-input v-model="shenheForm.shhf"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="shenhe">审核</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="改稿通知" :visible.sync="tongzhiVisible">
      <el-form  :model="tongzhiForm" label-width="120px">
        <el-form-item label="稿件id">
          {{ tongzhiForm.id }}
        </el-form-item>
        <el-form-item label="改稿内容">
          <el-input v-model="tongzhiForm.gaigaoneirong"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="gaigaotongzhi">通知</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: [], // 表格数据
      searchForm: {
      },
      dialogVisible: false,
      isEdit: false,
      flag: '',
      form: {}, // 表单数据
      shenheForm: {},
      tongzhiForm: {},
      formVisible: false,
      shenheVisible: false,
      tongzhiVisible: false,
      currentPage: 1,
      pageSize: 10,
      total: 0
    };
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
      this.$http.get('/shougao/' + (this.flag === 'zuozhe' ? 'page' : 'list'), {params})
          .then(response => {
            this.data = response.data.data.list;
            this.total = response.data.data.total
          })
          .catch(error => {
            console.error(error);
          });
    },
    download(row) {
      window.open(row.gaojian)
    },
    handleDetail(row) {
      this.form = Object.assign({}, row);
      this.isEdit = false;
      this.dialogVisible = true;
    },
    handleEdit(row) {
      this.form = Object.assign({}, row);
      this.isEdit = true;
      this.dialogVisible = true;
    },
    saveEdit() {
      this.$http.post('/shougao/update', this.form)
          .then(response => {
            this.dialogVisible = false;
            this.fetchData();
          })
          .catch(error => {
            console.error(error);
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

    handleDelete(row) {
      this.$confirm('此操作将永久删除该稿件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('/shougao/delete', [row.id])
            .then(response => {
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              this.fetchData();
            })
            .catch(error => {
              console.error(error);
            });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    gaojianluyong(row) {
      this.$http.post(`/shougao/luyong/${row.id}`).then(response => {
        if (response.data.code === 0) {
          this.$message.success('稿件录用成功');
          this.fetchData()
        } else {
          this.$message.error(response.data.msg);
        }
      }).catch(error => {
        console.error(error);
        this.$message.error('稿件录用失败');
      });
    },
    gaigaotongzhi() {
      this.$http.post('/shougao/gaigaotongzhi/'+this.tongzhiForm.id, {
        gaigaoneirong: this.tongzhiForm.gaigaoneirong,
      }).then(response => {
        if (response.data.code === 0) {
          this.$message.success('改稿通知发送成功');
          this.tongzhiVisible = false
          this.fetchData()
        } else {
          this.$message.error(response.data.msg);
        }
      }).catch(error => {
        console.error(error);
        this.$message.error('改稿通知发送失败');
      });
    },
    // 审核方法
    shenhe() {
      if (!this.shenheForm.id || !this.shenheForm.shhf) {
        this.$message.error('请填写收稿ID和审核回复');
        return;
      }
      this.$http.post('/shougao/shenhe/'+this.shenheForm.id, this.shenheForm)
          .then(response => {
            if (response.data.code === 0) {
              this.$message.success('审核成功');
              this.fetchData()
              this.shenheVisible = false
            } else {
              this.$message.error(response.data.msg || '审核失败');
            }
          })
          .catch(error => {
            console.error('审核错误:', error);
            this.$message.error('审核错误');
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
