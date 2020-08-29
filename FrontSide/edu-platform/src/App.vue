<template>
  <v-app>
    <div class="header-box">
      <img>
      <div class="login-box">
        <span>
          <!-- icon -->
          <img>
        </span>
        <span>로그인</span>
        <span>회원가입</span>
      </div>
    </div>

    <div class="footer-box">
      <div>UntactEdu / 서울시 동작구 상도1동</div>
      <div>Tel. 010. 3601. 2779</div>
      <div>Vaninside. all rights reserved</div>
    </div>

    <!-- <v-footer absolute class="font-weight-medium footer-box white--text">
      <v-col class="text-center" cols="12">
        <div>UntactEdu / 서울시 동작구 상도1동</div>
        <div>Tel. 010. 3601. 2779</div>
        <div>Vaninside. all rights reserved</div>
      </v-col>
    </v-footer> -->
  </v-app>
</template>

<script>


export default {
  name: "App",

  data: () => ({
    //
  }),
};
</script>

<style scoped>
.footer-box {
  background-color:rgb(64,64,64);
  padding: 1rem;
  text-align: center;
  color:white;
  font-size: 0.8rem;
}
</style>
