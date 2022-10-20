import Vue from 'vue'
import Vant, {Locale} from 'vant'
import 'vant/lib/index.css'
import {Tabbar, TabbarItem} from 'vant';
import {ActionSheet} from 'vant';
import { Toast } from 'vant';
import { Tab, Tabs } from 'vant';


Vue.use(Tab);
Vue.use(Tabs);
Vue.use(Toast);
Vue.use(ActionSheet);
Vue.use(Tabbar);
Vue.use(TabbarItem);
Vue.use(Vant)

