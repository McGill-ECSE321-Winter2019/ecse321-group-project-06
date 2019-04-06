import axios from 'axios'
var config = require('../../config')


var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})
var config = {
  apiKey: "AIzaSyA61sctgjaZ2soMqo9PFT7DAdKBnWufssM",
  authDomain: "cooperator-e1dc3.firebaseapp.com",
  databaseURL: "https://cooperator-e1dc3.firebaseio.com",
  projectId: "cooperator-e1dc3",
  storageBucket: "cooperator-e1dc3.appspot.com",
  messagingSenderId: "378829380532"
};
"https://www.gstatic.com/firebasejs/5.9.3/firebase.js"></script>

firebase.initializeApp(config);

export default {
  name:"CoopTerms",
    data(){
      return {
        template:[
          {
            name: 'xixi',
            startDate: '2019',
            endDate: '123213',
            active: 'false'
          },
          {
            name:'beibei',
            startDate: '2019',
            endDate: '123213',
            active: 'false'
          },
          {
            name:'jingjing',
            startDate: '2019',
            endDate: '2039',
            active: 'false'
          },
          {
            name:'huanhuan',
            startDate: '2019',
            endDate: '123213',
            active: 'true'
          },
          {
            name:'yingying',
            startDate: '2019',
            endDate: '2020',
            active: 'true'
          },
          {
            name:'nini',
            startDate: '2019',
            endDate: '2020',
            active: 'false'
          }
        ],
        coopTerms:[],
        error:'',
      }
  },
  create: function () {
    AXIOS.get(`/coopTerms`)
      .then(response => {
        this.coopTerms = response.data
      })
      .catch(e =>{
        console.log("error in post request: " + e);
        this.error = e;
      })
  },
  methods:{
    isActive: function(coopTerm){
      var i;
      if(coopTerm.active==="true"){
        return "Active";
      }else{
        return "Not Active";
      }
    }
  }
}
