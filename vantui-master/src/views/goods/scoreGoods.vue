<template>
  <div>
    <div style="position: sticky;top: 0;z-index: 1000;">
      <van-search shape="round" plac disabled @click="$router.push('/popup')" placeholder="请输入搜索关键词">
        <template #left>
          <van-icon name="arrow-left" style="margin-right: 10px" @click="$router.back()"/>
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
        <van-image :src="good.carousel[0]" style="border-radius: 10px"/>
        <div style="width: 100%">
          <p
              style="font-weight: bold;font-size: 12px;overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
            <van-tag type="danger" size="small">天猫</van-tag>
            {{ good.title }}
          </p>

          <span style="color: red;font-size:16px ">{{ good.credit }}</span>
          <span style="font-size: 15px">积分</span>
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
  name: "scoreGoods",
  data() {
    return {
      full: false,
      page: 0,
      goodsList: [],
      screening1: "SOLD_COUNT",
      screening2: "SOLD_COUNT",
      option: [{
        text: '销量',
        value: "SOLD_COUNT"
      },
        {
          text: '价格升序',
          value: "PRICE"
        },
        {
          text: '凑数的别点',
          value: "demo2"
        },
      ]
    }
  },
  methods: {
    loadingGoods() {
      this.page += 1
      this.getRequst('/products/score', {
        page: this.page,
        num: 10,
        sortType: this.screening1 ? 3 : this.screening2
      }).then(resp => {
        this.full = resp.length === 0
        resp.forEach(goods => {
          this.goodsList.push(goods)
        })
      })
      this.loading = false;
    },
    initGoodsList() {
      this.getRequst('/products?type=CREDIT', {
        page: this.page,
        num: 10,
        sortBy: this.screening1 ? "TIME" : this.screening2,
      }).then(resp => {
        console.log(resp)
        this.goodsList = resp
      })
    }
  },
  computed: {
    text() {
      return this.full ? "没有更多了" : "点我加载"
    }
  },
  mounted() {
    this.initGoodsList()
  }
}
</script>

<style scoped>

</style>
