<template>
  <div>
    <h2 class="text-center">SIGN UP</h2>
    <table class="table">
      <colgroup>
        <col width="30%" />
        <col width="70%" />
      </colgroup>
      <tr>
        <td class="bg-primary" style="text-align: center">아이디</td>
        <td><input id="userid" v-model="userid" /></td>
      </tr>
      <tr>
        <td class="bg-primary" style="text-align: center">비밀번호</td>
        <td><input id="userpwd" type="password" v-model="userpwd" /></td>
      </tr>
      <tr>
        <td class="bg-primary" style="text-align: center">이름</td>
        <td><input id="username" v-model="username" /></td>
      </tr>
      <tr>
        <td class="bg-primary" style="text-align: center">이메일</td>
        <td><input id="email" v-model="email" type="email" /></td>
      </tr>
      <tr>
        <td class="bg-primary" style="text-align: center">주소</td>
        <td><input id="address" v-model="address" /></td>
      </tr>

      <tr>
        <td colspan="2" style="text-align: center">
          <button @click="createHandler">회원가입</button>
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      userid: "",
      username: "",
      userpwd: "",
      email: "",
      address: ""
    };
  },

  methods: {
    createHandler() {
      axios
        .post(`${SERVER_URL}/user/confirm/signup`, {
          userid: this.userid,
          username: this.username,
          userpwd: this.userpwd,
          email: this.email,
          address: this.address
        })
        .then(({ data }) => {
          let msg = null;
          if (
            data.userid === null ||
            data.username === null ||
            data.userpwd === null ||
            data.email === null ||
            data.address === null
          ) {
            msg = "회원가입시 문제가 발생했습니다.";
          } else {
            msg = "회원가입이 완료되었습니다.";
          }
          alert(msg);
          this.moveHome();
        });
    },
    moveHome() {
      this.$router.push("/login");
    }
  }
};
</script>
<style></style>
