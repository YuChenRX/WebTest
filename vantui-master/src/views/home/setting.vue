<template>
  <div>
    <van-nav-bar
        title="设置"
        left-text="返回"
        left-arrow
        @click-left="out"
    />

    <van-cell title="我的收货地址" to="/address"/>
    <van-cell title="账户与安全"/>
    <van-cell title="退出登录" style="text-align: center;margin-top: 5px" @click="logout"/>
  </div>
</template>

<script>
export default {
  name: "setting",
  methods: {
    out() {
      this.$router.push('/navigation/personal')
    },
    logout() {
      window.localStorage.removeItem('token')
      this.$router.push('/navigation/personal')
    }
  }
}
</script>

<style scoped>

</style>