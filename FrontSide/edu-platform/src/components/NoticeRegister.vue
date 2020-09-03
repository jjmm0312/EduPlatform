<template>
  <div id="main-text">
    <h1 id="main-title">공지사항</h1>
    <hr id="main-line" />
    <div id="title-box">
        <div class="row">
      <div class="col-sm-11 col-sm-offset-5">
      <label class="sr-only" for="adminid">Admin ID</label>
      <input
        v-bind:class="textinput"
        type="text"
        id="adminid"
        v-model="inputTitle"
        title="managerid"
        placeholder="제목을 입력해 주세요"
      />
      </div>
        </div>
    </div>
    <textarea placeholder="내용을 입력해주세요" class="form-control" id="content" name="name" rows="8" cols="80" v-model="inputContent"></textarea>
    <hr id="page_bottom_line" />
    <div id="notice-below-button">
      <button v-bind:class="primebtn" @click="create">완료</button>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import IP from "../../static/IP";

export default {
  data() {
    return {
      inputContent:"",
      inputTitle:"",
      textinput: "form-control",
      primebtn:
        "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    create() {

       axios
        .post("http://" + IP.IP + ":8080/notice/newNotice", {
          title:this.inputTitle,
          content:this.inputContent,
          timeout: 10000,
        })
        .then((res) => {
          console.log("Create Notice Fin.");
          console.log(res);
        });
    },
  },
};
</script>

<style scoped>
#date-box{
    padding-top: 1.2rem;
}
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