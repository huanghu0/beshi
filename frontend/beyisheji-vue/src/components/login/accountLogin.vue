<template>
  <div>
    <a-form
      id="components-form-demo-normal-login"
      class="login-form"
      :style="{ width: '400px', marginLeft: '150px', marginTop: '50px' }"
    >
      <a-form-item>
        <a-input placeholder="Account" v-model="account">
          <a-icon
            slot="prefix"
            type="user"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input type="password" placeholder="Password" v-model="password">
          <a-icon
            slot="prefix"
            type="lock"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-button
          type="primary"
          html-type="submit"
          class="login-form-button"
          @click="submit"
        >
          Log in
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "accountLogin",
  data() {
    return {
      account: null,
      password: null,
    };
  },
  methods: {
    submit() {
      var reg = /^[0-9]+.?[0-9]*$/;
      if (
        this.account === null ||
        this.account === "" ||
        !reg.test(this.account)
      ) {
        alert("请输入正确的账号");
        return;
      }
      if (this.password === null || this.password === "") {
        alert("密码不能为空");
        return;
      }
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/accountlogin",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        params: {
          account: parseInt(this.account),
          password: this.password,
        },
      })
        .then((result) => {
          if (result.data.length === 0) {
            alert("用户不存在");
            return;
          }
          this.$router.push("/home");
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
<style scoped>
</style>