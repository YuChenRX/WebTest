<template>
  <van-tabbar style="width: 100%" v-model="index" route>
    <van-tabbar-item icon="home-o" to="/navigation/main">首页</van-tabbar-item>
    <van-tabbar-item icon="search" to="/navigation/classification">分类</van-tabbar-item>
    <van-tabbar-item icon="shopping-cart-o" to="/navigation/shoppingCart">购物车</van-tabbar-item>
    <van-tabbar-item icon="manager-o" to="/navigation/personal">个人中心</van-tabbar-item>
  </van-tabbar>
</template>

<script>
export default {
  data() {
    return {
      index: 0
    }
  },
  methods() {

  },
  mounted() {
    this.index = Number(window.sessionStorage.getItem('homePage'))
  },
};
</script>

<style>
</style>