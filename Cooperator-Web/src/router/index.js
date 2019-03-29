import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Dashboard from "../components/Dashboard";
import Login from '@/components/Login.vue';
import Help from '@/components/Help';
import Home from '@/components/Home';
import Events from '@/components/Events.vue';
import CoopTerms from '@/components/CoopTerms.vue';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/hello',
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
      name: 'Coopterms',
      component: CoopTerms
    },
    {
      path: '/events',
      name: 'Events',
      component: Events
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
