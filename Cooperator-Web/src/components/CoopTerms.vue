<template>
  <div id="table">
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
        <div class="container" style="align:center">
          <h1 class="page-title">All Coop-Terms</h1>
            <div class="container" align="center">


              <table style="width: 100%; height: 100%;" id="CoopTermTable">
                <tr style="font-size:25px" >
                  <th style="padding:10px" id = "text">NAME</th>
                  <th style="padding:10px" id = "text">START DATE</th>
                  <th style="padding:10px" id = "text">END DATE</th>
                  <th style="padding:10px" id = "text">STATUS</th>
                  <th style="padding:10px" id = "text">ACTION</th>
                </tr>
                <tr v-for="coopTerm in template">
                  <td style="padding:10px" id = "contentText">{{coopTerm.name}}</td>
                  <td style="padding:10px" id = "contentText">{{coopTerm.startDate}}</td>
                  <td style="padding:10px" id = "contentText">{{coopTerm.endDate}}</td>
                  <td style="padding:10px" id = "contentText">{{isActive(coopTerm)}}</td>
                  <td>
                    <b-button id = "button"   v-bind:to="{path:'/Coop-Page'}" class="mr-1" style=" margin: 10px" >      view   </b-button>

                  </td>
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
  padding: 10px;
}
  #CoopTermTable{
    background-color: #D2D1D1;
    border: 20px;
    margin: 5px;
    font-size: 20px;
  }

  #text{
    text-align: center;
    color: #EC3A0E;
  }

  #contentText{
    text-align: center;
    color: #0C0A0A;
  }

  #button{
    size:lg;
    margin:auto;
    display:block;

  }

</style>
