<template>
  <div class="treeTableShow">
    <a-layout id="components-layout-demo-top-side">
      <a-layout-content>
        <a-layout style="background: #fff">
          <a-layout-sider :width="width" :style="{ background: '#fff' }">
            <div class="page-header-index-wide">
              <a-card :bordered="true">
                <a-button
                  type="primary"
                  style="margin: 0 20px 0 0"
                  @click="addProduct()"
                  >添加产品</a-button
                >
                <a-button type="primary">粘贴产品节点</a-button>
                <a-tree :treeData="treeData">
                  <template v-slot:custom="item">
                    <a-card
                      :bordered="true"
                      v-if="item.isAddNode"
                      :style="{ zIndex: 1 }"
                      :hoverable="true"
                    >
                      <a-form-model-item
                        layout="inline"
                        :style="{ width: '500px' }"
                      >
                        <a-form-model-item label="产品节点编号">
                          <a-input class="productnodenumber" />
                        </a-form-model-item>
                        <a-form-model-item label="产品节点名称">
                          <a-input class="productnodename" />
                        </a-form-model-item>
                        <a-form-model-item :style="{ display: 'block' }">
                          <a-button
                            type="primary"
                            @click="makeSure(item)"
                            style="margin: 0 20px 0 0"
                          >
                            添加
                          </a-button>
                          <a-button type="primary" @click="cancle(item)">
                            取消
                          </a-button>
                        </a-form-model-item>
                      </a-form-model-item>
                    </a-card>
                    <a-card
                      :bordered="true"
                      v-else-if="item.isEditNode"
                      :style="{ zIndex: 1 }"
                      :hoverable="true"
                    >
                      <a-form-model-item
                        layout="inline"
                        :style="{ width: '300px' }"
                      >
                        <a-form-model-item label="产品节点名称">
                          <a-input class="editproductnodename" />
                        </a-form-model-item>
                        <a-form-model-item :style="{ display: 'block' }">
                          <a-button
                            type="primary"
                            @click="makeEdit(item)"
                            style="margin: 0 20px 0 0"
                          >
                            编辑
                          </a-button>
                          <a-button type="primary" @click="cancle(item)">
                            取消
                          </a-button>
                        </a-form-model-item>
                      </a-form-model-item>
                    </a-card>
                    <span v-else>
                      <span style="margin: 0 20px 0 0">{{
                        item.productnodename
                      }}</span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        @click="deletenode(item)"
                      >
                        <a-icon type="delete" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        @click="editnode(item)"
                      >
                        <a-icon type="edit" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        @click="addnode(item)"
                      >
                        <a-icon type="plus-circle" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="复制子树"
                      >
                        <a-icon type="copy" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="复制节点"
                      >
                        <a-icon type="copyright" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="粘贴"
                      >
                        <a-icon type="diff" theme="twoTone" />
                      </span>
                    </span>
                  </template>
                </a-tree>
              </a-card>
            </div>
          </a-layout-sider>
          <a-layout-content :style="{ padding: '0 12px', minHeight: '280px' }">
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
    <a-card :bordered="true" :style="{ zIndex: 1 }" v-if="isAddProduct">
      <a-form-model-item layout="inline">
        <a-form-model-item label="产品编号">
          <a-input class="productnumber" />
        </a-form-model-item>
        <a-form-model-item label="产品名称">
          <a-input class="productname" />
        </a-form-model-item>
        <a-form-model-item :style="{ display: 'block', width: '500px' }">
          <a-button type="primary" @click="Commit()" style="margin: 0 20px 0 0">
            新增产品
          </a-button>
          <a-button type="primary" @click="cancleProduct()">取消</a-button>
        </a-form-model-item>
      </a-form-model-item>
    </a-card>
  </div>
</template>
<script>
const treeData = [
  {
    // key: "0-0",
    id: 1,
    productnodenumber: "HC0001",
    productnumber: "HC0001",
    parentnodenumber: "",
    productnodename: "火车",
    scopedSlots: { title: "custom" },
    isAddNode: false,
    isEditNode: false,
    children: [
      {
        key: "0-0-0",
        productnodenumber: "HC000101",
        productnumber: "HC0001",
        parentnodenumber: "HC0001",
        productnodename: "火车头",
        scopedSlots: { title: "custom" },
        isAddNode: false,
        isEditNode: false,
      },
      {
        key: "0-0-1",
        productnodenumber: "HC000102",
        productnumber: "HC0001",
        parentnodenumber: "HC0001",
        productnodename: "火车箱",
        scopedSlots: { title: "custom" },
        isAddNode: false,
        isEditNode: false,
      },
    ],
  },
  {
    // key: "0-1",
    id: 1,
    productnodenumber: "LC0001",
    productnumber: "LC0001",
    parentnodenumber: "",
    productnodename: "轮船",
    scopedSlots: { title: "custom" },
    isAddNode: false,
    isEditNode: false,
  },
];
const tableData = [
  {
    id: 13,
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
    id: 22,
    productnodenumber: "LC0001",
    productnumber: "LC0001",
    parentnodenumber: "",
    productnodename: "轮船",
    lft: 1,
    rht: 2,
  },
];
export default {
  name: "treeTableShow",
  data() {
    return {
      tableData: tableData,
      treeData: treeData,
      isAddProduct: false,
      width: 300,
    };
  },
  watch: {},
  methods: {
    // 递归查找
    searchOption(option, arr, obj) {
      console.log(option, arr);
      for (let s = 0; s < arr.length; s++) {
        console.log(arr[s].key, option.key);
        if (arr[s].key === option.key) {
          if (obj.type === "delete") {
            arr.splice(s, 1);
          } else if (obj.type === "add") {
            if (!arr[s].children) {
              this.$set(arr[s], "children", []);
            }
            arr[s].children.push(obj.newNode);
          } else {
            arr[s].productnodename = obj.productnodename;
          }
          break;
        } else if (arr[s].children && arr[s].children.length > 0) {
          // 递归条件
          this.searchOption(option, arr[s].children, obj);
        } else {
          continue;
        }
      }
    },
    editnode(data) {
      data.isEditNode = true;
      data.dataRef.isEditNode = true;
    },
    makeEdit(data) {
      let productnodename = document.querySelector(".editproductnodename")
        .value;
      let obj = {
        type: "edit",
        productnodename,
      };
      this.searchOption(data, this.treeData, obj);
      data.isEditNode = false;
      data.dataRef.isEditNode = false;
    },
    addnode(data) {
      console.log(data);
      data.isAddNode = true;
      data.dataRef.isAddNode = true;
    },
    makeSure(data) {
      console.log(data);
      let productnodenumber = document.querySelector(".productnodenumber")
          .value,
        productnumber = data.productnumber,
        parentnodenumber = data.productnodenumber,
        productnodename = document.querySelector(".productnodename").value;
      // if (!data.dataRef.children) {
      //   this.$set(data.dataRef, "children", []);
      // }

      let key = data.key + "-";
      if (!data.children) {
        key += "0";
      } else {
        let lastIndex = data.children.length - 1;
        let lastIndexkey = data.children[lastIndex].key.split("-").pop();
        key += parseInt(lastIndexkey) + 1;
      }
      let newNode = {
        key,
        productnodenumber,
        productnumber,
        parentnodenumber,
        productnodename,
        isAddNode: false,
        isEditNode: false,
        scopedSlots: { title: "custom" },
      };
      let obj = {
        type: "add",
        newNode,
      };
      // data.dataRef.children.push(newNode);
      this.searchOption(data, this.treeData, obj);
      data.dataRef.isAddNode = false;
      data.isAddNode = false;
    },
    addProduct() {
      this.isAddProduct = true;
    },
    Commit() {
      let productnumber = document.querySelector(".productnumber").value,
        productname = document.querySelector(".productname").value;
      if (this.treeData === null) {
        this.treeData = [];
      }
      let key = "0-" + this.treeData.length;
      let newProdct = {
        key,
        productnodenumber: productnumber,
        productnumber,
        parentnodenumber: "",
        productnodename: productname,
        scopedSlots: { title: "custom" },
        isShow: false,
      };
      this.treeData.push(newProdct);
      this.isAddProduct = false;
    },
    deletenode(data) {
      console.log(data);
      let obj = {
        type: "delete",
      };
      this.searchOption(data, this.treeData, obj);
    },
    cancle(data) {
      data.isAddNode = false;
      data.dataRef.isAddNode = false;
      data.isEditNode = false;
      data.dataRef.isEditNode = false;
    },
    cancleProduct() {
      this.isAddProduct = false;
    },
  },
};
</script>
<style  scoped>
.ant-table-wrapper {
  width: 1188px;
}
.ant-form-item {
  display: inline-block;
  margin: 10px;
}
</style>
