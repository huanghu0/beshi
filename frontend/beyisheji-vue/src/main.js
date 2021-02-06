import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueAxios from 'vue-axios'
import axios from 'axios'
Vue.config.productionTip = false
Vue.use(VueAxios,axios);
new Vue({
  render: h => h(App),
  router,
  store,
  mounted(){
    console.log(this.axios);
  }
}).$mount('#app')
