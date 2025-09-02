<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import LoginRegisterView from './views/LoginRegisterView.vue'
</script>

<template>
  <div class="pageHeader"><p style="font-size: xx-large; margin: 0">汽车4S店管理系统</p></div>
  <div class="pageMain">
    <RouterView />
  </div>
</template>

<script lang="ts">
export default {}
</script>

<style>
.pageHeader {
  display: flex;
  width: 100%;
  height: 5%;
  justify-content: center;
  align-items: center;
  background-color: rgb(85, 190, 255);
}

.pageMain {
  width: 100%;
  height: 95%;
}
</style>
