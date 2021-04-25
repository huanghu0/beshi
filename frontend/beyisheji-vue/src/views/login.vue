<template>
  <div class="login">
    <a-menu class="tabmenu" v-model="current" mode="horizontal">
      <a-menu-item key="accountLogin">
        <router-link to="/accountLogin">账号登录</router-link>
      </a-menu-item>
      <a-menu-item key="shortMessageLogin"
        ><router-link to="/shortMessageLogin">短信登录</router-link>
      </a-menu-item>
      <a-menu-item key="register"
        ><router-link to="/register"> 注册</router-link>
      </a-menu-item>
    </a-menu>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
export default {
  name: "login",
  data() {
    return { current: ["accountLogin"] };
  },
};
</script>

<style scoped>
.login {
  width: 800px;
  height: 500px;
  border: 1px solid #ccc;
  position: absolute;
  left: 50%;
  top: 50%;
  margin-left: -400px;
  margin-top: -200px;
}
.tabmenu {
  margin-left: 200px;
  border: #fff;
}
</style>