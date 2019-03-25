import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Dashboard from "../components/Dashboard";
import Login from "@/components/Login.vue";
import Help from "@/components/Help";

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
      meta: { layout: "default" },
      component: Dashboard
    },
    {
      path: '/coop-term',
      name: 'Coopterm',
      meta: { layout: "default" },
      component: require('../components/CoopTerms.vue').default
    },
    {
      path: '/events',
      name: 'Events',
      meta: { layout: "default" },
      component: require('../components/Events.vue').default
    },
    {
      path: '/login',
      name: 'Login',
      meta: { layout: "default" },
      component: Login
    },
    {
      path: '/help',
      name: 'Help',
      meta: { layout: "default" },
      component: Help
    },
    {
      path: '/coop-page',
      name: 'CoopPage',
      meta: { layout: "default" },
      component: require('../components/CoopPage.vue').default
    }
  ]
})
