<template>
  <div>
    <div style="position: sticky;top: 0;z-index: 1000;">
      <van-search shape="round" plac disabled @click="$router.push('/popup')" :placeholder="placeholder">
        <template #left>
          <van-icon name="arrow-left" style="margin-right: 10px" @click="$router.push('/')"/>
        </template>
      </van-search>
      <!-- 上面筛选 -->
      <van-tabs v-model="screening1" @change="initGoodsList">
        <van-tab>
          <template #title>
            <van-dropdown-menu>
              <van-dropdown-item v-model="screening2" :options="option" @change="initGoodsList"/>
            </van-dropdown-menu>
          </template>
        </van-tab>
        <van-tab title="新品"></van-tab>
      </van-tabs>
    </div>


    <van-grid :column-num="2" :border="false">
      <van-grid-item v-for="good in goodsList" :key="good.mid">
        <van-image :src="good.carousel[0]" style="border-radius: 10px" @click="$router.push(`/goodsDetailed/${good.id}/1`)">
          <template v-slot:loading>
            <van-loading type="spinner" size="20"/>
          </template>
        </van-image>
        <div style="width: 100%">
          <p
              style="font-weight: bold;font-size: 12px;overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
            <van-tag type="danger" size="small">天猫</van-tag>
            {{ good.title }}
          </p>
          <span style=" color: red; font-size: 12px;">¥</span>
          <span style="color: red">{{ good.left }}</span>
          <span style=" color: red; font-size: 12px;">.{{ good.right }}</span>
          <span style="color:rgb(153,153,153);font-size: 11px;">&nbsp{{ good.soldCount }}人已付款</span>
        </div>
      </van-grid-item>
      <van-button style="text-align: center;;width: 100vw" @click="loadingGoods">
        {{ text }}
      </van-button>
      <p style="margin-top: 77px"></p>
    </van-grid>
  </div>
</template>

<script>
export default {
  name: "goodsList",
  props: {
    words: String
  },
  data() {
    return {
      placeholder: "请输入搜索关键词",
      goodsList: [],
      page: 1,
      full: false,
      screening1: 0,
      screening2: 0,
      option: [{
        text: '销量',
        value: 0
      },
        {
          text: '价格升序',
          value: 1
        },
        {
          text: '价格降序',
          value: 2
        },
      ]
    }
  },
  computed: {
    text() {
      return this.full ? "没有更多了" : "点我加载"
    }
  },
  methods: {
    loadingGoods() {
      this.page += 1

      if (!this.full){
        let page = {
          page: this.page,
          num: 10,
          sortType: this.screening1 ? 3 : this.screening2,
        }
        if (this.words != null) {
          page.words = this.words
        }

        this.getRequst('/products', page).then(resp => {
          this.full = resp.length === 0

          resp.forEach(goods => {
            goods.price *= 100;
            goods.left = parseInt(goods.price / 100)
            goods.right = goods.price - goods.left * 100
            if (goods.right == 0) {
              goods.right = '00'
            }
          })
          resp.forEach(goods => {
            this.goodsList.push(goods)
          })
        })
        this.loading = false;

      }
    },
    initGoodsList() {
      this.goodsList = []

      let page = {
        page: this.page,
        num: 10,
        sortType: this.screening1 ? 3 : this.screening2,
      }
      if (this.words != null) {
        page.words = this.words
      }

      this.getRequst('/products', page).then(resp => {
        resp.forEach(goods => {
          goods.price *= 100;
          goods.left = parseInt(goods.price / 100)
          goods.right = goods.price - goods.left * 100
          if (goods.right == 0) {
            goods.right = '00'
          }
        })

        if (resp.length<10){
          this.full=true
        }
        this.goodsList = resp
      })
    }
  },
  mounted() {
    this.initGoodsList()
    console.log(this.words)
    if (this.words != null) {
      this.placeholder = this.words
    }
  }
}
</script>

<style scoped>

</style>
