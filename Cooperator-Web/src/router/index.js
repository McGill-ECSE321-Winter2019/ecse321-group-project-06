import Vue from 'vue'
import Router from 'vue-router'
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
