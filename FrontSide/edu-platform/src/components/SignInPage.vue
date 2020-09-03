<template>
  <div id="main-text">
    <div id="main-title">로그인</div>
    <hr id="main-line" />
    <div class="row justify-content-center">
      <div class="col-sm-4 col-sm-offset-3">
        <label class="sr-only" for="adminid">Admin ID</label>
        <input
          v-bind:class="textinput"
          type="text"
          id="adminid"
          v-model="loginID"
          title="managerid"
          placeholder="아이디"
        />
        <br />
        <label class="sr-only" for="adminpwd">Admin Password</label>
        <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
        <br />
        <button v-bind:class="primebtn" @click="loginEdu">로그인</button>
        <!--얘가 여기 말고 다른 곳에 있을 경우, props / emit으로 데이터를 주고받아야함 -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IP from "../../static/IP";
import { EventBus } from "../utils/event-bus";

export default {
  data() {
    return {
      loginID: "",
      loginPass: "",
      primebtn: "btn btn-primary disabled btn-block",
      textinput: "form-control",
    };
  },
  methods: {
    loginEdu() {
      console.log("Login Button Pressed");
      // axios -> post를 날리면 끝!
      var vm = this;
      axios
        .post("http://" + IP.IP + ":8080/auth/signin", {
          username: vm.loginID,
          password: vm.loginPass,
          timeout: 10000,
        })
        .then((res) => {
          console.log(res);
          if (res.data.status == 0)
            alert("로그인 오류입니다. 아이디와 비밀번호를 확인하세요.");
          else{ 
            localStorage.setItem("accesstoken-untact", res.data.accessToken);
            
            EventBus.$emit("login-success");
          }
        });
    },
  },
};
</script>

<style scoped>
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
input {
  /* margin:0em 0em 0.5em 0em; */
  display: flex;
  align-items: center;
}
.btn-primary {
  background-color: rgb(224, 224, 224);
  border-color: rgb(224, 224, 224);
  color: #000;
}
</style>