<template>
  <b-container id="default" fluid>
    <b-row id="menu" class="no-gutters">
      <b-col cols="2">
        <Nav />
      </b-col>
      <b-col cols="10" id="board">
        <b-row class="no-gutters">
          <div class="topnav">
            <div class="topnav-right">
              <a href="#about">About</a>
            </div>
          </div>
        </b-row>
        <slot />
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
  import Nav from "../components/Nav";
    export default {
      name: "default",
      components: {
          Nav
      }
    }
</script>

<style scoped>
  #default {
    padding-left: 0px;
    padding-right: 0px;
    background-color: #44566c;
    height: 100%;
  }
  #menu{
    height: 100%;
  }
  #board{
    background-color: #dadada;
  }
  .topnav {
    background-color: #a2a5a7;
    overflow: hidden;
    width: 100%;
    padding: 15px 30px 15px 0px;
  }

  /* Style the links inside the navigation bar */
  .topnav a {
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 8px 8px;
    text-decoration: none;
    font-size: 16px;
  }

  /* Change the color of links on hover */
  .topnav a:hover {
    background-color: #9099a2;
    color: black;
  }

  /* Add a color to the active/current link */
  .topnav a.active {
    background-color: #4CAF50;
    color: white;
  }

  /* Right-aligned section inside the top navigation */
  .topnav-right {
    float: right;
  }
</style>
