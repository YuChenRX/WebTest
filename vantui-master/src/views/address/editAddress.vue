<template>
  <div style="width: 100vw;height: 100vh">

    <!--    加载-->
    <van-overlay :show="show" @click="show = false">
      <div class="wrapper" @click.stop>
        <van-loading color="#1989fa"/>
      </div>
    </van-overlay>

    <van-nav-bar @click-left="$router.back()" style="background: rgb(239,239,239);height: 5%"
                 title="编辑收货地址          "
                 left-text="" left-arrow>
      <template #right>
        <span style="color: rgb(226,79,10)" @click="deleteAddress">
          删除
        </span>
      </template>
    </van-nav-bar>

    <van-address-edit
        :area-list="areaList"
        show-set-default
        show-search-result
        show-delete
        :address-info="addressInfo"
        :is-saving="saving"
        :area-columns-placeholder="['请选择', '请选择', '请选择']"
        @delete="deleteAddress"
        @save="save"/>

  </div>
</template>

<script>
import {areaList} from '@vant/area-data';
import {Notify} from 'vant';

export default {
  name: "editAddress",
  data() {
    return {
      id: '',
      areaList: areaList,
      show: false,
      saving: false,
      addressInfo: {
        "name": "",
        "tel": "",
        "province": "",
        "city": "",
        "county": "",
        "areaCode": "",
        "addressDetail": "",
        "isDefault": false
      }
    }
  },
  methods: {
    initAddress() {
      this.getRequst('/addresses/' + this.id).then(resp => {
        console.log(resp);
        this.addressInfo.name = resp.name
        this.addressInfo.tel = resp.phoneNumber
        this.addressInfo.province = resp.province
        this.addressInfo.city = resp.city
        this.addressInfo.county = resp.addressLine1
        this.addressInfo.areaCode = resp.areaCode
        this.addressInfo.addressDetail = resp.addressLine2
        this.addressInfo.isDefault = resp.def
      })
    },
    deleteAddress() {
      this.show = true;
      this.deleteRequst('/addresses/' + this.id).then(resp => {
        this.show = false;
        Notify({type: 'primary', message: '删除成功', duration: 800});
        this.$router.push('/address')
      })
    },
    save(data) {
      this.show = true
      this.putRequst('/addresses/' + this.id, {
        name: data.name,
        phoneNumber: data.tel,
        province: data.province,
        city: data.city,
        addressLine1: data.county,
        areaCode: data.areaCode,
        addressLine2: data.addressDetail,
        def: data.isDefault
      }).then(resp => {
        this.show = false;
        Notify({type: 'primary', message: '修改成功', duration: 500});
        this.$router.push('/address')
      })
    },
  },
  created() {
    this.id = window.sessionStorage.getItem('addressId')
    this.initAddress()
  }
}
</script>

<style scoped>
.wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
</style>