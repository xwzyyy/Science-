<template>
  <div>


    <div >
      <!-- 搜索表单 -->
      <el-form :inline="true" :model="searchForm" class="demo-form-inline" label-width="100px">
        <el-form-item label="稿件编号">
          <el-input v-model="searchForm.gaojianbianhao"></el-input>
        </el-form-item>
        <el-form-item label="稿件标题">
          <el-input v-model="searchForm.gaojianbiaoti"></el-input>
        </el-form-item>
        <el-form-item label="是否审核">
          <el-input v-model="searchForm.sfsh"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleSearch">查询</el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
        <el-button v-if="flag === 'zuozhe'" type="primary" @click="shangchuan">上传稿件</el-button>
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
        <el-table-column prop="sfsh" label="是否审核" width="100"></el-table-column>
        <el-table-column prop="shhf" label="审核回复" width="100"></el-table-column>
        <el-table-column label="操作" fixed="right" width="300">
          <template slot-scope="scope">
            <el-button size="mini" type="primary"  v-if="flag === 'zuozhe'"  @click="handleEdit(scope.row)">修改</el-button>
            <el-button size="mini" type="primary" v-if="flag === 'shengaoren'"  @click="shougaoFun(scope.row)"> 收稿</el-button>
            <el-button size="mini" type="primary"  v-if="flag === 'shengaoren'" @click="shenheVisible = true; shenheForm.id = scope.row.id">审核</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
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
          <el-form-item label="稿件">
            <file-upload
                tip="点击上传稿件"
                action="/file/upload"
                :limit="1"
                :multiple="false"
                :fileUrls="form.gaojian ? form.gaojian : ''"
                @change="gaojianUploadChange"
            ></file-upload>
          </el-form-item>
          <el-form-item label="上传时间" prop="shangchuanshijian">
            <el-input v-model="form.shangchuanshijian" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="收稿时间" prop="shougaoshijian">
            <el-input v-model="form.shougaoshijian" :disabled="true"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button v-if="isEdit" type="primary" @click="saveEdit">保存</el-button>
      </span>
      </el-dialog>
      <el-dialog title="上传" :visible.sync="formVisible">
        <el-form  :model="form" label-width="120px">
        <el-form-item label="稿件编号">
          <el-input v-model="form.gaojianbianhao"></el-input>
        </el-form-item>
        <el-form-item label="稿件标题">
          <el-input v-model="form.gaojianbiaoti"></el-input>
        </el-form-item>
        <el-form-item label="稿件类型">
          <el-select v-model="form.gaojianleixing" placeholder="请选择稿件类型">
            <el-option
                v-for="item in gaojianleixingOptions"
                :key="item.id"
                :label="item.gaojianleixing"
                :value="item.gaojianleixing"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="作者账号">
          <el-input disabled v-model="form.zuozhezhanghao"></el-input>
        </el-form-item>
        <el-form-item label="作者姓名">
          <el-input disabled v-model="form.zuozhexingming"></el-input>
        </el-form-item>
        <el-form-item label="作者手机">
          <el-input disabled v-model="form.zuozheshouji"></el-input>
        </el-form-item>
        <el-form-item label="稿件">
          <file-upload
              tip="点击上传稿件"
              action="/file/upload"
              :limit="1"
              :multiple="false"
              :fileUrls="form.gaojian ? form.gaojian : ''"
              @change="gaojianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item label="上传时间">
          <el-input v-model="form.shangchuanshijian" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
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
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      shenheForm: {},
      ruleForm: {},
      form: {
        id: '',
        gaojianbianhao: '',
        gaojianbiaoti: '',
        gaojianleixing: '',
        zuozhezhanghao: '',
        zuozhexingming: '',
        zuozheshouji: '',
        gaojian: '',
        shangchuanshijian: '',
        sfsh: false,
        shhf: ''
      },
      gaojianleixingOptions: [],
      flag: '',
      data: [], // 表格数据
      searchForm: {
      },
      dialogVisible: false,
      formVisible: false,
      shenheVisible: false,
      isEdit: false,
      currentPage: 1,
      pageSize: 10,
      total: 0
    };
  },
  created() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.fetchGaojianleixingOptions();
    this.fetchData()
    this.form.shangchuanshijian = new Date().toISOString().slice(0, 19).replace('T', ' '); // 初始化上传时间
  },
  methods: {
    shangchuan(){
      this.form.zuozheshouji = this.ruleForm.zuozheshouji
      this.form.zuozhexingming = this.ruleForm.zuozhexingming
      this.form.zuozhezhanghao = this.ruleForm.zuozhezhanghao
      this.formVisible = true;
    },
    fetchGaojianleixingOptions() {
      this.$http.get('/gaojianleixing/list')
          .then(response => {
            this.gaojianleixingOptions = response.data.data.list;
          })
          .catch(error => {
            console.error('Failed to fetch gaojianleixing options:', error);
          });
    },
    gaojianUploadChange(fileUrls) {
      console.log('fileUrls',fileUrls)
      this.form.gaojian = fileUrls;
    },
    submitForm() {
      this.$http.post('/shangchuangaojian/add', this.form)
          .then(response => {
            this.$message.success('稿件上传成功');
            this.resetForm();
            this.formVisible = false
            this.fetchData()
          })
          .catch(error => {
            console.error('Failed to upload gaojian:', error);
            this.$message.error('稿件上传失败');
          });
    },
    resetForm() {
      this.form = {
        gaojianbianhao: '',
        gaojianbiaoti: '',
        gaojianleixing: '',
        zuozhezhanghao: '',
        zuozhexingming: '',
        zuozheshouji: '',
        gaojian: '',
        shangchuanshijian: new Date().toISOString().slice(0, 19).replace('T', ' '),
        sfsh: false,
        shhf: ''
      };
    },
    fetchData() {
      for (const searchFormKey in this.searchForm) {
        if (!this.searchForm[searchFormKey]) delete this.searchForm[searchFormKey]
      }
      const params = {
        page: this.currentPage,
        limit: this.pageSize,
        ...this.searchForm
      };
      this.$http.get('/shangchuangaojian/' + (this.flag === 'zuozhe' ? 'page' : 'list'), {params})
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
      this.$http.post('/shangchuangaojian/update', this.form)
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
        this.$http.post('/shangchuangaojian/delete', [row.id])
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
    // 审核方法
    shenhe() {
      if (!this.shenheForm.id || !this.shenheForm.shhf) {
        this.$message.error('请填写收稿ID和审核回复');
        return;
      }
      this.$http.post('/shangchuangaojian/shenhe/'+this.shenheForm.id, this.shenheForm)
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
    shougaoFun(row) {
      this.shenheForm.id = row.id
      this.$confirm('是否收稿', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('/shangchuangaojian/shougao/'+this.shenheForm.id)
            .then(response => {
              if (response.data.code === 0) {
                this.$message.success('收稿成功');
                this.fetchData()
              } else {
                this.$message.error(response.data.msg || '收稿失败');
              }
            })
            .catch(error => {
              console.error('收稿错误:', error);
              this.$message.error('收稿错误');
            });
        });
    },
  }
};
</script>

<style scoped>
</style>
