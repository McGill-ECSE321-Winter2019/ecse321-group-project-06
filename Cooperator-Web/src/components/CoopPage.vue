<template>


  <div class="site-wrap">
    <div class="site-section" style="padding-top:10%">
      <div class="container" style="align:center">
        <div id="cooppage" class="ml-lg-12 overflow-auto">

          <b-container>
            <b-row>
              <b-col class="col-lg-12">
                <h3 class="card-title" data-aos="fade-up" data-aos-delay="100">Coop Term</h3>
                <div class="card" style="width: 60rem;" data-aos="fade-up" data-aos-delay="200">
                  <div class="overflow-auto">
                    <div class="card-body">

                      <button type="button" class="btn btn-default text-black ">
                        <router-link :to="{name: 'Coopterms'}"><a> Back </a></router-link>
                      </button>


                      <form>
                        <div class="form-group row">
                          <label for="staticEmail1" class="col-sm-4 col-form-label col-lg-3">Student Name</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail1"
                                   v-bind:value="`${student.name}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Email</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail"
                                   v-bind:value="`${student.email}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Coop Term Start Date</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail2"
                                   v-bind:value="`${coopStartDate}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Coop Term End Date</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail3"
                                   v-bind:value="`${coopEndDate}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Academic Semester</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" rows="5" columns="30"
                                   id="staticEmail4" v-bind:value="`${coopTerm.academicSemester}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Job Description</label>
                          <div class="col-sm-8">
                            <button @click="coopJobDescription()"
                                    type="button"
                                    class="btn btn-default text-white  "
                            > Link
                            </button>
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Location</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="2"
                                   v-bind:value="`${coopTerm.location}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Work Permit Needed?</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="3"
                                   v-bind:value="`${workPermit}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Upload Student Evaluation Form</label>
                          <UploadFile v-on:downloadURL="handleDownLoadURLInParent"/>
                          <div class="col-sm-2">
                            <button @click="updateCoopTerm()"
                                    type="button"
                                    class="btn btn-default text-white"
                            > Upload
                            </button>
                          </div>
                          <div  v-if="this.coopTerm.evaluationForm!==null" class="col-sm-2">
                              <button @click="evaluationFormView()"
                                      type="button"
                                      class="btn btn-default text-white"
                              > DownLoad
                              </button>
                          </div>

                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-4 col-form-label col-lg-3">Confirm Coop Term</label>

                          <a  @click="confirmCoopTerm()" class="btn-custom aos-init aos-animate">
                            <span>Confirm</span>
                          </a >

                          <span v-if="this.coopTerm.state==='ACTIVE'" class='btn btn-primary' color="white"> ✔ </span>


                        </div>

                        <button type="button" class="btn btn-default text-black ">
                          <router-link :to="{name: 'Coopterms'}"><a> Back </a></router-link>
                        </button>


                      </form>

                    </div>
                  </div>
                </div>
              </b-col>
            </b-row>
          </b-container>


        </div>
      </div>

    </div>
  </div>


</template>

<script src="./CoopPage.js">
</script>

<style scoped>
  #cooppage {
    height: 500px;
    padding: 20px 0px 20px 40px;

  }

  span {
    padding-top: 20px;
    color: white;
  }

  a {
    color: white;
    -webkit-transition: .3s all ease;
    -o-transition: .3s all ease;
    transition: .3s all ease;
    font-weight: 300;
    text-emphasis-position: over;

  }

  button {
    padding: 5px 5px;
  }

  .btn-default {
    background-color: #ff5733;
    padding: 10px;
  }

  .btn-custom {
    text-transform: uppercase;
    color: #fff !important;
    background: #ff380d;
    padding: 16px 30px;
    display: inline-block;
    letter-spacing: .2em;
    position: relative;
  }

  .btn-primary {
    background-color: #ff380d;
  }

  label {
    color: #ff5733;
  }

  form {
    margin-top: 20px;
  }

  h3 {
    color: #ff5733;
    text-align: justify-all;
    font-family: inherit;
    text-transform: uppercase;
  }


</style>


