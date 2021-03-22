import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter);
const routes = [
    {
        path:'/',
        component: resolve => require(['@/views/home.vue'],resolve),
        children:[
            {
                path:'createProduct',
                component: resolve => require(['@/components/createProduct.vue'],resolve),
            },{
                path:'editProduct',
                component: resolve => require(['@/components/editProduct.vue'],resolve),                
            },{
                path:'createProductNode',
                component: resolve => require(['@/components/createProductNode.vue'],resolve),
            },{
                path:'editProductNode',
                component: resolve => require(['@/components/editProductNode.vue'],resolve),
            },{
                path:'treeTableShow',
                component: resolve => require(['@/components/treeTableShow.vue'],resolve),
            }
        ],
        redirect: 'createProduct'
    }
];
export default new VueRouter({
    mode: 'history',
    routes,
});