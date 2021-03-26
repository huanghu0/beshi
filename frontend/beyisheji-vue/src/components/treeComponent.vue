<template>
  <div class="page-header-index-wide">
    <a-card :bordered="true">
      <a-button type="primary">添加顶级菜单</a-button>
      <a-tree :treeData="treeData">
        <template v-slot:custom="item">
          <span v-if="isAddNode">
            <a-form-model layout="inline">
              <a-form-model-item label="产品节点编号">
                <a-input />
              </a-form-model-item>
              <a-form-model-item label="产品模板编号">
                <a-input />
              </a-form-model-item>
              <a-form-model-item label="父节点编号">
                <a-input />
              </a-form-model-item>
              <a-form-model-item label="产品节点名称">
                <a-input />
              </a-form-model-item>
              <a-form-model-item>
                <a-button type="primary" @click="makeSure(item)">
                  确定
                </a-button>
              </a-form-model-item>
            </a-form-model>
          </span>
          <span v-else>
            <span style="margin: 0 40px 0 0">{{ item.title }}</span>
            <span class="icon-wrap" style="margin: 0 20px 0 0">
              <a-icon type="delete" theme="twoTone" />
            </span>
            <span class="icon-wrap" style="margin: 0 20px 0 0">
              <a-icon type="edit" theme="twoTone" />
            </span>
            <span
              class="icon-wrap"
              style="margin: 0 20px 0 0"
              @click="addnode(item)"
            >
              <a-icon type="plus-circle" theme="twoTone" />
            </span>
          </span>
        </template>
      </a-tree>
    </a-card>
  </div>
</template>

<script>
const treeData = [
  {
    title: "0-0",
    key: "0-0",
    scopedSlots: { title: "custom" },
    children: [
      {
        title: "0-0-0",
        key: "0-0-0",
        scopedSlots: { title: "custom" },
        children: [
          {
            title: "0-0-0-0",
            key: "0-0-0-0",
            scopedSlots: { title: "custom" },
          },
          {
            title: "0-0-0-1",
            key: "0-0-0-1",
            scopedSlots: { title: "custom" },
          },
          {
            title: "0-0-0-2",
            key: "0-0-0-2",
            scopedSlots: { title: "custom" },
          },
        ],
      },
      {
        title: "0-0-1",
        key: "0-0-1",
        scopedSlots: { title: "custom" },
        children: [
          {
            title: "0-0-1-0",
            key: "0-0-1-0",
            scopedSlots: { title: "custom" },
          },
          {
            title: "0-0-1-1",
            key: "0-0-1-1",
            scopedSlots: { title: "custom" },
          },
          {
            title: "0-0-1-2",
            key: "0-0-1-2",
            scopedSlots: { title: "custom" },
          },
        ],
      },
      {
        title: "0-0-2",
        key: "0-0-2",
        scopedSlots: { title: "custom" },
      },
    ],
  },
  {
    title: "0-1",
    key: "0-1",
    scopedSlots: { title: "custom" },
    children: [
      { title: "0-1-0-0", key: "0-1-0-0", scopedSlots: { title: "custom" } },
      { title: "0-1-0-1", key: "0-1-0-1", scopedSlots: { title: "custom" } },
      { title: "0-1-0-2", key: "0-1-0-2", scopedSlots: { title: "custom" } },
    ],
  },
  {
    title: "0-2",
    key: "0-2",
    scopedSlots: { title: "custom" },
  },
];

export default {
  name: "treeComponent",
  data() {
    return {
      treeData,
      isAddNode: false,
    };
  },
  methods: {
    // // 递归查找
    // searchOption(option, arr, type = "delect") {
    //   console.log(option, arr);
    //   for (let s = 0; s < arr.length; s++) {
    //     console.log(arr[s].key, option.key);
    //     if (arr[s].key === option.key) {
    //       if (type === "delect") {
    //         arr.splice(s, 1);
    //       } else {
    //         //这是模拟数据编辑数据
    //         this.$set(arr, s, {
    //           title: "12121212",
    //           key: "12121212",
    //           scopedSlots: { title: "custom" },
    //         });
    //       }
    //       break;
    //     } else if (arr[s].children && arr[s].children.length > 0) {
    //       // 递归条件
    //       this.searchOption(option, arr[s].children);
    //     } else {
    //       continue;
    //     }
    //   }
    // },
    // append(data) {
    //   //模拟添加
    //   const newChild = {
    //     title: "ceshi1",
    //     key: "ceshi1",
    //     scopedSlots: { title: "custom" },
    //     children: [],
    //   };
    //   if (!data.children) {
    //     this.$set(data, "children", []);
    //   }
    //   data.children.push(newChild);
    // },
    // remove(data) {
    //   //先请求后端接口，删除成功后执行
    //   this.searchOption(data, this.treeData);
    // },
    // edit(data) {
    //   //先请求后端接口，编辑成功后执行
    //   this.searchOption(data, this.treeData, "edit");
    // },
    addnode(data) {
      this.isAddNode = true;
    },
    makeSure(data) {
      this.isAddNode = false;
    },
  },
};
</script>
<style scoped>
</style>
