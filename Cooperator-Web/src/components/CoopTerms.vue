<template>
  <div id="table">
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
        <div class="container" style="align:center">
          <h1 class="page-title">All Coop-Terms</h1>
            <div class="container" align="center">
              <table style="width:100%" id="CoopTermTable">
                <tr style="font-size:25px">
                  <th>Name</th>
                  <th>Start Date</th>
                  <th>End Date</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
                <tr v-for="coopTerm in template">
                  <td>{{coopTerm.name}}</td>
                  <td>{{coopTerm.startDate}}</td>
                  <td>{{coopTerm.endDate}}</td>
                  <td>{{isActive(coopTerm)}}</td>
                  <td><b-button size="lg"  v-bind:to="{path:'/Coop-Page'}" class="mr-1" style="margin: 5px">   view   </b-button></td>
                  <td></td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script src="./CoopTerms.js">
</script>

<style scoped>
#table{
  padding: 20px;
}
  #CoopTermTable{
    background-color: #9099a2;
    border: 20px;
    margin: 5px;
    font-size: 20px;
  }
</style>
