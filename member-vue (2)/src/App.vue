<template>
  <div id="app" class="container">
    <nav-header></nav-header>
    <!--<h2 class="text-center">Vue를 이용한 사원목록</h2>-->
    <router-view></router-view>
    <nav-footer></nav-footer>
  </div>
</template>

<script>
import Vue from "vue";
import NavHeader from "@/views/NavHeader.vue";
import NavFooter from "@/views/Footer.vue";
import { BNav, NavPlugin, BootstrapVue } from "bootstrap-vue";

Vue.use("b-nav", BNav);
Vue.use(NavPlugin);
Vue.use(BootstrapVue);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

//mapGetters 등록
import { mapGetters } from "vuex";

export default {
  components: {
    NavHeader,
    NavFooter
  },
  data() {
    return {
      isLogin: false
    };
  },
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
html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
caption,
tbody,
tfoot,
thead,
tr,
th,
td,
article,
aside,
canvas,
details,
embed,
figure,
figcaption,
footer,
header,
hgroup,
menu,
nav,
output,
ruby,
section,
summary,
time,
mark,
audio,
video {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  font-family: "NanumSquare", sans-serif;
}

img {
  vertical-align: middle;
  border-style: none;
}

a,
a:hover,
a:visited {
  text-decoration: none;
  color: black;
}
</style>
