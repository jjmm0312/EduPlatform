<template>
  <div id="main-text">
    <h1 id="main-title">공지사항</h1>
    <hr id="main-line" />
    <div id="title-box">
      <span id="notice-title">[공지] 학원 개설에 대해 안내드립니다.</span>
      <span>
        작성일 :
        <span id="regi_date">2020-08-30</span>
      </span>
    </div>

    <hr />
    <p id="notice-content">학원 개설을 축하드립니다. 학원 개설을 위해서는 다음과 같은 절차가 필요합니다.</p>
    <hr id="page_bottom_line" />
    <div id="notice-below-button">
    <button v-bind:class="primebtn" @click="modifyNotice">수정</button>
    <button v-bind:class="primebtn" @click="listNotice">목록</button>
    </div>
<!-- 
    <button id="edit_button" type="button" name="edit">수정</button>
    <button id="exit_button" type="button" name="exit">목록</button> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      primebtn: "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
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
.below-button{
    margin: 0 0.5rem 0 0;
    /* height: 2%; */
}
.btn-primary{
    background-color: rgb(94,94,94);
}
#notice-below-button{
    display:flex;
    justify-content: flex-end;
}
#notice-content {
  margin: 1rem 1rem 1rem 1rem;
  min-height: 30vh;
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