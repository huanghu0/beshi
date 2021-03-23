<template>
  <a-layout id="components-layout-demo-top-side">
    <a-layout-content>
      <a-layout style="background: #fff">
        <a-layout-sider width="200" style="background: #fff">
          <a-menu
            mode="inline"
            :default-selected-keys="['1']"
            :default-open-keys="['sub1']"
            style="height: 100%"
          >
            <a-sub-menu key="sub1" title="火车">
              <a-sub-menu key="sub2" title="火车头">
                <a-menu-item key="1"> 型号1 </a-menu-item>
                <a-menu-item key="2"> 型号2 </a-menu-item>
              </a-sub-menu>
              <a-sub-menu key="sub3" title="火车箱">
                <a-menu-item key="3"> 型号1 </a-menu-item>
                <a-menu-item key="4"> 型号2 </a-menu-item>
              </a-sub-menu>
            </a-sub-menu>
          </a-menu>
        </a-layout-sider>
        <a-layout-content :style="{ padding: '0 12px', minHeight: '280px' }">
          <!-- <a-table :columns="columns" :data-source="data" :pagination="false">
            <a slot="name" slot-scope="text">{{ text }}</a>
          </a-table> -->
          <el-table
            :data="tableData"
            style="width: 100%; margin-bottom: 20px"
            row-key="id"
            border
            default-expand-all
            :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
          >
            <el-table-column prop="productnodenumber" label="产品节点编号">
            </el-table-column>
            <el-table-column prop="productnumber" label="产品编号">
            </el-table-column>
            <el-table-column prop="parentnodenumber" label="父节点编号">
            </el-table-column>
            <el-table-column prop="productnodename" label="产品节点名称">
            </el-table-column>
            <el-table-column prop="lft" label="左值"> </el-table-column>
            <el-table-column prop="rht" label="右值"> </el-table-column>
          </el-table>
        </a-layout-content>
      </a-layout>
    </a-layout-content>
  </a-layout>
</template>
<script>
export default {
  name: "treeTableShow",
  data() {
    return {
      tableData: [
        {
          id: 1,
          productnodenumber: "HC0001",
          productnumber: "HC0001",
          parentnodenumber: "",
          productnodename: "火车",
          lft: 1,
          rht: 6,
          children: [
            {
              id: 11,
              productnodenumber: "HC000101",
              productnumber: "HC0001",
              parentnodenumber: "HC0001",
              productnodename: "火车头",
              lft: 2,
              rht: 3,
            },
            {
              id: 12,
              productnodenumber: "HC000102",
              productnumber: "HC0001",
              parentnodenumber: "HC0001",
              productnodename: "火车箱",
              lft: 4,
              rht: 5,
            },
          ],
        },
        {
          id: 2,
          productnodenumber: "LC0001",
          productnumber: "LC0001",
          parentnodenumber: "",
          productnodename: "轮船",
          lft: 1,
          rht: 2,
        },
      ],
    };
  },
};
</script>
<style  scoped>
.ant-table-wrapper {
  width: 1188px;
}
.ant-pagination.ant-table-pagination {
  margin-right: 20px;
}
</style>
