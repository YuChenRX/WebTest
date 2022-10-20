import axios from "axios";

const localhost = axios.create({
    timeout: 5000,
    // baseURL: 'http://101.34.229.217:8081/',
    // baseURL: 'https://yang-selections-morocco-lot.trycloudflare.com/',
    baseURL: 'http://192.168.1.103:8082/',
    disableHostCheck: true,
})

localhost.interceptors.request.use(config => {
    if (config.url !== '/signin') {
        if (window.localStorage.getItem('token')) {
            config.headers['Authorization'] = "Bearer " + window.localStorage.getItem('token');
        }
    }
    return config;
}, error => {
    console.log(error)
})

localhost.interceptors.response.use(
    success => {
        return success.data
    },
    error => {
        return Promise.reject(error)
    }
)

const base = '';
export const postRequst = (url, params) => {
    return localhost({
        method: 'post',
        url: `${base}${url}`,
        data: params
    })
}

export const getRequst = (url, params) => {
    return localhost({
        method: 'get',
        url: `${base}${url}`,
        params: params
    })
}

export const putRequst = (url, params) => {
    return localhost({
        method: 'put',
        url: `${base}${url}`,
        data: params
    })
}

export const deleteRequst = (url, params) => {
    return localhost({
        method: 'delete',
        url: `${base}${url}`,
        data: params
    })
}

export default localhost;

