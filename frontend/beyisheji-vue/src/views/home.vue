<template>
  <a-layout id="components-layout-demo-top" class="layout">
    <a-layout-header>
      <a-menu
        theme="dark"
        mode="horizontal"
        :default-selected-keys="['1']"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">
          <router-link to="createProduct">创建产品</router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="tableShow">表格呈现</router-link>
        </a-menu-item>
        <a-menu-item key="3">
          <router-link to="treeQuickShow">树状快速呈现</router-link>
        </a-menu-item>
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
.ant-layout-content div{
    margin-top: 18px;
    margin-bottom: 18px;
    height: 622px;
}
</style>
