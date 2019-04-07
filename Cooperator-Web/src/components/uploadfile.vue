<template>
  <div class="col-sm-4">
    <v-btn
      @click.native="selectFile"
      v-if="!uploadEnd && !uploading">
      Please select a file to upload!
    </v-btn>
    <input
      id="files"
      type="file"
      name="file"
      ref="uploadInput"
      accept=".pdf"
      :multiple="false"
      @change="detectFiles($event)" />
    <v-btn v-if="this.fileName!==''"
      class="ma-0"
      dark
      small
      color="error"
    >
      <a> {{this.fileName}}</a>
    </v-btn>
    </div>
</template>

<script>
  import { firestorage } from '@/firebase/firestorage'

  export default {
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
  input[type="file"] {
    position: absolute;
    clip: rect(0,0,0,0);
  }
</style>
