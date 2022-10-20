<template>
  <div>
    <div style="height: 5vh;display: flex;align-items: center;padding: 15px 0 0 15px">
			<span style="font-size: 20px">
				<van-icon name="arrow-left"/>购物车
			</span><span style="font-size: 14px">({{ commodity.length }})</span>
    </div>

    <div>
      <van-swipe-cell v-for="com in commodity" :key="com.id">
        <!--    购物车内商品信息-->
        <div style="background: rgb(250,250,250);margin: 0 5px 10px 5px;border-radius: 10px;display: flex">
          <!--        复选框-->
          <van-checkbox v-model="com.checked" @click="computePrice" style="margin: 0 5vw 0 3vw;width: 7vw">
          </van-checkbox>
          <!--        信息-->
          <van-card :num=com.amount :price=com.sku.price :thumb=com.sku.image
                    style="margin: 0 10px;width: 100%;" @click-thumb="clickThumb(com.product.id)">
            <template #title>
              <div
                  style="overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
                {{ com.product.title }}
              </div>
            </template>
            <template #desc>
              <div
                  style="overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
                {{ com.product.description }}
              </div>
            </template>
            <template #num style="font-size: 50px">
              <!--            数量步进器-->
              <van-stepper @change="changeNumber(com)" v-model="com.amount"
                           disable-input/>
            </template>

            <template #tags>
              <div @click="toShow(com)"
                   style="background: rgb(249,249,249);color: rgb(152,152,152);overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
                {{ com.sku.title }}
                <van-icon name="arrow-down"/>
              </div>
            </template>
          </van-card>
        </div>
        <template #right>
          <van-button square type="danger" text="删除" style="height: 100%;" @click="deleteCom(com)"/>
        </template>
      </van-swipe-cell>
    </div>
    <van-submit-bar style="margin-bottom: 50px" :loading="tradeStatus" :price="totalPrice" button-text="提交订单"
                    @submit="billPlease">
      <van-checkbox v-model="checkedAll" @click="checkAll">全选</van-checkbox>
    </van-submit-bar>


    <!--    商品规格选择-->
    <van-sku v-model="show" :initial-sku="initialSku" :sku="sku" ref="sku" :goods="goods" :goods-id="1">
      <template #sku-actions="props">
        <div class="van-sku-actions">
          <van-button square size="large" type="warning" @click="saveSku">
            确认
          </van-button>
        </div>
      </template>
    </van-sku>

    <!--    加载-->
    <van-overlay :show="loading" style="width: 100vw;height: 100vh">
      <div style="display: flex;
          align-items: center;
         justify-content: center;
         height: 100vh;">
        <van-loading size="50" color="#0094ff"/>
      </div>
    </van-overlay>
  </div>
</template>

<script>
import {Toast} from 'vant';

export default {
  name: "shoppingCart",
  data() {
    return {
      tradeStatus: false,
      id: 0,
      cartId: 0,
      loading: false,
      goods: {
        // 默认商品 sku 缩略图
        picture: 'https://img11.360buyimg.com/seckillcms/s280x280_jfs/t1/148596/40/19991/196900/615a7481E2e6eb51a/2a029d17f401cdc5.jpg.webp'
      },
      initialSku: {}, //默认选中的数据
      sku: {},
      totalPrice: 0,
      commodity: [],
      checkedAll: false,
      show: true,
    }
  },
  methods: {
    deleteCom(com) {
      this.deleteRequst('/shoppingCart/' + com.id).then(resp => {
        this.initTotalPrice()
      })
    },
    clickThumb(id) {
      this.$router.push(`/goodsDetailed/ ${id}/1`)
    },
    //修改规格后保存
    saveSku() {
      this.loading = true;
      this.show = false
      let sku = this.$refs.sku.getSkuData()
      this.putRequst('/shoppingCart/' + this.cartId, {
        productId: this.id,
        amount: sku.selectedNum,
        skuId: sku.selectedSkuComb.id
      }).then(resp => {
        this.loading = false
        this.initTotalPrice()
      })
    },
    //初始化商品规格列表里的信息
    toShow(com) {
      this.id = com.product.id
      this.cartId = com.id
      console.log(`初始化sku${com.product.id}`)

      const initialSku = {}
      initialSku.selectedNum = com.amount
      com.sku.indexes.split("_").forEach((v, i) => {
        initialSku[`id${i}`] = parseInt(v) + 1
      })
      this.initialSku = initialSku

      const sku = {
        price: '1.00', // 默认价格（单位元）
        stock_num: 227, // 商品总库存
        collection_id: 2261,
      }

      sku.tree = Object.entries(com.product.sku).map(([k, v], idx) => ({
        k: k,
        k_s: `id${idx}`,
        v: v.map((item, idx) => ({
          id: idx + 1,
          name: item.name,
          previewImgUrl: item.image,
        }))
      }));
      sku.list = com.product.skuDetails.map(v => {
        let newVar = {
          id: v.id,
          price: v.price * 100,
          stock_num: v.stock,
        };
        v.indexes.split("_").forEach((v, idx) => {
          newVar[`id${idx}`] = parseInt(v) + 1
        })
        return newVar
      })

      this.sku = sku

      this.show = true
    },
    // 计算总价
    computePrice() {
      let sum = 0;
      let num = 0;
      this.commodity.forEach(com => {
        if (com.checked) {
          sum += com.sku.price * com.amount * 100
          num++;
        }
      })
      this.totalPrice = sum
      this.checkedAll = num === this.commodity.length;
    },
    //全选商品
    checkAll() {
      this.commodity.forEach(com => {
        com.checked = this.checkedAll
      })
      this.computePrice()
    },
    //初始化
    initTotalPrice() {
      this.getRequst('/shoppingCart').then(resp => {
        this.commodity = resp
      })

      this.commodity.forEach(comm => {
        comm.checked = true
        comm.doublePrice = comm.sku.price / 100
      })
    },
    //修改商品数量
    changeNumber(com) {
      this.putRequst('/shoppingCart/' + com.id, {
        amount: com.amount,
        skuId: com.sku.id,
        productId: com.product.id
      }).then(resp => {
      })
      this.computePrice()
    },
    //准备去支付
    billPlease() {
      let pay = []
      this.commodity.forEach(com => {
        if (com.checked) {
          pay.push(com.id)
        }
      })
      if (pay.length < 1) {
        Toast('请至少选择一个商品');
      } else {
        window.sessionStorage.setItem('pay', JSON.stringify(pay))
        this.$router.push('/settlement')
      }
    }
  },
  mounted() {
    this.initTotalPrice()
  }
}
</script>

<style scoped>

</style>
