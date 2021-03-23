<template>
  <a-form-model>
    <a-form-model-item label="产品模板编号">
      <a-input class="productnumber" />
    </a-form-model-item>
    <a-form-model-item label="产品模板名称">
      <a-input class="productname" />
    </a-form-model-item>
    <a-form-model-item>
      <a-button type="primary" @click="addproduct"> Submit </a-button>
    </a-form-model-item>
  </a-form-model>
</template>
<script>
export default {
  name: "createProduct",
  data() {
    return {};
  },
  methods: {
    addproduct: function () {
      let productnumber = document.querySelector(".productnumber");
      let productname = document.querySelector(".productname");
      console.log(productnumber.value, productname.value);
      this.axios
        .get(
          "http://localhost:8081/addproduct/" +
            productnumber.value +
            "/" +
            productname.value
        )
        .then((respones) => {
          console.log(respones);
        });
    },
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