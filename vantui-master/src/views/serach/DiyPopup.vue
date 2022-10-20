<template>
  <div style="display: flex;flex-direction: column;background: white;height: 100vh">
    <div class="popup">
      <van-search
          v-model="searchValue"
          shape="round"
          plac
          show-action
          @search="onSearch"
          @cancel="onCancel"
          :placeholder="popular"/>
    </div>
    <div class="history">
      <van-row style="display: flex;align-items: center">
        <van-col span="10"><h4 style="margin-left: 17px">历史记录</h4></van-col>
        <van-col span="12" style="text-align: right">
          <van-icon name="delete-o" @click="deleteHistory"/>
        </van-col>
      </van-row>

      <!--    历史搜索展示区-->
      <div style="width: 90vw;margin-left: 5vw;display: flex;flex-wrap: wrap">
        <div class="myHistory" v-for="h in history.slice(0, this.historyNums)" @click="toSearch(h)">
          {{ h[0] }}
        </div>
        <!--        展开更多-->
        <div class="myHistory">
          <van-icon name="arrow-down" style="align-items: center" @click="historyNums+=10"/>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import {Dialog} from "vant";

export default {
  name: "DiyPopup",
  data() {
    return {
      searchValue: '',
      popular: '请输入搜索关键词',
      history: [],
      historyNums: 10
    }
  },
  mounted() {
    this.initHistory()
  },
  methods: {
    deleteHistory() {
      Dialog.confirm({
        message:
            '确认删除全部历史记录。',
      })
          .then(() => {
            // on confirm
            localStorage.removeItem('searchHistory')
            this.history = [];
          })
          .catch(() => {
            // on cancel
          });
    },
    initHistory() {
      this.history = JSON.parse(localStorage.getItem('searchHistory'));
      let h = JSON.parse(localStorage.getItem('searchHistory'))
      if (!(h === null)) {
        this.popular = h[0][0]
      }
    },
    toSearch(value) {
      this.searchValue = value[0]
      this.$router.push('/navigation/goodsList/keywords/' + value[0])
    },
    onCancel() {
      this.$router.back()
    },
    onSearch() {
      //处理搜索历史
      let history = JSON.parse(localStorage.getItem('searchHistory'));
      if (history == null) {
        history = [[this.searchValue, 1]]
        localStorage.setItem('searchHistory', JSON.stringify(history));
      } else {
        let state = true;

        for (let i = 0; i < history.length; i++) {
          let h = history[i]
          if (h[0] === this.searchValue) {
            h[1] += 1
            state = false;
          }
        }
        if (state) {
          history.push([this.searchValue, 1])
        }
        //按搜索次数排序
        history.sort(function (a, b) {
          return b[1] - a[1];
        });
        localStorage.setItem('searchHistory', JSON.stringify(history));
        this.$router.push('/navigation/goodsList/keywords/' + this.searchValue)
      }
    }
  }
}
</script>

<style>
.popup {
  /*background: rgb(0, 0, 0.25);*/
  background: white;
}

.myHistory {
  line-height: 30px;
  color: #676767;
  background-color: #efefef;
  border-radius: 10px;
  text-align: center;
  margin-top: 5px;
  margin-right: 10px;
  padding: 0 10px 0 10px;
}
</style>