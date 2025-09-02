<template>
  <el-container>
    <el-header> 登录 </el-header>
    <el-main>
      <el-input size="large" v-model="usernameInput" placeholder="请输入用户名"></el-input>
      <el-input
        size="large"
        type="password"
        v-model="passwordInput"
        placeholder="请输入密码"
        show-password
      ></el-input>
    </el-main>
    <el-footer>
      <el-button type="primary">登录</el-button>
      <el-button type="primary" @click="OnGoRegisterButtonClick">前往注册</el-button>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      usernameInput: '',
      passwordInput: '',
    }
  },
  methods: {
    //前往注册按钮点击事件
    OnGoRegisterButtonClick() {
      this.$emit('goRegister')
    },
  },
}
</script>

<style scoped>
.el-header {
  text-align: center;
  font-size: 50px;
}
.el-main {
  display: flex;
  flex-direction: column;
}
.el-footer {
  display: flex;
  flex-direction: column;
}
.el-input {
  align-self: center;
  width: 50%;
  margin: 5px;
}
.el-button {
  align-self: center;
  width: 25%;
  margin: 5px;
}
</style>
