<template>
  <div id="main-text">
    <div id="class-title-bar">
      <img :src="sampleImg" alt="My Image" />
      <div id="class-info-text">
        <h1><strong>Class Title</strong></h1>
        <p>
          강사 :
          <span>이 철</span>
        </p>
        <p>class description</p>
      </div>     
      </div>

<div id="below-button">
<button v-bind:class="primebtn" @click="modifyNotice">수강 신청</button>
    </div>

    <div id="below-box">
      <table class="table table-hover table-bordered" id="notice-table">
          <thead class="thead-light">
            <tr>
              <th colspan="2" scope="col"><strong>Chapter 1.</strong></th>
              <!-- <th scope="col">제목</th>
              <th scope="col">작성일</th> -->
            </tr>
          </thead>
          <tbody>
            <tr>
              <td style="width: 15%; text-align:center;">Class 01.</td>
              <td style="width: 85%">도커란 무엇인가?</td>
            </tr>
            <tr>
              <td style="width: 15%; text-align:center;">Class 02.</td>
              <td>도커 설치하기</td>
            </tr>
            <!-- <tr v-for="(data,index) in dataset" v-bind:key="index">
            <td>{{data.name}}</td>
            <td>{{data.memo}}</td>
            <td>{{data.location}}</td>
            <td>{{data.protocol}}</td>
            <td>{{data.type}}</td>
            <td>{{data.time}}</td>
            <td>
              <button v-on:click="selectDevice(index)" class="btn btn-primary">관리</button>
            </td>
            </tr>-->
          </tbody>

          <!-- 첫번째 줄 끝 -->
        </table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textinput: "form-control",
      sampleImg: require("../../static/img/classImage.png"),
      primebtn:
        "row-sm-1 col-lg-2 btn btn-primary disabled btn-sm below-button",
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
#class-info-text{
  text-align: center;
  padding: 0rem 20% 0 0%;
}
#below-box {
  margin: 1rem 20% 2rem 20%;
}
#class-title-bar {
  /* display: flex; */
  /* margin: 0 5% 0 5%; */
  justify-content: space-between;
  align-items: center;
  padding: 2rem 20% 1rem 20%;
  margin: 2rem 0 0.5rem 0;
  background-color: rgb(243, 236, 231);
  display: flex;
}
.upper-box {
  display: flex;
  /* height: 50px; */
  align-items: center;
  justify-content: space-around;
}
#below-button {
  margin: 0rem 20% 0rem 20%;
  display: flex;
  justify-content: flex-end;
  flex-wrap: wrap;
}
#main-text {
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

#lecture-list {
  margin: 2rem 0rem 5rem 0rem;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
.btn-primary {
  background-color: rgb(94, 94, 94);
}
</style>