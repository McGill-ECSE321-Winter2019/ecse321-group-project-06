<template>
  <div>
    <h1>Events</h1>
    <b-container id="events">
      <b-row class="no-gutters">
        <b-col>
          <Event event="Tech Fair" text="Whether you have jobs today or will have jobs in the future, McGill students and alumni want to know more about your organization and potential careers!"/>
        </b-col>
        <b-col>
          <Event event="On Campus Recruitment" text="on campus recruitment for your organization"/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
  import Event from "./Event";
    export default {
      name: "Events",
      components: {
          Event
      }
    }
</script>

<style scoped>
#events{
  padding: 25px;
}
</style>
