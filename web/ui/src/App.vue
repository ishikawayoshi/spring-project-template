<template>
  <div id="app">
    <nav-bar></nav-bar>
    <div class="container">
      <page-input></page-input>
      <b-table :items="myPages"></b-table>
    </div>
  </div>
</template>

<script>
  import NavBar from './components/NavBar';
  import PageInput from './components/PageInput';

  export default {
    name: 'app',
    components: {NavBar, PageInput},
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        myPages: []
      }
    },
    mounted() {
      this.axios.get("/api/pages").then(resp => {
        this.myPages = resp.data;
      })
    }
  }
</script>

<style lang="scss">
</style>
