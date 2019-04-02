import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
//var backendUrl = 'https://cooperator-backend-060606.herokuapp.com/'
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
  name: 'login',
  data() {
    return {
      username: '',
      password: '',
      errorLogin: '',
      response: '',
    }
  },
  methods: {
    login(username, password) {
      if (username == '') {
        var errorMsg = "Invalid username"
        console.log(errorMsg)
        this.errorLogin = errorMsg
        return
      }
      if (password == '') {
        var errorMsg = "Invalid password"
        console.log(errorMsg)
        this.errorLogin = errorMsg
        return
      }

      console.log(`/?Email=`+username+'&Password='+password)
      AXIOS.get(`/login?Email=`+username+'&Password='+password)

      //   axios({
      //     method:'get',
      //     url:'/employers/1',
      //     responseType:'json'
      //     })
        .then(response => {
          this.response = response.data
          this.errorLogin = ''

          this.$cookie.set('username', username, { expires: '1h' })
          this.$cookie.set('password', password, { expires: '1h' })

          //this.$cookies.set("coopUserId", this.response.coopUserId, { expires: '1h' })
          this.username = this.$cookie.get("username") || ''
          this.password = this.$cookie.get("password") || ''
          // if (this.response === 'employer') {
           //localStorage.setItem('loggedIn', "Employer")
            window.location.href = '/#/home/';
         // }

          // else{
          //   this.errorLogin = response.data
          //   console.log(this.response)
          // }
        })
        .catch(e => {
          var errorMsg = "Invalid email or password!"
          console.log(errorMsg)
          this.errorLogin = errorMsg
        });
    }
  }
}
