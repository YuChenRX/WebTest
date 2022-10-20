<template>
  <div>
    <van-nav-bar @click-left="$router.back()" style="background: rgb(239,239,239)" title="我的收货地址        "
                 left-text="" left-arrow>
      <template #right>
        <span style="color: rgb(226,79,10)">
          管理
        </span>
      </template>
    </van-nav-bar>

    <van-swipe-cell :key="addres.id" v-for="addres in address">
      <!--    地址-->
      <van-cell-group
          style="border-radius: 15px;margin: 0 10px 5px 10px;height: 100px;display: flex">
        <!--      左边-->
        <div style="height: 100%;width: 15%">

        </div>
        <!--      中间-->
        <div style="width: 75%;padding-top: 20px;" @click="chooseAddress(addres)">
          <div style="align-items: center;display: flex;line-height: 20px;margin-bottom: 7px;">
            <span style="font-size: 17px;color: rgb(13,13,13);font-weight: 550;">{{ addres.name }}</span>
            <span style="font-size: 15px;color: rgb(155,155,155);margin-left: 7px">{{ addres.phoneNumber }} </span>
            <van-tag plain type="danger" v-if="addres.def" style="margin-left: 7px">默认</van-tag>
          </div>
          <span style="color: rgb(62,62,62);">{{ addres.province }}&nbsp;{{
              addres.city
            }}&nbsp;{{ addres.addressLine1 }}&nbsp;{{
              addres.addressLine2
            }}</span>
        </div>
        <!--      右边-->
        <div style="height: 100%;width: 10%;display: flex;align-items: center">
          <van-icon name="edit" size="25" @click="editAddress(addres.id)"/>
        </div>
      </van-cell-group>

      <template #right>
        <van-button square text="删除" type="danger" class="delete-button" style="height: 100%"
                    @click="deleteAddress(addres.id)"/>
      </template>
    </van-swipe-cell>


    <van-tabbar style="display: flex;justify-content: center;align-items: center;padding: 5px 0 10px 0">
      <van-button round type="info" style="width: 90%" @click="addAddress">添加收货地址</van-button>
    </van-tabbar>
  </div>
</template>

<script>
import {Notify} from "vant";

export default {
  name: "chooseAddress",
  data() {
    return {
      address: [],
    }
  },
  methods: {
    chooseAddress(address) {
      console.log(address)
      window.sessionStorage.setItem('address', address.id)
      this.$router.back()
    },
    editAddress(id) {
      window.sessionStorage.setItem('addressId', id)
      this.$router.push('/editAddress')
    },
    initAdminAddress() {
      this.getRequst('/addresses').then(resp => {
        if (resp) {
          this.address = resp
        }
      })
    },
    addAddress() {
      this.$router.push('/addAddress')
    },
    deleteAddress(id) {
      this.show = true;
      this.deleteRequst('/addresses/' + id).then(resp => {
        this.show = false;
        Notify({type: 'primary', message: '删除成功', duration: 800});
        this.initAdminAddress()
      })
    },
  },
  mounted() {
    this.initAdminAddress()
  }
}
</script>

<style scoped>

</style>