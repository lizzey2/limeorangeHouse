<template>
  <div>
    탈퇴처리중...
  </div>
</template>
<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  created() {
    axios
      .delete(`${SERVER_URL}/user/userdelete/${this.$route.query.userid}`)
      .then(({ data }) => {
        let msg = "삭제 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "삭제이 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/");
      });
  }
};
</script>
<style></style>
