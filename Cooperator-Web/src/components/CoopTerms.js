// import axios from 'axios'
// var config = require('../../config')
// import CoopTerms from './CoopTerms'
//
//
// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl='https://cooperator-backend-060606.herokuapp.com/'
//
// var AXIOS = axios.create({
//   baseURL: backendUrl,
//   headers: { 'Access-Control-Allow-Origin': frontendUrl }
// })
//
// export default {
//   name:"CoopTerms",
//   compnents:{
//     CoopTerms
//   },
//
//   data(){
//     return {
//       coopterms:[],
//       error:''
//     }
//   },
//
//   create: function () {
//     AXIOS.get(`/coopterms`)
//       .then(response => {
//         this.coopterms = response.data
//       })
//       .catch(e =>{
//         console.log("error in post request: " + e);
//         this.error = e;
//       })
//   }
//
// }
