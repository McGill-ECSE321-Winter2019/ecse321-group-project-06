<template>
  <div class="hello">
    <div>
      <b-jumbotron header="Cooperator" lead="ECSE321-Winter2019-Development Unit3-Group6">
        <p>For more information visit <a href="https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06">website</a></p>
        <b-row class="justify-content-md-center mt-lg-4">
          <b-list-group horizontal>
            <b-list-group-item>Lily Li</b-list-group-item>
            <b-list-group-item>Irene Huang</b-list-group-item>
            <b-list-group-item>Yin Zhang</b-list-group-item>
            <b-list-group-item>Xinquan Wang</b-list-group-item>
            <b-list-group-item>Zhuzhen Li</b-list-group-item>
          </b-list-group>
        </b-row>
      </b-jumbotron>
    </div>
  </div>
</template>

<script>
  import router from '../router';
export default {
  name: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    navigate() {
      router.push({ name:"Dashboard" });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
