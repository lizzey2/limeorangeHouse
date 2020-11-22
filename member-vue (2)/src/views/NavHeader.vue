<template>
  <div id="header">
    <router-link :to="'/'"
      ><img src="../assets/images/logo.png" id="hlogo"
    /></router-link>
    <ul id="pcmenu">
      <li><router-link :to="'/intro'">서비스 소개</router-link></li>
      <li><router-link :to="'/search'">실거래가 조회</router-link></li>
      <li><router-link :to="'/noticelist'">공지사항</router-link></li>
      <li><router-link :to="'/listboard'">FAQ</router-link></li>
      <li>
        <router-link :to="'/safeHospital'" id="covid">코로나19</router-link>
      </li>
    </ul>
    <ul id="pclogin" v-if="getAccessToken">
      <li>
        <router-link :to="'/me'">
          {{ getUserName }}({{ getUserId }})님 환영합니다.</router-link
        >
      </li>
      <li @click.prevent="onClickLogout">로그아웃</li>
    </ul>
    <ul id="pclogin" v-else>
      <!--<div class="login">-->
      <li><router-link :to="'/login'">로그인</router-link></li>
      <li>|</li>
      <li><router-link :to="'/signup'">회원가입</router-link></li>
    </ul>
  </div>
</template>

<script>
import Vue from "vue";
import { mapGetters } from "vuex";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

export default {
  computed: {
    ...mapGetters(["getAccessToken", "getUserId", "getUserName"])
  },
  methods: {
    onClickLogout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => this.$router.replace("/").catch(() => {}));
    }
  }
};
</script>

<style>
img {
  vertical-align: middle;
  border-style: none;
}

router-link,
router-link:hover,
router-link:visited {
  text-decoration: none;
  color: black;
}

#header {
  position: static;
  height: 100px;
}

#hlogo {
  margin-left: 20px;
  margin-top: 15px;
  width: 180px;
}

#pcmenu {
  position: absolute;
  margin-top: 50px;
  margin-left: 50px;
}

#pcmenu,
#pcmenu li {
  display: inline-block;
  font-size: 18px;
}
#covid {
  color: #fc4949;
}

#pcmenu li {
  margin-left: 40px;
}

#pclogin {
  position: absolute;
  right: 50px;
  margin-top: 50px;
  margin-right: 20px;
  color: #333333;
}

#pclogin,
#pclogin li {
  display: inline-block;
}

#login {
  width: 1200px;
  margin: 40px auto 90px;
}

#login #btn {
  display: inline-block;
}
</style>
