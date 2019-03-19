<template>
    <div id="dashboard">

      <b-container id="content">
        <b-row>
          <b-col>
            <Event />
          </b-col>
          <b-col>
            <Event />
          </b-col>
        </b-row>
      </b-container>
    </div>
</template>

<script>
  import Event from './Event'
    export default {
        name: "dashboard",
      components: {
          Event
      }
    }
</script>

<style scoped>
  #dashboard{
    border-radius: 3px 0px 0px 3px;
    background-color: #dadada;
  }

  #content{
    padding: 20px;
  }


</style>
