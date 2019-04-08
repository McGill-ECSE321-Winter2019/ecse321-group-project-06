import axios from 'axios'
import Vue from 'vue'
var config = require('../../config')

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
              label: "STATUS",
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
      /*get coopterms of the employer*/
      AXIOS.get(`coopTerm/employer/`+this.id)
        .then(response => {
          this.coopTerms = response.data

        }).then(()=>{

        for (var i = 0; i < this.coopTerms.length; i++) {
          var coopTerm = this.coopTerms[i]
          //Handle Json startDate
          var startDate = new Date(coopTerm.startDate)
          var year = startDate.getFullYear()
          var month = startDate.getMonth() + 1
          var dt = startDate.getDate();
          if (dt < 10) {
            dt = '0' + dt
          }
          if (month < 10) {
            month = '0' + month
          }
          startDate = (year + '-' + month + '-' + dt)
          coopTerm.startDate = startDate

          //Handle Json endDate
          var endDate = new Date(coopTerm.endDate)
          var endYear = endDate.getFullYear()
          var endMonth = endDate.getMonth() + 1
          var endDt = endDate.getDate()

          if (endDt < 10) {
            endDt = '0' + endDt
          }
          if (endMonth < 10) {
            endMonth = '0' + endMonth
          }
          endDate = (endYear + '-' + endMonth + '-' + endDt)
          coopTerm.endDate = endDate

          //Determine if it is a active coop term or not
          var current = new Date()
          var currentYear = current.getFullYear()
          var currentMonth = current.getMonth() + 1
          var currentDt = current.getDate()
          if (currentDt < 10) {
            currentDt = '0' + currentDt
          }
          if (currentMonth < 10) {
            currentMonth = '0' + currentMonth
          }
          var currentDate = currentYear + '-' + currentMonth + '-' + currentDt
          console.log(currentDate)
          coopTerm.status = "ACTIVE";
          for(var k = 0; k < startDate.length; k++){
            if(currentDate.charAt(k) === "-"){
              continue;
            }
            if(currentDate.charCodeAt(k)>startDate.charCodeAt(k)){
              break;
            }
            if(currentDate.charCodeAt(k)<startDate.charCodeAt(k)){
              coopTerm.status = 'INACTIVE'
            }
          }

          for(var k = 0; k<length; k++){
            if(currentDate.charAt(k) === "-"){
              continue;
            }
            if(currentDate.charCodeAt(k)<endDate.charCodeAt(k)){
              break;
            }
            if(currentDate.charCodeAt(k)>endDate.charCodeAt(k)){
               coopTerm.status = 'INACTIVE'
            }
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
      /*get students*/
    getStudent: async function(){
      for (var i = 0; i < this.coopTerms.length; i++) {
        var id = this.coopTerms[i].studentId
        await this.getName(id, i);
      }
    },
    /*get student name*/
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
    /*redirect to coop page*/
    coopTermView(item) {
      var coopId = item.coopTermId
      var studentId = item.studentId
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
