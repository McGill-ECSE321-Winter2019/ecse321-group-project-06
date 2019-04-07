import axios from 'axios'
import UploadFile from "./uploadfile";
var config = require('../../config')


// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var frontendUrl = 'https://' + config.build.host + ':'
var backendUrl = 'https://' + config.build.backendHost + ':'
var studentBackendUrl = 'https://sturegistration-front-009b01.herokuapp.com/'

//get coop term information
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: {'Access-Control-Allow-Origin': frontendUrl}
})

//get student information from another url
// const studentAXIOS = axios.create ({
//   baseURL: studentBackendUrl
// })


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
  components:{
    UploadFile
  },
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
      link:'',
      coopId: null,
      studentId: null,
      evaluationForm:''
    }
  },
  created: function () {
    this.coopId = this.$route.params.coopId
    AXIOS.get(`/coopTerm/` + this.coopId )
      .then(response => {
        this.coopTerm = response.data

        //Handle job description link
        this.link = this.coopTerm.jobDescription;
        this.evaluationForm = this.coopTerm.evaluationForm;
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


    this.studentId = this.$route.params.studentId;

    AXIOS.get(`/student/` + this.studentId)
      .then(response => {
        this.student = response.data
      })
      .catch(e=>  {
        this.errorStudent = e
    })
  },
  methods: {
    handleDownLoadURLInParent: function(downloadURL){
      this.evaluationForm = downloadURL;
    },
    //confirm button
    confirmCoopTerm() {
      this.coopTerm.state = "ACTIVE"
      AXIOS.put(`/coopTerm/` + this.coopId,
        this.coopTerm
        )
        .then(response => {
          this.coopTerm = response.data
          this.coopTerm.state = "ACTIVE"
          //confirm Student
          console.log(this.coopTerm.state)
          console.log("Confirmed")
        })
        .catch(e => {
          console.log("Confirm Unsuccessful")
          this.errorRegister = errorMsg
          this.coopTerm.state = "INACTIVE"
        })
    },

    updateCoopTerm(){
      this.coopTerm.evaluationForm=this.evaluationForm
      AXIOS.put(`/coopTerm/` + this.coopId,
        this.coopTerm
      )
        .then(response => {
            this.coopTerm = response.data
            console.log(this.coopTerm.evaluationForm)
            console.log("upload Successful")
      })
    },

    //link of job description
    coopJobDescription(){
      window.location.href = this.link;
    },
    evaluationFormView(){
      window.location.href = this.evaluationForm;
    },
  }


}


