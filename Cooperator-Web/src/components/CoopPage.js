import axios from 'axios'
import UploadFile from "./uploadfile";
var config = require('../../config')

var frontendUrl = 'https://' + config.build.host + ':'
var backendUrl = 'https://' + config.build.backendHost + ':'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: {'Access-Control-Allow-Origin': frontendUrl}
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
      evaluationForm:'',
      upload: null,
      modalShow: false
    }
  },
  created: function () {
    this.coopId = this.$route.params.coopId
    /* get coopterm */
    AXIOS.get(`/coopTerm/` + this.coopId )
      .then(response => {
        this.coopTerm = response.data

        //Handle job description link
        this.link = this.coopTerm.jobDescription;
        //get evaluation form, conditionally render upload field
        this.evaluationForm = this.coopTerm.evaluationForm;
        if(this.evaluationForm === null){
          this.upload = true;
        }
        else{
          this.upload = false;
        }
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

    /*get student*/
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
    /*conditionally render upload file button*/
    toggleUpload: function(){
      this.upload = !this.upload;
    },
    /*update downloadURL*/
    handleDownLoadURLInParent: function(downloadURL){
      this.evaluationForm = downloadURL;
    },
    /*update coopterm status*/
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
    /*update coopterm evaluation form*/
    updateCoopTerm(){
      this.coopTerm.evaluationForm=this.evaluationForm
      AXIOS.put(`/coopTerm/` + this.coopId,
        this.coopTerm
      )
        .then(response => {
            this.coopTerm = response.data;
            this.upload = false;
            this.modalShow = true;
            console.log(this.coopTerm.evaluationForm)
            console.log("upload Successful")
      })
    },

    /*link to job description*/
    coopJobDescription(){
      window.location.href = this.link;
    },
    /*link to evaluation form*/
    evaluationFormView(){
      window.location.href = this.evaluationForm;
    },
  }


}


