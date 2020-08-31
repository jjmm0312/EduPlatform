<template>
  <div id="main-text">
    <h1 id="main-title">공지사항</h1>
    <hr id="main-line" />
    <div id="notice-below-button">
    <button id="regi_button" type="button" name="regi">글 작성</button>
    </div>
    <table border="1">
      <th>No.</th>
      <th>제목</th>
      <th>작성일</th>
      <tr>
        <!-- 첫번째 줄 시작 -->
        <td>첫번째 칸</td>
        <td>두번째 칸</td>
        <td>두번째 칸</td>
      </tr>
      <!-- 첫번째 줄 끝 -->
      <tr>
        <!-- 두번째 줄 시작 -->
        <td>첫번째 칸</td>
        <td>두번째 칸</td>
        <td>두번째 칸</td>
      </tr>
      <!-- 두번째 줄 끝 -->
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      primebtn:
        "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    loginEdu() {
      console.log("Login Button Pressed");
    },
  },
};
</script>

<style scoped>
.below-button {
  margin: 0 0.5rem 0 0;
  /* height: 2%; */
}
.btn-primary {
  background-color: rgb(94, 94, 94);
}
#notice-below-button {
  display: flex;
  justify-content: flex-end;
}
#notice-content {
  margin: 1rem 1rem 1rem 1rem;
}
#notice-title {
  font-weight: bold;
}
#title-box {
  display: flex;
  justify-content: space-between;
}
#main-text {
  margin: 2rem 20% 2rem 20%;
}
#page_title {
}

#page_title_line {
  height: 4px;
  background: rgb(25, 94, 76);
}

#page_bottom_line {
}
#main-line {
  height: 4px;
  background-color: rgb(25, 94, 76);
}
#main-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-left: 5%;
}
#main-text {
  margin: 5rem 20% 2rem 20%;
}
</style>