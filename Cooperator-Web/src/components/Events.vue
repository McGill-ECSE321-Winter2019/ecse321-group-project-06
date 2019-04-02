<template>
  <div>
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
        <div class="container" style="align:center">
          <h1>Events</h1>
          <b-container id="events" data-aos="fade-up">
            <b-row class="no-gutters">
              <b-col>
                <Event event="Tech Fair"
                       text="Whether you have jobs today or will have jobs in the future,
                       McGill students and alumni want to know more about your organization and potential careers!"
                location="montreal"></Event>
              </b-col>
              <b-col>
                <Event event="On Campus Recruitment" text="on campus recruitment for your organization" location="montreal"></Event>
              </b-col>
            </b-row>
          </b-container>
          <div>
            <div v-for="event in events">
              <b-container>
                <b-row>
                  <Event event="event" text="event text" v-bind:location="`${event.location}`" ></Event>
                </b-row>
              </b-container>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./events.js">
</script>

<style scoped>
#events{
  padding: 25px;
}
</style>
