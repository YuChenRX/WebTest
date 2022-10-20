<template>
  <div>
    <van-nav-bar
        title="我的钱包"
        left-text="返回"
        left-arrow
        @click-left="$router.back()"
    />

    <van-cell-group inset
                    style="margin-top: 20px;height: 15vh;align-items: center;display: flex;flex-direction: column">
      <div
          style="background: rgb(227,239,255);width: 100%;text-align: center;color: rgb(23,120,253);line-height: 30px;">
        <van-icon name="good-job-o"/>
        资金安全无保障
      </div>
      <table style="min-width: 100%;align-content: center;text-align: center;max-width: 100%;margin-top: 30px">
        <tr>
          <td>总资产(元)</td>
          <td>累计充值(元)</td>
          <td>累计消费(元)</td>
        </tr>
        <tr>
          <td>{{ admin.balance }}</td>
          <td>{{ admin.toppedUpAmount }}</td>
          <td>{{ admin.expenditure }}</td>
        </tr>
      </table>
    </van-cell-group>

    <van-cell-group inset style="margin-top: 15px;display: flex;flex-direction: column;align-items: center">
      <van-cell v-for="r in rechargePlan" :key="r.id">
        <div style="display: flex;font-size: 17px;align-items: center;line-height: 20px">
          <van-icon name="shop-o" size="20"/>
          充值{{ r.min }}¥ 赠送{{ r.extra }}¥
          <van-button round type="primary" size="mini" style="margin-left: auto;padding: 12px 15px"
                      @click="recharge(r.id)">充值
          </van-button>
        </div>
      </van-cell>
    </van-cell-group>
  </div>
</template>

<script>
export default {
  name: "myPurse",
  data() {
    return {
      admin: {},
      rechargePlan: []
    }
  },
  methods: {
    recharge(rid) {
      this.postRequst('/top_up_plans/' + rid + '/top_up').then(resp => {
        this.initAdmin()
        this.initPlans()
      })
    },
    initPlans() {
      this.getRequst('/top_up_plans').then(resp => {
        this.rechargePlan = resp
      })
    },
    initAdmin() {
      this.getRequst("/users/me").then((resp) => {
        this.admin = resp
      });
    },
  },
  mounted() {
    this.initPlans()
    this.initAdmin()
  }
}
</script>

<style scoped>

</style>