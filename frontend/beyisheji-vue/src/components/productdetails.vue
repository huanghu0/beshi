<template>
  <div class="productdetails">
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="产品编号:">
              <span>{{ props.row.pnum }}</span>
            </el-form-item>
            <el-form-item label="产品名称:">
              <span>{{ props.row.pname }}</span>
            </el-form-item>
            <el-form-item label="模型:">
              <span>{{ props.row.model }}</span>
            </el-form-item>
            <el-form-item label="属性详情:">
              <span>{{ props.row.details }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="产品编号" prop="pnum"> </el-table-column>
      <el-table-column label="产品名称" prop="pname"> </el-table-column>
      <el-table-column label="模型" prop="model"> </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pagesize"
      :total="total"
      :current-page="currentpage"
      @prev-click="handelPrev"
      @next-click="handelNext"
    >
    </el-pagination>
  </div>
</template>
<script>
export default {
  name: "productdetails",
  data() {
    return {
      tableData: [],
      totalData: [],
      pagesize: 5,
      total: null,
      currentpage: 1,
    };
  },
  methods: {
    handelPrev() {
      if (this.currentpage !== 1) {
        this.currentpage -= 1;
      }
      this.tableData = this.totalData.slice(
        this.pagesize * this.currentpage - this.pagesize,
        this.pagesize * this.currentpage
      );
    },
    handelNext() {
      if (this.currentpage < Math.ceil(this.total / this.pagesize)) {
        this.currentpage += 1;
      }
      if (this.currentpage === Math.ceil(this.total / this.pagesize)) {
        this.tableData = this.totalData.slice(
          this.pagesize * this.currentpage - this.pagesize
        );
      }
      this.tableData = this.totalData.slice(
        this.pagesize * this.currentpage - this.pagesize,
        this.pagesize * this.currentpage
      );
    },
  },
  mounted() {
    this.axios
      .get("http://localhost:8081/selectallproductinstancelist")
      .then((result) => {
        this.totalData = result.data;
        this.total = result.data.length;
        this.tableData = result.data.slice(0, this.pagesize);
        //console.log(this.total);
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>