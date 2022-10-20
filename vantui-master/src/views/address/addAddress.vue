<template>
  <div style="width: 100vw;height: 100vh">
    <van-nav-bar @click-left="$router.back()" style="background: rgb(239,239,239);height: 5%"
                 title="添加收货地址        "
                 left-text="" left-arrow>
    </van-nav-bar>

    <van-address-edit
        :area-list="areaList"
        show-set-default
        show-search-result
        :is-saving="saving"
        :area-columns-placeholder="['请选择', '请选择', '请选择']"
        @save="save"/>

  </div>
</template>

<script>
import {areaList} from '@vant/area-data';

export default {
  name: "addAddress",
  data() {
    return {
      areaList: areaList,
      saving: false,
    }
  },
  methods: {
    showPop() {
      this.show = true

    },
    save(data) {
      console.log(data);
      this.saving = true;
      this.postRequst('/addresses', {
            name: data.name,
            phoneNumber: data.tel,
            province: data.province,
            city: data.city,
            addressLine1: data.county,
            areaCode: data.areaCode,
            addressLine2: data.addressDetail,
            def: data.isDefault
          }
      ).then(resp => {
        this.saving = false;
        this.$router.push('/address')
      })
    },
  },
}
</script>

<style scoped>

</style>