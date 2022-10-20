<template>
  <div>
    <div>
      <div style="display: block; padding-top: 10px">
        <van-cell-group inset style="margin-top: 10px; background: #efefef">
          <!--      这是设置-->
          <div style="display: flex; justify-content: right;margin-left: 85vw;">
            <van-icon name="setting-o" size="20px" @click="setting"/>
          </div>
          <van-row
              gutter="20"
              style="display: flex; align-items: center; height: 80px"
          >
            <!-- 这是头像 -->
            <van-col span="5">
              <van-image
                  round
                  style="width: 100%; height: 100%"
                  :src="admin.imageUrl"
              ></van-image>
            </van-col>
            <van-col
                span="19"
                style="
                height: 100%;
                font-size: 20px;
                font-weight: bold;
                display: flex;
                align-items: center;
              "
            >
              <span @click="login" style="font-size: 18px"> {{ admin.name }}</span>
            </van-col>
          </van-row>
        </van-cell-group>

        <van-cell-group inset style="margin-top: 10px">
          <van-cell>
            <van-row
                justify="space-between"
                style="
                text-align: center;
                color: rgb(166, 47, 67);
                font-size: 18px;
              "
            >
              <van-col span="6">{{ admin.balance }}</van-col>
              <van-col span="6">{{ admin.coupon }}0</van-col>
              <van-col span="6">{{ admin.buyQuantity }}0</van-col>
              <van-col span="6">{{ admin.credit }}</van-col>
            </van-row>
          </van-cell>
          <van-cell>
            <van-row
                justify="space-between"
                style="text-align: center; font-size: 15px"
            >
              <van-col span="6">余额</van-col>
              <van-col span="6">优惠券</van-col>
              <van-col span="6">购买数</van-col>
              <van-col span="6">积分</van-col>
            </van-row>
          </van-cell>
        </van-cell-group>

        <van-cell-group inset style="margin-top: 10px">
          <van-row
              style="text-align: center; margin-top: 15px; margin-bottom: 15px;font-size: 12px"
          >


            <van-col span="5" class="order-icon"
                     @click="$router.push('/navigation/orderState/1')">
              <van-icon name="shop-o" size="25px" :badge="orderCount.UNPAID"/>
              <span>未支付</span>
            </van-col>
            <van-col span="5" class="order-icon"
                     @click="$router.push('/navigation/orderState/2')">
              <van-icon name="shop-collect-o" size="25px" :badge="orderCount.PAID"/>
              <span>待发货</span>
            </van-col>
            <van-col span="5" class="order-icon"
                     @click="$router.push('/navigation/orderState/3')">
              <van-icon name="logistics" size="25px" :badge="orderCount.DELIVERED"/>
              <span>待收货</span>
            </van-col>
            <van-col span="5" class="order-icon"
                     @click="$router.push('/navigation/orderState/4')">
              <van-icon name="cart-o" size="25px" :badge="orderCount.RECEIVED"/>
              <span>待评价</span>
            </van-col>
            <van-col span="4" class="order-icon"
                     @click="$router.push('/navigation/orderState/5')">
              <van-icon name="cart-o" size="25px"/>
              <span>完成</span>
            </van-col>
          </van-row>
        </van-cell-group>

        <van-cell-group inset style="margin-top: 10px">
          <van-cell is-link @click="myPurse">
            <!-- 使用 title 插槽来自定义标题 -->
            <template #title>
              <div style="display: flex; align-items: center">
                <span class="custom-title" style="font-size: 16px"
                >我的钱包</span
                >
                <van-icon
                    name="gold-coin-o"
                    size="22"
                    style="margin-left: 8px"
                />
              </div>
            </template>
          </van-cell>

          <van-cell is-link @click="$router.push('/myCollection')">
            <!-- 使用 title 插槽来自定义标题 -->
            <template #title>
              <div style="display: flex; align-items: center">
                <span class="custom-title" style="font-size: 16px"
                >我的收藏</span
                >
                <van-icon
                    name="underway-o"
                    size="22"
                    style="margin-left: 8px"
                />
              </div>
            </template>
          </van-cell>

          <van-cell is-link @click="$router.push('/footprint')">
            <!-- 使用 title 插槽来自定义标题 -->
            <template #title>
              <div style="display: flex; align-items: center">
                <span class="custom-title" style="font-size: 16px"
                >我的足迹</span
                >
                <van-icon
                    name="gold-coin-o"
                    size="22"
                    style="margin-left: 8px"
                />
              </div>
            </template>
          </van-cell>
        </van-cell-group>
      </div>
      <router-view/>
    </div>
    <down/>
  </div>
</template>

<script>
import Down from "@/views/home/down";

export default {
  name: "Personal",
  components: {Down},
  data() {
    return {
      admin: {
        name: "未登录请登录",
        balance: null,
        coupon: null,
        buyQuantity: null,
        credit: null,
        imageUrl:
            "https://guxianimg-1307121012.cos.ap-shanghai.myqcloud.com/md/QQ图片20211221210034.jpg",
      },
      orderCount: {}
    };
  },
  methods: {
    initOrderCount() {
      this.getRequst('/orders/count').then(resp => {
        this.orderCount = resp
        console.log(resp);
      })
    },
    initAdmin() {
      if (window.localStorage.getItem("token")) {
        this.getRequst("/users/me").then((resp) => {
          this.admin.name = resp.name;
          this.admin.balance = resp.balance;
          this.admin.credit = resp.credit;
        });
      }
    },
    login() {
      if (!window.localStorage.getItem("token")) {
        this.$router.push("/login");
      }
    },
    setting() {
      this.$router.push("/setting");
    },
    myPurse() {
      this.$router.push("/myPurse");
    },
  },
  mounted() {
    this.initAdmin();
    this.initOrderCount();
    window.sessionStorage.setItem("homePage", 4);
  },
};
</script>

<style>
.layout {
  background: white;
  border-radius: 15px;
  width: 100%;
}
.order-icon{
  display: flex;
  flex-direction: column;
  padding: 0 14px;
}
</style>