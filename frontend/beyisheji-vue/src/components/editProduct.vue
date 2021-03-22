<template>
  <a-form-model>
    <a-form-model-item label="产品模板编号">
      <a-input />
    </a-form-model-item>
    <a-form-model-item label="产品模板名称">
      <a-input />
    </a-form-model-item>
    <a-form-model-item>
      <a-button type="primary"> Submit </a-button>
    </a-form-model-item>
  </a-form-model>
</template>
<script>
export default {
  name: "editProduct",
  data() {
    return {};
  },
};
</script>
<style scoped>
.ant-form {
  position: relative;
  left: -345px;
  margin-left: 50%;
  width: 50%;
}
.ant-row.ant-form-item {
  margin-bottom: 0;
}
</style>