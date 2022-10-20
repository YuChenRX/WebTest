<template>
  <div style="height: 100vh;display: flex;flex-direction: column;justify-content: space-between ">
    <van-nav-bar
        :title="`我的足迹(${footprint.length})`"
        left-arrow
        @click-left="$router.push('/navigation/personal')">
    </van-nav-bar>

    <!--  足迹展示  -->
    <div style="background: white;height: 85%;border-radius: 20px 20px 0 0;padding: 10px">
      <van-row v-for="(v1,i) in data" :key="i" style="margin-top: 10px">
        <span style="font-size: 15px;margin-left: 15px">
          {{ v1.k }}
        </span>
        <br>
        <van-col span="8" v-for="v2 in v1.v" :key="v2.id" @click="$router.push(`/goodsDetailed/${v2.product.id}/0`)">
          <van-image
              width="100%"
              height="100%"
              fit="contain"
              :src="v2.product.carousel[0]"
          />
          <span style="color: red;margin-left: 14px">
            <span style="font-size: 14px">
              ￥
            </span>
            <span style="font-size: 16px">
              {{ v2.product.price }}
            </span>
          </span>
        </van-col>
      </van-row>
    </div>
  </div>
</template>

<script>

export default {
  name: "footprint",
  data() {
    return {
      page: 1,
      footprint: [],
      data: []
    }
  },
  methods: {
    init() {
      this.getRequst(`/footprints?page=${this.page}`).then(resp => {
        this.footprint = resp
        this.footprint.forEach(v => {
          let date = new Date(v.updatedAt);
          v.updatedAt = `${date.getMonth()}月${date.getDay()}日`
        })
        this.handler()
        console.log(this.footprint)
      })
    },
    handler() {
      let footprint = this.footprint;


      let map = new Map();
      footprint.map((foot) => {
        let updatedAt = foot.updatedAt;
        if (!map.has(updatedAt)) {
          map.set(updatedAt, []);
        }

        let a = map.get(updatedAt);
        a.push(foot)
      })

      console.log(map)

      let data = [];
      map.forEach((v, k) => {
        data.push({k, v})
      })

      data.sort((v1, v2) => {
        return v1.k < v2.k
      })

      console.log(data)
      this.data = data;
    }
  },
  created() {
    this.init()
  }
}
</script>

<style scoped>

</style>