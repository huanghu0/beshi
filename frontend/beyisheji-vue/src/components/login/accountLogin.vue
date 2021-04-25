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
        <a-input placeholder="code" v-model="code">
          <a-icon
            slot="prefix"
            type="code"
            style="color: rgba(0, 0, 0, 0.25)"
          />
        </a-input>
      </a-form-item>
      <a-form-item>
        <!--从Vue中获取url属性-->
        <img id="num" :src="url" />
        <!--									从Vue中调用名为getImage()的方法-->
        <a href="javascript:;" @click="getImage">换一张</a>
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
      code: null,
      url: "",
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
          code: this.code,
        },
      })
        .then((result) => {
          if (result.data.length === 0) {
            alert("用户不存在,或者密码错误,或者验证码错误,请认真检查");
            return;
          }
          this.$router.push("/home");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //用来更换验证码
    getImage() {
      this.getSrc();
    },

    //获取验证码，代码复用，便于调用
    getSrc() {
      //console.log("xxxx");
      //异步请求：请求验证码图片
      this.axios
        .get("http://localhost:8081/getImage?time=" + Math.random())
        .then((res) => {
          console.log(res.data);
          //把图片赋给url属性
          this.url = res.data;
        });
    },
  },
  created() {
    //获取验证码
    this.getSrc();
  },
};
</script>
<style scoped>
</style>