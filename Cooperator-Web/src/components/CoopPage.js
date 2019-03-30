import axios from 'axios'

var config = require('../../config')

var frontendUrl = 'http://127.0.0.1:8087/'
var backendUrl = 'http://localhost:8080/'
//var frontendUrl = 'https://cooperator-frontend-060606.herokuapp.com/'
//var backendUrl = 'https://cooperator-backend-060606.herokuapp.com/'

var studentBackendUrl= 'https://sturegistration-backend-009b01.herokuapp.com/'

//get coop term information
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: {'Access-Control-Allow-Origin': frontendUrl}
})

//get student information from another url
const studentAXIOS = axios.create ({
  baseURL: studentBackendUrl
})


function CoopTermDto(startDate, endDate, location, academicSemester,
                     ifWorkPermitNeeded, jobDescription, evaluationForm, coopPlacement,
                     taxCreditForm, coopTermId, employer, student, status) {
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

function StudentDto(name, email) {
  this.name = name;
  this.email = email;
}

export default {
  name: "coopPage",
  data() {
    return {
      coopTerm: '',
      errorCoopTerm: '',
      student: '',
      errorStudent: '',
      file: '',
      workPermit: '',
      coopStartDate: '',
      coopEndDate: '',
      errorConfirm:'',
      confirmTrue: false,
      link:''
    }
  },
  created: function () {
    AXIOS.get(`/coopTerm/8`)
      .then(response => {
        this.coopTerm = response.data

        //Handle job description link
        this.link = this.coopTerm.jobDescription;

        //Determine if  work permit is needed
        if (this.coopTerm.ifWorkPermitNeeded === true) {
          this.workPermit = 'Yes'

        } else {
          this.workPermit = 'No'
        }

        //Handle Json startDate
        var startDate = new Date(this.coopTerm.startDate)
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
        this.coopStartDate = startDate;

        //Handle Json endDate
        var endDate = new Date(this.coopTerm.endDate)
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
        this.coopEndDate = endDate;
      })

      //Handle Error
      .catch(e => {
        this.errorCoopTerm = e
      })


    studentAXIOS.get(`/student/1`)
      .then(res => {
        this.student = res.data

      })
      .catch(e => {
        this.errorStudent = e
      })


  },
  methods: {

    //confirm button
    confirmCoopTerm() {
      if (this.confirmTrue === false) {
        AXIOS.put(`/coopTerm/8`, {},{})
          .then(response => {
          this.coopTerm = response.data
          //confirm Student
          this.confirmTrue = true
          console.log("Confirmed")
        })
          .catch(e => {
                  console.log("Confirm Unsuccessful")
                  this.errorRegister = errorMsg
                  this.confirmTrue = false
                })

      }
    },

    //link of job description
    coopJobDescription(){
      window.location.href = this.link;
    }
  }

}


