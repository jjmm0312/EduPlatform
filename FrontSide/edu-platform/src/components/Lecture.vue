<template>
  <div id="main-text">
    <div id="class-title-bar">
      <img :src="sampleImg" alt="My Image" />
      <div id="class-info-text">
        <h1><strong>{{lectureTitle}}</strong></h1>
        <p>
          강사 :
          <span>{{teacher}}</span>
        </p>
        <p>{{description}}</p>
      </div>     
      </div>

<div id="below-button">
<button v-bind:class="primebtn" @click="register">수강 신청</button>
    </div>

    <div id="below-box">
      <table class="table table-hover table-bordered" id="notice-table">
          <thead class="thead-light">
            <tr>
              <th colspan="2" scope="col"><strong>강의 목록</strong></th>
              <!-- <th scope="col">제목</th>
              <th scope="col">작성일</th> -->
            </tr>
          </thead>
          <tbody>
             <tr v-for="(data,index) in dataset" v-bind:key="index">
            <td style="width: 15%;">Class {{index+1}} .{{data.title}}</td>
            </tr>
           
          </tbody>

          <!-- 첫번째 줄 끝 -->
        </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IP from "../../static/IP";


export default {
  mounted(){
      var vm = this;

      axios
        .get("http://" + IP.IP + ":8080/course/course-info", {
          params: { num : vm.courseid },
          timeout: 10000,
        })
        .then((res) => {
          vm.lectureTitle = res.data.title;
          vm.description = res.data.description;
          vm.teacher = res.data.teacher.name;
        });

        axios
        .get("http://" + IP.IP + ":8080/course/lecture-list", {
          params: { num : vm.courseid },
          timeout: 10000,
        })
        .then((res) => {
            console.log(res);
            vm.dataset = res.data;
          });
  },
  data() {
    return {
       dataset:[],
      courseid:1,
      lectureTitle:"",
      teacher:"",
      description:"",
      textinput: "form-control",
      sampleImg: require("../../static/img/classImage.png"),
      primebtn:
        "row-sm-1 col-lg-2 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    register() {
      console.log("register course");
      var vm = this;

      axios
        .get("http://" + IP.IP + ":8080/course/register", {
          params: { num : vm.courseid },
          timeout: 10000,
          // 테스트 아직 안함.
        })
        .then((res) => {
          console.log(res.data);
          console.log("register Success");
        });
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