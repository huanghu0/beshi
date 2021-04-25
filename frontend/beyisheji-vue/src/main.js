import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueAxios from 'vue-axios'
import axios from 'axios'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

axios.defaults.withCredentials = true;//允许跨域携带cookie信息
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueAxios,axios);
Vue.use(Antd);

new Vue({
  render: h => h(App),
  router,
  store,
  // mounted(){
  //   console.log(this.axios);
  // }
}).$mount('#app')
