<template>
  <div>
    <a-form
      id="components-form-demo-normal-login"
      class="login-form"
      :style="{ width: '400px', marginLeft: '150px', marginTop: '50px' }"
    >
      <a-form-item>
        <a-input placeholder="name" class="name" v-model="name">
          <a-icon
            slot="prefix"
            type="user"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input placeholder="Password" class="password" v-model="password">
          <a-icon
            slot="prefix"
            type="lock"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input placeholder="telnumber" class="telnum" v-model="telnum">
          <a-icon
            slot="prefix"
            type="phone"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-button
          type="primary"
          html-type="submit"
          class="login-form-button"
          @click="register"
        >
          Register
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "register",
  data() {
    return {
      name: null,
      password: null,
      telnum: null,
    };
  },
  methods: {
    register() {
      if (this.name === null || this.name === "") {
        alert("姓名不能为空!");
        return;
      }
      var reg = /^[0-9]+.?[0-9]*$/;
      if (this.password === null || this.password === "") {
        alert("密码不能为空");
        return;
      }
      if (
        !reg.test(this.telnum) ||
        this.telnum === null ||
        this.telnum === "" ||
        this.telnum.length !== 11
      ) {
        alert("电话号码不能为空,且必须时11为的数字");
        return;
      }
      this.axios({
        baseURL: "http://localhost:8081/",
        url: "/addAdmin",
        method: "post",
        headers: { "Content-Type": "application/json;charset=utf-8" },
        params: {
          name: this.name,
          password: this.password,
          telnum: this.telnum,
        },
      })
        .then((result) => {
          // console.log(result);
          alert(result.data);
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