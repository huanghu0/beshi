<template>
  <div class="dictionary" :style="{ position: 'relative' }">
    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-button
          type="primary"
          style="margin: 20px 20px 0 0"
          @click="addDictionary()"
          >添加字典</a-button
        >
      </a-layout-sider>
      <a-layout :style="{ padding: '0 24px 24px', margin: '16px 0' }">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            margin: 0,
            minHeight: '280px',
          }"
        >
          <a-table
            :data-source="data"
            :columns="columns"
            :pagination="{ defaultPageSize: 5 }"
          >
            <div
              slot="filterDropdown"
              slot-scope="{
                setSelectedKeys,
                selectedKeys,
                confirm,
                clearFilters,
                column,
              }"
              style="padding: 8px"
            >
              <a-input
                v-ant-ref="(c) => (searchInput = c)"
                :placeholder="`Search ${column.dataIndex}`"
                :value="selectedKeys[0]"
                style="width: 188px; margin-bottom: 8px; display: block"
                @change="
                  (e) => setSelectedKeys(e.target.value ? [e.target.value] : [])
                "
                @pressEnter="
                  () => handleSearch(selectedKeys, confirm, column.dataIndex)
                "
              />
              <a-button
                type="primary"
                icon="search"
                size="small"
                style="width: 90px; margin-right: 8px"
                @click="
                  () => handleSearch(selectedKeys, confirm, column.dataIndex)
                "
              >
                Search
              </a-button>
              <a-button
                size="small"
                style="width: 90px"
                @click="() => handleReset(clearFilters)"
              >
                Reset
              </a-button>
            </div>
            <a-icon
              slot="filterIcon"
              slot-scope="filtered"
              type="search"
              :style="{ color: filtered ? '#108ee9' : undefined }"
            />
            <template
              slot="customRender"
              slot-scope="text, record, index, column"
            >
              <span v-if="searchText && searchedColumn === column.dataIndex">
                <template
                  v-for="(fragment, i) in text
                    .toString()
                    .split(
                      new RegExp(`(?<=${searchText})|(?=${searchText})`, 'i')
                    )"
                >
                  <mark
                    v-if="fragment.toLowerCase() === searchText.toLowerCase()"
                    :key="i"
                    class="highlight"
                    >{{ fragment }}</mark
                  >
                  <template v-else>{{ fragment }}</template>
                </template>
              </span>
              <template v-else>
                {{ text }}
              </template>
            </template>
          </a-table>
        </a-layout-content>
      </a-layout>
    </a-layout>
    <a-card
      :bordered="true"
      :style="{ zIndex: 1, position: 'absolute', top: '0px', left: '200px' }"
      v-if="isAdd"
    >
      <a-form-model-item layout="inline">
        <a-form-model-item label="产品名称">
          <a-input class="dname" />
        </a-form-model-item>
        <a-form-model-item label="产品描述">
          <a-input class="represent" />
        </a-form-model-item>
        <a-form-model-item :style="{ display: 'block', width: '500px' }">
          <a-button type="primary" @click="Commit()" style="margin: 0 20px 0 0">
            添加
          </a-button>
          <a-button type="primary" @click="cancleProduct()">取消</a-button>
        </a-form-model-item>
      </a-form-model-item>
    </a-card>
  </div>
</template>
<script>
export default {
  name: "dictionary",
  data() {
    return {
      isAdd: false,
      data: null,
      searchText: "",
      searchInput: null,
      searchedColumn: "",
      columns: [
        {
          title: "Id",
          dataIndex: "key",
          key: "key",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.key.toString().toLowerCase().includes(value.toLowerCase()),
          onFilterDropdownVisibleChange: (visible) => {
            if (visible) {
              setTimeout(() => {
                this.searchInput.focus();
              });
            }
          },
        },
        {
          title: "Name",
          dataIndex: "dname",
          key: "dname",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.dname.toString().toLowerCase().includes(value.toLowerCase()),
          onFilterDropdownVisibleChange: (visible) => {
            if (visible) {
              setTimeout(() => {
                this.searchInput.focus();
              }, 0);
            }
          },
        },
        {
          title: "Represent",
          dataIndex: "represent",
          key: "represent",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.represent
              .toString()
              .toLowerCase()
              .includes(value.toLowerCase()),
          onFilterDropdownVisibleChange: (visible) => {
            if (visible) {
              setTimeout(() => {
                this.searchInput.focus();
              });
            }
          },
        },
      ],
    };
  },
  methods: {
    addDictionary() {
      this.isAdd = true;
    },
    Commit() {
      let dname = document.querySelector(".dname").value;
      let represent = document.querySelector(".represent").value;
      console.log(dname, represent);
      let key = this.data.length + 1;
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/adddictionary",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        data: JSON.stringify({
          key,
          dname,
          represent,
        }),
      })
        .then((result) => {
          console.log(result);
        })
        .catch((err) => {
          console.log(err);
        });
      this.data.push({ key, dname, represent });
      this.isAdd = false;
    },
    cancleProduct() {
      this.isAdd = false;
    },
    handleSearch(selectedKeys, confirm, dataIndex) {
      confirm();
      this.searchText = selectedKeys[0];
      this.searchedColumn = dataIndex;
    },

    handleReset(clearFilters) {
      clearFilters();
      this.searchText = "";
    },
  },
  mounted() {
    this.axios
      .get("http://localhost:8081/selectalldictionary")
      .then((result) => {
        console.log(result);
        this.data = result.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
<style scoped>
.ant-form-item {
  display: inline-block;
  margin: 10px;
}
.highlight {
  background-color: rgb(255, 192, 105);
  padding: 0px;
}
</style>
