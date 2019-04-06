<template>
  <div id="table">
    <div class="site-wrap">
      <div class="site-section" style="padding-top:10%">
        <div class="container" style="align:center">
          <h1 class="page-title">All Coop-Terms</h1>

          <div class = "container">

          <b-row>

            <b-col md="6" class="my-1">
              <b-form-group label-cols-sm="3" label="Filter" class="mb-0">
                <b-input-group>
                  <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
                  <b-input-group-append>
                    <b-button :disabled="!filter" @click="filter = ''">Clear</b-button>
                  </b-input-group-append>
                </b-input-group>
              </b-form-group>
            </b-col>

          </b-row>

          </div>

          <div class="container" align="center">

            <div id="table1">
              <b-table ref="table"
                       class="info-table"
                       selectable select-mode="single"
                       striped hover
                       :items= "coopTerms"
                       :fields= "fields"
                       @click = "coopTermView"
                       :filter="filter"
              >
                <template slot="action" slot-scope="row">
                  <b-button size="sm" @click.stop="coopTermView(row.item)">Coop Term</b-button>
                </template>


              </b-table>
            </div>

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
