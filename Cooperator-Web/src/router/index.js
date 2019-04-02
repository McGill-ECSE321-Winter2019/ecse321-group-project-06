import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login.vue';
import Help from '@/components/Help';
import Home from '@/components/Home';
import Events from '@/components/Events.vue';
import CoopTerms from '@/components/CoopTerms.vue';
import Register from '@/components/Register.vue';
import CoopPage from '@/components/CoopPage.vue';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/coop-term',
      name: 'Coopterms',
      component: CoopTerms
    },
    {
      path: '/events',
      name: 'Events',
      component: Events
    },
    {
      path: '/forms',
      name: 'Forms',
      component: Help
    },
    {
      path: '/coop-page/coopterm=:coopId&student=:studentId',
      name: 'CoopPage',
      component: CoopPage
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})
