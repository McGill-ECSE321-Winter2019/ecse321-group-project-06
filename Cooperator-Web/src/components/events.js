import axios from 'axios'
var config = require('../../config')
import Event from './Event'


var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl='https://cooperator-backend-060606.herokuapp.com/'
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
  name: "Events",
  components: {
    Event
  },
  data(){
    return{
      events: [],
      error: ''
    }
  },
  created: function(){
    AXIOS.get(`/events`)
      .then(response => {
        this.events = response.data
      })
      .catch(e => {
        this.error = e;
      })
  }
}

