<template>
  <div class="hello">
    <div class="site-section site-hero">
      <div class="container">

          <div class="col-md-10">
            <h1 class="d-block mb-4" data-aos = "fade-up" data-aos-delay="100"> {{this.name}},</h1>
            <h1 class="d-block mb-4" data-aos="fade-up" data-aos-delay="200">Welcome to </h1>
            <h1 class="d-block mb-4" data-aos="fade-up" data-aos-delay="300"> Co-operator </h1>

          </div>
        </div>

    </div>
    <div class="site-section">
      <div class="container">
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      data(){
          return {
            name: ''
          }
      },
      created: function (){
          this.name = this.$cookie.get("name")
          console.log(this.name)
      }

    }
</script>

<style scoped>
</style>
