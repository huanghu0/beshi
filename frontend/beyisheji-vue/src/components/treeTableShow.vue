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
          <a-table :columns="columns" :data-source="data" :pagination="false">
            <a slot="name" slot-scope="text">{{ text }}</a>
          </a-table>
        </a-layout-content>
      </a-layout>
    </a-layout-content>
  </a-layout>
</template>
<script>
const columns = [
  {
    title: "节点编号",
    dataIndex: "productnodenumber",
    key: "productnodenumber",
    ellipsis: true,
  },
  {
    title: "产品编号",
    dataIndex: "productnumber",
    key: "productnumber",
    ellipsis: true,
  },
  {
    title: "父节点编号",
    dataIndex: "parentnodenumber",
    key: "parentnodenumber",
    ellipsis: true,
  },
  {
    title: "节点名称",
    dataIndex: "productnodename",
    key: "productnodename",
    ellipsis: true,
  },
  {
    title: "节点左值",
    dataIndex: "lft",
    key: "lft",
    ellipsis: true,
  },
  {
    title: "节点右值",
    dataIndex: "rht",
    key: "rht",
    ellipsis: true,
  },
];

const data = [
  {
    key: "1",
    productnodenumber: "HC0001",
    productnumber: "HC0001",
    parentnodenumber: null,
    productnodename: "火车",
    lft: 1,
    rht: 4,
  },
  {
    key: "2",
    productnodenumber: "HC000101",
    productnumber: "HC0001",
    parentnodenumber: "HC0001",
    productnodename: "火车头",
    lft: 2,
    rht: 3,
  },
];
export default {
  name: "treeTableShow",
  data() {
    return {
      data,
      columns,
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
