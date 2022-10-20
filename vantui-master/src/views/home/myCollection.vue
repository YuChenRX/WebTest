<template>
  <div>
    <van-nav-bar
        title="我的收藏"
        left-arrow
        @click-left="$router.back()">
      <template #right>
        <div style="color: #1989fa" @click="management" v-show="!start">
          管理
        </div>
        <div style="color: red" @click="management" v-show="start">
          退出管理
        </div>
      </template>
    </van-nav-bar>

    <van-grid :column-num="2" :border="false">
      <van-grid-item v-for="good in goodsList" :key="good.id">
        <van-checkbox v-model="good.checked" style="margin-left: auto;margin-bottom: 10px"
                      v-show="start" @click="childChecked"></van-checkbox>
        <van-image :src="good.product.carousel[0]" style="border-radius: 10px" @click="$router.push(`/goodsDetailed/${good.product.id}`)">
          <template v-slot:loading>
            <van-loading type="spinner" size="20"/>
          </template>
        </van-image>
        <div style="width: 100%">
          <p
              style="font-weight: bold;font-size: 12px;overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
            <van-tag type="danger" size="small">天猫</van-tag>
            {{ good.product.title }}
          </p>
          <span style=" color: red; font-size: 12px;">¥</span>
          <span style="color: red">{{ good.left }}</span>
          <span style=" color: red; font-size: 12px;">.{{ good.right }}</span>
          <span style="color:rgb(153,153,153);font-size: 11px;">&nbsp{{ good.product.soldCount }}人已付款</span>
        </div>
      </van-grid-item>
    </van-grid>

    <div style="position: fixed;bottom: 0;left: 0;z-index: 100;width: 100%;" v-show="start">
      <div style="height: 50px;background: #fff;display: flex;align-items: center;padding: 0 16px;font-size: 14px">
        <van-checkbox v-model="checked" @click="checkedAll">全选</van-checkbox>
        <van-button round type="info" style="margin-left: auto;width: 20vw;background: #fff;color: #1989fa"
                    size="small" @click="removeCheck">删除
        </van-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "myCollection",
  data() {
    return {
      start: false,//false管理 true退出管理
      goodsList: [],
      checked: false
    }
  },
  methods: {
    childChecked() {
      let num = 0;
      this.goodsList.forEach(goods => {
        if (goods.checked) {
          num += 1;
        }
      })
      this.checked = num == this.goodsList.length ? true : false;
    },
    checkedAll() {
      this.goodsList.forEach(goods => {
        goods.checked = this.checked
      })
    },
    removeCheck() {
      let list = []
      this.goodsList.forEach(goods => {
        goods.checked ? list.push(goods.id) : false;
      })
      console.log(list)
      this.deleteRequst('/favourites', list).then(resp => {
        this.initCollection()
      })
    },
    //初始化收藏列表
    initCollection() {
      this.getRequst('/favourites').then(resp => {
        resp.forEach(goods => {
          goods.checked = false
          goods.price = goods.product.price * 100;
          console.log(goods.price)
          goods.left = parseInt(goods.price / 100)
          goods.right = goods.price - goods.left * 100
          if (goods.right == 0) {
            goods.right = '00'
          }
        })
        this.goodsList = resp
      })
    },
    management() {
      if (this.start) {
        this.start = false
      } else {
        this.start = true
      }
    }
  },
  mounted() {
    this.initCollection()
  }
}
</script>

<style scoped>

</style>
