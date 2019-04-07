import axios from 'axios'
var config = require('../../config')
import Event from './Event'

var frontendUrl = 'https://' + config.build.host + ':'
var backendUrl = 'https://' + config.build.backendHost + ':'

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

