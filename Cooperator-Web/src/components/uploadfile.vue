<!--<template>-->
<!--<div class="form-group row">-->
<!--<div class="col col-lg-4">-->
<!--<b-form-file-->
<!--v-model="file"-->
<!--:state="Boolean(file)"-->
<!--placeholder="Choose a file..."-->
<!--drop-placeholder="Drop file here..."-->
<!--&gt;-->
<!--<progress value="0" max="100" id="uploader">0%</progress>-->
<!--<input type="file" value="upload" id="fileButton" ref="file"/>-->
<!--</b-form-file>-->
<!--</div>-->
<!--</div>-->
<!--</template>-->

<!--<script src="https://www.gstatic.com/firebasejs/5.9.2/firebase-firestore.js">-->
<!--export default {-->
<!--}-->
<!--import firebase from 'firebase/app';-->
<!--// Initialize Firebase-->
<!--var config = {-->
<!--apiKey: "AIzaSyA61sctgjaZ2soMqo9PFT7DAdKBnWufssM",-->
<!--authDomain: "cooperator-e1dc3.firebaseapp.com",-->
<!--databaseURL: "https://cooperator-e1dc3.firebaseio.com",-->
<!--projectId: "cooperator-e1dc3",-->
<!--storageBucket: "cooperator-e1dc3.appspot.com",-->
<!--messagingSenderId: "378829380532"-->
<!--};-->
<!--firebase.initializeApp(config);-->

<!--var uploader = document.getElementById('uploader');-->
<!--var fileButton = document.getElementById('fileButton');-->

<!--fileButton.addEventListener('change',function(e){-->
<!--var file = e.target.files(0);-->

<!--var storageRef = firebase.storage().ref('folder_name/file_name.pdf'+file.name);-->

<!--var task = storageRef.put(file);-->

<!--task.on('state_changed',-->
<!--function progress(snapshot){-->
<!--var percentage = (snapshot.bytesTransferred/snapshot.totalBytes)*100;-->
<!--},-->

<!--function error(err){-->

<!--},-->
<!--function complete(){-->

<!--}-->
<!--);-->
<!--});-->
<!--</script>-->


<!--<style scoped>-->

<!--</style>-->
<template>
  <div>
    <v-btn
      @click.native="selectFile"
      v-if="!uploadEnd && !uploading">
      Upload a pdf file
    </v-btn>
    <input
      id="files"
      type="file"
      name="file"
      ref="uploadInput"
      accept=".pdf"
      :multiple="false"
      @change="detectFiles($event)" />
      <v-btn
        class="ma-0"
        dark
        small
        color="error"
      >
        <a v-bind:href="`${this.downloadURL}`"> {{this.fileName}}</a>

      </v-btn>
    </div>
</template>

<script>
  // Thanks Marcelo Forclaz(https://github.com/CristalT) https://gist.github.com/CristalT/2651023cfa2f36cddd119fd979581893
  // Thanks Matteo Leoni(https://github.com/signalkuppe) https://github.com/signalkuppe/vuetify-cloudinary-upload/blob/master/src/components/v-cloudinary-upload.vue
  import { firestorage } from '@/firebase/firestorage'

  export default {
    props: ['oldImgUrl'],
    data () {
      return {
        progressUpload: 0,
        fileName: '',
        uploadTask: '',
        uploading: false,
        uploadEnd: false,
        downloadURL: ''
      }
    },
    created () {
      if (this.oldImgUrl) this.setCoverImgOnUpdate()
    },
    methods: {
      selectFile () {
        this.$refs.uploadInput.click()
      },
      detectFiles (e) {
        let fileList = e.target.files || e.dataTransfer.files
        Array.from(Array(fileList.length).keys()).map(x => {
          this.upload(fileList[x])
        })
      },
      upload (file) {
        this.fileName = file.name
        this.uploading = true
        this.uploadTask = firestorage.ref('images/' + file.name).put(file)
      }
    },
    watch: {
      uploadTask: function () {
        this.uploadTask.on('state_changed', sp => {
            this.progressUpload = Math.floor(sp.bytesTransferred / sp.totalBytes * 100)
          },
          null,
          () => {
            this.uploadTask.snapshot.ref.getDownloadURL().then(downloadURL => {
              this.uploadEnd = true
              this.downloadURL = downloadURL
              this.$emit('downloadURL', downloadURL)
            })
          })
      }
    }
  }
</script>

<style>
  .progress-bar {
    margin: 10px 0;
  }
  input[type="file"] {
    position: absolute;
    clip: rect(0,0,0,0);
  }
</style>
