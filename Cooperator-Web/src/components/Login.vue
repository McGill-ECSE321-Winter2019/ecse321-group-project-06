<template>

  <div id="login">
    <div class="site-wrap">
      <div class="site-section site-hero" >
        <div class="half left">
          <div class="container" align="center">

            <div class="col-md-10" align="center" >
              <h1 class="d-block mb-4">CO-OPERATOR</h1>
            </div>

          </div>
        </div>

        <div class="half right"  data-aos="fade-up">
          <div class="container" align="center">

            <div class="form-group">
              <label for="email">Email address</label>
              <input v-model="username" type="email" name="email"  class="form-control" id="email" style="width: 300px;" aria-describedby="emailHelp" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input v-model="password"type="password" name="password" id="password"  class="form-control" style="width: 300px;" aria-describedby="emailHelp" placeholder="Enter Password">
            </div>

            <div class="form-group">
              <b-button @click="login(username, password)"
                     type="submit"
                     value="Login"
                     class="btn btn-primary py-2 px-4 text-white"
              > Login </b-button>
            </div>

            <div class="form-group">
              <b-button value="Register"
                        class="btn btn-primary py-2 px-4 text-white"
                        v-bind:to="{path:'/register'}"> Register </b-button>
            </div>

            <span> {{errorLogin}}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src ="./Login.js"></script>
