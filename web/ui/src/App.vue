<template>
  <div id="app">
    <nav-bar></nav-bar>
    <div class="container">

      <b-table :items="myPages" :fields="fields" :striped="true" :hover="true" :small="true">
        <template slot="actions" slot-scope="row">
          <!-- We use @click.stop here to prevent a 'row-clicked' event from also happening -->
          <b-button size="sm" @click="info(row.item, row.index, $event.target)">Info</b-button>
          <b-button size="sm" @click="add(row.item, row.index, $event.target)">Add</b-button>
          <b-button size="sm" @click="deleteElement(row.item, row.index, $event.target)">Delete</b-button>
        </template>
      </b-table>
      <!-- Info modal -->
      <b-modal id="modalInfo" ref="infoModalRef" @hide="resetModal" :title="modalInfo.title" ok-only>
        <pre>{{ modalInfo.content }}</pre>
      </b-modal>
      <!-- Info modal -->
      <b-modal id="modalAdd" ref="addModalRef"@hide="resetModal" :title="modalInfo.title" ok-only>
        <page-input @updateTable="updateTable"></page-input>
      </b-modal>
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
        myPages: [],
        modalInfo: {title: '', content: ''},
        fields: [
          {key: 'id', label: 'Id', sortable: true, sortDirection: 'desc'},
          {key: 'fileUrl', label: 'File Url', sortable: true, 'class': 'text-center'},
          {key: 'name', label: 'Name'},
          {key: 'actions', label: 'Actions'}
        ],
      }
    },
    mounted() {
      this.updateTable();
    },
    methods: {
      updateTable() {
        this.axios.get("/api/pages").then(resp => {
          this.myPages = resp.data;
          this.$refs.infoModalRef.hide();
          this.$refs.addModalRef.hide();
        })
      },
      info(item, index, button) {
        this.modalInfo.title = `Row index: ${index}`;
        this.modalInfo.content = JSON.stringify(item, null, 2);
        this.$root.$emit('bv::show::modal', 'modalInfo', button)
      },
      add(item, index, button) {
        this.modalInfo.title = `Add item:`;
        this.$root.$emit('bv::show::modal', 'modalAdd', button);
      },
      deleteElement(item, index, button) {
        this.axios.delete('/api/page', {params: item}).then(resp => {
          this.updateTable();
        });
      }
    }
  }
</script>

<style lang="scss">
</style>
