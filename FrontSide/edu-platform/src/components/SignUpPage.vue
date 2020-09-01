<template>
  <div id="main-text">
    <h1 id="main-title">회원가입</h1>
    <hr id="main-line" />

    <div class="input-box">
    <span id="type">유형</span>
    <select name>
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
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
</div>
    <br />
    <div class="input-box">
    <span id="id">아이디</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
<button v-bind:class="primebtn" @click="loginEdu">로그인</button>
    </div>
    <br />
    <div class="input-box">
    <span id="password">비밀번호</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
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
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span id="email">이메일</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span id="phone">전화번호</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
    </div>
    <br />
    <div class="input-box">
    <span id="invite">초대코드</span>
    <div class="col-sm-5 col-sm-offset-5">
    <input
          v-bind:class="textinput"
          type="password"
          id="adminpwd"
          v-model="loginPass"
          title="managerpass"
          placeholder="비밀번호"
        />
    </div>
    </div>
    <br />
    <br />
<button v-bind:class="primebtn" @click="loginEdu">로그인</button>
  </div>
</template>

<script>
export default {
    data() {
    return {
      loginID: "",
      loginPass: "",
      primebtn: "btn btn-primary disabled btn-block",
      textinput: "form-control",
    };
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