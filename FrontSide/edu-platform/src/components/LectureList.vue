<template>
  <div id="main-text">
    <h1 id = "main-title">수강신청</h1>
<hr id = "main-line">
<input id = "search" type="text" name="search" value="검색어를 입력하세요!">
<button id="search-button" type="button" name="name">찾기</button>

  <div id = "lecture-list">
    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>

    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>

    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>

    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>

    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>

    <div>
      <img src="classImage.PNG" alt="My Image">
      <p>Class Title</p>
    </div>
</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textinput: "form-control",
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
  margin: 5rem 20% 2rem 20%;
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
 #page-title {
  }

  #page-title-line {
    height : 5px;
    background : rgb(25,94,76);
  }

  #lecture-list {
    display : flex;
  }

</style>