<template>
  <div>
    <!--   搜索框-->
    <van-search
        shape="round"
        plac
        disabled
        @click="$router.push('/popup')"
        placeholder="请输入搜索关键词">
      <template #left>
        <van-icon name="arrow-left" style="margin-right: 10px" @click="$router.back()"/>
      </template>
    </van-search>

    <!--    轮播图-->
    <van-swipe @change="onChange">
      <van-swipe-item v-for="(image, index) in goods.carousel" :key="index">
        <img :src="image" width="100%" style="display: block"/>
      </van-swipe-item>
      <template #indicator>
        <div class="custom-indicator">{{ indicator }}</div>
      </template>
    </van-swipe>

    <div style="background: white;margin: 7px;border-radius: 10px;">
      <div style="display: flex;width: 100%">
        <div style="margin-left: 20px;margin-top: 5px">
          <span style=" color: red; font-size: 19px;">¥</span>
          <span style="color: red;font-size: 28px">{{ goods.left }}</span>
          <span style=" color: red; font-size: 19px;">.{{ goods.right }}</span>
        </div>

        <div style="margin-left: auto">
          <table style="color: rgb(203,203,203);text-align: center;font-size: 10px;margin-top: 3px;margin-right: 5px">
            <tr>
              <td>{{ goods.visitedTimes }}</td>
              <td>{{ goods.soldCount }}</td>
            </tr>
            <tr>
              <td>浏览</td>
              <td>销量</td>
            </tr>
          </table>
        </div>
      </div>
      <div style="margin:15px;padding-bottom: 20px;font-weight: 600;">
        {{ goods.title }}
      </div>
    </div>

    <div style="background: white;margin: 7px;border-radius: 10px;line-height: 50px">
      <div style="margin-left: 20px;display: flex" @click="toShow">
        选择规格:
        <van-icon name="arrow" style="margin-left: auto;display: flex;align-items: center;margin-right: 10px"/>
      </div>
    </div>

    <!--    商品规格-->
    <van-sku
        v-model="show"
        :sku="sku"
        ref="sku"
        :goods="image"
        :goods-id="0">
      <template #sku-actions="props">
        <div class="van-sku-actions">
          <van-button square size="large" type="warning" @click="addToShoppingCart">
            加入购物车
          </van-button>
          <van-button square size="large" type="warning" @click="placeOrder">
            立即购买
          </van-button>
        </div>
      </template>
    </van-sku>


    <!--    底下的导航栏-->
    <van-goods-action>
      <van-goods-action-icon icon="cart-o" text="购物车" @click="$router.push('/navigation/shoppingCart')"/>
      <van-goods-action-icon icon="star" text="收藏" color="#ff5000" v-show="collectState" @click="toCollect"/>
      <van-goods-action-icon icon="star-o" text="收藏" color="#ff5000" v-show="!collectState" @click="toCollect"/>
      <van-goods-action-button type="warning" text="加入购物车" @click="addToShoppingCart"/>
      <van-goods-action-button type="danger" text="立即购买" @click="show=true"/>
    </van-goods-action>
  </div>
</template>

<script>
import {Notify} from "vant";

export default {
  name: "goodsDetailed",
  props: {
    id: String,
    mode: String
  },
  data() {
    return {
      image: {},
      show: false,
      goods: {},
      current: 0,
      sku: {},
      indicator: '',
      collectState: false
    }
  },
  methods: {
    toShow() {
      this.show = true
    },
    //初始化
    initGoods() {
      this.getRequst('/products/' + this.id).then(resp => {
        let good = resp
        this.image.picture = resp.carousel[0]

        good.price *= 100;
        good.left = parseInt(good.price / 100)
        good.right = good.price - good.left * 100
        if (good.right == 0) {
          good.right = '00'
        }
        this.goods = good

        const sku = {
          price: good.left + '.' + good.right, // 默认价格（单位元）
          collection_id: 2261,
        }

        let nums = 0;
        resp.skuDetails.forEach(sku => {
          nums += sku.stock
        })
        sku.stock_num = nums

        console.log(this.goods)
        sku.tree = Object.entries(this.goods.sku).map(([k, v], idx) => ({
          k: k,
          k_s: `id${idx}`,
          v: v.map((item, idx) => ({
            id: idx + 1,
            name: item.name,
            previewImgUrl: item.image,
          }))
        }));
        sku.list = this.goods.skuDetails.map(v => {
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

        if (this.mode==1){
          console.log("足迹+1")
          this.postRequst(`/footprints/`,{productId: this.goods.id})
        }
      })
    },
    toCollect() {
      this.collectState = !this.collectState
      if (this.collectState) {
        this.postRequst('/favourites/?productId=' + this.id).then(resp => {

        })
      } else {
        this.deleteRequst('/favourites/' + this.id).then(resp => {

        })
      }
    },
    addToShoppingCart() {
      let data = this.$refs.sku.getSkuData();
      console.log(data)
      if (data.selectedSkuComb != null) {
        this.postRequst('shoppingCart', {
          skuId: data.selectedSkuComb.id,
          amount: data.selectedNum,
          productId: this.goods.id
        }).then(resp => {
          this.show = false
        })
      } else {
        Notify({type: 'danger', message: '请选择商品规格'});
      }
    },
    initCollectState() {
      this.getRequst('/favourites/?productId=' + this.id).then(resp => {
        this.collectState = resp == null;
      })
    },
    onChange(index) {
      this.indicator = index + 1 + '/' + this.goods.carousel.length
    },
    placeOrder(){
      let data = this.$refs.sku.getSkuData();
      if (data.selectedSkuComb == null) {
        Notify({type: 'danger', message: '请选择商品规格'});
      }else {
        let a=[{
          skuId:data.selectedSkuComb.id,
          amount:data.selectedNum
        }]
        this.$router.push(`/settlement/${JSON.stringify(a)}`)
      }
    }
  },
  mounted() {
    console.log(this.mode)
    this.initGoods()
    this.initCollectState()
  }
}
</script>

<style scoped>
.custom-indicator {
  position: absolute;
  right: 5px;
  bottom: 5px;
  padding: 2px 5px;
  font-size: 12px;
  background: rgba(0, 0, 0, 0.1);
}
</style>
