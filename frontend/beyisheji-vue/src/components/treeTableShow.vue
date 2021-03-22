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
          <a-table :columns="columns" :data-source="data">
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
    title: "Name",
    dataIndex: "name",
    key: "name",
    scopedSlots: { customRender: "name" },
  },
  {
    title: "Age",
    dataIndex: "age",
    key: "age",
    width: 80,
  },
  {
    title: "Address",
    dataIndex: "address",
    key: "address 1",
    ellipsis: true,
  },
  {
    title: "Long Column Long Column Long Column",
    dataIndex: "address",
    key: "address 2",
    ellipsis: true,
  },
  {
    title: "Long Column Long Column",
    dataIndex: "address",
    key: "address 3",
    ellipsis: true,
  },
  {
    title: "Long Column",
    dataIndex: "address",
    key: "address 4",
    ellipsis: true,
  },
];

const data = [
  {
    key: "1",
    name: "John Brown",
    age: 32,
    address: "New York No. 1 Lake Park, New York No. 1 Lake Park",
    tags: ["nice", "developer"],
  },
  {
    key: "2",
    name: "Jim Green",
    age: 42,
    address: "London No. 2 Lake Park, London No. 2 Lake Park",
    tags: ["loser"],
  },
  {
    key: "3",
    name: "Joe Black",
    age: 32,
    address: "Sidney No. 1 Lake Park, Sidney No. 1 Lake Park",
    tags: ["cool", "teacher"],
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
