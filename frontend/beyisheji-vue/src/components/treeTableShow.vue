<template>
  <div class="treeTableShow" :style="{ position: 'relative' }">
    <a-layout id="components-layout-demo-top-side">
      <a-layout-content>
        <a-layout style="background: #fff">
          <a-layout-sider
            :style="{
              background: '#fff',
              display: 'inline-block',
              minWidth: '400px',
            }"
          >
            <div class="page-header-index-wide">
              <a-card :bordered="true">
                <a-button
                  type="primary"
                  style="margin: 0 20px 0 0"
                  @click="addProduct()"
                  >添加产品</a-button
                >
                <a-button type="primary" @click="pasteproduct()"
                  >粘贴产品节点</a-button
                >
                <a-tree :treeData="treeData" @select="onSelect">
                  <template v-slot:custom="item">
                    <a-card
                      :bordered="true"
                      v-if="item.isAddNode"
                      :style="{ zIndex: 1 }"
                      :hoverable="true"
                    >
                      <a-form-model-item
                        layout="inline"
                        :style="{ width: '800px' }"
                      >
                        <a-form-model-item label="产品名称">
                          <a-input class="pnameaddnode" />
                        </a-form-model-item>
                        <a-form-model-item label="产品模型">
                          <a-input class="modeladdnode" />
                        </a-form-model-item>
                        <a-form-model-item label="所需数量">
                          <a-input class="countaddnode" />
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
                        :style="{ width: '800px' }"
                      >
                        <a-form-model-item label="产品名称">
                          <a-input class="pnameeditnode" />
                        </a-form-model-item>
                        <a-form-model-item label="产品模型">
                          <a-input class="modeleditnode" />
                        </a-form-model-item>
                        <a-form-model-item label="所需数量">
                          <a-input class="counteditnode" />
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
                      <span style="margin: 0 20px 0 0">{{ item.pname }}</span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="删除子节点"
                        @click="deletenode(item)"
                      >
                        <a-icon type="delete" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="编辑子节点"
                        @click="editnode(item)"
                      >
                        <a-icon type="edit" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="添加子节点"
                        @click="addnode(item)"
                      >
                        <a-icon type="plus-circle" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="复制子树"
                        @click="copytree(item)"
                      >
                        <a-icon type="copy" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="复制节点"
                        @click="copynode(item)"
                      >
                        <a-icon type="copyright" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="粘贴"
                        @click="pastetree(item)"
                      >
                        <a-icon type="diff" theme="twoTone" />
                      </span>
                      <span
                        class="icon-wrap"
                        style="margin: 0 10px 0 0"
                        title="添加到产品模板"
                        @click="addtoproductmodel(item)"
                      >
                        <a-icon type="right-circle" theme="twoTone" />
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
              row-key="pid"
              border
              default-expand-all
              :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
            >
              <el-table-column prop="pid" label="产品id"> </el-table-column>
              <el-table-column prop="parentid" label="父节点id">
              </el-table-column>
              <el-table-column prop="pname" label="产品名称"> </el-table-column>
              <el-table-column prop="model" label="产品型号"> </el-table-column>
              <el-table-column prop="count" label="所需数量"> </el-table-column>
              <el-table-column
                prop="originid"
                label="产品来源id"
              ></el-table-column>
            </el-table>
          </a-layout-content>
        </a-layout>
      </a-layout-content>
    </a-layout>
    <a-card
      :bordered="true"
      :style="{ zIndex: 1, position: 'absolute', top: '0px', left: '200px' }"
      v-if="isAddProduct"
    >
      <a-form-model-item layout="inline">
        <a-form-model-item label="产品名称">
          <a-input class="pnameaddproduct" />
        </a-form-model-item>
        <a-form-model-item label="产品模型">
          <a-input class="modeladdproduct" />
        </a-form-model-item>
        <a-form-model-item label="所需数量">
          <a-input class="countaddproduct" />
        </a-form-model-item>

        <a-form-model-item :style="{ display: 'block', width: '500px' }">
          <a-button type="primary" @click="Commit()" style="margin: 0 20px 0 0">
            添加产品
          </a-button>
          <a-button type="primary" @click="cancleProduct()">取消</a-button>
        </a-form-model-item>
      </a-form-model-item>
    </a-card>
  </div>
</template>
<script>
export default {
  name: "treeTableShow",
  data() {
    return {
      tableData: [],
      treeData: [],
      isAddProduct: false,
      deledata: [],
      copydata: {},
    };
  },
  watch: {},
  methods: {
    //验证输入的字符串是否是数字
    checkNumber(theObj) {
      var reg = /^[0-9]+.?[0-9]*$/;
      if (reg.test(theObj)) {
        return true;
      }
      return false;
    },
    // 递归查找
    searchOption(option, arr, obj) {
      //console.log(option, arr);
      for (let s = 0; s < arr.length; s++) {
        if (arr[s].pid === option.pid) {
          if (obj.type === "delete") {
            this.deledata = arr.splice(s, 1)[0];
          } else if (obj.type === "add") {
            if (!arr[s].children) {
              this.$set(arr[s], "children", []);
            }
            arr[s].children.push(obj.newNode);
          } else if (obj.type === "copytree") {
            this.copydata = arr[s];
            this.copydata.originid = arr[s].parentid;
          } else if (obj.type === "copy") {
            this.copydata = {
              pid: arr[s].pid,
              parentid: arr[s].parentid,
              pname: arr[s].pname,
              model: arr[s].model,
              count: arr[s].count,
              originid: arr[s].parentid,
              scopedSlots: { title: "custom" },
            };
          } else {
            //编辑
            arr[s].pname = obj.pname;
            arr[s].model = obj.model;
            arr[s].count = obj.count;
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
    //多叉树的深度遍历
    dfsTree(data, idlist) {
      if (!data) {
        return;
      }
      idlist.push(data.pid);
      if (data.children && data.children.length > 0) {
        for (let i = 0; i < data.children.length; i++) {
          this.dfsTree(data.children[i], idlist);
        }
      }
    },
    dfsTreeId(data, parentid, id, treelist) {
      if (!data) {
        return;
      }
      //console.log(data);
      data.pid = parentid * 10 + id;
      data.parentid = parentid;
      treelist.push({
        pid: data.pid,
        parentid: data.parentid,
        pname: data.pname,
        model: data.model,
        count: data.count,
        originid: data.originid,
      });
      if (data.children && data.children.length > 0) {
        for (let i = 0; i < data.children.length; i++) {
          this.dfsTreeId(data.children[i], data.pid, i, treelist);
        }
      }
    },
    editnode(data) {
      data.isEditNode = true;
      data.dataRef.isEditNode = true;
      //console.log(data);
    },
    makeEdit(data) {
      //console.log(data);
      let pid = data.pid,
        parentid = data.parentid,
        pname = null,
        model = null,
        count = null,
        originid = data.originid;
      pname =
        document.querySelector(".pnameeditnode").value === ""
          ? data.pname
          : document.querySelector(".pnameeditnode").value;
      model =
        document.querySelector(".modeleditnode").value === ""
          ? data.model
          : document.querySelector(".modeleditnode").value;
      count =
        document.querySelector(".counteditnode").value === ""
          ? data.count
          : parseInt(document.querySelector(".counteditnode").value);

      let obj = {
        type: "edit",
        pname,
        model,
        count,
      };
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/selectByDname",
        method: "get",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        params: {
          dname: pname,
        },
      })
        .then((result) => {
          //console.log(result);
          let len = null;
          len = result.data.length;
          if (len === 0) {
            alert("你编辑后的产品在字典中不存在,请在字典中添加它");
            return;
          } else {
            this.axios({
              baseURL: "http://localhost:8081/",
              url: "/updatetreeproduct",
              method: "post",
              headers: { "Content-Type": "application/json;charset=utf-8" },
              data: JSON.stringify({
                pid,
                parentid,
                pname,
                model,
                count,
                originid,
              }),
            })
              .then((result) => {
                //console.log(result);
              })
              .catch((err) => {
                //console.log(err);
              });
            this.searchOption(data, this.treeData, obj);
          }
        })
        .catch((err) => {
          //console.log(err);
        });

      data.isEditNode = false;
      data.dataRef.isEditNode = false;
    },
    addnode(data) {
      //console.log(data);
      data.isAddNode = true;
      data.dataRef.isAddNode = true;
    },
    makeSure(data) {
      //console.log("---------------");
      //console.log(data);
      let pid = null,
        parentid = null,
        pname = null,
        model = null,
        count = null,
        originid = 0;
      parentid = data.pid;
      pname = document.querySelector(".pnameaddnode").value;
      model = document.querySelector(".modeladdnode").value;
      count = document.querySelector(".countaddnode").value;
      if (!this.checkNumber(count)) {
        alert("所需数量需要输入数字，输入个数不正确!");
        return;
      }
      if (!data.children || data.children.length === 0) {
        pid = data.pid * 10;
      } else {
        pid = data.children[data.children.length - 1].pid + 1;
      }
      let newNode = {
        pid,
        parentid,
        pname,
        model,
        count: parseInt(count),
        originid,
        scopedSlots: { title: "custom" },
        isAddNode: false,
        isEditNode: false,
      };
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/selectByDname",
        method: "get",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        params: {
          dname: pname,
        },
      })
        .then((result) => {
          //console.log(result);
          let len = null;
          len = result.data.length;
          if (len === 0) {
            alert("你添加的产品在字典中不存在,请在字典中添加它");
            return;
          } else {
            this.axios({
              baseURL: "http://localhost:8081/",
              url: "/addtreeproduct",
              method: "post",
              headers: { "Content-Type": "application/json;charset=utf-8" },
              data: JSON.stringify({
                pid,
                parentid,
                pname,
                model,
                originid,
                count: parseInt(count),
              }),
            })
              .then((result) => {
                console.log(result);
              })
              .catch((err) => {
                console.log(err);
              });
            this.searchOption(data, this.treeData, {
              type: "add",
              newNode,
            });
          }
        })
        .catch((err) => {
          console.log(err);
        });

      data.dataRef.isAddNode = false;
      data.isAddNode = false;
    },
    addProduct() {
      this.isAddProduct = true;
    },
    Commit() {
      let pid = null,
        pname = document.querySelector(".pnameaddproduct").value,
        model = document.querySelector(".modeladdproduct").value,
        count = document.querySelector(".countaddproduct").value,
        originid = 0;
      if (!this.checkNumber(count)) {
        alert("所需数量需要输入数字，输入个数不正确!");
        return;
      }
      if (this.treeData.length === 0) {
        pid = 10;
      } else {
        pid = this.treeData[this.treeData.length - 1].pid + 1;
      }
      let newProdct = {
        pid,
        parentid: 1,
        pname,
        model,
        count: parseInt(count),
        originid,
        scopedSlots: { title: "custom" },
        isAddNode: false,
        isEditNode: false,
      };
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/selectByDname",
        method: "get",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        params: {
          dname: pname,
        },
      })
        .then((result) => {
          console.log(result);
          let len = null;
          len = result.data.length;
          if (len === 0) {
            alert("你添加的产品在字典中不存在,请在字典中添加它");
            return;
          } else {
            this.axios({
              baseURL: "http://localhost:8081/",
              url: "/addtreeproduct",
              method: "post",
              headers: { "Content-Type": "application/json;charset=utf-8" },
              data: JSON.stringify({
                pid,
                parentid: 1,
                pname,
                model,
                count: parseInt(count),
                originid,
              }),
            })
              .then((result) => {
                console.log(result);
              })
              .catch((err) => {
                console.log(err);
              });
            this.treeData.push(newProdct);
          }
        })
        .catch((err) => {
          console.log(err);
        });
      //console.log(len);

      this.isAddProduct = false;
      //console.log(this.treeData);
    },
    deletenode(data) {
      //console.log(data);
      let obj = {
        type: "delete",
      };
      this.searchOption(data, this.treeData, obj);
      //console.log(this.deledata);
      let idlist = [];
      this.dfsTree(this.deledata, idlist);
      //console.log(idlist);
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/deletetreeproductlists",
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
    cancle(data) {
      data.isAddNode = false;
      data.dataRef.isAddNode = false;
      data.isEditNode = false;
      data.dataRef.isEditNode = false;
    },
    cancleProduct() {
      this.isAddProduct = false;
    },
    onSelect(selectedKeys, e) {
      //console.log(selectedKeys);
      //console.log(e);
      //console.log(e.node.dataRef);
      this.tableData = [];
      this.tableData.push(e.node.dataRef);
    },
    copytree(data) {
      //console.log(data);
      //console.log("复制子树");
      let obj = { type: "copytree" };
      //console.log(this.treeData);
      this.searchOption(data, this.treeData, obj);
      //console.log(this.copydata);
    },
    copynode(data) {
      // console.log(data);
      //console.log("复制节点");
      let obj = { type: "copy" };
      //console.log(this.treeData);
      this.searchOption(data, this.treeData, obj);
      // console.log(this.copydata);
    },
    pasteproduct() {
      //console.log("复制产品节点");
      let treelist = [];
      let id = 0;
      if (this.treeData.length > 0) {
        id = (this.treeData[this.treeData.length - 1].pid % 10) + 1;
      }
      this.dfsTreeId(this.copydata, 1, id, treelist);
      //console.log(this.copydata);
      //console.log(treelist);
      this.treeData.push(this.copydata);
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/addtreeproductlists",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        data: JSON.stringify(treelist),
      })
        .then((result) => {
          console.log(result);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    pastetree(data) {
      // console.log(data);
      // console.log("粘贴节点");
      let treelist = [];
      let id = 0;
      // console.log(this.copydata);
      if (data.children && data.children.length > 0) {
        id = (data.children[data.children.length - 1].pid % 10) + 1;
      }
      this.dfsTreeId(this.copydata, data.pid, id, treelist);
      //console.log(this.copydata);
      let obj = {
        type: "add",
        newNode: this.copydata,
      };
      this.searchOption(data, this.treeData, obj);
      //console.log(treelist);
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/addtreeproductlists",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        data: JSON.stringify(treelist),
      })
        .then((result) => {
          console.log(result);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    dfsproductId(data, parentid, id, productmodellist) {
      if (!data) {
        return;
      }
      //console.log(data);
      data.pid = parentid * 10 + id;
      data.parentid = parentid;
      productmodellist.push({
        pnum: data.pid,
        parentid: data.parentid,
        pname: data.pname,
        model: data.model,
        count: data.count,
      });
      if (data.children && data.children.length > 0) {
        for (let i = 0; i < data.children.length; i++) {
          this.dfsproductId(data.children[i], data.pid, i, productmodellist);
        }
      }
    },
    addtoproductmodel(data) {
      let obj = { type: "copytree" };
      this.searchOption(data, this.treeData, obj);
      //console.log(this.copydata);
      let productmodel = null;
      this.axios
        .get("http://localhost:8081/selectallproductmodelchildren")
        .then((result) => {
          //console.log(result);
          productmodel = result.data.children;
          console.log(productmodel);
          let id = 0;
          console.log(productmodel.length);
          if (productmodel.length > 0) {
            id = (productmodel[productmodel.length - 1].pnum % 10) + 1;
          }
          let productmodellist = [];
          this.dfsproductId(this.copydata, 1, id, productmodellist);
          //console.log(productmodellist);
          this.axios({
            baseURL: "http://localhost:8081/",
            url: "/addproductmodellists",
            method: "post",
            headers: { "Content-Type": "application/json;charset=utf-8" },
            data: JSON.stringify(productmodellist),
          })
            .then((result) => {
              console.log(result);
              if (result.status === 200) {
                alert("添加模板成功,请到产品模板页查看!");
                this.$router.push({ path: "/home/productmodel" });
              }
            })
            .catch((err) => {
              console.log(err);
            });
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
          data.isAddNode = false;
          data.isEditNode = false;
          data.scopedSlots = { title: "custom" };
          deep(data[key]);
        }
      }
    }
    this.axios
      .get("http://localhost:8081/selectalltreeproductchildren")
      .then((result) => {
        //console.log(result);
        deep(result.data);
        for (let i = 0; i < result.data.children.length; i++) {
          this.treeData.push(result.data.children[i]);
        }
        this.tableData = this.treeData;
        //console.log(this.tableData);
      })
      .catch((err) => {
        console.log(err);
      });
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
