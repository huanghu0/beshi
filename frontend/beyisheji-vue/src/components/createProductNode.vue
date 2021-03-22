<template>
  <a-form-model>
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
    <a-form-model-item label="节点左值">
      <a-input placeholder="节点左值比节点右值小1" />
    </a-form-model-item>
    <a-form-model-item label="节点右值">
      <a-input placeholder="节点右值比节点左值大1" />
    </a-form-model-item>
    <a-form-model-item>
      <a-button type="primary"> Submit </a-button>
    </a-form-model-item>
  </a-form-model>
</template>
<script>
export default {
  name: "createProductNode",
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