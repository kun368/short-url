<template>
  <div>
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="preUrl" placeholder="输入要缩短的网址"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">缩短网址</el-button>
      </el-form-item>
    </el-form>
    <h4 v-if="shortUrl.length > 0">
      短网址：<a :href="shortUrl" target="_blank">{{shortUrl}}</a> &nbsp;
      <el-button type="primary" round size="mini" :data-clipboard-text="shortUrl" id="copyBtn" @click="showCopyBtnTip">复制</el-button>
    </h4>
  </div>
</template>

<script>
  import Clipboard from 'clipboard';
  let clipboard = new Clipboard('#copyBtn');
  export default {
    name: "main-converter",
    data() {
      return {
        preUrl: "",
        shortUrl: ""
      }
    },
    methods: {
      onSubmit() {
        let urlRegex = /^(ht|f)tp(s?):\/\/[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-.?,'\/\\+&amp;%$#_]*)?$/;
        let regExp = new RegExp(urlRegex);
        if (!regExp.test(this.preUrl))  {
          this.$message({
            message: '暂时不支持此类型URL哦~',
            type: 'warning'
          });
          this.shortUrl = "";
          return;
        }
        this.$http.get('/api/url/longToShort', {params: {url: this.preUrl}})
          .then(ret => {
            this.shortUrl = "http://" + window.location.host + "/" + ret.body.data;
            this.$message({
              message: '生成短网址成功！',
              type: 'success'
            });
          })
      },
      showCopyBtnTip() {
        this.$message({
          message: '已将短网址复制到剪切板',
          type: 'success'
        });
      }
    }
  }
</script>

<style scoped>

</style>
