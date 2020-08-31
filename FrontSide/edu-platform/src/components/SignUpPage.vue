<template>
    <div id="main-text">
        <div class="row justify-content-center">
        <div class="col-sm-4 col-sm-offset-3">
        <label class="sr-only" for="adminid">Admin ID</label>
        <input v-bind:class="textinput" type="text" id="adminid" v-model="newProjectID" title="managerid" placeholder="관리자 계정명"><br>
        <label class="sr-only" for="adminpwd">Admin Password</label>
        <input v-bind:class="textinput" type="password" id="adminpwd" v-model="newProjectPass" title="managerpass" placeholder="관리자 계정 비밀번호"><br>
        <button v-bind:class="primebtn" @click="loginProject">프로젝트 로그인</button> <!--얘가 여기 말고 다른 곳에 있을 경우, props / emit으로 데이터를 주고받아야함 --> 
        </div>
    </div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>

</style>