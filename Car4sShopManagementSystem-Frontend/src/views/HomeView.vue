<template>
  <div class="container">
    <p style="font-size: xx-large; margin: 10px">欢迎使用汽车4S店管理系统</p>
    <el-button type="primary" @click="OnEnterButtonClick" size="large" style="font-size: large"
      >进入系统</el-button
    >
  </div>
</template>

<script lang="ts">
export default {
  methods: {
    //登录按钮点击事件
    OnEnterButtonClick() {
      this.$router.push({ name: 'loginRegister' })
    },
  },
}
</script>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
