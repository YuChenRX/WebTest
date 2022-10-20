<template>
	<div style="width: 100vw;height: 100vh">
		<div style="background-color: white;height: 100vh;">
			<van-nav-bar
			  title="登录"
			  left-arrow
			  @click-left="$router.back()"
			/>

			<van-row style="align-items: center;height: 80vh;display: flex;">
				<van-form @submit="login" style="width: 100%">
					<van-cell-group inset>
						<van-field v-model="admin.username" class="loginInput" placeholder="请输入用户名"
							style="background-color: rgb(239,239,239)" />
					</van-cell-group>

					<van-cell-group inset>
						<van-field v-model="admin.password" placeholder="请输入密码" class="loginInput" type="password"
							style="margin-top: 15px;background-color: rgb(239,239,239);border-radius: 10px;" />
					</van-cell-group>

					<div style="margin: 16px;">
						<van-button round block type="info" native-type="submit"
							style="margin-top: 5px">
							登录
						</van-button>
					</div>
					<div style="display: flex;justify-content: space-around;color: rgb(218,208,204);">
						<span @click="$router.push('/register')">新用户注册</span>
						<span @click="run">快速登录</span>
					</div>
				</van-form>
			</van-row>
		</div>

		<van-overlay :show="loading">
			<div style="display: flex;align-items: center;width: 100vw;height: 100vh;">
				<van-loading color="#1989fa" size="60" style="align-content: center;width: 100vw;text-align: center;" />
			</div>
		</van-overlay>

	</div>
</template>

<script>
	import {
		Notify
	} from "vant";

	export default {
		name: "login",
		data() {
			return {
				admin: {
					username: '',
					password: ''
				},
				loading: false
			}
		},
		methods: {
			run(){
				this.admin.username='admin'
				this.admin.password='123'
				this.login()
			},
			login() {
				this.loading = true;
				this.postRequst('/signin', this.admin).then(resp => {
					console.log(resp)
					if (resp) {
						console.log(resp.token)
						window.localStorage.setItem('token', resp.token)
						this.$router.push('/navigation/personal')
					}
				}).catch(resp => {
					this.loading = false;
					Notify('账号或密码错误');
				})
			},
			quit() {
				this.$router.push('/navigation/personal')
			}
		},
	}
</script>

<style scoped>
	.loginInput {
		font-size: 16px;
		height: 50px;
	}
</style>
