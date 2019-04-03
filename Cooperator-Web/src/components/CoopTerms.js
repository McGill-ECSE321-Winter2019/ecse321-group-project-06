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
        coopTerms:[]
      }
  },

    created: function () {
      this.id = this.$cookie.get('id')
      AXIOS.get(`coopTerm/employer/`+this.id)
        .then(response => {
          this.coopTerms = response.data
        }).then(()=>{
          this.getStudent();
      })
        .catch(e =>{
          console.log("error in get coopterm request: " + e);
          this.error = e;
        })
  },

  methods: {
    isActive: function (coopTerm) {
      var start = coopTerm.startDate.substring(0,10);
      var end = coopTerm.endDate.substring(0,10);
      var present = "2019-04-01";

      //return start;
      var length = 10;
      var status = "Not Active";

      for(var k = 0; k<length; k++){
        if(present.charAt(k) == "-"){
          continue;
        }
        if(present.charCodeAt(k)>start.charCodeAt(k)){
          break;
        }

        if(present.charCodeAt(k)<start.charCodeAt(k)){
          //return present.charAt(k);
          return status;
        }
      }

      for(var k = 0; k<length; k++){
        if(present.charAt(k) == "-"){
          continue;
        }
        if(present.charCodeAt(k)<end.charCodeAt(k)){
          break;
        }
        if(present.charCodeAt(k)>end.charCodeAt(k)){
          return status;
        }
      }
      status = "Active";
      return status;

    },
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
    }

  }

}
