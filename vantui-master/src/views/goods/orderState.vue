<template>
  <div>
    <!--   订单状态导航 -->
    <van-tabs v-model:active="active" :swipeable="true" @click="onClickTab" animated>
      <van-tab v-for="data in stateEnum" :title="data.k" :key="data.v">


      </van-tab>
    </van-tabs>

    <div style="margin-top: 20px;padding-bottom: 100px">
      <van-swipe-cell v-for="com in commodity" :key="com.id">
        <!--    购物车内商品信息-->
        <div
            style="background: rgb(250,250,250);margin: 0 5px 10px 5px;border-radius: 10px;display: flex">
          <!--        信息-->
          <van-card :num=com.amount :price=com.sku.price :thumb=com.sku.image
                    style="margin: 0 10px;width: 100%;"
                    @click-thumb="clickThumb(com.product.id)">
            <template #title>
              <div style="display: flex;flex-direction: column">
                <van-tag type="primary" style="margin-left: auto;margin-bottom: 5px">{{ com.state }}</van-tag>
                <div
                    style="overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
                  {{ com.sku.title }}
                </div>
              </div>
            </template>
            <template #tags>
              <div
                   style="background: rgb(249,249,249);color: rgb(152,152,152);overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
                {{ com.sku.title }}
                <van-icon name="arrow-down"/>
              </div>
            </template>

            <template #footer>
              <div style="font-size: 14px;font-weight: 600">
                实付款￥{{com.price}}
              </div>
            </template>
          </van-card>
        </div>
      </van-swipe-cell>
    </div>
  </div>
</template>

<script>
export default {
  name: "orderState",
  props: {
    state: String
  },
  data() {
    return {
      active: 0,
      stateEnum: [
        {k: "全部", v: 0, enum: null},
        {k: "未支付", v: 1, enum: 'UNPAID'},
        {k: "待发货", v: 2, enum: 'PAID'},
        {k: "待收获", v: 3, enum: 'DELIVERED'},
        {k: "待评价", v: 4, enum: 'RECEIVED'},
        {k: "已完成", v: 5, enum: 'CLOSED'}
      ],
      commodity: []
    }
  },
  methods: {
    onClickTab(v) {
      this.active = v
      this.initOrder()
    },
    initOrder() {
      let url = '';
      if (this.active == 0) {
        url = `/orders`
      } else {
        url = `/orders?state=${this.stateEnum[this.active].enum}`
      }
      this.getRequst(url).then(resp => {
        this.commodity = resp

        let map=new Map;
        this.stateEnum.forEach(v=>{
          map.set(v.enum,v.k)
        })


        this.commodity.forEach(v=>{
          v.state=map.get(v.state)
        })

        console.log(resp)
      })
    }
  },
  mounted() {
    console.log(this.state)
    this.active = parseInt(this.state)
    this.initOrder()
  }
}
</script>

<style scoped>

</style>