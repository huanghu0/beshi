<template>
  <div>
    <a-form
      id="components-form-demo-normal-login"
      class="login-form"
      :style="{ width: '400px', marginLeft: '150px', marginTop: '50px' }"
    >
      <a-form-item>
        <a-input placeholder="telphone">
          <a-icon
            slot="prefix"
            type="phone"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input placeholder="code">
          <a-icon
            slot="prefix"
            type="code"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
        <a-button type="primary"> 获取验证码</a-button>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" class="login-form-button">
          Log in
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "shortMessageLogin",
};
</script>
<style scoped>
</style>