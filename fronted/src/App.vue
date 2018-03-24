<template>
  <div id="app">
    <el-container direction="horizontal">
      <el-main>

        <h1><i class="el-icon-circle-check"> </i> 短网址服务</h1>
        <h5>简单 / 易用 / 便捷</h5>
        <h5>Powered By zzkun.com</h5>
        <main-converter/>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import MainConverter from "./components/MainConverter";

  export default {
    components: {MainConverter},
    name: 'App',
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
