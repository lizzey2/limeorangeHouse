<template>
  <div>
    <!-- 템플릿에 ROOT엘리먼트가 필요 -->
    <div style = "text-align:center;">
  <br/>
  <h1> 자유게시판 </h1>
  </div>
  <br/>
   <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col width="10%" />
          <col width="50%" />
          <col width="15%" />
          <col width="25%" />
        </colgroup>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        <tr v-for="board in items" :key="board.no">
          <td>{{ board.no }}</td>
          <td>
            <router-link :to="'readboard/' + board.no">{{ board.title }}</router-link>
          </td>
          <td>{{ board.writer }}</td>
          <td>{{ getFormatDate(board.regtime) }}</td>
        </tr>
      </table>
   </div>
    <div v-else class="text-center">
      게시글이 없습니다.
    </div>
    <div class="text-right">
      <button class="btn btn-primary" @click="movePage">등록</button>
    </div>
  </div>
</template>
<script>
import moment from 'moment';
import {mapGetters} from 'vuex';

export default {
  data() {
    return {
      items: [],
    };
  },
  computed: {
    ...mapGetters(['boards']),
  },
  created() {
    this.$store.dispatch('getBoards');
    this.items=this.boards;
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD');
    },
    movePage() {
      this.$router.push('/createboard');
    },
  },
};
</script>
<style></style>
