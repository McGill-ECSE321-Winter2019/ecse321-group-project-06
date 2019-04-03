<template>
  <div id="table">
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
        <div class="container" style="align:center">
          <h1 class="page-title">All Coop-Terms</h1>
            <div class="container" align="center">
              <table style="width: 100%; height: 100%; border:1px solid black; border-collapse:collapse;"  id="CoopTermTable" >
                <tr style="font-size:25px"    >
                  <th style="padding:10px; border:1px solid black;"   id = "text">NAME</th>
                  <th style="padding:10px; border:1px solid black;" id = "text">START DATE</th>
                  <th style="padding:10px; border:1px solid black;" id = "text">END DATE</th>
                  <th style="padding:10px; border:1px solid black;" id = "text">STATUS</th>
                  <th style="padding:10px; border:1px solid black;" id = "text">ACTION</th>
                </tr>

                <tr v-for="coopTerm in coopTerms" >
                  <td style="padding:10px; border:1px solid black;" id = "contentText">{{coopTerm.student}}</td>
                  <td style="padding:10px; border:1px solid black;" id = "contentText">{{coopTerm.startDate.substr(0,10)}}</td>
                  <td style="padding:10px; border:1px solid black;" id = "contentText">{{coopTerm.endDate.substr(0,10)}}</td>
                  <td style="padding:10px; border:1px solid black;" id = "contentText">{{isActive(coopTerm)}}</td>
                  <td style="padding:10px; border:1px solid black;">
                    <b-button id = "button"   v-bind:to="{path:'/coop-page/coopterm='+coopTerm.coopTermId+'&student='+coopTerm.studentId}" class="mr-1" style=" margin: 10px" >      view   </b-button>

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
   // border: 1px solid black;
    background-color: #D2D1D1;
    margin: 5px;
    font-size: 20px;

  }

  #text{
   // border: 1px solid black;
    text-align: center;
    color: #EC3A0E;
  }

  #contentText{
   // border: 1px solid black;
    text-align: center;
    color: #0C0A0A;
  }

  #button{

    size:lg;
    margin:auto;
    display:block;

  }

</style>
