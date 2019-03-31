<template>
  <div id="app">
    <div class="site-wrap" style="height:100%;">
      <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>

          </div>
        </div>
        <div class="site-mobile-menu-body">
        </div>
      </div>

      <header class="site-navbar py-3" role="banner">
        <div class="container-fluid">
          <div class="row align-items-center">
            <div class="col-11 col-xl-2">
              <h1 class="mb-0"><a href="index.html" class="text-white h2 mb-0">Co<span class="text-primary">operator</span> </a></h1>
            </div>
            <div class="col-12 col-md-10 d-none d-xl-block">
              <nav class="site-navigation position-relative text-right" role="navigation">
                <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                  <li class="active">
                    <router-link :to="{name: 'Home'}">Home</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Hello'}">Hello</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Coopterms'}">Coopterms</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Events'}">Events</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Login'}">Login</router-link>
                  </li>
                </ul>
              </nav>
            </div>
            <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>
          </div>
        </div>
      </header>

      <router-view></router-view>


      <footer class="site-footer">
        <div class="container">
          <div class="row mb-5">
            <div class="col-md-4">
              <h2 class="footer-heading text-uppercase mb-4">About Event</h2>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit aliquid quibusdam fugit architecto.</p>
            </div>
            <div class="col-md-3 ml-auto">
              <h2 class="footer-heading text-uppercase mb-4">Quick Links</h2>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Speakers</a></li>
                <li><a href="#">Gallery</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-md-4">
              <h2 class="footer-heading text-uppercase mb-4">Connect with Us</h2>
              <p>
                <a href="#" class="p-2 pl-0"><span class="icon-facebook"></span></a>
                <a href="#" class="p-2"><span class="icon-twitter"></span></a>
                <a href="#" class="p-2"><span class="icon-youtube"></span></a>
                <a href="#" class="p-2"><span class="icon-instagram"></span></a>
              </p>
            </div>
          </div>
          <div class="row">

            <div class="col-md-12 text-center">
              <div class="border-top pt-5">
                <p>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  Copyright &copy; All rights reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
              </div>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>
</template>

<script>
const default_layout = "default";
export default {
  name: 'app',
}
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Roboto+Mono);
@import 'style/fonts/icomoon/style.css';
@import 'style/css/bootstrap.min.css';
@import 'style/css/magnific-popup.css';
@import 'style/css/owl.theme.default.min.css';
@import 'style/css/bootstrap-datepicker.css';
@import 'style/fonts/flaticon/font/flaticon.css';
@import 'style/css/aos.css';
@import 'style/css/style.css';
</style>
