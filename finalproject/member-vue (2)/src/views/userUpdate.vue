<template>
  <div>
    <div class="form-group">
      <label for="userid">아이디</label>
      <input
        type="text"
        class="form-control"
        id="userid"
        ref="userid"
        v-model="userid"
        value="this.userid"
        disabled
      />
    </div>
    <div class="form-group">
      <label for="userpwd">현재 비밀번호 입력 </label>
      <input
        type="password"
        class="form-control"
        id="userpwd"
        ref="userpwd"
        v-model="userpwd"
      />
    </div>
    <div class="form-group">
      <label for="newuserpwd">새 비밀번호 입력</label>
      <input
        type="password"
        class="form-control"
        id="newuserpwd"
        ref="newuserpwd"
        placeholder="새 비밀번호를 입력하세요"
        v-model="newuserpwd"
      />
    </div>
    <div class="form-group">
      <label for="username">이름</label>
      <input
        type="text"
        class="form-control"
        id="username"
        ref="username"
        v-model="username"
        value="this.username"
      />
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input
        type="email"
        class="form-control"
        id="email"
        ref="email"
        v-model="email"
        value="this.email"
      />
    </div>
    <div class="form-group">
      <label for="address">주소</label>
      <input
        type="text"
        class="form-control"
        id="address"
        ref="address"
        v-model="address"
        value="this.address"
      />
    </div>
    <div class="text-right">
      <button class="btn btn-primary" @click="checkHandler">수정</button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      userid: "",
      userpwd: "",
      newuserpwd: "",
      username: "",
      email: "",
      address: "",
      joindate: ""
    };
  },
  created() {
    axios
      .get(`${SERVER_URL}/user/getuserinfo/${this.$route.query.userid}`)
      .then(({ data }) => {
        this.userid = data.userid;
        this.userpwd = data.userpwd;
        this.username = data.username;
        this.email = data.email;
        this.address = data.address;
      });
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = "";
      !this.userpwd &&
        ((msg = "현재 비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.userpwd.focus());
      err &&
        !this.newuserpwd &&
        ((msg = "새로운 비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.newuserpwd.focus());
      if (this.userpwd == this.newuserpwd) {
        //확인해봅시다....
        msg = "동일한 비밀번호 입니다. 새로운 비밀번호를 입력해주세요";
        err = false;
        this.$refs.newuserpwd.focus();
        alert(msg);
      }
      if (!err) alert(msg);
      else this.updateHandler();
    },

    updateHandler() {
      axios
        .put(`${SERVER_URL}/user/userupdate/${this.$route.query.userid}`, {
          userid: this.userid,
          userpwd: this.newuserpwd,
          username: this.username,
          email: this.email,
          address: this.email,
          joindate: this.joindate
        })
        .then(({ data }) => {
          let msg = "회원정보 변경에 실패했습니다";
          if (data === "success") {
            msg = "회원정보 수정이 완료되었습니다";
            this.Logout();
          }
          alert(msg);
          this.$router.push("/login");
        });
    },
    Logout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => this.$router.replace("/login").catch(() => {}));
    }
  }
};
</script>
<style></style>
