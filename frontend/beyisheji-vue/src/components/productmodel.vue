<template>
  <a-layout>
    <a-layout-sider width="300" style="background: #fff">
      <a-tree :tree-data="treeData">
        <template v-slot:custom="item">
          <span>{{ item.pname }}</span>
        </template>
      </a-tree>
    </a-layout-sider>
    <a-layout style="padding: 0 24px 24px">
      <a-layout-content
        :style="{
          background: '#fff',
          padding: '24px',
          margin: '20px',
          minHeight: '280px',
        }"
      >
        <el-table
          :data="
            tableData.filter(
              (data) =>
                !search ||
                data.name.toLowerCase().includes(search.toLowerCase())
            )
          "
          style="width: 100%"
          row-key="pnum"
        >
          <el-table-column label="编号" prop="pnum"> </el-table-column>
          <el-table-column label="名称" prop="pname"> </el-table-column>
          <el-table-column label="模型" prop="model"> </el-table-column>
          <el-table-column label="数量" prop="count"> </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >Delete</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
// const treeData = [
//   {
//     pname: "0-0",
//     pnum: 1,
//     model: "***",
//     count: 10,
//     scopedSlots: { title: "custom" },
//     children: [
//       {
//         pname: "0-0-0",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//         children: [
//           {
//             pname: "0-0-0-0",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//           {
//             pname: "0-0-0-1",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//           {
//             pname: "0-0-0-2",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//         ],
//       },
//       {
//         pname: "0-0-1",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//         children: [
//           {
//             pname: "0-0-1-0",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//           {
//             pname: "0-0-1-1",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//           {
//             pname: "0-0-1-2",
//             pnum: 1,
//             model: "***",
//             count: 10,
//             scopedSlots: { title: "custom" },
//           },
//         ],
//       },
//       {
//         pname: "0-0-2",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//       },
//     ],
//   },
//   {
//     pname: "0-1",
//     pnum: 1,
//     model: "***",
//     count: 10,
//     scopedSlots: { title: "custom" },
//     children: [
//       {
//         pname: "0-1-0-0",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//       },
//       {
//         pname: "0-1-0-1",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//       },
//       {
//         pname: "0-1-0-2",
//         pnum: 1,
//         model: "***",
//         count: 10,
//         scopedSlots: { title: "custom" },
//       },
//     ],
//   },
//   {
//     pname: "0-2",
//     pnum: 1,
//     model: "***",
//     count: 10,
//     scopedSlots: { title: "custom" },
//   },
// ];
export default {
  name: "productmodel",
  data() {
    return {
      treeData: [],
      tableData: [],
      search: "",
    };
  },
  methods: {
    searchOption(option, arr1, arr2) {
      for (let s = 0; s < arr1.length; s++) {
        if (arr1[s].pnum === option.pnum) {
          arr1.splice(s, 1)[0];
          arr2.splice(s, 1)[0];
          break;
        } else if (arr1[s].children && arr1[s].children.length > 0) {
          // 递归条件
          this.searchOption(option, arr1[s].children, arr2[s].children);
        } else {
          continue;
        }
      }
    },
    dfsdata(data, idlist) {
      if (!data) {
        return;
      }
      idlist.push(data.pnum);
      if (data.children && data.children.length > 0) {
        for (let i = 0; i < data.children.length; i++) {
          this.dfsdata(data.children[i], idlist);
        }
      }
    },
    handleDelete(index, row) {
      // console.log(index, row);
      this.searchOption(row, this.treeData, this.tableData);
      let idlist = [];
      this.dfsdata(row, idlist);
      // console.log(idlist);
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/deleteproductmodellists",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        data: JSON.stringify(idlist),
      })
        .then((result) => {
          console.log(result);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  mounted() {
    function deep(data) {
      for (var key in data) {
        if (typeof data[key] == "object") {
          data.scopedSlots = { title: "custom" };
          deep(data[key]);
        }
      }
    }
    this.axios
      .get("http://localhost:8081/selectallproductmodelchildren")
      .then((result) => {
        deep(result.data);
        this.treeData = result.data.children;
        this.tableData = result.data.children;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
<style scoped>
</style>