<template>
  <div id="main-text">
    <h1 id="main-title">공지사항</h1>
    <hr id="main-line" />
    <div id="notice-below-button">
      <button v-bind:class="primebtn" @click="register">글 작성</button>
    </div>

    <table class="table table-hover table-bordered" id="notice-table">
          <thead class="thead-light">
            <tr>
              <th scope="col">No.</th>
              <th scope="col">제목</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
             <tr v-for="(data,index) in dataset" v-bind:key="index">
            <td>{{data.id}}</td>
            <td>{{data.title}}</td>
            <td>{{data.time}}</td>
            </tr>
          </tbody>

          <!-- 첫번째 줄 끝 -->
        </table>
    
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
import axios from "axios";
import IP from "../../static/IP";

export default {
  mounted() {
      var vm = this;
      var pageid = 0;

      axios
        .get("http://" + IP.IP + ":8080/notice/noticeList", {
          params: { size:10, page:pageid },
          timeout: 10000,
        })
        .then((res) => {
            vm.dataset = res.data.content;
          });
  },
  data() {
    return {
      dataset:[],
      primebtn:
        "row-sm-1 col-sm-1.5 btn btn-primary disabled btn-sm below-button",
    };
  },
  methods: {
    register() {
      console.log("Login Button Pressed");
    },
  },
};
</script>

<style scoped>
.below-button {
  margin: 0 0.5rem 0 0;
  /* height: 2%; */
}
.btn-primary {
  background-color: rgb(94, 94, 94);
}
#notice-below-button {
  display: flex;
  justify-content: flex-end;
  margin: 0.5rem 0 0.5rem 0;
}
#notice-content {
  margin: 1rem 1rem 1rem 1rem;
}
#notice-title {
  font-weight: bold;
}
#title-box {
  display: flex;
  justify-content: space-between;
}
#main-text {
  margin: 2rem 20% 2rem 20%;
}
#page_title {
}

#page_title_line {
  height: 4px;
  background: rgb(25, 94, 76);
}

#page_bottom_line {
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
</style>