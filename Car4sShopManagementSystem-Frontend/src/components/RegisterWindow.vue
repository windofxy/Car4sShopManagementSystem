<template>
  <el-container>
    <el-header style="text-align: center"> 注册 </el-header>
    <el-main>
      <el-input size="large" placeholder="请输入用户名"></el-input>
      <el-input size="large" placeholder="请输入密码"></el-input>
      <el-input size="large" placeholder="请输入确认密码"></el-input>
    </el-main>
    <el-footer style="text-align: center">
      <el-button type="primary">注册</el-button>
      <el-button type="primary" @click="OnGoLoginButtonClick">前往登录</el-button>
    </el-footer>
  </el-container>
</template>

<script lang="ts">
export default {
  methods: {
    //前往登录按钮点击事件
    OnGoLoginButtonClick() {
      this.$emit('goLogin')
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
