import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Dashboard from "../components/Dashboard";
import Login from "@/components/Login.vue";
import Help from "@/components/Help";
import Home from "@/components/Home";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/employer',
      name: 'Dashboard',
      component: Dashboard
    },
    {
      path: '/coop-term',
      name: 'Coopterm',
      component: require('../components/CoopTerms.vue').default
    },
    {
      path: '/events',
      name: 'Events',
      component: require('../components/Events.vue').default
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/help',
      name: 'Help',
      component: Help
    },
    {
      path: '/coop-page',
      name: 'CoopPage',
      component: require('../components/CoopPage.vue').default
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})
