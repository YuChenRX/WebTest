<template>
  <div>
    <div style="height: 5vh;display: flex;align-items: center;padding: 15px 0 0 15px">
			<span style="font-size: 20px" @click="$router.back()">
				<van-icon name="arrow-left"/>确认订单
			</span>
    </div>

    <!--    收货地址-->
    <div>
      <van-swipe-cell>
        <!--    地址-->
        <van-cell-group style="border-radius: 15px;margin: 0 10px 5px 10px;height: 100px;display: flex">
          <!--      左边-->
          <div style="height: 100%;width: 15%;display: flex;align-items: center">
            <van-icon name="location-o" style="margin-left: 5vw" size="25"/>
          </div>
          <!--      中间-->
          <div style="width: 75%;padding-top: 20px;">
            <div style="align-items: center;display: flex;line-height: 20px;margin-bottom: 7px;">
							<span
                  style="font-size: 17px;color: rgb(13,13,13);font-weight: 550;">{{ address.name }}</span>
              <span
                  style="font-size: 15px;color: rgb(155,155,155);margin-left: 7px">{{ address.phoneNumber }}
							</span>
              <van-tag plain type="danger" v-if="address.def" style="margin-left: 7px">默认</van-tag>
            </div>
            <span style="color: rgb(62,62,62);">{{ address.province }}&nbsp;{{
                address.city
              }}&nbsp;{{ address.addressLine1 }}&nbsp;{{
                address.addressLine2
              }}</span>
          </div>
          <!--      右边-->
          <div style="height: 100%;width: 10%;display: flex;align-items: center">
            <van-icon name="arrow" size="25" @click="$router.push('/chooseAddress')"/>
          </div>
        </van-cell-group>
      </van-swipe-cell>
    </div>

    <!--    商品展示-->
    <div
        style="background: rgb(250,250,250);margin: 5px 10px 10px 10px;border-radius: 10px;display: flex;flex-direction: column;"
        v-for="com in commodity" :key="com.id">
      <!--        信息-->
      <van-card :num="com.amount" :price="com.selectedSku.price" :thumb="com.selectedSku.image"
                style="width: 100%;border-radius: 10px;">
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
          x{{ com.amount }}
        </template>

        <template #tags>
          <div
              style="background: rgb(249,249,249);color: rgb(152,152,152);overflow: hidden;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;">
            {{ com.selectedSku.title }}
            <van-icon name="arrow-down"/>
          </div>
        </template>

        <template #bottom>
          <a href="=-=-=-="></a>
        </template>
      </van-card>

      <div style="margin: 5px 10px 10px 13px;display: flex;">
        订单备注
        <span style="margin-left: auto;color: rgb(151,151,151);" @click="editNote(com)" title="" v-show="com.note==''">
					无备注
					<van-icon name="arrow"/>
				</span>
        <span style="margin-left: auto;" @click="editNote(com)" title="" v-show="com.note!=''">
					{{ com.note }}
					<van-icon name="arrow"/>
				</span>
      </div>
    </div>

    <!--    底下-->
    <van-submit-bar :loading="loading" :price="price*100" button-text="提交订单" @submit="onSubmit"/>
    <!-- 备注编辑 -->
    <van-popup v-model="Noteshow" round position="bottom" closeable :style="{ height: '80%' }">
      <center>
        <h3>订单备注</h3>
        <van-field v-model="note" rows="7" autosize type="textarea" maxlength="200" placeholder="请输入留言"
                   show-word-limit style="background: rgb(245,245,245);border-radius: 10px;width: 95%;"/>

        <van-button round color="linear-gradient(to right, #ff6034, #ee0a24)"
                    style="width: 90%;margin-top: 30vh;" @click="addNote">
          确定
        </van-button>
      </center>
    </van-popup>
  </div>
</template>

<script>
import {Notify} from "vant";

export default {
  name: "settlement",
  props: {
    infor: String
  },
  data() {
    return {
      loading:false,
      id: 0,
      note: '',
      Noteshow: false,
      address: {},
      commodity: [],
      price: 0,
      pay: []
    }
  },
  methods: {
    addNote() {
      this.commodity.forEach(com => {
        if (com.id == this.id) {
          com.note = this.note
        }
      })
      this.Noteshow = false
    },
    editNote(com) {
      this.id = com.id
      this.Noteshow = true
      this.note = com.note
    },
    onSubmit() {
      this.loading=true;
      this.postRequst('/sku/buy',this.pay).then(resp=>{
        if (resp.ok){
          Notify({type: 'success', message: resp.msg});
          this.$router.push('/navigation/orderState/2')
        }else {
          Notify({type: 'danger', message: resp.msg});
          this.loading=false;
        }
      })
    },
    initAdminAddress() {
      let id = window.sessionStorage.getItem('address');
      this.getRequst('/addresses').then(resp => {
        if (resp) {
          resp.forEach(addres => {
            if (id == null || id == '' || id == undefined) {
              if (addres.def) {
                this.address = addres
              }
            } else {
              if (addres.id == id) {
                this.address = addres
              }
            }
          })
        }
      })
    },
    //初始化
    initTotalPrice() {
      this.postRequst('/sku/calc',this.pay).then(resp=>{
        this.price=resp.price
        this.commodity=resp.items
      })
    },
  },
  mounted() {
    this.pay = JSON.parse(this.infor)
    this.initAdminAddress()
    this.initTotalPrice()
  }
}
</script>

<style scoped>

</style>
