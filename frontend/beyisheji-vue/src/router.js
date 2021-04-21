import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter);
const routes = [
    {
        path:'/',
        component:resolve=>require(['@/views/login.vue'],resolve),
        children:[
            {
                path:'accountlogin',
                component:resolve=>require(['@/components/login/accountLogin.vue'],resolve)
            },
            {
                path:'register',
                component:resolve=>require(['@/components/login/register.vue'],resolve)
            },{
                path:'shortMessageLogin',
                component:resolve=>require(['@/components/login/shortMessageLogin.vue'],resolve)
            }
        ],
        redirect: 'accountlogin'
    },
    {
        path:'/home',
        component: resolve => require(['@/views/home.vue'],resolve),
        children:[
            {
                path:'/home/createProduct',
                component: resolve => require(['@/components/createProduct.vue'],resolve),
            },{
                path:'/home/editProduct',
                component: resolve => require(['@/components/editProduct.vue'],resolve),                
            },{
                path:'/home/createProductNode',
                component: resolve => require(['@/components/createProductNode.vue'],resolve),
            },{
                path:'/home/editProductNode',
                component: resolve => require(['@/components/editProductNode.vue'],resolve),
            },{
                path:'/home/treeTableShow',
                component: resolve => require(['@/components/treeTableShow.vue'],resolve),
            },{
                path:'/home/treeComponent',
                component: resolve => require(['@/components/treeComponent.vue'],resolve),
            },{
                path:'/home/dictionary',
                component: resolve => require(['@/components/dictionary.vue'],resolve),
            },{
                path:'/home/productmodel',
                component:resolve => require(['@/components/productmodel.vue'],resolve)
            },{
                path:'/home/productdetails',
                component:resolve => require(['@/components/productdetails.vue'],resolve)
            }
        ],
        redirect: '/home/dictionary'
    }
];
export default new VueRouter({
    mode: 'history',
    routes,
});