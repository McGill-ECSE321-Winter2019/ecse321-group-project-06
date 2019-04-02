<template>
  <div id="event">
    <b-card v-bind:title="event" sub-title="event">
      <b-card-text>{{text}}</b-card-text>
      <b-card-text>{{location}}</b-card-text>
    </b-card>
  </div>
</template>

<script>
    export default {
      name: "Event",
      props: ['event', 'text', 'location']
    }
</script>

<style scoped>
#event{
  width: 500px;
}
  h4{
    color: #ff4d00;
  }
</style>
