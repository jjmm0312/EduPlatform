<template>
  <div id="main-text">
    <div id="first-line">
      <div id="main-table">
        <table class="table table-hover table-bordered" id="notice-table">
          <thead class="thead-light">
            <tr>
              <th scope="col">공지사항</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>학원생 여러분들에게 알려드립니다.</td>
            </tr>
            <tr>
              <td>첫번째 칸</td>
            </tr>
            <tr>
              <td>첫번째 칸</td>
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

      <div id="lecture-list">
        <p>모든 강좌 목록</p>
        <div id="lecture-image">
          <img id="left-arrow" :src="leftArrow" alt="My Image" />
          <img id="image-1" :src="sampleImage" alt="My Image" />
          <img id="image-2" :src="sampleImage" alt="My Image" />
          <img id="image-3" :src="sampleImage" alt="My Image" />
          <img id="right-arrow" :src="rightArrow" alt="My Image" />
        </div>
      </div>
    </div>
    <br />
    <div id="banner" class>
      <div id="banner-1" class></div>
      <div id="banner-2" class></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      leftArrow: require("../../static/img/left-arrow.png"),
      rightArrow: require("../../static/img/right-arrow.png"),
      sampleImage: require("../../static/img/classImage.png"),
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
#main-text {
  margin: 3rem 20% 2rem 20%;
}

/* 여기부터는 Jimin's Implements*/
#first-line {
}
#main-table {
  margin: 0px 5px 10px 0px;
  height: 200px;
}
#notice-table {
  margin-bottom: 0px;
  width: 100%;
  height: 100%;
}

#lecture-list {
  margin: 5px 5px 0px 0px;
  background-color: rgb(248, 247, 247);
  border-style: solid;
  border-width: 0.5px;
  border-color: rgb(190, 190, 190);
}

#lecture-image {
  display: flex;
  /* align-items: center;
   */
  flex-wrap: wrap;
  justify-content: space-between;
  background-color: rgb(248, 247, 247);
}

#left-arrow {
  height: 30px;
}

#right-arrow {
  height: 30px;
}

#image-1 {
  width: 180px;
  height: 120px;
  margin: 3px;
}

#image-2 {
  width: 180px;
  height: 120px;
  margin: 3px;
}

#image-3 {
  width: 180px;
  height: 120px;
  margin: 3px;
}

#banner {
  /* position: relative; */
  height: auto;
  margin: auto;
  display: flex;
}

#banner-1 {
  margin: 0px 5px 0px 0px;
  background-color: rgb(248, 247, 247);
  /* float: left; */
  /* width: 40%; */
  height: 150px;
  /* position: relaive; */
  border-style: solid;
  border-width: 0.5px;
  border-color: rgb(190, 190, 190);
  flex: 2 2;
}

#banner-2 {
  margin: 0px 0px 0px 5px;
  background-color: rgb(248, 247, 247);
  /* float: left; */
  /* width: 60%; */
  flex: 3 3;
  height: 150px;
  /* position: relaive; */
  border-style: solid;
  border-width: 0.5px;
  border-color: rgb(190, 190, 190);
}
</style>