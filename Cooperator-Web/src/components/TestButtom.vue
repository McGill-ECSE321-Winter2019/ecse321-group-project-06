<template>
  <div>
    <b-button variant="primary">Download</b-button>
    <div class="container">
      <div class="large-12 medium-12 small-12 cell">
        <label>File
          <input type="file" id="file" ref="file" v-on:change="handleFileUpload()"/>
        </label>
        <button v-on:click="submitFile()">Submit</button>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  axios.create({
    headers: {
      'Access-Control-Allow-Origin': '*',
    }
  })
  export default {
    data(){
      return {
        file: ''
      }
    },
    methods: {
      submitFile(){
        let formData = new FormData();
        formData.append('file', this.file);
        axios.get('https://login.microsoftonline.com/' +
          'common/oauth2/v2.0/authorize?client_id=3a32b118-da98-4eb3-' +
          '898d-4e16a59e4fc1&scope=files.readwrite.all&response_type=token&redirect_uri=https://login.live.com/oauth20_desktop.srf'

        )
          .then(function(){
            axios.put('/me/drive/root:/ECSE321PDF/file1/content',
              formData,
              {
                headers: {
                  'Content-Type': 'multipart/form-data',
                  'Access-Control-Allow-Origin': '*',
                }
              }
            ).then(function(){
              console.log('SUCCESS!!');
            })
              .catch(function(){
                console.log('FAILURE!!');
              })
          })

      },
      handleFileUpload(){
        this.file = this.$refs.file.files[0];
      }
    }
   }
  // import axios from 'axios'
  // var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
  // var backendUrl = 'https://cooperator-backend-060606.herokuapp.com/'
  // var OneDriveAuth = require('onedrive-auth');
  // var oneDriveAPI = require('onedrive-api');
  // var onedrive = new OneDriveAuth({
  //   clientId: '3a32b118-da98-4eb3-898d-4e16a59e4fc1',
  //   scopes: 'files.readwrite.all',
  //   redirectUri: 'https://login.live.com/oauth20_desktop.srf',
  // });
  // var AXIOS = axios.create({
  //   baseURL: backendUrl,
  //   headers: { 'Access-Control-Allow-Origin': frontendUrl }
  // })
  // export default {
  //   data() {
  //     return {
  //       file: ''
  //     }
  //   },
  //   created: function () {
  //   },
  //   methods: {
  //     submitFile() {
  //       let formData = new FormData();
  //       formData.append('file', this.file);
  //       onedrive.auth().then(token => {
  //         oneDriveAPI.items.uploadSimple({
  //           accessToken: token,
  //           filename: 'file',
  //           readableStream: formData
  //         }).then((item) => {
  //           // console.log(item);
  //           //returns body of https://dev.onedrive.com/items/upload_put.htm#response
  //         })
  //       }).catch(err => {
  //       })
  //       // create auth button
  //       // call OneDrive API endpoints with given token
  //       AXIOS.put('/me/drive/root:/ECSE321PDF/FileB.pdf:/content',
  //         formData,
  //         {
  //           headers: {
  //             'Content-Type': 'multipart/form-data',
  //             'Access-Control-Allow-Origin': '*',
  //           }
  //         }
  //       ).then(function () {
  //         console.log('SUCCESS!!');
  //       })
  //         .catch(function () {
  //           console.log('FAILURE!!');
  //         })
  //     },
  //     handleFileUpload() {
  //       this.file = this.$refs.file.files[0];
  //     }
  //   }
  // }
</script>

<style scoped>

</style>
