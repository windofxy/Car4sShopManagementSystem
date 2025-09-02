<script setup lang="ts">
import LoginWindow from '@/components/LoginWindow.vue'
import RegisterWindow from '@/components/RegisterWindow.vue'
</script>

<template>
  <div style="display: flex; justify-content: center; align-items: center; height: 100%">
    <LoginWindow @goRegister="OnGoRegisterButtonClick" v-if="isLogin" />
    <RegisterWindow @goLogin="OnGoLoginButtonClick" v-else />
  </div>
</template>

<script lang="ts">
export default {
  data() {
    return {
      //当前为登录还是注册
      // true为登录，false为注册
      isLogin: true,
    }
  },
  methods: {
    //前往登录按钮点击事件
    OnGoLoginButtonClick() {
      this.isLogin = true
    },
    //前往注册按钮点击事件
    OnGoRegisterButtonClick() {
      this.isLogin = false
    },
  },
}
</script>
