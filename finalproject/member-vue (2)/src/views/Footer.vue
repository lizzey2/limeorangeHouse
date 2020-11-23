<template>
  <div id="footer">
    <div id="fmenu">
      <router-link :to="'/sitemap'">사이트 맵</router-link>
      |
      <router-link :to="'#'">개인정보취급방침</router-link>
      |
      <router-link :to="'#'">고객센터</router-link>
    </div>
    <div id="copyright">
      COPYRIGHT(C) SSAFY SEOUL9 PARK DAYUN, PARK SEOYOUNG,YOON JISUN. ALL RIGHTS
      RESERVED
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#footer {
  height: 150px;
  background-color: #595959;
  text-align: center;
  padding-top: 50px;
  color: #d4d4d4;
  margin-top: 100px;
}

#fmenu {
  margin-bottom: 20px;
}
#fmenu a {
  color: #d4d4d4;
}
</style>
