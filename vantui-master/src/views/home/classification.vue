<template>
  <div>
    <van-nav-bar
        title="商品分类"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />


    <div style="display: flex">
      <div>
        <van-sidebar v-model="father" @change="myChange">
          <van-sidebar-item v-for="type in list" :title="type.name" :key="type.tid"/>
        </van-sidebar>
      </div>

      <div>
        <van-grid :column-num="3">
          <van-grid-item v-for="c in child" :key="c.tid" style="width: 25vw">
            <van-image :src="c.url" width="100" height="100" style="text-align: center;font-size: 10px">
              <template v-slot:default>{{ c.name }}</template>
            </van-image>
          </van-grid-item>
        </van-grid>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "classification",
  data() {
    return {
      father: 0,
      list: [],
      child: []
    }
  },
  methods: {
    onClickLeft() {
      this.$router.back()
    },
    initList() {
      this.getRequst('products_type/type').then(resp => {
        this.list = resp
        this.myChange(0)
      })
    },
    myChange(index) {
      this.child = this.list[index].childTypeList
    }
  },
  mounted() {
    this.initList()
  }
}
</script>

<style scoped>

</style>