import Vue from 'vue'
import VueRouter from 'vue-router'
import main from "@/views/home/main";
import Personal from "@/views/home/Personal";
import login from "@/views/home/login";
import setting from "@/views/home/setting";
import navigation from "@/views/home/navigation";
import shoppingCart from "@/views/goods/shoppingCart";
import DiyPopup from "@/views/serach/DiyPopup";
import address from "@/views/address/address";
import editAddress from "@/views/address/editAddress";
import addAddress from "@/views/address/addAddress";
import down from "@/views/home/down";
import classification from "@/views/home/classification";
import scoreGoods from "@/views/goods/scoreGoods";
import goodsDetailed from "@/views/goods/goodsDetailed";
import myPurse from "@/views/home/myPurse";
import register from "@/views/home/register"
import settlement from "@/views/goods/settlement";
import chooseAddress from "@/views/address/chooseAddress";
import myCollection from "@/views/home/myCollection";
import orderState from "@/views/goods/orderState";
import footprint from "@/views/home/footprint";


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/navigation/main'
    },
    {
        path: '/navigation',
        name: 'navigation',
        component: navigation,
        meta: {
            index: 0
        },
        children: [
            {
                path: 'main',
                components: {
                    default: main,
                    down: down
                },
                meta: {
                    index: 0
                }
            },
            {
                path: 'personal',
                components: {
                    default: Personal,
                    down: down
                },
                meta: {
                    index: 4
                }
            },
            {
                path: 'shoppingCart',
                components: {
                    default: shoppingCart,
                    down: down
                },
                meta: {
                    index: 3
                }
            },
            {
                path: 'classification',
                components: {
                    default: classification,
                    down: down
                },
                meta: {
                    index: 1
                }
            },
            // {
            //     path: 'goodsList/keywords/:words',
            //     components: {
            //         default: goodsList,
            //         down: down
            //     },
            //     props: {
            //         default: true
            //     }
            // },
            // {
            //     path: 'goodsList/',
            //     components: {
            //         default: goodsList,
            //         down: down
            //     },
            // },
            {
                path: 'scoreGoods',
                components: {
                    default: scoreGoods,
                    down: down
                }
            },
            {
                path: 'orderState/:state',
                components: {
                    default: orderState,
                    down: down
                },
                props: {
                    default: true
                }
            }
            ,]
    },
    {
        path: '/login',
        component: login,
        meta: {
            index: 1
        }
    },
    {
        path: '/setting',
        component: setting,
        meta: {
            index: 2
        }
    },
    {
        path: '/popup',
        component: DiyPopup,
        meta: {
            index: 3
        }
    },
    {
        path: '/address',
        component: address,
        meta: {
            index: 4
        }
    },
    {
        path: '/editAddress',
        component: editAddress,
        meta: {
            index: 5
        }
    },
    {
        path: '/addAddress',
        component: addAddress,
        meta: {
            index: 6
        }
    },
    {
        path: '/goodsDetailed/:id/:mode',
        component: goodsDetailed,
        props: true
    },
    {
        path: '/myPurse',
        component: myPurse
    },
    {
        path: '/register',
        component: register
    },
    {
        path: '/settlement/:infor',
        component: settlement,
        props: true
    },
    {
        path: '/chooseAddress',
        component: chooseAddress
    }, {
        path: '/myCollection',
        component: myCollection
    }, {
        path: '/footprint',
        component: footprint
    }
]

const router = new VueRouter({
    routes
})

export default router
