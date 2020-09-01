<template>
  <div id="main-text">
    <h1 id="main-title">학습현황</h1>
    <hr id="main-line" />
    <table class="table table-hover table-bordered">
      <thead class="thead-light">
        <tr>
          <th scope="col">총 강좌 수</th>
          <th scope="col">수강중인 강좌 수</th>
          <th scope="col">이번 달 학습 시간</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <!-- 첫번째 줄 시작 -->
          <td>첫번째 칸</td>
          <td>두번째 칸</td>
          <td>두번째 칸</td>
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
    <hr />
    <div id="lecture_list">
      <div id="lecture-1">
        <img class="class-img" :src="sampleImg" alt="My Image" />
        <div id="detail-box">
          <p id="detail-name-text">Class Title</p>
          <span id="detail-progress">
            <p>
              학습현황
              <span>12</span> /
              <span>25</span>
            </p>
            <progress id="progress-bar" value="20" max="100"></progress>
            <!-- <div class="progress">
              <div
                class="progress-bar progress-bar-success"
                role="progressbar"
                aria-valuenow="40"
                aria-valuemin="0"
                aria-valuemax="100"
                style="width:40%"
              >40% Complete (success)</div>
            </div> -->
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sampleImg: require("../../static/img/classImage.png"),
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
#progress-bar {
  width: 100%;
}
#detail-progress {
  margin: 0rem 0.5rem 0.5rem 0.5rem;
  overflow: scroll;
  font-weight: bold;
  width: 100%;
}
#detail-name-text {
  margin: 2rem 0.5rem 0.5rem 0.5rem;
  overflow: scroll;
  font-weight: bold;
  font-size: 2rem;
}
#detail-box {
  display: flex;
  width: 100%;
  padding-right: 3rem;
  padding-bottom: 1rem;
  flex-direction: column;
  justify-content: space-between;
}
.class-img {
  margin: 1rem 1rem 1rem 1rem;
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
#lecture-1 {
  display: flex;
  background-color: rgb(243, 236, 231);
}
</style>