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
                path:'createProductNode',
                component: resolve => require(['@/components/createProductNode.vue'],resolve),
            },{
                path:'editProductNode',
                component: resolve => require(['@/components/editProductNode.vue'],resolve),
            },{
                path:'tableShow',
                component: resolve => require(['@/components/tableShow.vue'],resolve),
            },{
                path:'treeQuickShow',
                component: resolve => require(['@/components/treeQuickShow.vue'],resolve),
            }
        ],
        redirect: 'createProduct'
    }
];
export default new VueRouter({
    mode: 'history',
    routes,
});