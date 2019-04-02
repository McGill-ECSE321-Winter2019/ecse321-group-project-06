<template>
  <div id="register">
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
      <div class="half left">
        <div class="container" style="align:center">
          <b-container>
          <div class="row align-items-center" align="center">
            <div class="col-md-10" align="center" style="padding-left:10%">
              <h1 class="d-block mb-4">CO-OPERATOR</h1>


              <div class="half right" data-aos="fade-up" vertical-align = top>
                <!--<div class="container" align="center"  vertical-align = top>-->


                  <select v-model="selected">
                    <option value="Select">Select</option>
                    <option value="Employer">Employer</option>

                  </select>


                  <div class="form-group">
                    <label >Name</label>
                    <input v-model="name" type="text" name="Name" id="name"  class="form-control" style="width: 300px;" aria-describedby="emailHelp" placeholder="Enter Name">
                  </div>



                  <div class="form-group">
                    <label >Email</label>
                    <input v-model="email" type="text" name="Email" id="email"  class="form-control" style="width: 300px;" aria-describedby="emailHelp" placeholder="Enter Email">
                  </div>

                  <div class="form-group">
                    <label >Password</label>
                    <input v-model="password" type="text" name="Password" id="password"  class="form-control" style="width: 300px;" aria-describedby="emailHelp" placeholder="Enter Password">
                  </div>



                  <!--
                  <input
                  class="login-text"
                  type="text"
                  placeholder="Name"
                  name = "Name"
                  v-model="name"
                />

                  <input
                    class="login-text"
                    type="text"
                    placeholder="Email"
                    name = "Email"
                    v-model="email"
                  />
                  <input
                    class="login-text"
                    type="password"
                    placeholder="Password"
                    name = "Password"
                    v-model="password"
                  />
        -->
                  <input @click="register(name, email, password, selected)"
                         type="submit"
                         value="Register"
                         class="btn btn-primary py-2 px-4 text-white"
                  />

                  <div class="form-group">
                    <b-button
                      class="btn btn-primary py-2 px-4 text-white"
                      align="left"
                      v-bind:to="{path:'/'}"> Go To Login </b-button>
                  </div>

                  <br>
                  <span v-if="errorRegister" style="color:red">Error: {{errorRegister}} </span>
                  <span v-if="response" style="color:green">Success: {{response}} </span>
                </div>
              </div>
            </div>
          </b-container>
          </div>

        </div>
      </div>
    </div>

    </div>

</template>

<script src="./Register.js">
</script>

<style>
  h1{
    color:#ff4d00
  }
</style>

