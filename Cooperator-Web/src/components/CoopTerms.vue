<template>
  <div id="table">
    <b-table striped hover bordered dark :fields="fields" :items="items" fixed>
      <template slot="actions" slot-scope="row">
        <b-button size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
          view coopterm
        </b-button>
      </template>
    </b-table>
  </div>
</template>

<script>
    export default {
        name: "CoopTerms",
      data(){
          return {
            items:[
              {name: "John Smith", startDate: 2019, endDate: 2020},
            ],
            fields: [
              {key:'name', label: 'Name'},
              {key:'startDate', label: 'Start Date'},
              {key:'endDate', label: 'End Date'},
              {key:'actions', label: 'Actions'}
            ]
          }
      }
    }
</script>

<style scoped>
#table{
  padding: 20px;
}
</style>
