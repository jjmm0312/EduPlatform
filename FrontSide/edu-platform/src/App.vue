<template>
  <v-app>
    <div class="header-box">
      <!-- <img id="logo-icon" :src="require('./assets/icon/user.png')"/> -->
      UntactEdu
      <div class="login-box">
        <span class="login-box-el">
          <img id="user-icon" :src="require('./assets/icon/user.png')" />
          <img />
        </span>
        <span class="login-box-el">로그인</span>
        <span class="login-box-el">회원가입</span>
      </div>
    </div>

    <div v-if="ifAdmin" class="menu-box">
      <v-button>학원소개</v-button>
      <v-button>강사소개</v-button>
      <v-button>강의소개</v-button>
      <v-button>공지사항</v-button>
    </div>
    <div v-if="ifTeacher" class="menu-box">
      <v-button></v-button>
      <v-button></v-button>
      <v-button></v-button>
      <v-button></v-button>
    </div>
    <div v-if="ifStudent" class="menu-box">
      <v-button></v-button>
      <v-button></v-button>
      <v-button></v-button>
      <v-button></v-button>
    </div>

    <div class="footer-box">
      <div>UntactEdu / 서울시 동작구 상도1동</div>
      <div>Tel. 010. 3601. 2779</div>
      <div>Vaninside. all rights reserved</div>
    </div>
  </v-app>
</template>

<script>
export default {
  name: "App",

  data: () => ({
    ifStudent: true,
    ifTeacher: true,
    ifAdmin: true,
  }),
  methods: {
    changeAuth(auth) {
      this.ifStudent = this.ifTeacher = this.ifAdmin = false;
      if (auth == 0) {
        this.ifAdmin = true;
      }
      else if(auth == 1){
        // teacher
        this.ifTeacher = true;
      }
      else if(auth == 3){
        // student
        this.ifStudent = true;
      }
    },
  },
};
</script>

<style scoped>
.menu-box {
  background-color: rgb(25, 94, 76);
  display: flex;
  justify-content: space-around;
  color: white;
  padding: 1rem 0rem 1rem 0rem;
  font-weight: bold;
}
.login-box-el {
  padding: 0 0 0 1rem;
}
.header-box {
  margin: 2rem 2rem 2rem 2rem;
  display: flex;
  align-items: center;
  justify-content: space-around;
}
#logo-icon {
  display: inline;
  width: 5%;
  height: auto;
}
#user-icon {
  display: inline;
  width: 4%;
  height: auto;
}
.footer-box {
  background-color: rgb(64, 64, 64);
  padding: 1rem;
  text-align: center;
  color: white;
  font-size: 0.8rem;
}
</style>
