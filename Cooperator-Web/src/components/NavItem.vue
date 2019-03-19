<template>
  <div class="item">
    <b-nav-item v-bind:to="{ path: `${link}` }">
      {{text}}
    </b-nav-item>
  </div>
</template>

<script>
    export default {
      name: "NavItem",
      props: ['text', 'link']
    }
</script>

<style scoped>
  .item{
    border-radius: 2px;
    color: #f1f1f1;
    padding: 5px;
  }
  .item:hover{
    background-color: #9099a2;
  }
  .nav-link{
    color: #f1f1f1;
  }
  .nav-link:hover{
    color: black;
  }
</style>
