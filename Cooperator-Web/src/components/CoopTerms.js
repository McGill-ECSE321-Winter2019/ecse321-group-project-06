import axios from 'axios'
import Vue from 'vue'
var config = require('../../config')
//
// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var frontendUrl = 'https://' + config.build.host + ':'
var backendUrl = 'https://' + config.build.backendHost + ':'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    data(){
      return {
        id: '',
        students: '',
        studentsName: [],
        coopTerms:[],
        nameSort:'name',
        sortDir:'asc',
        statusSort: 'status',
        sortBy: null,
        sortDesc: false,
        sortDirection: 'asc',
        filter: null,

          fields: {
            student: {
              label: "NAME",
              sortable: true
            },
            startDate: {
              label: "START DATE",
              sortable: true
            },
            endDate: {
              label: "END DATE",
              sortable: true
            },
            status: {
              label: "ACTIVE",
              sortable: true
            },
            action: {
              label: "COOP TERM",
              sortable: false
            }
          }

      }

  },

    created: function () {
      this.id = this.$cookie.get('id')
      AXIOS.get(`coopTerm/employer/`+this.id)
        .then(response => {
          this.coopTerms = response.data

        }).then(()=>{

        for (var i = 0; i < this.coopTerms.length; i++) {
          var coopTerm = this.coopTerms[i];
          //Handle Json startDate
          var startDate = new Date(coopTerm.startDate)
          var year = startDate.getFullYear();
          var month = startDate.getMonth() + 1;
          var dt = startDate.getDate();
          startDate.getDate()
          if (dt < 10) {
            dt = '0' + dt;
          }
          if (month < 10) {
            month = '0' + month;
          }
          startDate = (year + '-' + month + '-' + dt);
          coopTerm.startDate = startDate;

          //Handle Json endDate
          var endDate = new Date(coopTerm.endDate)
          var endYear = endDate.getFullYear();
          var endMonth = endDate.getMonth() + 1;
          var endDt = endDate.getDate();

          endDate.getDate()
          if (endDt < 10) {
            endDt = '0' + endDt;
          }
          if (endMonth < 10) {
            endMonth = '0' + endMonth;
          }
          endDate = (endYear + '-' + endMonth + '-' + endDt);
          coopTerm.endDate = endDate;

          //Determine if it is a active coop term or not
          var current = new Date()
          if (year <= current.getFullYear() && current.getFullYear() <= endYear &&
            month <= current.getMonth() && current.getMonth() <= endMonth &&
            dt <= current.getDay() && current.getDay() <= endDt) {
              coopTerm.status = 'ACTIVE'
            }
            else {
              coopTerm.status = 'INACTIVE'
            }


        }
        this.getStudent();
          this.$refs.table.refresh();
      })
        .catch(e =>{
          console.log("error in get coopterm request: " + e);
          this.error = e;
        })
  },

  methods: {
    getStudent: async function(){
      for (var i = 0; i < this.coopTerms.length; i++) {
        var id = this.coopTerms[i].studentId
        await this.getName(id, i);
      }
    },
    getName: function(id, i){
      AXIOS.get(`student/` + id)
        .then(res => {
          Vue.set(this.coopTerms[i], 'student', res.data['name']);
        })
        .catch(e => {
          console.log("error in get student request:" + e);
          this.error = e;
        })
    },

    coopTermView(item) {
     // var coopId = item[0].coopId
      var coopId = item.coopTermId
      var studentId = item.studentId
      //var studentId = item[0].studentId
      window.location.href = '/#/coop-page/coopterm='+coopId+'&student='+studentId
    }

  },
  computed: {
    sortOptions() {
      // Create an options list from our fields
      return this.fields
        .filter(f => f.sortable)
        .map(f => {
          return {text: f.label, value: f.key}
        })
    }
  }

}
