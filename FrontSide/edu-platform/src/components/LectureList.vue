<template>
  <div id="main-text">
    <h1 id="main-title">수강신청</h1>
    <hr id="main-line" />
    <div class="row upper-box">
      <div class="col-sm-10 col-sm-offset-5">
        <label class="sr-only" for="adminid">Admin ID</label>
        <input
          v-bind:class="textinput"
          type="text"
          id="adminid"
          v-model="loginID"
          title="managerid"
          placeholder="강의명을 입력해 주세요"
        />
      </div>

      <button v-bind:class="primebtn" @click="modifyNotice">검색</button>
    </div>
    <!-- <button id="search-button" type="button" name="name">찾기</button> -->

    <hr id="below-search" />

    <div id="lecture-list">
      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>

      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>

      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>

      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>

      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>

      <div>
        <img :src="sampleImg" alt="My Image" />
        <p>Class Title</p>
      </div>
    </div>

    <div class="container">
			<div class="row">
				<div class="col">
					<ul class="pagination justify-content-center">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textinput: "form-control",
      sampleImg: require("../../static/img/classImage.png"),
      primebtn:
        "row-sm-1 col-lg-1 btn btn-primary disabled btn-sm below-button",
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
#below-search {
}

.upper-box {
  display: flex;
  /* height: 50px; */
  align-items: center;
  justify-content: space-around;
}

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