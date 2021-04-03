<template>
  <div class="dictionary">
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
          <a-table :data-source="data" :columns="columns">
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
    <a-card :bordered="true" :style="{ zIndex: 1 }" v-if="isAdd">
      <a-form-model-item layout="inline">
        <a-form-model-item label="字典id">
          <a-input class="id" />
        </a-form-model-item>
        <a-form-model-item label="产品名称">
          <a-input class="name" />
        </a-form-model-item>
        <a-form-model-item label="产品描述">
          <a-input class="describe" />
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
const data = [
  {
    key: "1",
    name: "John Brown",
    age: 32,
    address: "New York No. 1 Lake Park",
  },
  {
    key: "2",
    name: "Joe Black",
    age: 42,
    address: "London No. 1 Lake Park",
  },
  {
    key: "3",
    name: "Jim Green",
    age: 32,
    address: "Sidney No. 1 Lake Park",
  },
  {
    key: "4",
    name: "Jim Red",
    age: 32,
    address: "London No. 2 Lake Park",
  },
];
export default {
  name: "dictionary",
  data() {
    return {
      isAdd: false,
      data,
      searchText: "",
      searchInput: null,
      searchedColumn: "",
      columns: [
        {
          title: "Name",
          dataIndex: "name",
          key: "name",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.name.toString().toLowerCase().includes(value.toLowerCase()),
          onFilterDropdownVisibleChange: (visible) => {
            if (visible) {
              setTimeout(() => {
                this.searchInput.focus();
              }, 0);
            }
          },
        },
        {
          title: "Age",
          dataIndex: "age",
          key: "age",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.age.toString().toLowerCase().includes(value.toLowerCase()),
          onFilterDropdownVisibleChange: (visible) => {
            if (visible) {
              setTimeout(() => {
                this.searchInput.focus();
              });
            }
          },
        },
        {
          title: "Address",
          dataIndex: "address",
          key: "address",
          scopedSlots: {
            filterDropdown: "filterDropdown",
            filterIcon: "filterIcon",
            customRender: "customRender",
          },
          onFilter: (value, record) =>
            record.address
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
