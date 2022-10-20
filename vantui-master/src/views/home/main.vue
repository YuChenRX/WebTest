<template>
	<div>
		<van-search shape="round" plac disabled @click="$router.push('/popup')" placeholder="请输入搜索关键词" />
		<!--轮播图-->
		<van-swipe class="my-swipe" :autoplay="3000" indicator-color="red">
			<van-swipe-item v-for="item in banner" :key="item.id">
				<img :src="item.image" alt="" width="100%" style="display: block" />
			</van-swipe-item>
		</van-swipe>

		<van-grid :column-num="2">
			<van-grid-item icon="cart-o" text="全部商品" to="/navigation/goodsList" />
			<van-grid-item icon="coupon-o" text="优惠券" />
    </van-grid>
    <van-grid :column-num="2">
			<van-grid-item icon="bag-o" text="积分商品"/>
			<van-grid-item icon="gift-o" text="积分签到" @click="clockIn()" />
		</van-grid>
	</div>

</template>

<script>
	import Slide from "@/views/home/slide";
	import Down from "@/views/home/down";
	import {
		Toast
	} from 'vant';

	export default {
		name: "Home",
		components: {
			Down,
			Slide
		},
		data() {
			return {
				show: false,
				banner: [],
				channel: [],
				newGoodsList: [],
				hotGoodsList: [],
				brandList: [],
				topicList: [],
				categoryList: [],
			};
		},
		methods: {
			clockIn() {
				this.postRequst('/clockIn').then(resp => {
					Toast(resp.message);
				})
			},
			initHomeDate() {
				this.getRequst("/banners").then((resp) => {
					if (resp) {
						this.banner = resp;
					}
				});
			},
		},

		mounted() {
			this.initHomeDate();
			window.sessionStorage.setItem('homePage', 0)
		},
	};
</script>

<style scoped>

</style>
