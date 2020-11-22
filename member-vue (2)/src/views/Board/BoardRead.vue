<template>
  <div>
    <table class="table table-bordered w-75">
      <tr>
        <th>번호</th>
        <td>{{ board.no }}</td>
      </tr>
      <tr>
        <th>글쓴이</th>
        <td>{{ board.writer }}</td>
      </tr>
      <tr>
        <th>제목</th>
        <td>{{ board.title }}</td>
      </tr>
      <tr>
        <th>날짜</th>
        <td>{{ getFormatDate(board.regtime) }}</td>
      </tr>
      <tr>
        <td colspan="2">
          {{ board.content }}
        </td>
      </tr>
    </table>

    <br />
    <div class="text-center">
      <router-link to="/listboard" class="btn btn-primary">목록</router-link>
      <router-link :to="'/updateboard?no=' + board.no" class="btn btn-primary"
        >수정</router-link>
      <router-link :to="'/deleteboard?no=' + board.no" class="btn btn-primary"
        >삭제</router-link>
    </div>
  </div>
</template>
<script>
import moment from 'moment';
import {mapGetters} from 'vuex';

const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
 computed: {
   ...mapGetters(['board']),
 },
  created() {
    this.$store.dispatch(
      'getBoard',
      `${SERVER_URL}/board/readboard/${this.$route.params.no}`
    )
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    },
  },
};
</script>
<style></style>
