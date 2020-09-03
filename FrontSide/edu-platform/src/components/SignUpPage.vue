<template>
  <div id="main-text">
    <h1 id="main-title">회원가입</h1>
    <hr id="main-line" />

    <div class="input-box">
    <span id="type">유형</span>
    <select v-model="roletype">
      <option value>학생</option>
      <option value>강사</option>
    </select>
    </div>
    <br />

<div class="input-box">
    <span id="name">이름</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="text"
          id="adminpwd"
          v-model="name"
          title="managerpass"
          placeholder="이름"
        />
    </div>
</div>
    <br />
    <div class="input-box">
    <span id="id">아이디</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="text"
          id="adminpwd"
          v-model="username"
          title="managerpass"
          placeholder="아이디"
        />
    </div>
<button v-bind:class="primebtn" :disabled="buttondisable"  @click="idCheck">{{buttonMessage}}</button>
    </div>
    <br />
    <div class="input-box">
    <span id="password">비밀번호</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="pwd"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span>비밀번호 확인</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="pwdcheck"
          title="managerpass"
          placeholder="비밀번호확인"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span id="email">이메일</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="text"
          id="adminpwd"
          v-model="email"
          title="managerpass"
          placeholder="이메일"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span id="invite">초대코드</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="text"
          id="adminpwd"
          v-model="invite"
          title="managerpass"
          placeholder="초대코드"
        />
    </div>
    </div>
    <br />
    <br />
<button v-bind:class="primebtn" @click="signup">가입</button>
  </div>
</template>

<script>
import axios from "axios";
import IP from "../../static/IP";

export default {
    data() {
    return {
      roletype:"",
      buttonMessage:"중복 확인",
      buttondisable:false,
      name:"",
      username: "",
      email:"",
      pwd:"",
      pwdcheck:"",
      invite:"",
      primebtn: "btn btn-primary disabled btn-block",
      textinput: "form-control",
    };
  },
  methods: {
    idCheck() {
      console.log("ID check");
      var vm = this;
      axios
        .get("http://" + IP.IP + ":8080/auth/check", {
          params: { username: vm.username },
          timeout: 10000,
        })
        .then((res) => {
          if (res.data.result == false)
            alert("아이디가 중복입니다!");
          else{
            alert("확인 완료되었습니다");
            vm.buttonMessage = "확인완료";
            vm.buttondisable = true;
          }
        });
    },
    signup() {
      console.log("Sign Up");
      var vm = this;
      var myRole = "학생";

      if(this.roletype == "학생"){
        myRole = "ROLE_STUDENT";
      } 
      else if(this.roletype == "강사") {
        myRole = "ROLE_TEACHER";
      }

      if(this.pwd !== this.pwdcheck) {
        alert("비밀번호를 확인하세요.");
        return;
      }

      if(this.buttondisable == false) {
        alert("아이디 중복확인하세요.");
        return;
      } 

      axios
        .post("http://" + IP.IP + ":8080/auth/signup", {
          username:vm.username,
          name:vm.name,
          email:vm.email,
          password:vm.pwd,
          code :vm.invite,
          role : myRole,
          timeout: 10000,
        })
        .then((res) => {
          if (res.data.status == 2)
            alert("아이디가 중복입니다!");
          else if(res.data.status == 3){
            alert("초대코드가 잘못되었습니다.")
          }else
            {
            alert("가입 완료되었습니다");
            console.log("회원가입 페이지 Okay");
          }
        }); 
    },
  },
};
</script>

<style scoped>
.input-box{
    display: flex;
    justify-content: center;
    align-items: center;
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
#page-title {
}

#page-title-line {
  height: 5px;
  background: rgb(25, 94, 76);
}

#type {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#name {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#id {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#password {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#email {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#phone {
  display: inline-block;
  width: 102px;
  text-align: center;
}

#invite {
  display: inline-block;
  width: 102px;
  text-align: center;
}
</style>