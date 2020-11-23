import Vue from "vue";
import VueRouter from "vue-router";
import Index from "@/views/Index.vue";
import Login from "@/views/Login.vue";
import Me from "@/views/Me.vue";
import Signup from "@/views/Signup.vue";
import store from "@/store";
import userDelete from "@/views/userDelete.vue";
import userUpdate from "@/views/userUpdate.vue";
import Search from "@/views/SearchAll.vue";
import BoardList from "@/views/Board/BoardList.vue";
import BoardCreate from "@/views/Board/BoardCreate.vue";
import BoardRead from "@/views/Board/BoardRead.vue";
import BoardDelete from "@/views/Board/BoardDelete.vue";
import BoardUpdate from "@/views/Board/BoardUpdate.vue";
import NoticeList from "@/views/Notice/NoticeList.vue";
import NoticeCreate from "@/views/Notice/NoticeCreate.vue";
import NoticeRead from "@/views/Notice/NoticeRead.vue";
import NoticeDelete from "@/views/Notice/NoticeDelete.vue";
import NoticeUpdate from "@/views/Notice/NoticeUpdate.vue";
Vue.use(VueRouter);

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const requireAuth = () => (to, from, next) => {
  const nextRoute = to.path;

  if (store.getters.getAccessToken) {
    return next();
  } else next("/login" + nextRoute);
};


const routes = [
  {    path: "/",    name: "Index",    component: Index  },
  {    path: "/login",    name: "Login",    component: Login  },
  {    path: "/login/:nextRoute",    name: "LoginNextRoute",    component: Login  },
  {    path: "/me",    name: "Me",    component: Me,    beforeEnter: requireAuth()  },
  {    path: "/signup",    name: "Signup",    component: Signup  },
  {    path: "/userdelete",    name: "userDelete",    component: userDelete  },
  {    path: "/userupdate",    name: "userUpdate",    component: userUpdate  },
  {    path: "/search",    name: "Search",    component: Search  },
  {    path: "/listboard",    name: "BoardList",    component: BoardList  },
  {    path: "/createboard",    name: "BoardCreate",    component: BoardCreate  },
  {    path: "/readboard/:no",    name: "BoardRead",    component: BoardRead  },
  {    path: "/deleteboard",    name: "BoardDelete",    component: BoardDelete  },
  {    path: "/updateboard", name: "BoardUpdate", component: BoardUpdate },
  {    path: "/listnotice",    name: "NoticeList",    component: NoticeList  },
  {    path: "/createnotice",    name: "NoticeCreate",    component: NoticeCreate  },
  {    path: "/readnotice/:no",    name: "NoticedRead",    component: NoticeRead  },
  {    path: "/deletenotice",    name: "NoticeDelete",    component: NoticeDelete  },
  {    path: "/updatenotice",    name: "NoticeUpdate",    component: NoticeUpdate  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
