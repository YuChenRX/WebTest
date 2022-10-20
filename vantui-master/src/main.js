import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuex from 'vuex'

import './plugins/vant.js'

Vue.config.productionTip = false
import {getRequst} from './axios/requst'
import {postRequst} from './axios/requst'
import {putRequst} from './axios/requst'
import {deleteRequst} from './axios/requst'


Vue.prototype.postRequst = postRequst;
Vue.prototype.getRequst = getRequst;
Vue.prototype.deleteRequst = deleteRequst;
Vue.prototype.putRequst = putRequst;
Vue.use(Vuex)
const store = new Vuex.Store({})

new Vue({
    router,
    store,
    beforeCreate() {
        Vue.prototype.$bus = this
    },
    render: function (h) {
        return h(App)
    }
}).$mount('#app')

