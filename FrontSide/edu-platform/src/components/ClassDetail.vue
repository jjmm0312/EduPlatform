<template>
  <div id="main-text">
    <h1 id="main-title">{{title}}</h1>
    <hr id="main-line" />

    <!-- <iframe
      style="content-align:center"
      width="560"
      height="315"
      src="https://www.youtube.com/embed/Yw5YZQXYDro"
      frameborder="0"
      allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
      allowfullscreen
    ></iframe>-->
    <div class="player-container" id="video-contain">
      <vue-core-video-player :src="videoSource"></vue-core-video-player>
    </div>
    <!-- <div id="video-contain">
    <video id="class-box" :src="videoSource" >지원하지 않는 브라우저입니다!</video>
    </div>-->

    <hr>
    <p>
      {{title}}
      <br />
      <br />{{content}}   </p>

    <br />
    <br />

    <hr>
    <span id="attach-text">첨부</span>
    <a id="attachment" href="https://www.youtube.com/watch?v=Yw5YZQXYDro">{{document}}</a>

    <br />
    <br />

    <div id=below-button>
    <button v-bind:class="primebtn" @click="modifyNotice">이전</button>
    <button v-bind:class="primebtn" @click="modifyNotice">목록</button>
    <button v-bind:class="primebtn" @click="modifyNotice">다음</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IP from "../../static/IP";

export default {
  mounted() {
      var vm = this;

      axios
        .get("http://" + IP.IP + ":8080/course/lecture-info", {
          params: { num : vm.lectureid },
          timeout: 10000,
        })
        .then((res) => {
          vm.title = res.data.title;
          vm.content = res.data.description;
          vm.document = res.data.document; // 이름으로 수정해야함.
          vm.video = res.data.video; // 비디오로 수정해야함.
        });

  },
  props:['id'],
  data() {
    return {
      title:"",
      content:"",
      document:"",
      video:"",
      lectureid:this.id,
      videoSource: require("../../static/video/demo.mp4"),
      textinput: "form-control",
      sampleImg: require("../../static/img/classImage.png"),
      primebtn:
        "row-sm-1 col-sm-2 btn btn-secondary disabled btn-sm below-button",
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
#attach-text{
  margin-right: 1rem;
}
#video-contain {
  margin-top: 2rem;
  margin-bottom: 3rem;
  /* width: 50%; */
  display: flex;
  justify-items: center;
  /* justify-content: center; */
}
#class-box {
  width: 600px;
  height: auto;
}
#class-info-text {
  text-align: center;
  padding: 0rem 20% 0 0%;
}
#main-text {
  align-content: center;
  align-items: center;
  margin: 5rem 20% 2rem 20%;
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
  margin: 3rem 0% 0rem 0%;
  display: flex;
  justify-content: space-between;
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
  /* background-color: rgb(94, 94, 94); */
}
</style>