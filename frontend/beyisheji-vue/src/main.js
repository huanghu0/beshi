import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueAxios from 'vue-axios'
import axios from 'axios'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
Vue.config.productionTip = false
Vue.use(VueAxios,axios);
Vue.use(Antd);
new Vue({
  render: h => h(App),
  router,
  store,
  mounted(){
    console.log(this.axios);
  }
}).$mount('#app')
