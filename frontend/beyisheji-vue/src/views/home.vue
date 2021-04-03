<template>
  <a-layout id="components-layout-demo-top" class="layout">
    <a-layout-header>
      <a-menu
        theme="dark"
        mode="horizontal"
        :default-selected-keys="['1']"
        :style="{ lineHeight: '64px' }"
      >
        <!-- <a-menu-item key="1">
          <router-link to="createProduct">创建产品</router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="editProduct">编辑产品</router-link>
        </a-menu-item>
        <a-menu-item key="3">
          <router-link to="createProductNode">创建产品节点</router-link>
        </a-menu-item>
        <a-menu-item key="4">
          <router-link to="editProductNode">编辑产品节点</router-link>
        </a-menu-item> -->
        <a-menu-item key="1">
          <router-link to="dictionary">产品字典</router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="treeTableShow">树状及表格呈现</router-link>
        </a-menu-item>
        <!-- <a-menu-item key="6">
          <router-link to="treeComponent">树形组件</router-link>
        </a-menu-item> -->
      </a-menu>
    </a-layout-header>
    <a-layout-content style="padding: 0 50px">
      <div :style="{ background: '#fff', padding: '24px' }">
        <router-view></router-view>
      </div>
    </a-layout-content>
  </a-layout>
</template>
<style>
#components-layout-demo-top .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 24px 16px 0;
  float: left;
}
</style>
