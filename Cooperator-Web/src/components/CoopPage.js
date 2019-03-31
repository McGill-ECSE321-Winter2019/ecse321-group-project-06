import axios from 'axios'
var config = require('../../config')

// var frontendUrl = 'http://127.0.0.1:8087/'
// var backendUrl = 'http://localhost:8080/'

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var studentBackendUrl= 'https://sturegistration-backend-009b01.herokuapp.com/'

//get coop term information
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

//get student information from another url
const studentAXIOS = axios.create ({
  baseURL: studentBackendUrl
})


function CoopTermDto (startDate, endDate, location, academicSemester,
                      ifWorkPermitNeeded, jobDescription, evaluationForm, coopPlacement,
                      taxCreditForm, coopTermId, employer,student, status) {
  this.startDate = startDate
  this.endDate = endDate
  this.location = location
  this.academicSemester = academicSemester
  this.ifWorkPermitNeeded = ifWorkPermitNeeded
  this.jobDescription = jobDescription
  this.evaluationForm = evaluationForm
  this.coopPlacement = coopPlacement
  this.taxCreditForm = taxCreditForm
  this.coopTermId = coopTermId
  this.employer = employer
  this.student = student
  this.status = status

}

function StudentDto (name, email) {
  this.name = name;
  this.email = email;
}

export default {
  name: "coopPage",
  data() {
    return {
      studentName: "Oliver",
      studentEmail: "oliver@mail.mcgill.ca",
      startDate: "2019-01",
      endDate: "2020-01",
      academicSemester: "Fall 2019",
      jobDescription: "Job Requirement: Matlab, python, C. This job is only for McGill Software Engineering Student",
      location: "Montreal",
      ifWorkPermitNeeded: "Yes",
      studentstatus: false,
      coopTerm:'',
      errorCoopTerm:'',
      student: '',
      errorStudent:'',
      file: ''
    }
  },
  created: function() {
    AXIOS.get(`/coopTerm/1`)  //change url
      .then(response => {
        this.coopTerm = response.data
      })
      .catch(e => {
        this.errorCoopTerm = e
      })


    studentAXIOS.get(`/student/{userID}`)  //change url
      .then(response => {
        this.student = response.data
      })
      .catch(e => {
        this.errorStudent = e
      })


  },
  methods: {
    confirmStatus(coopTerm){
      if(coopTerm.studentStatus==false){
        coopTerm.studentStatus=true;
        axois.put(`/coopTerm/1`)
        then(response => {
          this.coopTerm = response.data
        })
          .catch(e => {
            this.errorCoopTerm = e
          })
      }
    }
  }

}


