<template>
	<div style="width: 100vw;height: 100vh">
		<div style="background-color: white;height: 100vh;">
			<van-nav-bar title="注册" left-arrow @click-left="$router.back()" />

			<van-row style="align-items: center;height: 80vh;display: flex;">
				<van-form @submit="toRegister" style="width: 100%">
					<van-cell-group inset>
						<van-field v-model="admin.username" class="loginInput" placeholder="请输入账号"
							style="background-color: rgb(239,239,239)" />
					</van-cell-group>

					<van-cell-group inset>
						<van-field v-model="admin.name" placeholder="请输入昵称" class="loginInput"
							style="margin-top: 15px;background-color: rgb(239,239,239);border-radius: 10px;" />
					</van-cell-group>


					<van-cell-group inset>
						<van-field v-model="admin.password" placeholder="请输入密码" class="loginInput" type="password"
							style="margin-top: 15px;background-color: rgb(239,239,239);border-radius: 10px;" />
					</van-cell-group>

					<van-cell-group inset>
						<van-field v-model="admin.password2" placeholder="请确认密码" class="loginInput" type="password"
							style="margin-top: 15px;background-color: rgb(239,239,239);border-radius: 10px;" />
					</van-cell-group>

					<div style="margin: 16px;">
						<van-button round block type="info" native-type="submit" style="margin-top: 5px">
							注册
						</van-button>
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
		Toast
	} from 'vant';
	import {
		Notify
	} from 'vant';
	export default {
		name: 'register',
		data() {
			return {
				loading: false,
				admin: {
					name: '',
					username: '',
					password: '',
					password2: ''
				}
			}
		},
		methods: {
			toRegister() {
				if (this.admin.password == '' || this.admin.password2 == '' || this.admin.username == '') {
					Notify({
						type: 'danger',
						message: '请填写所有信息'
					});
				} else if (this.admin.password === this.admin.password2) {
					this.loading = true
					this.postRequst('/signup', {
						username: this.admin.username,
						password: this.admin.password,
						name:this.admin.name
					}).then(resp => {
						window.localStorage.setItem('token', resp.token)
						this.loading=false
						this.$router.push('/navigation/personal')
					})
				} else {
					Notify({
						type: 'danger',
						message: '请重新输入密码'
					});
					this.admin.password = ''
					this.admin.password2 = ''
				}
			}
		}
	}
</script>

<style>
</style>
