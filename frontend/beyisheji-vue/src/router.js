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
            },{
                path:'treeComponent',
                component: resolve => require(['@/components/treeComponent.vue'],resolve),
            },{
                path:'dictionary',
                component: resolve => require(['@/components/dictionary.vue'],resolve),
            }
        ],
        redirect: 'treeTableShow'
    }
];
export default new VueRouter({
    mode: 'history',
    routes,
});