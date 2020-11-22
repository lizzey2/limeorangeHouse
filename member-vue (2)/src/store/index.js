import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
Vue.use(Vuex);

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default new Vuex.Store({
  state: {
    accessToken: null,
    userId: null,
    userName: null,
    boards:[],
    board:{}
  },
  getters: {
    getAccessToken(state) {
      state.accessToken = localStorage.getItem("access_token");
      axios.defaults.headers.common["auth-token"] = state.accessToken;
      return state.accessToken;
    },
    getUserId() {
      return localStorage.getItem("user-id");
    },
    getUserName() {
      return localStorage.getItem("user-name");
    },
    boards(state){
      return state.boards;
    },
    board(state){
      return state.board;
    }
  },
  mutations: {
    LOGIN(state, payload) {
      state.accessToken = payload["auth-token"];
      state.userId = payload["user-id"];
      state.userName = payload["user-name"];
    },
    LOGOUT(state) {
      state.accessToken = null;
      state.userId = null;
      state.userName = null;
    },
    setBoards(state,boards){
      state.boards = boards;
    },
    setBoard(state,board){
      state.board=board;
    }
  },
  actions: {
    LOGIN(context, user) {
      return axios
        .post(`${SERVER_URL}/user/confirm/login`, user)
        .then(response => {
          context.commit("LOGIN", response.data);
          let token = `${response.data["auth-token"]}`;
          let id = `${response.data["user-id"]}`;
          let name = `${response.data["user-name"]}`;
          localStorage.setItem("access_token", token);
          localStorage.setItem("user-id", id);
          localStorage.setItem("user-name", name);
          axios.defaults.headers.common["auth-token"] = token;
          this.state.accessToken = token;
        });
    },
    LOGOUT(context) {
      axios.defaults.headers.common["auth-token"] = undefined;
      this.state.accessToken = null;
      localStorage.removeItem("access_token");
      localStorage.removeItem("user-id");
      localStorage.removeItem("user-name");
      context.commit("LOGOUT");
    },
    getBoards(context){
      axios.get(`${SERVER_URL}/board/listboard`)
      .then(({data})=>{
        context.commit('setBoards',data);
      });
    },
    getBoard(context,url){
      axios.get(url).then(({data})=>{
        context.commit('setBoard',data);
      });
    }
  },
  modules: {}
});
