<template>
  <v-app>
    <div class="header-box">
      <div>
      <img id="logo-icon" @click="gotohome" :src="require('../static/img/logo2.png')"/>
      <!-- <span>UntactEdu</span> -->
      </div>
      <!-- <span>UntactEdu</span> -->
      <div class="login-box">
        <!-- <span id="user-icon-box"> -->
        <img id="user-icon" :src="require('./assets/icon/user.png')" />
        <!-- </span> -->
        
        <span v-if="ifNonmember" v-on:click="loginButton" class="login-box-el">로그인</span>
        <span v-if="ifNonmember" v-on:click="signupButton" class="login-box-el">회원가입</span>
        <span v-else v-on:click="signoutButton" class="login-box-el">로그아웃</span>
      </div>
    </div>

    <div v-if="ifAdmin || ifNonmember" class="menu-box">
      <button v-for="(menu,index) in menuNormal" v-bind:key="index" @click="normalMenu(index)">{{menu}}</button>
    </div>
    <div v-if="ifTeacher" class="menu-box">
      <button v-for="(menu,index) in menuStudent" v-bind:key="index" @click="studentMenu(index)">{{menu}}</button>
    </div>
    <div v-if="ifStudent" class="menu-box">
      <button v-for="(menu,index) in menuTeacher" v-bind:key="index" @click="teacherMenu(index)">{{menu}}</button>
    </div>

    <div id="cropping">
      <!--Title Image 대표이미지-->
      <img id="title-img" :src="titleImg" />
    </div>

    <router-view></router-view>

    <div class="footer-box">
      <div>UntactEdu / 서울시 동작구 상도1동</div>
      <div>Tel. 010. 3601. 2779</div>
      <div>Vaninside. all rights reserved</div>
    </div>
  </v-app>
</template>

<script>
import { EventBus } from "./utils/event-bus.js";
import axios from 'axios';
import IP from "../static/IP.json";

export default {
  created() {
    axios
      .get("http://" + IP.IP + ":8080/auth/init", {
        timeout: 10000, // 1초 이내에 응답이 없으면 에러 처리
      })
      .then((res) => {
        console.log(res);

        // this.dataset = res.data.payload;
      });
      
      var vm = this;
      EventBus.$on('login-success',()=>{
        console.log("Login Event Catch");
        vm.ifNonmember = false,
        vm.ifStudent = true;
        vm.$router.replace({name:'main'}).catch(()=>{});
      }); // Login success message
  },
  name: "App",
  data: () => ({
    ifStudent: false,
    ifTeacher: false,
    ifAdmin: false,
    ifNonmember: true,
    menuNormal: ["학원소개", "강사소개", "강좌소개", "공지사항"],
    menuStudent: ["수강신청", "내 강좌", "학습현황", "공지사항"],
    menuTeacher: ["수강신청", "내 강좌", "학원관리", "공지사항"],
    titleImg: require("../static/img/titleJimin.jpeg"),
    normalName:['intro','teacher_intro','notyet','noticeList'],
  }),
  methods: {
    signoutButton(){
        this.$router.replace({name:'main'}).catch(()=>{});
        this.changeAuth(4);
    },
    gotohome(){
      this.$router.push({name:'main'}).catch(()=>{});
    },
    normalMenu: function(index){
      console.log("normalMenu " + index);
      this.$router.push({name:this.normalName[index]}).catch(()=>{});
    },
    signupButton(){
      console.log("Signup Button Pressed");
      this.$router.push({name:"signup"}).catch(()=>{});
    },
    loginButton(){
      console.log("Login Button Pressed");
      // vm.$router.push({name:"main",params:{id:adminID}}).catch(() => {});
      this.$router.push({name:"login"}).catch(() => {});
    },
    changeAuth(auth) {
      this.ifStudent = this.ifTeacher = this.ifAdmin = this.ifNonmember = false;
      if (auth == 0) {
        // 0 - admin,
        this.ifAdmin = true;
      } else if (auth == 1) {
        // teacher
        this.ifTeacher = true;
      } else if (auth == 3) {
        // student
        this.ifStudent = true;
      } else if (auth == 4) {
        // 4 - nonmember
        this.ifNonmember = true;
      }
    },
  },
};
</script>

<style scoped>
#cropping {
  max-height: 300px;
  overflow: hidden;
}
#title-img {
  max-height: 600px;
  width: 100%;
  margin-top: -5%;
}
.header-box {
  margin: 2rem 3rem 2rem 5rem;
  display: flex;
  /* align-items: center; */
  /* align-content: space-between; */
  justify-content: space-between;
  /* flex-wrap: wrap; */
  /* flex-wrap: wrap; */
}
.login-box {
  margin: 0;
  /* flex: 1 1; */
  /* width: 200px; */
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: space-around;
  /* flex-wrap: wrap; */
  /* flex-wrap:inherit; */
}
#user-icon-box{
  /* width: 5%; */
  width: 30%;
}
.login-box-el {
  padding: 0 0 0 0rem;
  margin: 0rem 0.5rem 0rem 0.5rem;
  /* width: 5%; */
  /* width: 1rem; */
}
#user-icon {
  /* display: inline; */
  /* width: 100%; */
  width:auto;
  height: 30px;
  margin-right: 0.5rem;
}
.menu-box {
  background-color: rgb(25, 94, 76);
  display: flex;
  justify-content: space-around;
  color: white;
  padding: 1rem 10rem 1rem 10rem;
  flex-wrap: wrap;
  font-weight: bold;
}


#logo-icon {
  display: inline;
  height: 60px;
  width: auto;
}

.footer-box {
  background-color: rgb(64, 64, 64);
  padding: 1rem;
  text-align: center;
  color: white;
  font-size: 0.8rem;
}
</style>