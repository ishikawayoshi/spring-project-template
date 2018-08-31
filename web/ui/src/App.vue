<template>
  <div id="app">
    <nav-bar></nav-bar>
    <div class="container">
      <page-input @updateTable="updateTable"></page-input>
      <b-table :items="myPages" :striped="true" :hover="true" :small="true"></b-table>
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
      this.updateTable();
    },
    methods:{
      updateTable(){
        this.axios.get("/api/pages").then(resp => {
          this.myPages = resp.data;
        })
      }
    }
  }
</script>

<style lang="scss">
</style>
