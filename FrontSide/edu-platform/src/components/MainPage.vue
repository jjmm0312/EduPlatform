<template>
  <div id="main-text">
    <div id="first-line">
      <div id="lecture-list">
        <p id="text-lecture-list">모든 강좌 목록</p>
        <div id="lecture-image">
          <img id="left-arrow" :src="leftArrow" alt="My Image" />
          <div id="image-box">
            <img @click="lectureDetail(lecture.id)"  class="image-lecture" v-for="(lecture,index) in lectureData" v-bind:key="index"  :src="sampleImage" alt="My Image"/>
            <!-- <img id="image-1" :src="sampleImage" alt="My Image" />
            <img id="image-2" :src="sampleImage" alt="My Image" />
            <img id="image-3" :src="sampleImage" alt="My Image" /> -->
          </div>
          <img id="right-arrow" :src="rightArrow" alt="My Image" />
        </div>
      </div>
      <div id="main-table">
        <table class="table table-hover table-bordered" id="notice-table">
          <thead class="thead-light">
            <tr>
              <th scope="col">공지사항</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(data,index) in noticeData" v-bind:key="index">
              <td>{{data.title}}</td>
            </tr>
          </tbody>

          <!-- 첫번째 줄 끝 -->
        </table>
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
import axios from "axios";
import IP from "../../static/IP";

export default {
  mounted() {
    // 1. 공지사항을 가져와야 함
    var vm = this;
    axios
      .get("http://" + IP.IP + ":8080/notice/noticeList", {
        params: { size: 3, page: 0 },
        timeout: 10000,
      })
      .then((res) => {
        vm.noticeData = res.data.content
      });
    // 2. 상황에 맞게, 강좌목록인지, 아닌지 판단해야 함.
    axios
      .get("http://" + IP.IP + ":8080/course/course-list", {
        params: { size: 3, page: 0 },
        timeout: 10000,
      })
      .then((res) => {
        vm.lectureData = res.data.content
      });
  },
  data() {
    return {
      noticeData: [],
      lectureData:[],
      leftArrow: require("../../static/img/left-arrow.png"),
      rightArrow: require("../../static/img/right-arrow.png"),
      sampleImage: require("../../static/img/classImage.png"),
      primebtn:
        "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    lectureDetail(id){
      this.$router.push({name:'lectureDetail',params:{id:id}});
    },
    loginEdu() {
      console.log("Login Button Pressed");
    },
  },
};
</script>

<style scoped>
#text-lecture-list {
  font-size: 1rem;
  font-weight: bold;
  margin: 0.5rem 0rem 0.5rem 0.5rem;
}
#main-text {
  margin: 3rem 20% 2rem 20%;
}

/* 여기부터는 Jimin's Implements*/
#first-line {
}
#main-table {
  margin: 2rem 5px 0.5rem 0px;
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

#image-box {
  display: flex;
  /* align-items: center;
   */
  flex-wrap: wrap;
  justify-content: space-between;
  background-color: rgb(248, 247, 247);
}

#lecture-image {
  display: flex;
  height: auto;
  align-content: center;
  align-items: center;
  padding: 0 0.5rem 1rem 0.5rem;
  justify-content: space-between;
}

#left-arrow {
  /* margin-top: ; */
  height: 30px;
}

#right-arrow {
  height: 30px;
}

.image-lecture {
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