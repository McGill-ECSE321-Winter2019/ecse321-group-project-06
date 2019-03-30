<template>


  <div class="site-wrap">
    <div class="site-section" style="padding-top:10%">
      <div class="container" style="align:center">
        <div id="cooppage" class="ml-lg-12 overflow-auto">

          <b-container>

            <b-row>
              <b-col class="col-lg-12">
                <div class="card" style="width: 60rem;">
                  <div class="overflow-auto">
                    <div class="card-body">
                      <h5 class="card-title">Coop Term</h5>


                      <form>
                        <div class="form-group row">
                          <label for="staticEmail1" class="col-sm-2 col-form-label">Student Name</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail1"
                                   v-bind:value="`${student.name}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail"
                                   v-bind:value="`${student.email}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Coop Term Start Date</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail2"
                                   v-bind:value="`${coopStartDate}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Coop Term End Date</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail3"
                                   v-bind:value="`${coopEndDate}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Academic Semester</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" rows="5" columns="30"
                                   id="staticEmail4" v-bind:value="`${coopTerm.academicSemester}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Job Description</label>
                          <!--<div class="col-sm-8">-->
                          <!--<input type="text" readonly class="form-control-plaintext" id="4" v-bind:value="`${coopTerm.jobDescription}`">-->
                          <!--</div>-->

                          <button @click="coopJobDescription()"
                                  type="button"
                                  class="btn btn-default text-black "
                          > Link
                          </button>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Location</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="2"
                                   v-bind:value="`${coopTerm.location}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Work Permit Needed?</label>
                          <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="3"
                                   v-bind:value="`${workPermit}`">
                          </div>
                        </div>

                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Confirm Coop Term</label>

                          <input @click="confirmCoopTerm()"
                                 type="submit"
                                 value="Confirm"
                                 class="btn btn-primary py-2 px-4 text-white"
                          />

                          <span v-if="errorConfirm" class='btn btn-primary'> ✗ </span>
                          <span v-if="confirmTrue" class='btn btn-primary' color="white"> ✔ </span>

                        </div>

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
  }

  .btn-default {
    background-color: #ced4da;
    padding: 15px;
  }

</style>


