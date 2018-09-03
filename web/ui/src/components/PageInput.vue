<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="exampleInputGroup1"
                    label="File URL:"
                    label-for="exampleInput1"
                    description="We'll never share your url with anyone else.">
        <b-form-input id="exampleInput1"
                      type="text"
                      size="sm"
                      v-model="form.fileUrl"
                      required
                      placeholder="Enter your url">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="File Name:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      size="sm"
                      v-model="form.name"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
      <!--<b-form-group id="exampleInputGroup3"-->
                    <!--label="Food:"-->
                    <!--label-for="exampleInput3">-->
        <!--<b-form-select id="exampleInput3"-->
                       <!--:options="foods"-->
                       <!--required-->
                       <!--v-model="form.food">-->
        <!--</b-form-select>-->
      <!--</b-form-group>-->
      <!--<b-form-group id="exampleGroup4">-->
        <!--<b-form-checkbox-group v-model="form.checked" id="exampleChecks">-->
          <!--<b-form-checkbox value="me">Check me out</b-form-checkbox>-->
          <!--<b-form-checkbox value="that">Check that out</b-form-checkbox>-->
        <!--</b-form-checkbox-group>-->
      <!--</b-form-group>-->
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        form: {
          name: '',
          fileUrl:''
        },
        show: true
      }
    },
    methods: {
      onSubmit (evt) {
        evt.preventDefault();
        this.axios.post("/api/pages",this.form).then(resp=>{
          console.log(resp.data);
          this.$emit("updateTable");
          this.form.name = '';
          this.form.fileUrl = '';
        })
      },
      onReset (evt) {
        evt.preventDefault();
        /* Reset our form values */
        this.form.name = '';
        this.form.fileUrl = '';
        this.show = false;
        this.$nextTick(() => { this.show = true });
      }
    }
  }
</script>

<style scoped>

</style>
