import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
  name: 'register',
  data() {
    return {
      name:'',
      email: '',
      password: '',
      selected: 'Select',
      errorRegister: '',
      response: '',
    }
  },
  created: function () {

  },
  methods: {
    register(name, email, password, selected) {
      console.log(selected)
      if (name == '') {
        var errorMsg = "Invalid name"
        console.log(errorMsg)
        this.errorRegister = errorMsg
        return
      }

      if (email == '') {
        var errorMsg = "Invalid email"
        console.log(errorMsg)
        this.errorRegister = errorMsg
        return
      }
      if (password == '') {
        var errorMsg = "Invalid password"
        console.log(errorMsg)
        this.errorRegister = errorMsg
        return
      }
      this.errorRegister = ''
      if(selected == "Employer"){

        AXIOS.post(`/employers`,{
          email: email,
          password: password,
          name: name
        })
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data
            console.log(this.response)
            this.response = "Empolyer Created!"
            this.name= ''
            this.email= ''
            this.password= ''
            this.selected= 'Select'
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorRegister = errorMsg
            this.response = ''
          });
      }

    }
  }
}
