<template>
  <div id="main-text">
    <h1 id="main-title">공지사항</h1>
    <hr id="main-line" />
    <div id="title-box">
      <span id="notice-title">{{title}}</span>
      <span>
        작성일 :
        <span id="regi_date">{{createdAt}}</span>
      </span>
    </div>

    <hr />
    <p id="notice-content">{{content}}</p>
    <hr id="page_bottom_line" />
    <div id="notice-below-button">
    <button v-bind:class="primebtn" @click="edit">수정</button>
    <button v-bind:class="primebtn" @click="cancel">목록</button>
    </div>
<!-- 
    <button id="edit_button" type="button" name="edit">수정</button>
    <button id="exit_button" type="button" name="exit">목록</button> -->
  </div>
</template>

<script>
import axios from "axios";
import IP from "../../static/IP";

export default {
  props:["id"],
  mounted(){
      var vm = this;

      axios
        .get("http://" + IP.IP + ":8080/notice/noticeDetail", {
          params: { noticeID : vm.noticeid },
          timeout: 10000,
        })
        .then((res) => {
          vm.title = res.data.title;
          vm.content = res.data.content;
          vm.createdAt = res.data.time;
        });
  },
  data() {
    return {
      noticeid:this.id,
      title:"",
      createdAt:"",
      content:"",
      primebtn: "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    edit() {
      console.log("Move to Edit Page.");
    },
    cancel() {
      console.log("cancel. move page.");
      this.$router.go(-1);
    }
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