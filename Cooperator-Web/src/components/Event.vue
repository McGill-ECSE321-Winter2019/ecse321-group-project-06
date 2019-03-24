<template>
  <div id="event">
    <b-card v-bind:title="event" sub-title="Card subtitle">
      <b-card-text>{{text}}</b-card-text>
      <b-card-text>A second paragraph of text in the card.</b-card-text>
      <b-card-text>{{location}}</b-card-text>
      <div slot="footer"><small class="text-muted">Last updated 3 mins ago</small></div>
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
</style>
