<template>
    <div class="parent">
      <div id="nav-header">
        <h1>Menu</h1>
      </div>



      <b-nav fill vertical>
        <NavItem text="Home" link="/"/>
        <NavItem text="Coop-Terms" link="/coop-term"/>
        <NavItem text="Events" link="/events"/>
      </b-nav>

      <div id="nav-footer" class="footer">
        <hr class="w-100 clearfix d-md-block">
        <b-row>
          <b-col>
            <b-button size="sm" variant="danger" @click="showModal">Logout</b-button>
          </b-col>
          <b-col>
            <b-button size="sm" variant="secondary" @click="showModal">Setting</b-button>
          </b-col>
        </b-row>
      </div>
      <b-modal ref="myModalRef" id="modal1" title="Logout" hide-footer>
        <div class="d-block text-center">
          <p class="my-4">Are you sure you want to log out? Confirm and log out</p>
        </div>
        <b-button class="mt-3" variant="outline-danger" block @click="hideModal" v-bind:to="{path:'/'}">Confirm</b-button>
        <b-button class="mt-3" variant="outline-secondary" block @click="hideModal">Cancel</b-button>
      </b-modal>
    </div>
</template>

<script>
  import NavItem from './NavItem';
    export default {
      name: "Nav",
      components:{
         NavItem
      },
      methods: {
        showModal() {
          this.$refs.myModalRef.show()
        },
        hideModal() {
          this.$refs.myModalRef.hide()
        }
      }
    }
</script>

<style scoped>
.parent{
  height: 100%;
  display:flex;
  flex-direction: column;
  position:relative;
  height: 100%;
}
#nav-header {
  padding: 10px 0px 20px 0px;
  margin: 10px 0px 10px 0px;
  color: #f1f1f1;
}
  #nav-footer{
    position: absolute;
    bottom: 0;
    padding: 20px 0px 15px 0px;
    width: 100%;
  }

</style>
